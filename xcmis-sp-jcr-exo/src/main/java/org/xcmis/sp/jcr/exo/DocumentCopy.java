/*
 * Copyright (C) 2010 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.xcmis.sp.jcr.exo;

import org.exoplatform.services.jcr.core.ExtendedNode;
import org.xcmis.sp.jcr.exo.index.IndexListener;
import org.xcmis.spi.CmisConstants;
import org.xcmis.spi.CmisRuntimeException;
import org.xcmis.spi.DocumentData;
import org.xcmis.spi.FolderData;
import org.xcmis.spi.NameConstraintViolationException;
import org.xcmis.spi.PolicyData;
import org.xcmis.spi.StorageException;
import org.xcmis.spi.UpdateConflictException;
import org.xcmis.spi.model.Property;
import org.xcmis.spi.model.TypeDefinition;
import org.xcmis.spi.model.VersioningState;

import java.io.IOException;
import java.util.Calendar;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * @author <a href="mailto:andrey00x@gmail.com">Andrey Parfonov</a>
 * @version $Id$
 */
class DocumentCopy extends DocumentDataImpl
{

   private final DocumentData source;

   public DocumentCopy(DocumentData source, TypeDefinition type, FolderData parent, Session session,
      VersioningState versioningState, IndexListener indexListener)
   {
      super(type, parent, session, versioningState, indexListener);
      this.source = source;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected void create() throws StorageException, NameConstraintViolationException, UpdateConflictException
   {
      try
      {
         if (name == null)
         {
            Property<?> nameProperty = properties.get(CmisConstants.NAME);
            if (nameProperty != null)
            {
               name = (String)nameProperty.getValues().get(0);
            }
         }

         if (name == null || name.length() == 0)
         {
            name = source.getName();
         }

         Node parentNode = parent.getNode();

         if (parentNode.hasNode(name))
         {
            throw new NameConstraintViolationException("Object with name " + name
               + " already exists in specified folder.");
         }

         Node doc = parentNode.addNode(name, type.getLocalName());

         if (!doc.isNodeType(JcrCMIS.CMIS_MIX_DOCUMENT))
         {
            doc.addMixin(JcrCMIS.CMIS_MIX_DOCUMENT);
         }
         if (doc.canAddMixin(JcrCMIS.MIX_VERSIONABLE))
         {
            doc.addMixin(JcrCMIS.MIX_VERSIONABLE);
         }

         doc.setProperty(CmisConstants.OBJECT_TYPE_ID, //
            type.getId());
         doc.setProperty(CmisConstants.BASE_TYPE_ID, //
            type.getBaseId().value());
         doc.setProperty(CmisConstants.CREATED_BY, //
            session.getUserID());
         doc.setProperty(CmisConstants.CREATION_DATE, //
            Calendar.getInstance());
         doc.setProperty(CmisConstants.LAST_MODIFIED_BY, //
            session.getUserID());
         doc.setProperty(CmisConstants.LAST_MODIFICATION_DATE, //
            Calendar.getInstance());
         doc.setProperty(CmisConstants.VERSION_SERIES_ID, //
            doc.getProperty(JcrCMIS.JCR_VERSION_HISTORY).getString());
         doc.setProperty(CmisConstants.IS_LATEST_VERSION, //
            true);
         doc.setProperty(CmisConstants.IS_MAJOR_VERSION, //
            versioningState == VersioningState.MAJOR);
         doc.setProperty(CmisConstants.VERSION_LABEL, //
            versioningState == VersioningState.CHECKEDOUT ? pwcLabel : latestLabel);
         doc.setProperty(CmisConstants.IS_VERSION_SERIES_CHECKED_OUT, //
            versioningState == VersioningState.CHECKEDOUT);
         if (versioningState == VersioningState.CHECKEDOUT)
         {
            doc.setProperty(CmisConstants.VERSION_SERIES_CHECKED_OUT_ID, //
               ((ExtendedNode)doc).getIdentifier());
            doc.setProperty(CmisConstants.VERSION_SERIES_CHECKED_OUT_BY, //
               session.getUserID());
         }

         // TODO : copy the other properties from source.

         for (Property<?> property : properties.values())
         {
            setProperty(doc, property);
         }

         try
         {
            // TODO : use native JCR ??
            setContentStream(doc, source.getContentStream());
         }
         catch (IOException ioe)
         {
            throw new CmisRuntimeException("Unable copy content for new document. " + ioe.getMessage(), ioe);
         }

         if (policies != null && policies.size() > 0)
         {
            for (PolicyData policy : policies)
            {
               applyPolicy(doc, policy);
            }
         }

         if (acl != null && acl.size() > 0)
         {
            setACL(doc, acl);
         }

         session.save();

         name = null;
         policies = null;
         acl = null;
         properties.clear();

         node = doc;
      }
      catch (RepositoryException re)
      {
         throw new StorageException("Unable save Document. " + re.getMessage(), re);
      }
   }

}

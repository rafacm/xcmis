/**
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

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.xcmis.spi.CMIS;
import org.xcmis.spi.CmisRuntimeException;
import org.xcmis.spi.ConstraintException;
import org.xcmis.spi.ItemsIterator;
import org.xcmis.spi.NameConstraintViolationException;
import org.xcmis.spi.StorageException;
import org.xcmis.spi.TypeDefinition;
import org.xcmis.spi.data.ContentStream;
import org.xcmis.spi.data.Folder;
import org.xcmis.spi.data.ObjectData;
import org.xcmis.spi.data.Policy;
import org.xcmis.spi.object.Property;
import org.xcmis.spi.utils.CmisUtils;

import java.util.Calendar;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * @author <a href="mailto:andrew00x@gmail.com">Andrey Parfonov</a>
 * @version $Id$
 */
class FolderImpl extends BaseObjectData implements Folder
{

   private static final Log LOG = ExoLogger.getLogger(FolderImpl.class);

   public FolderImpl(TypeDefinition type, Folder parent, Session session)
   {
      super(type, parent, session);
   }

   public FolderImpl(TypeDefinition type, Node node)
   {
      super(type, node);
   }

   public void addObject(ObjectData object) throws ConstraintException
   {
      throw new UnsupportedOperationException("addObject");
      /*      if (isNew())
               throw new UnsupportedOperationException("addObject");

            if (object.getBaseType() == BaseType.DOCUMENT)
            {
               try
               {
                  Node o = ((BaseObjectData)object).getNode();
                  Session session = node.getSession();
                  if (!o.isNodeType("xcmis:sharedObject"))
                  {
                     Node unfiled = (Node)session.getItem("/xcmis:system/xcmis:unfiled");
                     // TODO : node-type
                     Node wrapper = unfiled.addNode(IdGenerator.generate(), JcrCMIS.NT_UNSTRUCTURED);
                     String destPath = wrapper.getPath() + "/" + o.getName();
                     session.move(o.getPath(), destPath);
                     o = (Node)session.getItem(destPath);
                     o.addMixin("xcmis:sharedObject");
                  }

                  if (!o.hasProperty("xcmis:parents"))
                  {
                     o.setProperty("xcmis:parents", new String[]{((ExtendedNode)getNode()).getIdentifier()},
                        javax.jcr.PropertyType.REFERENCE);
                  }
                  else
                  {
                     Value[] parents = o.getProperty("xcmis:parents").getValues();
                     Value[] newParents = Arrays.copyOf(parents, parents.length + 1, parents.getClass());
                     o.setProperty("xcmis:parents", newParents);
                  }
                  Node link = node.addNode(object.getName(), "nt:linkedFile");
                  link.setProperty("jcr:content", o);

                  session.save();
               }
               catch (RepositoryException re)
               {
                  re.printStackTrace();
                  throw new CmisRuntimeException("Unable add object to current folder. " + re.getMessage(), re);
               }
            }
      */
   }

   /**
    * {@inheritDoc}
    */
   public ItemsIterator<ObjectData> getChildren(String orderBy)
   {
      if (LOG.isDebugEnabled())
         LOG.debug("Get children " + getObjectId() + ", name " + getName());

      if (isNew())
         return CmisUtils.emptyItemsIterator();

      try
      {
         return new FolderChildrenIterator(node.getNodes());
      }
      catch (RepositoryException re)
      {
         throw new CmisRuntimeException("Unable get children for folder " + getObjectId() + ". " + re.getMessage(), re);
      }
   }

   /**
    * {@inheritDoc}
    */
   public ContentStream getContentStream(String streamId)
   {
      // TODO : renditions for Folder object.
      // It may be XML or HTML representation direct child or full tree.
      return null;
   }

   /**
    * {@inheritDoc}
    */
   public String getPath()
   {
      if (isNew())
         return null;

      try
      {
         return node.getPath();
      }
      catch (RepositoryException re)
      {
         throw new CmisRuntimeException("Unable get folder path. " + re.getMessage(), re);
      }
   }

   /**
    * {@inheritDoc}
    */
   public boolean hasChildren()
   {
      if (isNew())
         return false;

      try
      {
         // Weak solution. Even this method return true iterator over children may
         // be empty if folder contains only not CMIS object.
         return node.hasNodes();
      }
      catch (RepositoryException re)
      {
         throw new CmisRuntimeException("Unexpected error. " + re.getMessage(), re);
      }
   }

   /**
    * {@inheritDoc}
    */
   public boolean isAllowedChildType(String typeId)
   {
      if (isNew())
         return false;

      // There is no any restriction about types. Any fileable objects supported.
      // Is type is fileable must be checked before calling this method.
      return true;
   }

   /**
    * {@inheritDoc}
    */
   public boolean isRoot()
   {
      if (isNew())
         return false;

      try
      {
         return node.getDepth() == 0;
      }
      catch (RepositoryException re)
      {
         throw new CmisRuntimeException("Unexpected error. " + re.getMessage(), re);
      }
   }

   public void removeObject(ObjectData object)
   {
      throw new UnsupportedOperationException("removeObject");
      /*      if (isNew())
               throw new UnsupportedOperationException("removeObject");

            try
            {
               Node o = node.getNode(object.getName());
               if (o.isNodeType("nt:linkedFile"))
               {
                  o.remove();
               }
               else
               {
                  // TODO : unfile
                  throw new UnsupportedOperationException();
               }
               node.save();
            }
            catch (PathNotFoundException pe)
            {
               throw new InvalidArgumentException("Object " + object.getObjectId() + " is not filed in current folder");
            }
            catch (RepositoryException re)
            {
               throw new CmisRuntimeException("Unable remove object from current folder. " + re.getMessage(), re);
            }
      */
   }

   /**
    * {@inheritDoc}
    */
   protected void create() throws StorageException, NameConstraintViolationException
   {
      try
      {
         if (name == null || name.length() == 0)
            throw new NameConstraintViolationException("Name for new folder must be provided.");

         Node parentNode = parent.getNode();

         if (parentNode.hasNode(name))
            throw new NameConstraintViolationException("Object with name " + name
               + " already exists in specified folder.");

         Node folder = parentNode.addNode(name, type.getLocalName());
         if (!folder.isNodeType(JcrCMIS.CMIS_MIX_FOLDER)) // May be already inherited.
            folder.addMixin(JcrCMIS.CMIS_MIX_FOLDER);

         folder.setProperty(CMIS.OBJECT_TYPE_ID, //
            type.getId());
         folder.setProperty(CMIS.BASE_TYPE_ID, //
            type.getBaseId().value());
         folder.setProperty(CMIS.CREATED_BY, //
            parentNode.getSession().getUserID());
         folder.setProperty(CMIS.CREATION_DATE, //
            Calendar.getInstance());
         folder.setProperty(CMIS.LAST_MODIFIED_BY, //
            parentNode.getSession().getUserID());
         folder.setProperty(CMIS.LAST_MODIFICATION_DATE, //
            Calendar.getInstance());

         for (Property<?> property : properties.values())
            setProperty(folder, property);

         if (policies != null && policies.size() > 0)
         {
            for (Policy policy : policies)
               applyPolicy(folder, policy);
         }

         if (acl != null && acl.size() > 0)
            setACL(folder, acl);

         parentNode.save();

         name = null;
         policies = null;
         acl = null;
         properties.clear();

         node = folder;
      }
      catch (RepositoryException re)
      {
         throw new StorageException("Unable save Folder. " + re.getMessage(), re);
      }
   }

}

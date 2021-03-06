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

package org.xcmis.wssoap.impl;

import org.xcmis.core.EnumRelationshipDirection;
import org.xcmis.messaging.CmisExtensionType;
import org.xcmis.messaging.CmisObjectListType;
import org.xcmis.soap.CmisException;
import org.xcmis.soap.RelationshipServicePort;
import org.xcmis.spi.CmisConstants;
import org.xcmis.spi.CmisRegistry;
import org.xcmis.spi.Connection;
import org.xcmis.spi.model.RelationshipDirection;
import org.xcmis.spi.utils.Logger;

import java.math.BigInteger;

/**
 * @author <a href="mailto:max.shaposhnik@exoplatform.com">Max Shaposhnik</a>
 * @version $Id: RelationshipServicePortImpl.java 2 2010-02-04 17:21:49Z
 *          andrew00x $
 */
@javax.jws.WebService(// name = "RelationshipServicePort",
serviceName = "RelationshipService", //
portName = "RelationshipServicePort", //
targetNamespace = "http://docs.oasis-open.org/ns/cmis/ws/200908/", //
wsdlLocation = "/wsdl/CMISWS-Service.wsdl" //,
// endpointInterface = "org.xcmis.soap.RelationshipServicePort"
)
public class RelationshipServicePortImpl implements RelationshipServicePort
{

   /** Logger. */
   private static final Logger LOG = Logger.getLogger(RelationshipServicePortImpl.class);

   /**
    * Constructs instance of <code>RelationshipServicePortImpl</code> .
    *
    */
   public RelationshipServicePortImpl()
   {
   }

   /**
    * {@inheritDoc}
    */
   public CmisObjectListType getObjectRelationships(String repositoryId, //
      String objectId, //
      Boolean includeSubRelationshipTypes, //
      EnumRelationshipDirection relationshipDirection, //
      String typeId, //
      String propertyFilter, //
      Boolean includeAllowableActions, //
      BigInteger maxItems, //
      BigInteger skipCount, //
      CmisExtensionType extension) throws CmisException
   {
      if (LOG.isDebugEnabled())
      {
         LOG.debug("Executing operation getRelationships");
      }
      Connection conn = null;

      try
      {
         conn = CmisRegistry.getInstance().getConnection(repositoryId);

         return TypeConverter.getCmisObjectListType(conn.getObjectRelationships(
            objectId, //
            relationshipDirection == null ? RelationshipDirection.SOURCE : RelationshipDirection
               .fromValue(relationshipDirection.value()), //
            typeId, //
            includeSubRelationshipTypes == null ? false : includeSubRelationshipTypes, //
            includeAllowableActions == null ? false : includeAllowableActions, //
            false, propertyFilter, //
            maxItems == null ? CmisConstants.MAX_ITEMS : maxItems.intValue(), //
            skipCount == null ? 0 : skipCount.intValue() //
            ).getItems());
      }
      catch (Exception e)
      {
         LOG.error("Get relationships error : " + e.getMessage(), e);
         throw ExceptionFactory.generateException(e);
      }
      finally
      {
         if (conn != null)
         {
            conn.close();
         }
      }
   }
}

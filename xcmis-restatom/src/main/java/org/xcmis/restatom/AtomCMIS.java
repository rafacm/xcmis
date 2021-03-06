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

package org.xcmis.restatom;

import org.xcmis.spi.CmisConstants;

import javax.xml.namespace.QName;

/**
 * @author <a href="mailto:andrey.parfonov@exoplatform.com">Andrey Parfonov</a>
 * @version $Id: AtomCMIS.java 211 2010-02-12 14:12:45Z alexey.zavizionov $
 */
public interface AtomCMIS extends CmisConstants
{
   /**
    * Value for &#64;javax.ws.rs.Path on JAX-RS service.
    */
   String CMIS_REST_RESOURCE_PATH = "cmisatom";

   String CMISRA_NS_URI = "http://docs.oasis-open.org/ns/cmis/restatom/200908/";

   String CMISRA_PREFIX = "cmisra";

   String XML_SCHEMA_INST_URI = "http://www.w3.org/2001/XMLSchema-instance";

   String XML_SCHEMA_INST_PREFIX = "xsi";

   QName X_TYPE = new QName(XML_SCHEMA_INST_URI, "type", XML_SCHEMA_INST_PREFIX);

   QName ABSTRACT = new QName(CMIS_NS_URI, "abstract", CMIS_PREFIX);

   QName ALLOWABLE_ACTIONS = new QName(CMIS_NS_URI, "allowableActions", CMIS_PREFIX);

   QName BASE_TYPE = new QName(CMIS_NS_URI, "baseType", CMIS_PREFIX);

   QName BASE_ID = new QName(CMIS_NS_URI, "baseId", CMIS_PREFIX);

   QName BASE_TYPE_QUERY_NAME = new QName(CMIS_NS_URI, "baseTypeQueryName", CMIS_PREFIX);

   QName CAN_CANCEL_CHECK_OUT = new QName(CMIS_NS_URI, "canCancelCheckOut", CMIS_PREFIX);

   QName CAN_CHECK_IN = new QName(CMIS_NS_URI, "canCheckIn", CMIS_PREFIX);

   QName CAN_CHECK_OUT = new QName(CMIS_NS_URI, "canCheckOut", CMIS_PREFIX);

   QName CAN_CREATE_DOCUMENT = new QName(CMIS_NS_URI, "canCreateDocument", CMIS_PREFIX);

   QName CAN_CREATE_FOLDER = new QName(CMIS_NS_URI, "canCreateFolder", CMIS_PREFIX);

   QName CAN_CREATE_RELATIONSHIP = new QName(CMIS_NS_URI, "canCreateRelationship", CMIS_PREFIX);

   QName CAN_DELETE_CONTENT_STREAM = new QName(CMIS_NS_URI, "canDeleteContentStream", CMIS_PREFIX);

   QName CAN_DELETE_TREE = new QName(CMIS_NS_URI, "canDeleteTree", CMIS_PREFIX);

   QName CAN_GET_ALL_VERSIONS = new QName(CMIS_NS_URI, "canGetAllVersions", CMIS_PREFIX);

   QName CAN_ADD_OBJECT_TO_FOLDER = new QName(CMIS_NS_URI, "canAddObjectToFolder", CMIS_PREFIX);

   QName CAN_GET_APPLIED_POLICIES = new QName(CMIS_NS_URI, "canGetAppliedPolicies", CMIS_PREFIX);

   QName CAN_GET_CONTENT_STREAM = new QName(CMIS_NS_URI, "canGetContentStream", CMIS_PREFIX);

   QName CAN_APPLY_POLICY = new QName(CMIS_NS_URI, "canApplyPolicy", CMIS_PREFIX);

   QName CAN_GET_CHILDREN = new QName(CMIS_NS_URI, "canGetChildren", CMIS_PREFIX);

   QName CAN_GET_RENDITIONS = new QName(CMIS_NS_URI, "canGetRenditions", CMIS_PREFIX);

   QName CAN_GET_ACL = new QName(CMIS_NS_URI, "canGetACL", CMIS_PREFIX);

   QName CAN_APPLY_ACL = new QName(CMIS_NS_URI, "canApplyACL", CMIS_PREFIX);

   QName CAN_GET_DESCENDANTS = new QName(CMIS_NS_URI, "canGetDescendants", CMIS_PREFIX);

   QName CAN_GET_FOLDER_PARENT = new QName(CMIS_NS_URI, "canGetFolderParent", CMIS_PREFIX);

   QName CAN_GET_OBJECT_PARENTS = new QName(CMIS_NS_URI, "canGetObjectParents", CMIS_PREFIX);

   QName CAN_GET_PROPERTIES = new QName(CMIS_NS_URI, "canGetProperties", CMIS_PREFIX);

   QName CAN_GET_OBJECT_RELATIONSHIPS = new QName(CMIS_NS_URI, "canGetObjectRelationships", CMIS_PREFIX);

   QName CAN_MOVE_OBJECT = new QName(CMIS_NS_URI, "canMoveObject", CMIS_PREFIX);

   QName CAN_REMOVE_OBJECT_FROM_FOLDER = new QName(CMIS_NS_URI, "canRemoveObjectFromFolder", CMIS_PREFIX);

   QName CAN_REMOVE_POLICY = new QName(CMIS_NS_URI, "canRemovePolicy", CMIS_PREFIX);

   QName CAN_SET_CONTENT_STREAM = new QName(CMIS_NS_URI, "canSetContentStream", CMIS_PREFIX);

   QName CAN_UPDATE_PROPERTIES = new QName(CMIS_NS_URI, "canUpdateProperties", CMIS_PREFIX);

   QName CAN_GET_FOLDER_TREE = new QName(CMIS_NS_URI, "canGetFolderTree", CMIS_PREFIX);

   QName CAN_DELETE_OBJECT = new QName(CMIS_NS_URI, "canDeleteObject", CMIS_PREFIX);

   QName CAPABILITIES = new QName(CMIS_NS_URI, "capabilities", CMIS_PREFIX);

   QName ACL_CAPABILITY = new QName(CMIS_NS_URI, "aclCapability", CMIS_PREFIX);

   QName CAPABILITY_ACL = new QName(CMIS_NS_URI, "capabilityACL", CMIS_PREFIX);

   QName CAPABILITY_ALL_VERSIONS_SEARCHABLE = new QName(CMIS_NS_URI, "capabilityAllVersionsSearchable", CMIS_PREFIX);

   QName CAPABILITY_CHANGES = new QName(CMIS_NS_URI, "capabilityChanges", CMIS_PREFIX);

   QName CAPABILITY_CONTENT_STREAM_UPDATABILITY =
      new QName(CMIS_NS_URI, "capabilityContentStreamUpdatability", CMIS_PREFIX);

   QName CAPABILITY_GET_DESCENDANTS = new QName(CMIS_NS_URI, "capabilityGetDescendants", CMIS_PREFIX);

   QName CAPABILITY_GET_FOLDER_TREE = new QName(CMIS_NS_URI, "capabilityGetFolderTree", CMIS_PREFIX);

   QName CAPABILITY_CHANGES_INCOMPLETE = new QName(CMIS_NS_URI, "capabilityChangesIncomplete", CMIS_PREFIX);

   QName CAPABILITY_JOIN = new QName(CMIS_NS_URI, "capabilityJoin", CMIS_PREFIX);

   QName CAPABILITY_MULTIFILLING = new QName(CMIS_NS_URI, "capabilityMultifiling", CMIS_PREFIX);

   QName CAPABILITY_PWC_SEARCHABLE = new QName(CMIS_NS_URI, "capabilityPWCSearchable", CMIS_PREFIX);

   QName CAPABILITY_PWC_UPDATEABLE = new QName(CMIS_NS_URI, "capabilityPWCUpdateable", CMIS_PREFIX);

   QName CAPABILITY_QUERY = new QName(CMIS_NS_URI, "capabilityQuery", CMIS_PREFIX);

   QName CAPABILITY_RENDITIONS = new QName(CMIS_NS_URI, "capabilityRenditions", CMIS_PREFIX);

   QName CAPABILITY_UNFILING = new QName(CMIS_NS_URI, "capabilityUnfiling", CMIS_PREFIX);

   QName CAPABILITY_VERSION_SPECIFIC_FILING = new QName(CMIS_NS_URI, "capabilityVersionSpecificFiling", CMIS_PREFIX);

   QName PROPAGATION = new QName(CMIS_NS_URI, "propagation", CMIS_PREFIX);

   QName SUPPORTED_PERMISSIONS = new QName(CMIS_NS_URI, "supportedPermissions", CMIS_PREFIX);

   QName CARDINALITY = new QName(CMIS_NS_URI, "cardinality", CMIS_PREFIX);

   QName CHILDREN = new QName(CMISRA_NS_URI, "children", CMISRA_PREFIX);

   QName CHOICE = new QName(CMIS_NS_URI, "choice", CMIS_PREFIX);

   QName RESOLUTION = new QName(CMIS_NS_URI, "resolution", CMIS_PREFIX);

   QName COLLECTION_TYPE = new QName(CMISRA_NS_URI, "collectionType", CMISRA_PREFIX);

   QName CMIS_VERSION_SUPPORTED = new QName(CMIS_NS_URI, "cmisVersionSupported", CMIS_PREFIX);

   QName THIN_CLIENT_URI = new QName(CMIS_NS_URI, "thinClientURI", CMIS_PREFIX);

   QName CHANGES_INCOMPLETE = new QName(CMIS_NS_URI, "changesIncomplete", CMIS_PREFIX);

   QName CHANGES_ON_TYPE = new QName(CMIS_NS_URI, "changesOnType", CMIS_PREFIX);

   QName PRINCIPAL_ANONYMOUS = new QName(CMIS_NS_URI, "principalAnonymous", CMIS_PREFIX);

   QName PRINCIPAL_ANYONE = new QName(CMIS_NS_URI, "principalAnyone", CMIS_PREFIX);

   QName CONTROLLABLE_ACL = new QName(CMIS_NS_URI, "controllableACL", CMIS_PREFIX);

   QName CONTROLLABLE_POLICY = new QName(CMIS_NS_URI, "controllablePolicy", CMIS_PREFIX);

   QName CREATABLE = new QName(CMIS_NS_URI, "creatable", CMIS_PREFIX);

   QName DEFAULT_VALUE = new QName(CMIS_NS_URI, "defaultValue", CMIS_PREFIX);

   QName DIRECT = new QName(CMIS_NS_URI, "direct", CMIS_PREFIX);

   QName DESCRIPTION = new QName(CMIS_NS_URI, "description", CMIS_PREFIX);

   QName DISPLAY_NAME = new QName(CMIS_NS_URI, "displayName", CMIS_PREFIX);

   QName FILEABLE = new QName(CMIS_NS_URI, "fileable", CMIS_PREFIX);

   QName ID = new QName(CMIS_NS_URI, "id", CMIS_PREFIX);

   QName INCLUDED_IN_SUPERTYPE_QUERY = new QName(CMIS_NS_URI, "includedInSupertypeQuery", CMIS_PREFIX);

   QName INHERITED = new QName(CMIS_NS_URI, "inherited", CMIS_PREFIX);

   QName MAX_LENGTH = new QName(CMIS_NS_URI, "maxLength", CMIS_PREFIX);

   QName MAX_VALUE = new QName(CMIS_NS_URI, "maxValue", CMIS_PREFIX);

   QName MIN_VALUE = new QName(CMIS_NS_URI, "minValue", CMIS_PREFIX);

   QName NAME = new QName(CMIS_NS_URI, "name", CMIS_PREFIX);

   QName OBJECT = new QName(CMISRA_NS_URI, "object", CMISRA_PREFIX);

   QName OPEN_CHOICE = new QName(CMIS_NS_URI, "openChoice", CMIS_PREFIX);

   QName ORDERABLE = new QName(CMIS_NS_URI, "orderable", CMIS_PREFIX);

   QName PACKAGE = new QName(CMIS_NS_URI, "package", CMIS_PREFIX);

   QName MAX_ITEMS = new QName(CMIS_NS_URI, "maxItems", CMIS_PREFIX);

   QName PARENT_ID = new QName(CMIS_NS_URI, "parentId", CMIS_PREFIX);

   QName PERMISSION = new QName(CMIS_NS_URI, "permission", CMIS_PREFIX);

   QName PERMISSIONS = new QName(CMIS_NS_URI, "permissions", CMIS_PREFIX);

   QName KEY = new QName(CMIS_NS_URI, "key", CMIS_PREFIX);

   QName MAPPING = new QName(CMIS_NS_URI, "mapping", CMIS_PREFIX);

   QName PRECISION = new QName(CMIS_NS_URI, "precision", CMIS_PREFIX);

   QName PRODUCT_NAME = new QName(CMIS_NS_URI, "productName", CMIS_PREFIX);

   QName PRODUCT_VERSION = new QName(CMIS_NS_URI, "productVersion", CMIS_PREFIX);

   QName PROPERTIES = new QName(CMIS_NS_URI, "properties", CMIS_PREFIX);

   QName PROPERTY_BOOLEAN = new QName(CMIS_NS_URI, "propertyBoolean", CMIS_PREFIX);

   QName PROPERTY_BOOLEAN_DEFINITION = new QName(CMIS_NS_URI, "propertyBooleanDefinition", CMIS_PREFIX);

   QName PROPERTY_DATE_TIME = new QName(CMIS_NS_URI, "propertyDateTime", CMIS_PREFIX);

   QName PROPERTY_DATE_TIME_DEFINITION = new QName(CMIS_NS_URI, "propertyDateTimeDefinition", CMIS_PREFIX);

   QName PROPERTY_DECIMAL = new QName(CMIS_NS_URI, "propertyDecimal", CMIS_PREFIX);

   QName PROPERTY_DECIMAL_DEFINITION = new QName(CMIS_NS_URI, "propertyDecimalDefinition", CMIS_PREFIX);

   QName PROPERTY_DEFINITION = new QName(CMIS_NS_URI, "propertyDefinition", CMIS_PREFIX);

   QName PROPERTY_DEFINITION_ID = new QName(CMIS_NS_URI, "propertyDefinitionId", CMIS_PREFIX);

   QName LOCAL_NAME = new QName(CMIS_NS_URI, "localName", CMIS_PREFIX);

   QName LOCAL_NAMESPACE = new QName(CMIS_NS_URI, "localNamespace", CMIS_PREFIX);

   QName PRINCIPAL = new QName(CMIS_NS_URI, "principal", CMIS_PREFIX);

   QName PRINCIPAL_ID = new QName(CMIS_NS_URI, "principalId", CMIS_PREFIX);

   QName PROPERTY_HTML = new QName(CMIS_NS_URI, "propertyHtml", CMIS_PREFIX);

   QName PROPERTY_HTML_DEFINITION = new QName(CMIS_NS_URI, "propertyHtmlDefinition", CMIS_PREFIX);

   QName PROPERTY_ID = new QName(CMIS_NS_URI, "propertyId", CMIS_PREFIX);

   QName PROPERTY_ID_DEFINITION = new QName(CMIS_NS_URI, "propertyIdDefinition", CMIS_PREFIX);

   QName PROPERTY_INTEGER = new QName(CMIS_NS_URI, "propertyInteger", CMIS_PREFIX);

   QName PROPERTY_INTEGER_DEFINITION = new QName(CMIS_NS_URI, "propertyIntegerDefinition", CMIS_PREFIX);

   QName PROPERTY_STRING = new QName(CMIS_NS_URI, "propertyString", CMIS_PREFIX);

   QName PROPERTY_STRING_DEFINITION = new QName(CMIS_NS_URI, "propertyStringDefinition", CMIS_PREFIX);

   QName PROPERTY_TYPE = new QName(CMIS_NS_URI, "propertyType", CMIS_PREFIX);

   QName PROPERTY_URI = new QName(CMIS_NS_URI, "propertyUri", CMIS_PREFIX);

   QName PROPERTY_URI_DEFINITION = new QName(CMIS_NS_URI, "propertyUriDefinition", CMIS_PREFIX);

   QName PROPERTY_DEFINITIONS[] =
      new QName[]{PROPERTY_BOOLEAN_DEFINITION, PROPERTY_DATE_TIME_DEFINITION, PROPERTY_DECIMAL_DEFINITION,
         PROPERTY_HTML_DEFINITION, PROPERTY_ID_DEFINITION, PROPERTY_INTEGER_DEFINITION, PROPERTY_STRING_DEFINITION,
         PROPERTY_URI_DEFINITION};

   QName QUERY = new QName(CMIS_NS_URI, "query", CMIS_PREFIX);

   QName QUERY_NAME = new QName(CMIS_NS_URI, "queryName", CMIS_PREFIX);

   QName QUERYABLE = new QName(CMIS_NS_URI, "queryable", CMIS_PREFIX);

   QName FULLTEXT_INDEXED = new QName(CMIS_NS_URI, "fulltextIndexed", CMIS_PREFIX);

   QName RELATIOSNHIP = new QName(CMIS_NS_URI, "relationship", CMIS_PREFIX);

   QName CHANGE_EVENT_INFO = new QName(CMIS_NS_URI, "changeEventInfo", CMIS_PREFIX);

   QName ACL = new QName(CMIS_NS_URI, "acl", CMIS_PREFIX);

   QName EXACT_ACL = new QName(CMIS_NS_URI, "exactACL", CMIS_PREFIX);

   QName POLICY_IDS = new QName(CMIS_NS_URI, "policyIds", CMIS_PREFIX);

   QName RENDITION = new QName(CMIS_NS_URI, "rendition", CMIS_PREFIX);

   QName STREAM_ID = new QName(CMIS_NS_URI, "streamId", CMIS_PREFIX);

   QName MIMETYPE = new QName(CMIS_NS_URI, "mimetype", CMIS_PREFIX);

   QName LENGTH = new QName(CMIS_NS_URI, "length", CMIS_PREFIX);

   QName KIND = new QName(CMIS_NS_URI, "kind", CMIS_PREFIX);

   QName TITLE = new QName(CMIS_NS_URI, "title", CMIS_PREFIX);

   QName HEIGHT = new QName(CMIS_NS_URI, "height", CMIS_PREFIX);

   QName WIDTH = new QName(CMIS_NS_URI, "width", CMIS_PREFIX);

   QName RENDITION_DOCUMENT_ID = new QName(CMIS_NS_URI, "renditionDocumentId", CMIS_PREFIX);

   QName CHANGE_TYPE = new QName(CMIS_NS_URI, "changeType", CMIS_PREFIX);

   QName CHANGE_TIME = new QName(CMIS_NS_URI, "changeTime", CMIS_PREFIX);

   QName REPOSITORY_DESCRIPTION = new QName(CMIS_NS_URI, "repositoryDescription", CMIS_PREFIX);

   QName REPOSITORY_ENTRY = new QName(CMIS_NS_URI, "repositoryEntry", CMIS_PREFIX);

   QName REPOSITORY_ID = new QName(CMIS_NS_URI, "repositoryId", CMIS_PREFIX);

   QName REPOSITORY_INFO = new QName(CMISRA_NS_URI, "repositoryInfo", CMISRA_PREFIX);

   QName REPOSITORY_NAME = new QName(CMIS_NS_URI, "repositoryName", CMIS_PREFIX);

   QName REPOSITORY_RELATIONSHIP = new QName(CMIS_NS_URI, "repositoryRelationship", CMIS_PREFIX);

   QName REPOSITORY_URI = new QName(CMIS_NS_URI, "repositoryURI", CMIS_PREFIX);

   QName REPOSITORY_SPECIFIC_INFORMATION = new QName(CMIS_NS_URI, "repositorySpecificInformation", CMIS_PREFIX);

   QName REQUIRED = new QName(CMIS_NS_URI, "required", CMIS_PREFIX);

   QName ROOT_FOLDER_ID = new QName(CMIS_NS_URI, "rootFolderId", CMIS_PREFIX);

   QName SCHEMA_URI = new QName(CMIS_NS_URI, "schemaURI", CMIS_PREFIX);

   QName SEARCH_ALL_VERSIONS = new QName(CMIS_NS_URI, "searchAllVersions", CMIS_PREFIX);

   QName SKIP_COUNT = new QName(CMIS_NS_URI, "skipCount", CMIS_PREFIX);

   QName STATEMENT = new QName(CMIS_NS_URI, "statement", CMIS_PREFIX);

   QName INCLUDE_ALLOWABLE_ACTIONS = new QName(CMIS_NS_URI, "includeAllowableActions", CMIS_PREFIX);

   QName INCLUDE_RELATIONSHIPS = new QName(CMIS_NS_URI, "includeRelationships", CMIS_PREFIX);

   QName RENDITION_FILTER = new QName(CMIS_NS_URI, "renditionFilter", CMIS_PREFIX);

   QName TYPE = new QName(CMISRA_NS_URI, "type", CMISRA_PREFIX);

   QName RENDITION_KIND = new QName(CMISRA_NS_URI, "renditionKind", CMISRA_PREFIX);

   QName TYPE_ID = new QName(CMIS_NS_URI, "typeId", CMIS_PREFIX);

   QName UPDATABILITY = new QName(CMIS_NS_URI, "updatability", CMIS_PREFIX);

   QName VALUE = new QName(CMIS_NS_URI, "value", CMIS_PREFIX);

   QName VENDOR_NAME = new QName(CMIS_NS_URI, "vendorName", CMIS_PREFIX);

   QName URITEMPLATE = new QName(CMISRA_NS_URI, "uritemplate", CMISRA_PREFIX);

   QName MEDIATYPE = new QName(CMISRA_NS_URI, "mediatype", CMISRA_PREFIX);

   QName BASE64 = new QName(CMISRA_NS_URI, "base64", CMISRA_PREFIX);

   QName TEMPLATE = new QName(CMISRA_NS_URI, "template", CMISRA_PREFIX);

   QName VERSIONABLE = new QName(CMIS_NS_URI, "versionable", CMIS_PREFIX);

   QName CONTENT_STREAM_ALLOWED = new QName(CMIS_NS_URI, "contentStreamAllowed", CMIS_PREFIX);

   QName ALLOWED_SOURCE_TYPES = new QName(CMIS_NS_URI, "allowedSourceTypes", CMIS_PREFIX);

   QName ALLOWED_TARGET_TYPES = new QName(CMIS_NS_URI, "allowedTargetTypes", CMIS_PREFIX);

   QName CONTENT = new QName(CMISRA_NS_URI, "content", CMISRA_PREFIX);

   QName NUM_ITEMS = new QName(CMISRA_NS_URI, "numItems", CMISRA_PREFIX);

   QName PATH_SEGMENT = new QName(CMISRA_NS_URI, "pathSegment", CMISRA_PREFIX);

   QName RELATIVE_PATH_SEGMENT = new QName(CMISRA_NS_URI, "relativePathSegment", CMISRA_PREFIX);

   QName LATEST_CHANGE_LOG_TOKEN = new QName(CMIS_NS_URI, "latestChangeLogToken", CMIS_PREFIX);

   //   QName HAS_MORE_ITEMS = new QName(CMISRA_NS_URI, "hasMoreItems", CMISRA_PREFIX);

   String PARAM_ORDER_BY = "orderBy";

   String PARAM_CHANGE_LOG_TOKEN = "changeLogToken";

   String PARAM_CHILD_TYPES = "childTypes";

   String PARAM_CONTINUE_ON_FAILURE = "continueOnFailure";

   String PARAM_CHECKIN = "checkin";

   String PARAM_CHECKIN_COMMENT = "checkinComment";

   String PARAM_DEPTH = "depth";

   String PARAM_DIRECTION = "direction";

   String PARAM_FILTER = "filter";

   String PARAM_FOLDER_ID = "folderId";

   String PARAM_INCLUDE_ACL = "includeACL";

   String PARAM_INCLUDE_ALLOWABLE_ACTIONS = "includeAllowableActions";

   String PARAM_INCLUDE_PROPERTIES = "includeProperties";

   String PARAM_INCLUDE_PATH_SEGMENT = "includePathSegment";

   String PARAM_INCLUDE_RELATIVE_PATH_SEGMENT = "includeRelativePathSegment";

   String PARAM_INCLUDE_PROPERTY_DEFINITIONS = "includePropertyDefinitions";

   String PARAM_INCLUDE_POLICY_IDS = "includePolicyIds";

   String PARAM_INCLUDE_RELATIONSHIPS = "includeRelationships";

   String PARAM_INCLUDE_SUB_RELATIONSHIP_TYPES = "includeSubRelationshipTypes";

   String PARAM_LENGTH = "length";

   String PARAM_MAJOR = "major";

   String PARAM_MAX_ITEMS = "maxItems";

   String PARAM_OVERWRITE_FLAG = "overwriteFlag";

   String PARAM_RELATIONSHIP_DIRECTION = "relationshipDirection";

   String PARAM_RELATIONSHIP_TYPE = "relationshipType";

   String PARAM_RENDITION_FILTER = "renditionFilter";

   String PARAM_REMOVE_FROM = "removeFrom";

   String PARAM_REPOSITORY_ID = "repositoryId";

   String PARAM_RETURN_VERSION = "returnVersion";

   String PARAM_SKIP_COUNT = "skipCount";

   String PARAM_SOURCE_FOLDER_ID = "sourceFolderId";

   String PARAM_THIS_VERSION = "thisVersion";

   String PARAM_TYPE_ID = "typeId";

   String PARAM_TYPES = "types";

   String PARAM_UNFILE_OBJECT = "unfileObjects";

   String PARAM_VERSIONING_STATE = "versioningState";
   
   String PARAM_ALL_VERSIONS = "allVersions";

   String LINK_SELF = "self";

   String LINK_EDIT = "edit";

   String LINK_EDIT_MEDIA = "edit-media";

   String LINK_VIA = "via";

   String LINK_UP = "up";

   String LINK_DOWN = "down";

   String LINK_ALTERNATE = "alternate";

   String LINK_VERSION_HISTORY = "version-history";

   String LINK_CURRENT_VERSION = "current-version";

   String LINK_WORKING_COPY = "working-copy";

   String LINK_SERVICE = "service";

   String LINK_DESCRIBEDBY = "describedby";

   String LINK_FIRST = "first";

   String LINK_LAST = "last";

   String LINK_NEXT = "next";

   String LINK_PREVIOUS = "previous";

   String LINK_CMIS_ALLOWABLEACTIONS = "http://docs.oasis-open.org/ns/cmis/link/200908/allowableactions";

   String LINK_CMIS_RELATIONSHIPS = "http://docs.oasis-open.org/ns/cmis/link/200908/relationships";

   String LINK_CMIS_SOURCE = "http://docs.oasis-open.org/ns/cmis/link/200908/source";

   String LINK_CMIS_TARGET = "http://docs.oasis-open.org/ns/cmis/link/200908/target";

   String LINK_CMIS_POLICIES = "http://docs.oasis-open.org/ns/cmis/link/200908/policies";

   String LINK_CMIS_ACL = "http://docs.oasis-open.org/ns/cmis/link/200908/acl";

   String LINK_CMIS_CHANGES = "http://docs.oasis-open.org/ns/cmis/link/200908/changes";

   String LINK_CMIS_FOLDERTREE = "http://docs.oasis-open.org/ns/cmis/link/200908/foldertree";

   String LINK_CMIS_TYPEDESCENDANTS = "http://docs.oasis-open.org/ns/cmis/link/200908/typedescendants";

   String LINK_CMIS_ROOTDESCENDANTS = "http://docs.oasis-open.org/ns/cmis/link/200908/rootdescendants";

   String COLLECTION_TYPE_ROOT = "root";

   String COLLECTION_TYPE_UNFILED = "unfiled";

   String COLLECTION_TYPE_CHECKEDOUT = "checkedout";

   String COLLECTION_TYPE_TYPES = "types";

   String COLLECTION_TYPE_QUERY = "query";

   String COLLECTION_TYPE_CHANGES = "changes";

   String MEDIATYPE_ALLOWABLE_ACTIONS = "application/cmis+xml;type=allowableActions";

   String MEDIATYPE_ATOM_SERVICE = "application/atomsvc+xml";

   String MEDIATYPE_ATOM_ENTRY = "application/atom+xml;type=entry";

   String MEDIATYPE_ATOM_FEED = "application/atom+xml;type=feed";

   String MEDIATYPE_CMISTREE = "application/cmistree+xml";

   String MEDIATYPE_ACL = "application/cmisacl+xml";

   String URITEMPLATE_OBJECTBYID = "objectbyid";

   String URITEMPLATE_OBJECTBYPATH = "objectbypath";

   String URITEMPLATE_QUERY = "query";

   String URITEMPLATE_TYPEBYID = "typebyid";

   String URITEMPLATE_CHANGES = "changes";

   String CONTENT_DISPOSITION_HEADER = "Content-Disposition";

}

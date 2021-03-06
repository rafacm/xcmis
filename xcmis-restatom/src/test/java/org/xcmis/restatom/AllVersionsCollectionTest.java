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

import org.everrest.core.impl.ContainerResponse;
import org.everrest.core.tools.ByteArrayContainerResponseWriter;
import org.w3c.dom.NodeList;
import org.xcmis.spi.BaseContentStream;
import org.xcmis.spi.ContentStream;
import org.xcmis.spi.model.CmisObject;
import org.xcmis.spi.utils.MimeType;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author <a href="mailto:andrey.parfonov@exoplatform.com">Andrey Parfonov</a>
 * @version $Id: AllVersionsCollectionTest.java 2 2010-02-04 17:21:49Z andrew00x
 *          $
 */
public class AllVersionsCollectionTest extends BaseTest
{

   public void testGetAllVersionsWithPWC() throws Exception
   {
      String docId = createDocument(testFolderId, "doc1", null, null);
      conn.checkout(docId);

      CmisObject doc = getCmisObject(docId);
      String versionSeriesId = doc.getObjectInfo().getVersionSeriesId();

      // One source document and private working copy in version series.
      String requestURI =
         "http://localhost:8080/rest" + "/cmisatom/" + cmisRepositoryId + "/versions/" + versionSeriesId;
      ByteArrayContainerResponseWriter writer = new ByteArrayContainerResponseWriter();
      ContainerResponse resp = service("GET", requestURI, "http://localhost:8080/rest", null, null, writer);

      //      printBody(writer.getBody());
      assertEquals(200, resp.getStatus());

      DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
      f.setNamespaceAware(true);
      org.w3c.dom.Document xmlDoc = f.newDocumentBuilder().parse(new ByteArrayInputStream(writer.getBody()));

      org.w3c.dom.Node xmlFeed = getNode("atom:feed", xmlDoc);
      validateFeedCommons(xmlFeed);
      // Check feed links.
      assertTrue(hasLink(AtomCMIS.LINK_SERVICE, xmlFeed));
      assertTrue(hasLink(AtomCMIS.LINK_SELF, xmlFeed));
      assertTrue(hasLink(AtomCMIS.LINK_VIA, xmlFeed));
      assertTrue(hasLink(AtomCMIS.LINK_FIRST, xmlFeed));

      assertEquals("2", getStringElement("cmisra:numItems", xmlFeed));

      NodeList entries = getNodeSet("atom:entry", xmlFeed);
      int length = entries.getLength();
      assertEquals(2, length);
      for (int i = 0; i < length; i++)
      {
         org.w3c.dom.Node n = entries.item(i);
         validateObjectEntry(n, "cmis:document");
      }

   }

   public void testGetAllVersions() throws Exception
   {
      String docId = createDocument(testFolderId, "doc1", null, null);
      String docIdPWC = conn.checkout(docId);

      CmisObject doc = getCmisObject(docId);
      String versionSeriesId = doc.getObjectInfo().getVersionSeriesId();

      ContentStream data =
         new BaseContentStream("test".getBytes("UTF-8"), "test", MimeType.fromString("text/plain;charset=UTF-8"));
      conn.checkin(docIdPWC, true, null, data, "checkin comment", null, null, null);

      // One source document and new version in version series.
      String requestURI =
         "http://localhost:8080/rest" + "/cmisatom/" + cmisRepositoryId + "/versions/" + versionSeriesId;// + "?filter=*";

      ByteArrayContainerResponseWriter writer = new ByteArrayContainerResponseWriter();
      ContainerResponse resp = service("GET", requestURI, "http://localhost:8080/rest", null, null, writer);

      //      printBody(writer.getBody());
      assertEquals(200, resp.getStatus());

      DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
      f.setNamespaceAware(true);
      org.w3c.dom.Document xmlDoc = f.newDocumentBuilder().parse(new ByteArrayInputStream(writer.getBody()));

      org.w3c.dom.Node xmlFeed = getNode("atom:feed", xmlDoc);
      validateFeedCommons(xmlFeed);
      // Check feed links.
      assertTrue(hasLink(AtomCMIS.LINK_SERVICE, xmlFeed));
      assertTrue(hasLink(AtomCMIS.LINK_SELF, xmlFeed));
      assertTrue(hasLink(AtomCMIS.LINK_VIA, xmlFeed));
      assertTrue(hasLink(AtomCMIS.LINK_FIRST, xmlFeed));

      NodeList entries = getNodeSet("atom:entry", xmlFeed);
      int length = entries.getLength();
      assertEquals(2, length);
      for (int i = 0; i < length; i++)
      {
         org.w3c.dom.Node n = entries.item(i);
         validateObjectEntry(n, "cmis:document");
      }

      assertEquals(2, Integer.parseInt(getStringElement("cmisra:numItems", xmlFeed)));
   }

}

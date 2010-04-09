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
package org.xcmis.sp.inmemory.query;

import org.xcmis.search.content.ContentEntry;
import org.xcmis.search.content.command.InvocationContext;
import org.xcmis.search.content.command.read.GetChildEntriesCommand;
import org.xcmis.search.content.command.read.GetContentEntryCommand;
import org.xcmis.search.content.interceptors.ContentReaderInterceptor;
import org.xcmis.sp.inmemory.query.IndexListener.ContentEntryAdapter;
import org.xcmis.spi.ItemsIterator;
import org.xcmis.spi.Storage;
import org.xcmis.spi.data.Folder;
import org.xcmis.spi.data.ObjectData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:Sergey.Kabashnyuk@exoplatform.org">Sergey Kabashnyuk</a>
 * @version $Id: exo-jboss-codetemplates.xml 34360 2009-07-22 23:58:59Z ksm $
 *
 */
public class CmisContentReader extends ContentReaderInterceptor
{
   private final Storage storage;

   private final ContentEntryAdapter contentEntryAdapter;

   /**
    * @param storage
    */
   public CmisContentReader(Storage storage)
   {
      super();
      this.storage = storage;
      this.contentEntryAdapter = new ContentEntryAdapter();
   }

   /**
    * @see org.xcmis.search.content.interceptors.ContentReaderInterceptor#visitChildEntriesCommand(org.xcmis.search.content.command.InvocationContext, org.xcmis.search.content.command.read.GetChildEntriesCommand)
    */
   @Override
   public Object visitChildEntriesCommand(InvocationContext ctx, GetChildEntriesCommand command) throws Throwable
   {
      List<ContentEntry> childs = new ArrayList<ContentEntry>();
      ObjectData parent = storage.getObject(command.getParentUuid());
      if (parent instanceof Folder)
      {
         ItemsIterator<ObjectData> childDatas = ((Folder)parent).getChildren(null);
         while (childDatas.hasNext())
         {
            childs.add(contentEntryAdapter.createEntry(childDatas.next()));

         }

      }
      return childs;
   }

   /**
    * @see org.xcmis.search.content.interceptors.ContentReaderInterceptor#visitGetContentEntryCommand(org.xcmis.search.content.command.InvocationContext, org.xcmis.search.content.command.read.GetContentEntryCommand)
    */
   @Override
   public Object visitGetContentEntryCommand(InvocationContext ctx, GetContentEntryCommand command) throws Throwable
   {

      ObjectData entry = storage.getObject(command.getEntryUuid());
      return contentEntryAdapter.createEntry(entry);
   }

}
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
package org.xcmis.search.content;

import org.xcmis.search.SearchServiceException;

/**
 *  
 */
public class ColumnDoesNotExistOnTable extends SearchServiceException
{

   /**
    * 
    */
   public ColumnDoesNotExistOnTable()
   {
      // TODO Auto-generated constructor stub
   }

   /**
    * @param message
    */
   public ColumnDoesNotExistOnTable(String message)
   {
      super(message);
      // TODO Auto-generated constructor stub
   }

   /**
    * @param cause
    */
   public ColumnDoesNotExistOnTable(Throwable cause)
   {
      super(cause);
      // TODO Auto-generated constructor stub
   }

   /**
    * @param message
    * @param cause
    */
   public ColumnDoesNotExistOnTable(String message, Throwable cause)
   {
      super(message, cause);
      // TODO Auto-generated constructor stub
   }

}

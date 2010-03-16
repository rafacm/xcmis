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
package org.xcmis.search.query.parser;

import org.xcmis.search.InvalidQueryException;
import org.xcmis.search.model.Query;

/**
 * The basic interface defining a component that is able to parse a string query into a {@link Query}.
 */
public interface QueryParser
{

   /**
    * Get the name of the language that this parser is able to understand.
    * 
    * @return the language name; never null
    */
   String getLanguage();

   /**
    * Parse the supplied query from a string representation into a {@link QueryCommand}.
    * 
    * @param query the query in string form; may not be null
    * @param typeSystem the type system used by the query; may not be null
    * @return the query command
    * @throws ParsingException if there is an error parsing the supplied query
    * @throws InvalidQueryException if the supplied query can be parsed but is invalid
    */
   Query parseQuery(String statement) throws InvalidQueryException;

}

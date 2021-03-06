/*
 * Copyright (C) 2009 eXo Platform SAS.
 * 
 * This is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this software; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA, or see the FSF
 * site: http://www.fsf.org.
 */
package org.xcmis.search.model.source.join;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.xcmis.search.QueryObjectModelVisitor;
import org.xcmis.search.VisitException;
import org.xcmis.search.Visitors;
import org.xcmis.search.model.source.SelectorName;

/**
 * Created by The eXo Platform SAS.
 * 
 * @author <a href="mailto:Sergey.Kabashnyuk@gmail.com">Sergey Kabashnyuk</a>
 * @version $Id: SameNodeJoinConditionImpl.java 2 2010-02-04 17:21:49Z andrew00x
 *          $
 */
public class SameNodeJoinCondition extends JoinCondition
{
   
   /** The  serialVersionUID. */
   private static final long serialVersionUID = 8876245918655451590L;

   private final SelectorName selector1Name;

   private final SelectorName selector2Name;

   private final String selector2Path;

   private final int hcode;

   /**
    * Create a join condition that determines whether the node identified by the
    * first selector is the same as the node identified by the second selector.
    * 
    * @param selector1Name
    *           the name of the first selector
    * @param selector2Name
    *           the name of the second selector
    */
   public SameNodeJoinCondition(SelectorName selector1Name, SelectorName selector2Name)
   {
      this(selector1Name, selector2Name, null);
   }

   /**
    * Create a join condition that determines whether the node identified by the
    * first selector is the same as the node at the given path relative to the
    * node identified by the second selector.
    * 
    * @param selector1Name
    *           the name of the first selector
    * @param selector2Name
    *           the name of the second selector
    * @param selector2Path
    *           the relative path from the second selector locating the node
    *           being compared with the first selector
    */
   public SameNodeJoinCondition(SelectorName selector1Name, SelectorName selector2Name, String selector2Path)
   {
      Validate.notNull(selector1Name, "The selector1Name argument may not be null");
      Validate.notNull(selector2Name, "The selector2Name argument may not be null");

      this.selector1Name = selector1Name;
      this.selector2Name = selector2Name;
      this.selector2Path = selector2Path;

      this.hcode = new HashCodeBuilder()
                  .append(selector1Name)
                  .append(selector2Name)
                  .append(selector2Path)
                  .toHashCode();
   }

   /**
    * @see org.xcmis.search.model.QueryElement#accept(org.xcmis.search.QueryObjectModelVisitor)
    */
   public void accept(QueryObjectModelVisitor visitor) throws VisitException
   {
      visitor.visit(this);
   }

   /**
    * {@inheritDoc}
    * 
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj == null)
      {
         return false;
      }
      if (obj == this)
      {
         return true;
      }
      if (obj.getClass() != getClass())
      {
         return false;
      }
      SameNodeJoinCondition rhs = (SameNodeJoinCondition)obj;
      return new EqualsBuilder()
                    .append(selector1Name, rhs.selector1Name)
                    .append(selector2Name, rhs.selector2Name)
                    .append(selector2Path, rhs.selector2Path)
                    .isEquals();
   }

   /**
    * Get the selector name for the first side of the join condition.
    * 
    * @return the name of the first selector; never null
    */
   public final SelectorName getSelector1Name()
   {
      return selector1Name;
   }

   /**
    * Get the selector name for the second side of the join condition.
    * 
    * @return the name of the second selector; never null
    */
   public final SelectorName getSelector2Name()
   {
      return selector2Name;
   }

   /**
    * Get the path for the node being used, relative to the second selector.
    * 
    * @return the relative path to the node; may be null if the second selector
    *         is the node being used
    */
   public final String getSelector2Path()
   {
      return selector2Path;
   }

   /**
    * {@inheritDoc}
    * 
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      return hcode;
   }

   /**
    * {@inheritDoc}
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return Visitors.readable(this);
   }
}

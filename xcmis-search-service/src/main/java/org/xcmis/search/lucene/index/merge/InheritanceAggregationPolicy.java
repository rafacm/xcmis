/*
 * Copyright (C) 2009 eXo Platform SAS.
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
package org.xcmis.search.lucene.index.merge;

import org.xcmis.search.lucene.index.LuceneIndexDataManager;
import org.xcmis.spi.utils.Logger;

import java.util.Collection;

/**
 * Created by The eXo Platform SAS.
 * 
 * @author <a href="mailto:Sergey.Kabashnyuk@gmail.com">Sergey Kabashnyuk</a>
 * @version $Id: InheritanceAggregationPolicy.java 2 2010-02-04 17:21:49Z andrew00x $
 */
public abstract class InheritanceAggregationPolicy implements AggregatePolicy
{
   /**
    * Class logger.
    */
   private static final Logger LOG = Logger.getLogger(InheritanceAggregationPolicy.class);

   private final AggregatePolicy superAggregatePolicy;

   public InheritanceAggregationPolicy(AggregatePolicy superAggregatePolicy)
   {
      super();
      this.superAggregatePolicy = superAggregatePolicy;
   }

   public Collection<LuceneIndexDataManager> findIndexDataManagerToAggrigate(
      Collection<LuceneIndexDataManager> aggregateCandidat, long requiredCandidatCount, long reguiredTotalCandidatSize)
   {
      return superAggregatePolicy.findIndexDataManagerToAggrigate(aggregateCandidat, requiredCandidatCount,
         reguiredTotalCandidatSize);
   }

   public Collection<LuceneIndexDataManager> findIndexDataManagerToOptimize(
      Collection<LuceneIndexDataManager> aggregateCandidat)
   {
      return superAggregatePolicy.findIndexDataManagerToOptimize(aggregateCandidat);
   }

}

package org.cache2k.benchmark;

/*
 * #%L
 * zoo
 * %%
 * Copyright (C) 2013 - 2016 headissue GmbH, Munich
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 * Interface to a cache implementation we use for benchmarking.
 *
 * @author Jens Wilke; created: 2013-06-15
 */
public abstract class BenchmarkCache<K, T> {

  /**
   * Return the element that is present in the cache. The cache source will not be called in turn.
   */
  public T getIfPresent(K key) {
    throw new UnsupportedOperationException();
  }

  /**
   * Puts an entry in the cache. Needed for read/write benchmark.
   */
  public void put(K key, T value) {
    throw new UnsupportedOperationException();
  }

  /** free up all resources of the cache */
  public abstract void destroy();

  /** Configured maximum entry count of the cache */
  public abstract int getCacheSize();

  /** Statistics string produced by the cache. */
  public String getStatistics() { return "<none>"; }

  /** Optional, checks the cache integrity. Called after a run. */
  public void checkIntegrity() { }

  /**
   * Return the original implementation. We use this for experimentation to
   * get and set some runtime parameters during benchmarks runs.
   */
  public Object getOriginalCache() { return null; }

}

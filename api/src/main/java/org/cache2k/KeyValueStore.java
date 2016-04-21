package org.cache2k;

/*
 * #%L
 * cache2k API only package
 * %%
 * Copyright (C) 2000 - 2016 headissue GmbH, Munich
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Map;

/**
 * Reduced interface for read/write data access.
 *
 * <p>This interface contains no methods that expose or mutate the
 * cache state.
 *
 * @author Jens Wilke
 */
public interface KeyValueStore<K, V> extends AdvancedKeyValueSource<K,V> {

  /**
   * Insert a new value and call the writer, if registered.
   *
   * @see Cache#put(Object, Object)
   * @param key key with which the specified value is associated
   * @param value value to be associated with the specified key
   */
  void put(K key, V value);

  /**
   * Insert all elements of the map into the cache and call the writer, if registered.
   *
   * @param valueMap Map of keys with associated values to be inserted in the cache
   * @throws NullPointerException if one of the specified keys is null
   */
  void putAll(Map<? extends K, ? extends V> valueMap);

  /**
   * Remove a mapping from the cache and call the writer, if registered.
   *
   * @see Cache#remove
   * @param key key which mapping is to be removed from the cache, not null
   */
  void remove(K key);

  /**
   * Remove mappings from the cache and call the writer, if registered.
   *
   * @see Cache#removeAll
   * @param keys keys is to be removed from the cache
   */
  void removeAll(Iterable<? extends K> keys);

}

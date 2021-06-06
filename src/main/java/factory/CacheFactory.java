package factory;

import impl.CacheImpl;
import policy.LruEvictionPolicy;
import storage.HashMapStorage;

/**
 * The type Cache factory.
 *
 * @param <Key>   the type parameter
 * @param <Value> the type parameter
 */
public class CacheFactory<Key, Value> {

  /**
   * Default cache cache.
   *
   * @param capacity the capacity
   * @return the cache
   */
  public CacheImpl<Key, Value> defaultCache(final int capacity) {
    return new CacheImpl<>(new LruEvictionPolicy<>(),
        new HashMapStorage<>(capacity));
  }
}

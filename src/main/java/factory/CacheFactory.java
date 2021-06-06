package factory;

import impl.CacheImpl;
import policy.EvictionPolicy;
import storage.Storage;

/**
 * The type Cache factory.
 *
 * @param <Key>   the type parameter
 * @param <Value> the type parameter
 */
public class CacheFactory<Key, Value> {

  private final EvictionPolicy<Key> evictionPolicy;
  private final Storage<Key, Value> storage;

  /**
   * Instantiates a new Cache factory.
   *
   * @param evictionPolicy the eviction policy
   * @param storage        the storage
   */
  public CacheFactory(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
    this.evictionPolicy = evictionPolicy;
    this.storage = storage;
  }

  /**
   * Default cache cache.
   *
   * @param capacity the capacity
   * @return the cache
   */
  public CacheImpl<Key, Value> defaultCache() {
    return new CacheImpl<>(evictionPolicy, storage);
  }
}

package impl;

import exceptions.NotFoundException;
import exceptions.StorageFullException;
import org.apache.log4j.Logger;
import policy.EvictionPolicy;
import storage.Storage;

/**
 * The type Cache.
 *
 * @param <Key>   the type parameter
 * @param <Value> the type parameter
 */
public class CacheImpl<Key, Value> {
  private final EvictionPolicy<Key> evictionPolicy;
  private final Storage<Key, Value> storage;
  static final Logger logger = Logger.getLogger(CacheImpl.class);

  /**
   * Instantiates a new Cache.
   *
   * @param evictionPolicy the eviction policy
   * @param storage        the storage
   */
  public CacheImpl(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
    this.evictionPolicy = evictionPolicy;
    this.storage = storage;
  }

  /**
   * Put.
   *
   * @param key   the key
   * @param value the value
   */
  public void put(Key key, Value value) {
    try {
      storage.add(key, value);
      evictionPolicy.keyAccessed(key);
    } catch (StorageFullException ex) {
      logger.warn("Cache is full...");
      Key evictedKey = evictionPolicy.evictKey();
      if (evictedKey == null) {
        throw new RuntimeException("Storage is full but Evicted Key is null...nothing to evict");
      }
      logger.info("Evicted Key: "+evictedKey);
      storage.remove(evictedKey);
      put(key, value);
    }
  }

  /**
   * Get value.
   *
   * @param key the key
   * @return the value
   */
  public Value get(Key key) {
    try {
      Value value = this.storage.get(key);
      this.evictionPolicy.keyAccessed(key);
      return value;
    } catch (NotFoundException notFoundException) {
      logger.warn("Tried to access non-existing key.");
      return null;
    }
  }

  public void displayCacheContents() {
    storage.displayContents();
  }
}

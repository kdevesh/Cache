package policy;

/**
 * The interface Eviction policy.
 *
 * @param <Key> the type parameter
 */
public interface EvictionPolicy<Key> {
  /**
   * Key accessed.
   *
   * @param key the key
   */
  void keyAccessed(Key key);

  /**
   * Evict key from eviction policy and return it.
   *
   * @return the key
   */
  Key evictKey();
}

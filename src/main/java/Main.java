import factory.CacheFactory;
import impl.CacheImpl;
import policy.EvictionPolicy;
import policy.LruEvictionPolicy;
import storage.HashMapStorage;
import storage.Storage;

public class Main {
  public static void main(String[] args) {
    EvictionPolicy<Integer> evictionPolicy = new LruEvictionPolicy<>();
    Storage<Integer, String> storage = new HashMapStorage<>(5);
    CacheFactory<Integer, String> cacheFactory = new CacheFactory<>(evictionPolicy, storage);
    CacheImpl<Integer, String> cache = cacheFactory.defaultCache();
    cache.put(1, "one");
    cache.put(2, "two");
    cache.put(3, "three");
    cache.put(4, "four");
    cache.put(5, "five");
    cache.put(6, "six");
    cache.displayCacheContents();
  }
}

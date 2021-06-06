import factory.CacheFactory;
import impl.CacheImpl;

public class Main {
  public static void main(String[] args) {
    CacheFactory<Integer,String> cacheFactory = new CacheFactory<>();
    CacheImpl<Integer, String> cache = cacheFactory.defaultCache(5);
    cache.put(1,"one");
    cache.put(2,"two");
    cache.put(3,"three");
    cache.put(4,"four");
    cache.put(5,"five");
    cache.put(6,"six");
    cache.displayCacheContents();
  }
}

package impl;

import static org.junit.jupiter.api.Assertions.*;

import factory.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import policy.EvictionPolicy;
import policy.LruEvictionPolicy;
import storage.HashMapStorage;
import storage.Storage;

class CacheImplTest {

  EvictionPolicy<Integer> evictionPolicy;
  Storage<Integer, String> storage;
  @BeforeEach
  public void setUp(){
    evictionPolicy = new LruEvictionPolicy<>();
    storage = new HashMapStorage<>(5);
  }
  @Test
  void put() {
    CacheFactory<Integer,String> cacheFactory = new CacheFactory<>(evictionPolicy, storage);
    CacheImpl<Integer, String> cache = cacheFactory.defaultCache();
    cache.put(1,"one");
    cache.put(2,"two");
    cache.put(3,"three");
    cache.put(4,"four");
    cache.put(5,"five");
    cache.put(6,"six");
    assertEquals("two",cache.get(2));
    assertNull(cache.get(1));
  }

  @Test
  void displayCacheContents() {
    CacheFactory<Integer,String> cacheFactory = new CacheFactory<>(evictionPolicy,storage);
    CacheImpl<Integer, String> cache = cacheFactory.defaultCache();
    cache.put(1,"one");
    cache.put(2,"two");
    cache.put(3,"three");
    cache.put(4,"four");
    cache.put(5,"five");
    cache.put(6,"six");
    cache.displayCacheContents();
    assertEquals("two",cache.get(2));
    assertNull(cache.get(1));
  }
}
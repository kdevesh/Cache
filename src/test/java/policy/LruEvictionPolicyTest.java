package policy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LruEvictionPolicyTest {

  LruEvictionPolicy<Integer> evictionPolicy;
  @BeforeEach
  void setUp() {
    evictionPolicy = new LruEvictionPolicy<>();
    evictionPolicy.keyAccessed(1);
    evictionPolicy.keyAccessed(2);
    evictionPolicy.keyAccessed(3);
  }

  @Test
  void keyAccessed() {
    evictionPolicy.keyAccessed(1);
    Integer key = evictionPolicy.evictKey();
    assertEquals(2,key);
  }

  @Test
  void evictKey() {
    evictionPolicy.keyAccessed(1);
    evictionPolicy.keyAccessed(2);
    Integer key = evictionPolicy.evictKey();
    assertEquals(3,key);
  }
}
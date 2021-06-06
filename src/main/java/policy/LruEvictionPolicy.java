package policy;

import algorithms.DoublyLinkedListImpl;
import algorithms.DoublyLinkedListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Lru eviction policy.
 *
 * @param <Key> the type parameter
 */
public class LruEvictionPolicy<Key> implements EvictionPolicy<Key> {
  private final DoublyLinkedListImpl<Key> dll;
  private final Map<Key, DoublyLinkedListNode<Key>> map;

  public LruEvictionPolicy() {
    dll = new DoublyLinkedListImpl<>();
    map = new HashMap<>();
  }

  @Override
  public void keyAccessed(Key key) {
    if (map.containsKey(key)) {
      DoublyLinkedListNode<Key> node = map.get(key);
      dll.removeNode(node);
      dll.addNodeAtLast(node);
    } else {
      DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
      map.put(key, newNode);
    }
  }

  @Override
  public Key evictKey() {
    DoublyLinkedListNode<Key> evictedNode = dll.getFirstNode();
    if (evictedNode == null) {
      return null;
    }
    dll.removeNode(evictedNode);
    return evictedNode.getData();
  }
}

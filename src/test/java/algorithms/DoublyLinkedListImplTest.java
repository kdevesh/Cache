package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoublyLinkedListImplTest {

  DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl<>();

  @Test
  void addNodeAtLast() {
    dll.addNodeAtLast(new DoublyLinkedListNode<>(1));
    assertEquals(1,dll.getFirstNode().data);
  }

  @Test
  void isItemPresent() {
    assertFalse(dll.isItemPresent());
  }

  @Test
  void getFirstNode() {
    assertNull(dll.getFirstNode());
  }

  @Test
  void getLastNode() {
    assertNull(dll.getLastNode());
  }

  @Test
  void addElementAtLast() {
    DoublyLinkedListNode<Integer> node = dll.addElementAtLast(2);
    assertNotNull(node);
    assertEquals(2,dll.getLastNode().data);
    assertEquals(2,dll.getFirstNode().data);
  }

  @Test
  void removeNode() {
    DoublyLinkedListNode<Integer> node = dll.addElementAtLast(1);
    dll.removeNode(node);
    assertFalse(dll.isItemPresent());
    assertNull(dll.getFirstNode());
    assertNull(dll.getLastNode());
  }
}
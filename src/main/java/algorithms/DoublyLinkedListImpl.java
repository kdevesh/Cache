package algorithms;

/**
 * The type Doubly linked list.
 *
 * @param <E> the type parameter
 */
public class DoublyLinkedListImpl<E> {
  /**
   * The Dummy head.
   */
  DoublyLinkedListNode<E> dummyHead;
  /**
   * The Dummy tail.
   */
  DoublyLinkedListNode<E> dummyTail;

  /**
   * Instantiates a new Doubly linked list.
   */
  public DoublyLinkedListImpl() {
    dummyHead = new DoublyLinkedListNode<>(null);
    dummyTail = new DoublyLinkedListNode<>(null);
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  /**
   * Add node at last.
   *
   * @param node the node
   */
  public void addNodeAtLast(DoublyLinkedListNode<E> node) {
    dummyTail.prev.next = node;
    node.prev = dummyTail.prev;
    node.next = dummyTail;
    dummyTail.prev = node;
  }

  /**
   * Is item present boolean.
   *
   * @return the boolean
   */
  public boolean isItemPresent() {
    return dummyHead.next != dummyTail;
  }

  /**
   * Gets first node.
   *
   * @return the first node
   */
  public DoublyLinkedListNode<E> getFirstNode() {
    if (!isItemPresent()) {
      return null;
    } else {
      return dummyHead.next;
    }
  }

  /**
   * Gets last node.
   *
   * @return the last node
   */
  public DoublyLinkedListNode<E> getLastNode() {
    if (!isItemPresent()) {
      return null;
    } else {
      return dummyTail.prev;
    }
  }

  /**
   * Add element at last doubly linked list node.
   *
   * @param element the element
   * @return the doubly linked list node
   */
  public DoublyLinkedListNode<E> addElementAtLast(E element) {
    DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
    addNodeAtLast(node);
    return node;
  }

  /**
   * Remove node.
   *
   * @param node the node
   */
  public void removeNode(DoublyLinkedListNode<E> node) {
    if (node != null) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.prev = null;
      node.next = null;
    }
  }
}

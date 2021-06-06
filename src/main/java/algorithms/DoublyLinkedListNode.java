package algorithms;

/**
 * The type Doubly linked list node.
 *
 * @param <E> the type parameter
 */
public class DoublyLinkedListNode<E> {
  /**
   * The Data.
   */
  E data;
  /**
   * The Next.
   */
  DoublyLinkedListNode<E> next;
  /**
   * The Prev.
   */
  DoublyLinkedListNode<E> prev;

  /**
   * Instantiates a new Doubly linked list node.
   *
   * @param data the data
   */
  public DoublyLinkedListNode(E data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

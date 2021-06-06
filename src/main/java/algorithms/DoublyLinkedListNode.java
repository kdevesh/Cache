package algorithms;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Doubly linked list node.
 *
 * @param <E> the type parameter
 */
@Getter
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

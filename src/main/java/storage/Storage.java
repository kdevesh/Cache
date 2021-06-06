package storage;

import exceptions.NotFoundException;
import exceptions.StorageFullException;

/**
 * The interface Storage.
 *
 * @param <Key>   the type parameter
 * @param <Value> the type parameter
 */
public interface Storage<Key, Value> {
  /**
   * Add.
   *
   * @param key   the key
   * @param value the value
   * @throws StorageFullException the storage full exception
   */
  public void add(Key key, Value value) throws StorageFullException;

  /**
   * Remove.
   *
   * @param key the key
   * @throws NotFoundException the not found exception
   */
  void remove(Key key) throws NotFoundException;

  /**
   * Get value.
   *
   * @param key the key
   * @return the value
   * @throws NotFoundException the not found exception
   */
  Value get(Key key) throws NotFoundException;
}

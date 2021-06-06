package storage;

import exceptions.NotFoundException;
import exceptions.StorageFullException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Hash map storage.
 *
 * @param <Key>   the type parameter
 * @param <Value> the type parameter
 */
public class HashMapStorage<Key, Value> implements Storage<Key, Value> {
  private final Map<Key, Value> storageMap;
  private final Integer capacity;

  /**
   * Instantiates a new Hash map storage.
   *
   * @param capacity the capacity
   */
  public HashMapStorage(Integer capacity) {
    this.storageMap = new HashMap<>();
    this.capacity = capacity;
  }

  @Override
  public void add(Key key, Value value) throws StorageFullException {
    if (isStorageFull()) {
      throw new StorageFullException("Cache is Full");
    }
    storageMap.put(key, value);
  }

  @Override
  public void remove(Key key) throws NotFoundException {
    if (!storageMap.containsKey(key)) {
      throw new NotFoundException("Key is not present in Cache");
    }
    storageMap.remove(key);

  }

  @Override
  public Value get(Key key) throws NotFoundException {
    if (!storageMap.containsKey(key)) {
      throw new NotFoundException("Key not found");
    }
    return storageMap.get(key);
  }

  private boolean isStorageFull() {
    return storageMap.size() == capacity;
  }

  @Override
  public void displayContents() {
    storageMap.forEach((k, v) -> System.out.println(k + " " + v));
  }
}

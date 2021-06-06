package exceptions;

/**
 * The type Storage full exception.
 */
public class StorageFullException extends RuntimeException {
  public StorageFullException(String message) {
    super(message);
  }
}

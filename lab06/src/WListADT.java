/**
 * This interface represents all operations a word list
 */
public interface WListADT {
  /**
   * This function will add a new string val at the index position
   * @param index
   * @param val
   */
  void addIndex(int index, String val)throws IllegalArgumentException;

  /**
   * Remove a string at index
   * @param index
   */
  void remove(int index)throws IllegalArgumentException;

  /**
   *
   * @param index
   * @return the string at index
   */
  String get(int index)throws IllegalArgumentException;

  /**
   * @return the count of string in this list
   */
  int getSize();

  /**
   * @return true if this list is empty
   */
  boolean isEmpty();

  /**
   * @return Returns new WList including odd numbered words only
   */
  WListADT oddWords();

  /**
   * @return Returns new WList of even numbered words only
   */
  WListADT evenWords();

  String toString();
}

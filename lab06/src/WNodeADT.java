
/**
 * This interface represents all operations for a word in a word list implements as an  ADT
 */
public interface WNodeADT {

  /**
   * get the word at index
   *
   * @param index
   * @return a string
   * @throws IllegalArgumentException
   */
  String getWord(int index) throws IllegalArgumentException;

  /**
   * @return representation of this node
   */
  String toString();

  /**
   * @return count of string
   */
  int getSize();

  /**
   * @return next word node
   */
  WNodeADT getNext();

  /**
   * add new word at index
   *
   * @param index
   * @param word
   * @return
   * @throws IllegalArgumentException
   */
  WNodeADT add(int index, String word) throws IllegalArgumentException;

  /**
   * remove the word at index
   *
   * @param index
   * @return
   * @throws IllegalArgumentException
   */
  WNodeADT remove(int index) throws IllegalArgumentException;

  /**
   * @return words at even index
   */
  WNodeADT getEven();

  /**
   * @return words at odd index
   * @throws IllegalArgumentException
   */
  WNodeADT getOdd() throws IllegalArgumentException;


}

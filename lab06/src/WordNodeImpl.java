/**
 * This class implements the word node ADT
 */
public class WordNodeImpl implements WNodeADT {

  String word;
  WNodeADT next;

  /**
   * Constructor of WordNodeImpl
   *
   * @param word
   * @param next
   */
  public WordNodeImpl(String word, WNodeADT next) {
    this.word = word;
    this.next = next;
  }

  /**
   * get the word at index
   *
   * @param index
   * @return A string
   * @throws IllegalArgumentException
   */
  @Override
  public String getWord(int index) throws IllegalArgumentException {
    if (index < 0 || index > this.getSize()) {
      throw new IllegalArgumentException();
    }
    if (index == 0) {
      return this.word;
    }
    return this.next.getWord(index - 1);
  }

  /**
   * @return representation of this node and rest nodes
   */
  @Override
  public String toString() {
    return this.word + this.next.toString();
  }

  /**
   * @return count of strings since this node
   */
  @Override
  public int getSize() {
    return 1 + this.next.getSize();
  }

  /**
   * @return next node
   */
  @Override
  public WNodeADT getNext() {
    return this.next;
  }

  /**
   * add new word at index
   *
   * @param index
   * @param word
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public WNodeADT add(int index, String word) throws IllegalArgumentException {
    if (index < 0 || index > this.getSize()) {
      throw new IllegalArgumentException();
    }
    if (index == 0) {
      return new WordNodeImpl(word, this);
    } else {
      this.next = this.next.add(index - 1, word);
      return this;
    }
  }

  /**
   * remove a node at index
   *
   * @param index
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public WNodeADT remove(int index) throws IllegalArgumentException {
    if (index < 0 || index > this.getSize()) {
      throw new IllegalArgumentException();
    }
    if (index == 0) {
      return this.next;
    } else {
      this.next = this.next.remove(index - 1);
      return this;
    }
  }

  /**
   * words at even index
   *
   * @return
   */
  @Override
  public WNodeADT getEven() {
    WordNodeImpl newNode = new WordNodeImpl(this.word, this.next.getNext());
    return new WordNodeImpl(newNode.word, newNode.next.getEven());
  }

  /**
   * words at odd index
   *
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public WNodeADT getOdd() throws IllegalArgumentException {
    WordNodeImpl newNode = new WordNodeImpl(this.next.getWord(0), this.next.getNext());
    return new WordNodeImpl(newNode.word, newNode.next.getOdd());

  }
}

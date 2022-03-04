/**
 * This class implements the List of words ADT
 */
public class WListADTImpl implements WListADT {

  WNodeADT head;

  /**
   * Constructor of WListADT
   */
  public WListADTImpl() {
    this.head = new WordNodeEmptyImpl();
  }

  /**
   * This function will add a new string val at the index position
   *
   * @param index
   * @param val
   * @throws IllegalArgumentException
   */
  @Override
  public void addIndex(int index, String val) throws IllegalArgumentException {
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    this.head = this.head.add(index, val);
  }

  /**
   * Remove a string at index
   *
   * @param index
   * @throws IllegalArgumentException
   */
  @Override
  public void remove(int index) throws IllegalArgumentException {
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    this.head = this.head.remove(index);
  }

  /**
   * @param index
   * @return A string at the index
   * @throws IllegalArgumentException
   */
  @Override
  public String get(int index) throws IllegalArgumentException {
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    return this.head.getWord(index);
  }

  /**
   * @return the count of string in this list
   */
  @Override
  public int getSize() {
    return this.head.getSize();
  }

  /**
   * @return true if this list is empty (size =0)
   */
  @Override
  public boolean isEmpty() {
    return this.head.getSize() == 0;
  }

  /**
   * @return new WList including odd numbered words only
   */
  @Override
  public WListADT oddWords() {
    WListADT oddWords = new WListADTImpl();
    ((WListADTImpl) oddWords).head = this.head.getOdd();
    return oddWords;
  }

  /**
   * @return new WList including even numbered words only
   */
  @Override
  public WListADT evenWords() {
    WListADT evenWords = new WListADTImpl();
    ((WListADTImpl) evenWords).head = this.head.getEven();
    return evenWords;
  }

  /**
   * @return representation of this list
   */
  @Override
  public String toString() {
    return head.toString();
  }

}

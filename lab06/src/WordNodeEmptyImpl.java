/**
 * This class implements the empty word node ADT
 */
public class WordNodeEmptyImpl implements WNodeADT {
  String word;


  public WordNodeEmptyImpl() {
    this.word = "";
  }

  @Override
  public String getWord(int index) throws IllegalArgumentException {
    return this.word; //return an empty string
  }

  @Override
  public String toString(){
    return "";
  }

  @Override
  public int getSize() {
    return 0;
  }

  @Override
  public WNodeADT getNext() {
    return this;
  }

  /**
   * Add a new word node in front of this empty node
   * @param index
   * @param word
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public WNodeADT add(int index, String word) throws IllegalArgumentException {
    if(index == 0){
      return new WordNodeImpl(word,this);
    }
    throw new IllegalArgumentException("Invalid index to add an element");
  }

  /**
   * can't remove from nothing
   * @param index
   * @return an empty string
   * @throws IllegalArgumentException
   */
  @Override
  public WNodeADT remove(int index) throws IllegalArgumentException {
    if(index == 0){
      return this;
    }
    throw new IllegalArgumentException();
  }

  public WNodeADT getEven(){
    return this;
  }

  //can't get odd index node from nothing
  public WNodeADT getOdd() throws IllegalArgumentException{
    return this;
  }
}

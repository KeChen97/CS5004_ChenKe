/**
 * This class implements the word node ADT
 */
public class WordNodeImpl implements WNodeADT {
  String word;
  WNodeADT next;

  public WordNodeImpl(String word, WNodeADT next) {
    this.word = word;
    this.next = next;
  }

  @Override
  public String getWord(int index)  throws IllegalArgumentException{
    if(index<0 || index>this.getSize()){
      throw new IllegalArgumentException();
    }
    if(index ==0 ){
      return this.word;
    }
    return this.next.getWord(index-1);
  }

  @Override
  public String toString(){
    return this.word + this.next.toString();
  }

  @Override
  public int getSize() {
    return 1+this.next.getSize();
  }

  @Override
  public WNodeADT getNext(){
    return this.next;
  }

  @Override
  public WNodeADT add(int index, String word) throws IllegalArgumentException {
    if(index<0 || index>this.getSize()){
      throw new IllegalArgumentException();
    }
    if(index ==0 ){
      return new WordNodeImpl(word,this);
    }
    else{
      this.next = this.next.add(index-1,word);
      return this;
    }
  }

  @Override
  public WNodeADT remove(int index) throws IllegalArgumentException {
    if(index<0 || index>this.getSize()){
      throw new IllegalArgumentException();
    }
    if(index == 0){
      return this.next;
    }
    else{
      this.next = this.next.remove(index-1);
      return this;
    }
  }
  @Override
  public WNodeADT getEven(){
    WordNodeImpl newNode = new WordNodeImpl(this.word,this.next.getNext());
   // newNode.next = newNode.next.getNext();
    return new WordNodeImpl(newNode.word,newNode.next.getEven());
  }

  @Override
  public WNodeADT getOdd() throws IllegalArgumentException {
    WordNodeImpl newNode =  new WordNodeImpl(this.next.getWord(0),this.next.getNext());
    return new WordNodeImpl(newNode.word,newNode.next.getOdd());

  }
}

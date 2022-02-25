public class WListADTImpl implements WListADT {
  WNodeADT head;

  public WListADTImpl() {
    this.head = new WordNodeEmptyImpl();
  }

  @Override
  public void addIndex(int index, String val) throws IllegalArgumentException{
    if(index<0){
      throw new IllegalArgumentException();
    }
    this.head =  this.head.add(index,val);
  }

  @Override
  public void remove(int index) throws IllegalArgumentException{
    if(index<0){
      throw new IllegalArgumentException();
    }
    this.head = this.head.remove(index);
  }

  @Override
  public String get(int index) throws IllegalArgumentException{
    if(index<0){
      throw new IllegalArgumentException();
    }
    return this.head.getWord(index);
  }

  @Override
  public int getSize() {
    return this.head.getSize();
  }

  @Override
  public boolean isEmpty() {
    return this.head.getSize()==0;
  }

  @Override
  public WListADT oddWords() {
    WListADT oddWords = new WListADTImpl();
    ((WListADTImpl) oddWords).head = this.head.getOdd();
    return oddWords;
  }

  @Override
  public WListADT evenWords() {
    WListADT evenWords = new WListADTImpl();
    ((WListADTImpl) evenWords).head = this.head.getEven();
    return evenWords;
  }

  @Override
  public String toString(){
    return head.toString();
  }

}

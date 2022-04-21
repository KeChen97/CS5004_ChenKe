import java.util.ArrayList;

/**
 * Stack is a linear Data Structure that is based on the LIFO concept (last in first out).
 * Stack can accept String, Character, Float or other datatypes.
 * This class represents a stack with generic parameter E, and its 4 primary operations.
 *
 * We represent the type of data that this will work with a generic parameter.
 * @param <E> This is a placeholder for the actual data type.
 */
public class GenericStack<E> {
  private ArrayList<E> stack;

  /**
   * Constructor of generic stack
   * We will initialize an ArrayList with generic parameter E as the internal representation of the stack's data
   */
  public GenericStack() {
    this.stack = new ArrayList<E>();
  }

  /**
   * This method returns whether the stack is empty or not.
   * By calling the isEmpty() method of ArrayList
   * @return true is this stack is empty, otherwise return false.
   */
  public boolean empty() {
    return this.stack.isEmpty();
  }

  /**
   * This method addds element e to the back of stack. (so it is the last object in the ArrayList)
   * @param e  the object to be added to teh back of this stack
   */
  public void push(E e) {
    this.stack.add(e);
  }

  /**
   * This method removes the last element of the stack, whose index in ArrayList is size -1
   *
   * @throws IllegalArgumentException if this stack is empty
   */
  public void pop () throws IllegalArgumentException {
    if(this.empty()){
      throw new IllegalArgumentException("No element in this stack");
    }
    int size = this.stack.size();
    this.stack.remove(size - 1);
  }


  /**
   * Stack is based on "last in first out", so this method will return the last item added to this stack as "top"
   *
   * @return the last element of the stack.
   * @throws IllegalArgumentException if this stack is empty
   */
  public E top() throws IllegalArgumentException{
    if(this.empty()){
      throw new IllegalArgumentException("No element in this stack");
    }
    int size = this.stack.size();
    E e = this.stack.get(size - 1);
    return e;
  }

  /**
   * @return a string, representation of this stack by listing every element.
   */
  @Override
  public String toString() {
    String s = "Stack = " ;
    for(E e:this.stack){
      s = s + e + " ";
    }
    s = s + "\n";
    return s;
  }
}


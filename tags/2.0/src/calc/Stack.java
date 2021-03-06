package calc;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that is used to store entries so they can be retrieved in the correct order.
 *
 * @author Marcus Messer
 */
public class Stack {

  /**
   * This field stores the entries in the stack.
   */
  private List<Entry> entries = new ArrayList<>();
  /**
   * This field stores the size of the stack.
   */
  private int size;

  /**
   * This method puts the entry onto the stack.
   *
   * @param entry an entry of any type to be put onto the stack.
   */
  public void push(Entry entry) {
    this.entries.add(entry);
    size++;
  }

  /**
   * This method returns the top element of the stack.
   *
   * @return An entry object which is at the top of the stack.
   * @throws EmptyStackException this is thrown when top is called when the stack is empty.
   */
  public Entry top() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.get(entries.size() - 1);
  }

  /**
   * This method returns the size of the stack.
   *
   * @return An integer value of the number of entries in the stack.
   */
  public int size() {
    return size;
  }

  /**
   * This method returns the top entry of the stack and removes it.
   *
   * @return An entry that was on the top of the stack.
   * @throws EmptyStackException this is thrown when pop is called when the stack is empty.
   */
  public Entry pop() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry temp = entries.get(entries.size() - 1);
    entries.remove(entries.size() - 1);
    size--;
    return temp;
  }

  /**
   * This method constructs and returns a string of all the entries and the size.
   *
   * @return Returns a string of all the entries and the size of the stack.
   */
  @Override
  public String toString() {
    return "entries=" + entries.toString() + ", size=" + size;
  }

  /**
   * This method checks to see if two stacks are equal.
   *
   * @param object the object that is being checked against this object.
   * @return True if the stacks are equal and False if they are not equal.
   */
  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }

    if (!(object instanceof Stack)) {
      return false;
    }
    Stack stack = (Stack) object;
    return (this.size == stack.size && this.entries.equals(stack.entries));
  }

  /**
   * This method generates the hashcode for a stack.
   *
   * @return An integer value for the stack, comprised of the fields as integers.
   */
  @Override
  public int hashCode() {
    // formula for calculating hash code take from joshua bloch's recommendations in "effective
    // java".
    // in short provided by:
    // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
    int result = 1;
    int hash = size;
    hash += entries.hashCode();

    result = 37 * result + hash;
    return result;
  }
}

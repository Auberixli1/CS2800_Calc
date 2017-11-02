package testcalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import calc.BadType;
import calc.EmptyStack;
import calc.Entry;
import calc.Stack;
import org.junit.Before;
import org.junit.Test;

public class TestStack {

  private Stack stack;

  @Before
  public void setUp() {
    stack = new Stack();
  }

  // Test 10 - Tests when an entry is pushed on to the stack
  // Started with faking the value of the top so it returned 1, then went on to implement pop and
  // returning the entry field top. I started with using just one entry
  @Test
  public void pushThenTop() throws BadType, EmptyStack {
    Entry entry = new Entry(1);
    stack.push(entry);
    assertTrue("Push then top", 1 == stack.top().getValue());
  }

  // Test 11 - Tests the size method
  // Started with returning one, then implemented a counter in push to add one each time something
  // is pushed to the stack and change size() to return this value
  @Test
  public void size() {
    Entry entry = new Entry(123456);
    stack.push(entry);
    assertTrue("Size = 1", 1 == stack.size());
  }

  // Test 12 - Tests pushing 2 entities to the stack
  // Changed the single entry to an array of two entries
  @Test
  public void pushTwice() {
    Entry entry = new Entry(123456);
    stack.push(entry);
    entry = new Entry("test");
    stack.push(entry);
    assertTrue("Size = 2", 2 == stack.size());
  }

  // Test 13 - Tests pushing an item on to the stack then popping the item to make sure the item is
  // removed from the stack
  // Implemented some code to remove one from size
  @Test
  public void pushThenPopSize() throws EmptyStack {
    Entry entry = new Entry(123456);
    stack.push(entry);
    stack.pop();
    assertTrue("Size = 0", 0 == stack.size());
  }

  // Test 14 - Tests pushing an item on to the stack then popping the item and making sure the the
  // pushed item and the pop item are the same
  // Started with faking the return by creating the exact same entry on the return, then changed
  // that to get the actual entry which was pushed
  @Test
  public void pushThenPopSame() throws EmptyStack {
    Entry entry = new Entry(123456);
    stack.push(entry);
    Entry popped = stack.pop();
    assertTrue("Pushed = Pop", entry == popped);
  }

  // Test 16 - Tests pushing two items on to the stack then popping both and checking that the value
  // of the first one is correct
  @Test
  public void pushTwicePopTwice() throws EmptyStack {
    Entry valueEntry = new Entry(123456);
    stack.push(valueEntry);
    Entry stringEntry = new Entry("Test");
    stack.push(stringEntry);
    stack.pop();
    Entry popped = stack.pop();

    assertTrue("First Pushed = Second Popped", valueEntry == popped);

  }

  // Test 17 - Tests the pop order
  // Changed the array to a list of entries, reformatted push, pop and top to use the ArrayList.
  @Test
  public void popOrder() throws EmptyStack {
    Entry[] entries = new Entry[5];

    for (int i = 0; i < 5; i++) {
      entries[i] = new Entry(i);
      stack.push(entries[i]);
    }

    for (int i = 4; i > 0; i--) {
      assertFalse("Pushed != Popped", stack.pop() != entries[i]);
    }
  }

  // Test 18 - Tests EmptyStack Exception on pop
  // Started with reformatting the pop method to throw the error, then created the exception that
  // will be thrown
  @Test(expected = EmptyStack.class)
  public void emptyStackPop() throws EmptyStack {
    stack.pop();
  }

  // Test 19 - Tests the EmptyStack Exception on top
  // Reformatted top to implement the exception
  @Test(expected = EmptyStack.class)
  public void emptyStackTop() throws EmptyStack {
    stack.top();
  }

  // Test 22 - Tests the toString
  // Stated with faking the return value to the string I wanted, then implemented getting the string
  // from the ArrayList and then the size
  @Test
  public void stringReturn() {
    Entry entry = new Entry(123456);
    stack.push(entry);
    entry = new Entry("Test");
    stack.push(entry);
    assertEquals("stackstr = stack.toString", stack.toString(),
        "entries=[[value=123456.0, type=NUMBER, str=null, other=null], "
            + "[value=0.0, type=STRING, str=Test, other=null]], size=2");
  }

  // Test 23 - Tests if two stacks are equal.
  // Started with faking the return value, then checked if the size was the same and finally
  // implemented the ArrayList.equals() method to check if the entries are the same
  @Test
  public void equalStacks() {
    Entry entry = new Entry(123456);
    stack.push(entry);

    Stack otherStack = new Stack();
    otherStack.push(entry);

    assertTrue("stack = otherStack", stack.equals(otherStack));
  }

  // Test 25 - Tests if the hash code of two stacks are equal.
  // Started with faking the hash values, then implemented the hash code to use the values of the
  // fields, using ArrayList.hashCode()
  @Test
  public void equalHash() {
    Stack otherStack = new Stack();
    Entry entry = new Entry(123456);
    stack.push(entry);
    otherStack.push(entry);

    entry = new Entry("Test");
    stack.push(entry);
    otherStack.push(entry);

    assertTrue("equal hash codes", stack.hashCode() == otherStack.hashCode());
  }
}

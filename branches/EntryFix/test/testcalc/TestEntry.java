package testcalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import calc.BadType;
import calc.Entry;
import calc.Symbol;
import calc.Type;
import org.junit.Test;

public class TestEntry {

  private Entry entry;


  // Test 1 - Tests the float constructor and the float getter
  // Started with faking the return value of getValue to '123456' then implemented the constructor
  // to set the field.
  @Test
  public void floatSet() throws BadType {
    entry = new Entry(123456);
    assertTrue("Checks value = 123456", entry.getValue() == 123456);
  }


  // Test 2 - Tests the string constructor and the string getter
  // Started with faking the return value of getString to "test" then implemented the constructor to
  // set the field
  @Test
  public void strSet() throws BadType {
    entry = new Entry("test");
    assertEquals("Checks string = test", entry.getString(), "test");
  }

  // Test 3 - Tests the symbol constructor and the symbol getter
  // Started with writing the enum, then faking the return value of getSymbol, then got the
  // constructor to set the field
  @Test
  public void symbolSet() throws BadType {
    entry = new Entry(Symbol.LEFT_BRACKET);
    assertTrue("Checks other = LEFT_BRACKER", entry.getSymbol() == Symbol.LEFT_BRACKET);
  }

  // Test 4 - Tests the type getter when the type is a number
  // Started with faking the return value of getType to return number, then changed it so the
  // constructor sets the type field
  @Test
  public void typeNumber() {
    entry = new Entry(123456);
    assertTrue("Type = Number", entry.getType() == Type.NUMBER);
  }

  // Test 5 - Tests the type getter when the type is a string
  // Just changed the constructor to set the type field
  @Test
  public void typeString() {
    entry = new Entry("test");
    assertTrue("Type = String", entry.getType() == Type.STRING);
  }

  // Test 6 - Tests the type getter when the type is a symbol
  // Just changed the constructor to set the type field
  @Test
  public void typeSymbol() {
    entry = new Entry(Symbol.DIVIDE);
    assertTrue("Type = Symbol", entry.getType() == Type.SYMBOL);
  }

  // Test 7 - Tests the BadType exception on the value getter
  // Reformatted the methods getValue method to throw the exception, then created the exception
  @Test(expected = BadType.class)
  public void badTypeValue() throws BadType {
    entry = new Entry(Symbol.DIVIDE);
    entry.getValue();
  }

  // Test 8 - Tests the BadType exception on the string getter
  // Reformatted the getString method to throw the exception
  @Test(expected = BadType.class)
  public void badTypeString() throws BadType {
    entry = new Entry(123456);
    entry.getString();
  }

  // Test 9 - Tests the BadType exception of the symbol getter
  // Reformatted the getSymbol method to throw the exception
  @Test(expected = BadType.class)
  public void badTypeSymbol() throws BadType {
    entry = new Entry("test");
    entry.getSymbol();
  }

  // Test 20 - Tests if two entries are equal
  // Stated with faking the return value as true, then checked if they were the same type and
  // finally checked if the value was the same
  @Test
  public void equalEntry() throws BadType {
    entry = new Entry(123456);
    Entry valueEntry = new Entry(123456);
    assertTrue("Entry = Entry", entry.equals(valueEntry));
  }

  // Test 21 - Tests toString
  // Started faking the return value of the method to the string I wanted, then implemented the
  // method to use the values of the fields
  @Test
  public void stringReturn() {
    entry = new Entry(123456);
    assertEquals("str = toString()", entry.toString(),
        "[value=123456.0, type=NUMBER, str=null, other=null]");

  }

  // Test 24 - Tests that we get the correct hash code for an entry
  // Started with faking the hash code value so they were the same, then implemented the method to
  // use the values of the fields
  @Test
  public void hashCheck() {
    entry = new Entry(123456);
    Entry otherEntry = new Entry(123456);
    assertTrue("hashCode = otherEntry.hashCode", entry.hashCode() == otherEntry.hashCode());
  }
}

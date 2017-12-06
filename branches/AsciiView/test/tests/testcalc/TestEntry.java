package tests.testcalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import calc.BadEntryTypeException;
import calc.Entry;
import calc.Symbol;
import calc.EntryType;
import org.junit.Test;

public class TestEntry {

  private Entry entry;


  // Test 1 - Tests the float constructor and the float getter
  // Started with faking the return value of getValue to '123456' then implemented the constructor
  // to set the field.
  @Test
  public void floatSet() throws BadEntryTypeException {
    entry = new Entry(123456);
    assertTrue("Checks value = 123456", entry.getValue() == 123456);
  }


  // Test 2 - Tests the string constructor and the string getter
  // Started with faking the return value of getString to "test" then implemented the constructor to
  // set the field
  @Test
  public void strSet() throws BadEntryTypeException {
    entry = new Entry("test");
    assertEquals("Checks string = test", entry.getString(), "test");
  }

  // Test 3 - Tests the symbol constructor and the symbol getter
  // Started with writing the enum, then faking the return value of getSymbol, then got the
  // constructor to set the field
  @Test
  public void symbolSet() throws BadEntryTypeException {
    entry = new Entry(Symbol.LEFT_BRACKET);
    assertTrue("Checks other = LEFT_BRACKER", entry.getSymbol() == Symbol.LEFT_BRACKET);
  }

  // Test 4 - Tests the type getter when the type is a number
  // Started with faking the return value of getEntryType to return number, then changed it so the
  // constructor sets the type field
  @Test
  public void typeNumber() {
    entry = new Entry(123456);
    assertTrue("EntryType = Number", entry.getEntryType() == EntryType.NUMBER);
  }

  // Test 5 - Tests the type getter when the type is a string
  // Just changed the constructor to set the type field
  @Test
  public void typeString() {
    entry = new Entry("test");
    assertTrue("EntryType = String", entry.getEntryType() == EntryType.STRING);
  }

  // Test 6 - Tests the type getter when the type is a symbol
  // Just changed the constructor to set the type field
  @Test
  public void typeSymbol() {
    entry = new Entry(Symbol.DIVIDE);
    assertTrue("EntryType = Symbol", entry.getEntryType() == EntryType.SYMBOL);
  }

  // Test 7 - Tests the BadEntryTypeException exception on the value getter
  // Reformatted the methods getValue method to throw the exception, then created the exception
  @Test(expected = BadEntryTypeException.class)
  public void badTypeValue() throws BadEntryTypeException {
    entry = new Entry(Symbol.DIVIDE);
    entry.getValue();
  }

  // Test 8 - Tests the BadEntryTypeException exception on the string getter
  // Reformatted the getString method to throw the exception
  @Test(expected = BadEntryTypeException.class)
  public void badTypeString() throws BadEntryTypeException {
    entry = new Entry(123456);
    entry.getString();
  }

  // Test 9 - Tests the BadEntryTypeException exception of the symbol getter
  // Reformatted the getSymbol method to throw the exception
  @Test(expected = BadEntryTypeException.class)
  public void badTypeSymbol() throws BadEntryTypeException {
    entry = new Entry("test");
    entry.getSymbol();
  }

  // Test 20 - Tests if two entries are equal
  // Stated with faking the return value as true, then checked if they were the same type and
  // finally checked if the value was the same
  @Test
  public void equalEntry() throws BadEntryTypeException {
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
        "[value=123456.0, entryType=NUMBER, str=null, other=null]");

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

  // Test 27 - Tests if the equals method returns false when the object is null
  @Test
  public void equalNull() {
    Object object = null;
    entry = new Entry(123456);
    assertFalse("entry = null", entry.equals(object));
  }
}

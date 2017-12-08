package calc;

/**
 * This class will be used to store the users input, to be used within the <code>Stack</code> class.
 *
 * @author Marcus Messer
 */

public class Entry {

  /**
   * This field stores the value when the entryType of entry is a number.
   */
  private float value;
  /**
   * This field stores the entryType of the entry.
   */
  private EntryType entryType;
  /**
   * This field stores the string when the entryType of entry is a string.
   */
  private String str;
  /**
   * This field stores the <code>Symbol</code> when the entryType of entry is a <code>Symbol</code>.
   */
  private Symbol other;

  /**
   * This constructor is for when a string is inputed.
   *
   * @param str is a string that has been entered.
   */
  public Entry(String str) {
    this.str = str;
    this.entryType = EntryType.STRING;
  }

  /**
   * This constructor is for when a float is inputed.
   *
   * @param value is a float that has been entered.
   */

  public Entry(float value) {
    this.value = value;
    this.entryType = EntryType.NUMBER;
  }

  /**
   * This constructor is for when a <code>Symbol</code> is entered.
   *
   * @param other is the symbol that has been entered.
   */
  public Entry(Symbol other) {
    this.other = other;
    this.entryType = EntryType.SYMBOL;
  }

  /**
   * This getter returns the float that was inputed.
   *
   * @return The value that has been inputed.
   * @throws BadEntryTypeException when the entryType isn't a number.
   */
  public float getValue() throws BadEntryTypeException {
    if (getEntryType() != EntryType.NUMBER) {
      throw new BadEntryTypeException(EntryType.NUMBER, entryType);
    }
    return value;
  }

  /**
   * This getter gets the entryType of data that was inputed.
   *
   * @return The entryType from the enum <code>EntryType</code>.
   */
  public EntryType getEntryType() {
    return entryType;
  }

  /**
   * This getter gets the string that was inputed.
   *
   * @return The string that was entered by the user.
   * @throws BadEntryTypeException when the entryType isn't a string.
   */
  public String getString() throws BadEntryTypeException {
    if (getEntryType() != EntryType.STRING) {
      throw new BadEntryTypeException(EntryType.STRING, entryType);
    }
    return str;
  }

  /**
   * This getter gets the symbol that was inputed.
   *
   * @return The symbol that was entered.
   * @throws BadEntryTypeException when the entryType isn't a symbol.
   */
  public Symbol getSymbol() throws BadEntryTypeException {
    if (getEntryType() != EntryType.SYMBOL) {
      throw new BadEntryTypeException(EntryType.SYMBOL, entryType);
    }
    return other;
  }

  /**
   * This equals method is to detect when one Entry is equal to the other, when the entryType is the same
   * and the value/string/symbol are the same.
   *
   * @param object the object that we want to check if they are equal.
   * @return Returns a boolean true for they are equal, and false for not equal.
   * @throws BadEntryTypeException as the getters are used throws this exception if the wrong getter is used for
   * the entryType.
   */
  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (!(object instanceof Entry)) {
      return false;
    }
    Entry entry = (Entry) object;
    if (entry.getEntryType() == this.getEntryType()) {
      switch (entryType) {
        case NUMBER:
          try {
            return (entry.getValue() == this.getValue());
          } catch (BadEntryTypeException badEntryTypeException) {
            System.err.println("Caught: " + badEntryTypeException.getMessage());
            return false;
          }
        case STRING:
          try {
            return (entry.getString().equals(this.getString()));
          } catch (BadEntryTypeException badEntryTypeException) {
            System.err.println("Caught: " + badEntryTypeException.getMessage());
            return false;
          }
        case SYMBOL:
          try {
            return (entry.getSymbol() == this.getSymbol());
          } catch (BadEntryTypeException badEntryTypeException) {
            System.err.println("Caught: " + badEntryTypeException.getMessage());
            return false;
          }
        default:
          return false;
      }
    }
    return false;
  }

  /**
   * @return A string including the value for all the fields.
   */
  @Override
  public String toString() {
    return "[value=" + value + ", entryType=" + entryType + ", str=" + str + ", other=" + other
        + "]";
  }

  /**
   * @return an integer value for the object.
   */
  @Override
  public int hashCode() {
    // formula for calculating hash code taken from Joshua Bloch's recommendations in "effective
    // java".
    // in short provided by:
    // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
    int hash = 0;
    hash += entryType.hashCode();
    hash += Float.floatToIntBits(value);

    // If other or str are null they aren't included in the hash code, as null shouldn't change the
    // value of the hash.
    if (other != null) {
      hash += other.hashCode();
    }
    if (str != null) {
      hash += str.hashCode();
    }
    return 37 + hash;
  }
}

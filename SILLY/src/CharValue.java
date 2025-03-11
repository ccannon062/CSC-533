/**
 * Class that represents a Character value.
 *   @author Caleb Cannon
 *   @version 2/8/25
 */
public class CharValue implements DataValue {
	protected char val;
	
	/**
     * Constructs a default char value 'a'.
     */
	public CharValue() {
		this('a');
	}
	
	/**
     * Constructs a char value.
     * @param c the value being stored.
     */
	public CharValue(char c) {
		this.val = c;
	}
	
	/**
     * Comparison method for char values.
     * @param other the value being compared with
     * @return negative if <, 0 if ==, positive if >
     */
	public int compareTo(DataValue other) {
		return Character.valueOf(this.val).compareTo(Character.valueOf((char)other.getValue()));
	}
	
	/**
	 * Accesses the stored char value.
	 * @return the char value (as an object)
	 */
	public Object getValue() {
		return (char) this.val;
	}

	/**
	 * Identifies the actual type of the value.
	 * @return Token.Type.CHAR
	 */
	public DataValue.Type getType() {
		return DataValue.Type.CHAR;
	}
	
	/**
	 * Converts char value to a string.
	 * @return String representation of a char value.
	 */
	public String toString() {
		 return "" + this.val;
	}
}

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a String value.
 * @author Caleb Cannon
 * @version 2/22/25
 */

public class StringValue extends ListValue implements DataValue {
	
	/*
	 * Constructs a default String ""
	 */
	public StringValue() {
		this("");
	}
	
	/**
	 * Constructs a string value
	 * @param s the string value
	 */
	public StringValue(String s) {
		super(toArray(s));
	}
	
	/**
	 * Converts string to a list of characters
	 * @param s the full string
	 * @return charList the list of characters
	 */
	private static ArrayList<DataValue> toArray(String s) {
		ArrayList<DataValue> charList = new ArrayList<DataValue>();
		for(int i = 0; i < s.length(); i++) {
			charList.add(new CharValue(s.charAt(i)));
		}
		return charList;
	}
	
	/**
	 * Identifies the actual type of the value
	 * @return Token.Type.STRING
	 */
	public DataValue.Type getType() {
		return DataValue.Type.STRING;
	}
	
	/**
	 * Converts char list into a string
	 * @return a string representation of character list
	 */
	public String toString() {
		@SuppressWarnings("unchecked")
		List<DataValue> charList = (List<DataValue>) this.getValue();
		String collapsedList = "";
		for(int i = 0; i < charList.size(); i++) {
			collapsedList += charList.get(i);
		}
		return collapsedList;
	}
}

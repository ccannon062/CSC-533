import java.util.List;
import java.util.ArrayList;

/**
 * Class that represents a list value.
 *   @author Dave Reed modified by Caleb Cannon
 *   @version 1/20/25
 */
public class ListValue implements DataValue {
    private List<DataValue> value;

    /**
     * Constructs a default list value (empty list).
     */
    public ListValue() {
    	this.value = new ArrayList<DataValue>();
    }

    /**
     * Constructs a list value.
     *   @param vals the list values being stored
     */
    public ListValue(ArrayList<DataValue> vals) {
    	this();
    	for (DataValue v : vals) {
    		this.value.add(v);
    	}
    }
    
    /**
     * Accesses the stored list value.
     *   @return the list value (as an Object)
     */
    public Object getValue() {
        return this.value;
    }  

    /**
     * Identifies the actual type of the value.
     *   @return Token.Type.LIST
     */
    public DataValue.Type getType() {
        return DataValue.Type.LIST;
    }

    /**
     * Converts the list value to a String.
     *   @return a String representation of the list value
     */
    public String toString() {
    	String message = "[";
    	for (DataValue v : this.value) {
    		if(v.getType() == DataValue.Type.CHAR) {
    			message += "'" + v + "' ";
    			continue;
    		}
    		else if(v.getType() == DataValue.Type.STRING) {
    			message += "\"" + v + "\" ";
    		    continue;
    		}
    		message += v + " ";
    	}
        return message.trim() + "]";
    }

    /**
     * Comparison method for ListValues.
     *   @param other the value being compared with
     *   @return negative if <, 0 if ==, positive if >
     */
    public int compareTo(DataValue other) {
         return (this.getValue().toString()).compareTo(other.getValue().toString());
    }
}
/**
 * Class that represents a repeat statement.
 * @author Caleb Cannon
 * @version 2/11/25
 */
public class Repeat extends Statement{
	private Expression expr;
	private Compound compound;
	
	/**
	 * Reads in a repeat statement from the specified stream.
	 * @param input the input stream
	 */
	public Repeat(TokenStream input) throws Exception {
		if (!input.next().toString().equals("repeat")) {
            throw new Exception("SYNTAX ERROR: Malformed repeat statement");
        }
		this.expr = new Expression(input);
		this.compound = new Compound(input);
	}
	
	/**
	 * Executes the current repeat statement.
	 */
	public void execute() throws Exception {
		if(!(expr.evaluate().getType() == DataValue.Type.NUMBER)) {
			throw new Exception("RUNTIME ERROR: Number value expected.");
		}
		Double num = (Double)expr.evaluate().getValue();
		if(num != Math.round(num)) {
			throw new Exception("RUNTIME ERROR: Repeat value must be an integer.");
		}
		for(int i = 0; i < (int) Math.round(num); i++) {
			compound.execute();
		}
	}

	/**
	 * Converts the current repeat statement into a string.
	 * @return the String representation of this statement.
	 */
	public String toString() {
		return "repeat " + expr + " " + compound;
	}

}

public class Validate {
	// have an instance of operations so that we always know which strategy we are implementing
	public Authenticate typeOfStratagy;
	
	// do the operation that 'typeOfStratagy' is an instance of
	// if typeOfStratagy is add, operation(a, b) will be called from class Addition in Operations interface
	public boolean DoOp(String string) {
		return typeOfStratagy.operation(string);
	}
	
	// change the strategy
	// if typeOfStratagy is an instance of add but we want to subtract or multiply
	public void ChangeStrat(Authenticate newStrat) {
		typeOfStratagy = newStrat;
	}
	
	
	// to do an operation call: person.DoOp(1, 2);
	// a person (Maker) wants to subtract: person.ChangeStrat(new new Subtraction());
}

package pstfixInfix;

public class Calculator {
	private static volatile Calculator instance = null;
	private Calculator() {}
	
	public static Calculator getInstance() {
		if (instance == null) {
			synchronized(Calculator.class) {
				if (instance == null) {
					instance = new Calculator();
				}
			}
		}
		return instance;
	}
	
	protected Float add(float value2,float value1){
		float result= value1 + value2;
		return result;
	}
	protected Float subs(float value2,float value1){
		float result= value1 - value2;
		return result;
	}
	protected Float mult(float value2,float value1){
		float result= value1 * value2;
		return result;
	}
	protected Float div(float value2,float value1){
		float result = value1/value2;
		return result;
	}
	
	protected Float exp(float value2,float value1){
		float result= (float) Math.pow(value1, value2);
		return result;
	}
	
}

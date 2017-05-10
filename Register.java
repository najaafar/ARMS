import operator.*;

public class Register{

	private String name;
	private int value;
	private Operator operator;
	private boolean isBusy = false;

	public Register (String name, int value, boolean hasValue){
		this.name = name;
		this.value = value;
		this.isBusy = hasValue;
	} 

	/*setters*/

	public void setName(String name){
		this.name = name;
	}

	public void setValue(int value){
		this.value = value;
	}

	public void setOperator(Operator operator){
		this.operator = operator;
	}

	public void setStatus(boolean isBusy){
		this.isBusy = isBusy;
	}

	/*getters*/

	public String getName(){
		return name;
	}

	public int getValue(){
		return value;
	}

	public Operator getOperator(){
		return operator;
	}

	public boolean getStatus(){
		return isBusy;
	}

	public String toString(){
		return getName() + " " + getValue() + " " + getOperator() + " " + getStatus();
	}
}
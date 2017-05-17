package src;

import operator.*;

public class Register{

	private String name;
	private int value;
	private Operator operator;
	private boolean isBusy = false;

	//special case for MBR whose value would be string
	private String valueMBR;

	public Register (String name){
		this.name = name;
	} 

	/*setters*/

	public void setName(String name){
		this.name = name;
	}

	public void setValue(int value){
		this.value = value;
	}
	//special case: MBR contains string value since it contains the value of the instruction itself
	public void setValueMBR(String valueMBR){
		this.valueMBR = valueMBR;
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

	//special case: MBR contains string value since it contains the value of the instruction itself
	public String getValueMBR(){
		return valueMBR;
	}

	public Operator getOperator(){
		return operator;
	}

	public boolean getStatus(){
		return isBusy;
	}

	public String toString(){
		if(this.name.equals("MBR") == true)
			return getName() + " " + getValueMBR()/* + " " + getOperator() + " " + getStatus()*/;
		else return getName() + " " + getValue()/* + " " + getOperator() + " " + getStatus()*/;
	}
}
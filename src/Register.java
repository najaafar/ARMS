
public class Register{

	public String name;
	public int value;
	public boolean hasValue = false;

	public Register (String name, int value, boolean hasValue){
		this.name = name;
		this.value = value;
		this.hasValue = hasValue;
	} 

	public String getName(){
		return name;
	}

	public int getValue(){
		return value;
	}

	public boolean getHasValue(){
		return hasValue;
	}

	public String toString(){
		return getName() + " " + getValue() + " " + getHasValue();
	}
}
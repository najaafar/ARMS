package operator;

public class Load extends Operator{

	public String register;
	public int immediateValue;

	public Load (String name, int clockCycle, String register, int immediateValue){
		super(name, clockCycle);
		this.register = register;
		this.immediateValue = immediateValue;
	} 

	public String getRegister(){
		return register;
	}

	public int getImmeadiateValue(){
		return immediateValue;
	}

	public String toString(){
		return getName() + " " + getRegister() + " " + getImmeadiateValue() + " " + getClockCycle() + " " + getRemCountClockCycle();
	}

	//this method is not yet final. This is subject to changes.
	public void solve(){
		//check first if register is available or has already have a value
		/*if register has already have a value,
			delete/clear the current value of the register;
		/*register = immediateValue;*/
	}
}
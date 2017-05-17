/*
	Cmp.java
	- a class that executes the Cmp operation
*/
package operator;

public class Cmp extends Operator{

	public String src1;
	public String src2;

	public Cmp (String name, int clockCycle, String src1, String src2){
		super(name, clockCycle);
		this.src1 = src1;
		this.src2 = src2;
	} 

	public String getSrc1(){
		return src1;
	}

	public String getSrc2(){
		return src2;
	}

	public String toString(){
		return getName() + " " + getSrc1() + " " + getSrc2() + " " + getClockCycle() + " " + getRemCountClockCycle();
	}

	//this method is not yet final. This is subject to changes.
	public void solve(){
		//check first if both src is a register or immediate
			/*if src is register, fetch it's value from a hashmap<register, value>
			else stop this operation*/
		//verify if dst is a register
			/*if dst is not a register, stop this operation.
			else, proceed*/
		/*if src1 = src2, => 0;
		else if src1 < src2, => -1
		else src1 > src2, => 1*/
		//keep track of negative value
	}
}
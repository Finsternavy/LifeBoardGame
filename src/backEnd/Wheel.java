package backEnd;

import java.util.Random;

public class Wheel {
	
	int lastSpin = 1;
	
	public Wheel() {
		
	}
	
	public void setLastSpin(int spin){
		
		this.lastSpin = spin;
		
	}
	
	public int getLastSpin(){
		
		return lastSpin;
		
	}
	
	
	public int spinTheWheel() {

		Random r = new Random();
		int spin = r.nextInt((10 - 1) + 1) + 1;
		this.setLastSpin(spin);
		return spin;
		
	}
	



	
	/*public static void main(String[] args) {
		
		Wheel myWheel = new Wheel();
		
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		System.out.println(myWheel.spinTheWheel());
		
	}*/

}

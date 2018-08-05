package backEnd;

import java.util.ArrayList;
import java.util.Random;

public class SalaryCards {

	int salary;
	
	ArrayList<SalaryCards> mySalaryCards = new ArrayList<SalaryCards>();
	ArrayList<SalaryCards> mySalaryChoices = new ArrayList<SalaryCards>();
	
	public SalaryCards(int salary){
		
		this.salary = salary;
		
	}
	
	public SalaryCards(){
		
		generateSalaryCards();
		
	}
	
	public void setSalary(int salary){
		
		this.salary = salary;
		
	}
	
	public int getSalary(){
		
		return this.salary;
		
	}
	
	public void generateSalaryCards(){
		
		SalaryCards twentyThousand = new SalaryCards(20000);
		mySalaryCards.add(twentyThousand);
		
		SalaryCards thirtyThousand = new SalaryCards(30000);
		mySalaryCards.add(thirtyThousand);
		
		SalaryCards fortyThousand = new SalaryCards(40000);
		mySalaryCards.add(fortyThousand);
		
		SalaryCards fiftyThousand = new SalaryCards(50000);
		mySalaryCards.add(fiftyThousand);
		
		SalaryCards sixtyThousand = new SalaryCards(60000);
		mySalaryCards.add(sixtyThousand);
		
		SalaryCards seventyThousand = new SalaryCards(70000);
		mySalaryCards.add(seventyThousand);
		
		SalaryCards eightyThousand = new SalaryCards(80000);
		mySalaryCards.add(eightyThousand);
		
		SalaryCards ninetyThousand = new SalaryCards(90000);
		mySalaryCards.add(ninetyThousand);
		
		SalaryCards oneHundredThousand = new SalaryCards(100000);
		mySalaryCards.add(oneHundredThousand);
		
	}
	
	public void returnSalaryCards(int toDraw){
		
		if(mySalaryChoices.size() > 0){
			
			mySalaryChoices.clear();
			returnSalaryCards(toDraw);
			
		}else{
		
			int cardsToDraw = toDraw;
			for(int i = 0; i < cardsToDraw; i++){
			
				Random r = new Random();
				int value = r.nextInt(8 - 1 + 0) + 0;
				SalaryCards choice = new SalaryCards(mySalaryCards.get(value).getSalary());
				mySalaryChoices.add(choice);
			
			}
			
		}	
		
	}
	
}

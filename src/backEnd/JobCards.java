package backEnd;

import java.util.ArrayList;
import java.util.Random;

public class JobCards {
	
	//Superstar, Travel Agent, Teacher, Athlete, Salesperson, Doctor, Accountant, Artist, Police Officer
	
	String name;
	boolean degreeRequired;
	
	ArrayList<JobCards> myJobCards = new ArrayList<JobCards>();
	ArrayList<String> jobNames = new ArrayList<String>();
	ArrayList<JobCards> threeCardChoice = new ArrayList<JobCards>();

	
	public JobCards(){
		generateJobCards();
	}
	
	public JobCards(String name, boolean b){
		
		this.name = name;
		this.degreeRequired = b;
		
	}
	
	public void setName(String name){
		
		this.name = name;
		
	}
	
	public String getName(){
		
		return this.name;
		
	}
	
	public void setDegreeRequired(boolean b){
		
		this.degreeRequired = b;
		
	}
	
	public boolean getDegreeRequired(){
		
		return this.degreeRequired;
		
	}
	
	public void generateJobCards(){
		
		JobCards superstar = new JobCards("Superstar", false);
		myJobCards.add(superstar);
		
		JobCards traveAgent = new JobCards("Trave Agent", false);
		myJobCards.add(traveAgent);
		
		JobCards teacher = new JobCards("Teacher", true);
		myJobCards.add(teacher);
		
		JobCards athlete = new JobCards("Athlete", false);
		myJobCards.add(athlete);
		
		JobCards salesperson = new JobCards("Salesperson", false);
		myJobCards.add(salesperson);

		JobCards doctor = new JobCards("Doctor", true);
		myJobCards.add(doctor);
		
		JobCards accountant = new JobCards("Accountant", true);
		myJobCards.add(accountant);
		
		JobCards artist = new JobCards("Artist", false);
		myJobCards.add(artist);
		
		JobCards policeOfficer = new JobCards("Police Officer", false);
		myJobCards.add(policeOfficer);
		
		
	}

	
	public void returnJobCards(Player player, int toDraw){
		
		if(threeCardChoice.size() > 0){
			
			threeCardChoice.clear();
			returnJobCards(player, toDraw);
		
		}else{
		
			int cards = toDraw;
			for(int i = 0; i < cards; i++){
			
				Random r = new Random();
				int value = r.nextInt((8 - 1 + 1) + 1) ;
			
				if(myJobCards.get(value).getDegreeRequired() == true && player.getDegree() == true){
				
					JobCards choice = new JobCards(myJobCards.get(value).getName(), myJobCards.get(value).getDegreeRequired());
					threeCardChoice.add(choice);
					
			
				
				}else if(myJobCards.get(value).getDegreeRequired() == false){
			
					JobCards choice = new JobCards(myJobCards.get(value).getName(), myJobCards.get(value).getDegreeRequired());
					threeCardChoice.add(choice);
			
		
			
				}else{
				
					i--;
				
				}
			
			}
			
		}
		
	}
	
	public static void main(String[] args){
		
		JobCards cards = new JobCards();
		Player test = new Player();
		
		cards.returnJobCards(test, 10);
		
	}
	
}

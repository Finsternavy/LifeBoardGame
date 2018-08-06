package backEnd;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	
	/*This class tracks player progress through the game. 
	 * V.1 Created by Christopher Finster
	 */
	
	int playerID = 0;
	String name = "None";
	String job = "None";
	boolean hasDegree = false;
	int salary = 0;
	boolean married = false;
	int kids = 0;
	int funds = 10000;
	int totalBankLoan = 0;
	boolean autoInsurance = false;
	String houseOwned;
	int houseTax;
	int houseInsuranceCost;
	boolean homeInsurance = false;
	int lifeTiles = 0;
	boolean isRetired = false;
	boolean isRetiredMillionaire;
	int boardPosition = 0;
	int lostTurn = 0;
	private JobCards jobCard;
	
	//Empty constructor
	public Player (){
		
	}
	
	//Constructor with name and playerID specified
	public Player (int playerID, String name) {
		
		this.playerID = playerID;
		this.name = name;
		
	}
	
	public void addFunds(int funds){
		
		this.funds = this.getFunds() + funds;
		
	}
	
	public void removeFunds(int payment){
		
		if(this.getFunds() > payment){
		
			this.funds = this.getFunds() - payment;
			
		}else{
			
			this.increaseBankLoan(payment);
			
		}
		
	}
	
	//Increase amount owed to the bank accounting for interest
	public void increaseBankLoan(int loan){
		
		int interest = (loan / 20000) * 5000;
		
		this.totalBankLoan = this.getTotalBankLoan() + loan + interest;
		
		int increase = loan + interest;
		
		System.out.println("Bank Loan total increased by: $" + increase);
		
		
	}
	
	public void reduceBankLoan(int payment){
		
		this.totalBankLoan = this.getTotalBankLoan() - payment;
		this.removeFunds(payment);
		
	}
	
	public void addLifeTiles(int lifeTiles){
		this.lifeTiles = this.getLifeTiles() + lifeTiles;
	}

	public void advanceOneSpace(){
		
		this.boardPosition = this.getBoardPosition() + 1;
	}
	
	public void advancePlayer(int roll){
		
		this.boardPosition = this.getBoardPosition() + roll;
		
	}
	
	public void addLostTurn(int turns){
		
		this.lostTurn = this.getLostTurn() + turns;
		
	}

	
	public void removeLostTurn(){
		
		this.lostTurn--;
		
	}
	
	@Override
    public String toString(){
    	String playerID = "Player ID: " + new StringBuilder().append(this.playerID).toString() + "\n";
    	String playerName = "Player Name: " + new StringBuilder().append(this.name).toString() + "\n";
    	String playerJob = "Player Job: " + new StringBuilder().append(this.job).toString() + "\n";
    	String playerSalary = "Player Salary: " + new StringBuilder().append(this.salary).toString() + "\n";
    	String playerMarried = "Player Married?: " + new StringBuilder().append(this.married).toString() + "\n";
    	String playerKids = "Player has " + new StringBuilder().append(this.kids).toString() + " kids\n";
    	String playerFunds = "Player funds: " + new StringBuilder().append(this.funds).toString() + "\n";
    	String playerBankLoans = "Player Bank Loan Ammount: " + new StringBuilder().append(this.totalBankLoan).toString() + "\n";
    	String playerAuto = "Player has Auto Insurance?: " + new StringBuilder().append(this.autoInsurance).toString() + "\n";
    	String playerHome = "Player has Home Insurance?: " + new StringBuilder().append(this.homeInsurance).toString() + "\n";
    	String playerLifeTiles = "Player has " + new StringBuilder().append(this.lifeTiles).toString() +  " Life Tiles\n";
    	String playerRetired = "Player Retired?: " + new StringBuilder().append(this.isRetired).toString() + "\n";
    	String playerRetiredMillionaire = "Player retired at Millionaire estate?: " + new StringBuilder().append(this.isRetiredMillionaire).toString() + "\n";
    	String playerBoardPosition = "Player is at position: " + new StringBuilder().append(this.boardPosition).toString() + "\n";

    	return playerID + playerName + playerJob + playerSalary + playerMarried + playerKids + playerFunds + playerBankLoans + playerAuto + playerHome + playerLifeTiles
    			+ playerRetired + playerRetiredMillionaire + playerBoardPosition;
       
    }
}

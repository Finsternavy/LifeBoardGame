package backEnd;

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
	
	//Empty constructor
	public Player (){
		
	}
	
	//Constructor with name and playerID specified
	public Player (int playerID, String name) {
		
		this.playerID = playerID;
		this.name = name;
		
	}
	
	public int getPlayerID(){
		return playerID;
	}
	
	public void setPlayerID(int playerID){
		
		this.playerID = playerID;
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		
		this.name = name;
		
	}
	
	public String getJob(){
		
		return job;
		
	}
	
	public void setJob(String job){
		
		this.job = job;
		
	}
	
	public void setDegree(boolean b){
		
		this.hasDegree = b;
		
	}
	
	public boolean getDegree(){
		
		return this.hasDegree;
		
	}
	
	public int getSalary(){
		
		return salary;
		
	}
	
	public void setSalary(int salary){
		
		this.salary = salary;
		
	}
	
	public boolean getMarried(){
		
		return married;
		
	}
	
	public void setMarried(Boolean married){
		
		this.married = married;
		
	}
	
	public int getKids(){
		
		return kids;
		
	}
	
	public void setKids(int kids){
		
		this.kids = this.getKids() + kids;
		
	}
	
	public int getFunds(){
		
		return this.funds;
		
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
	
	public int getTotalBankLoan(){
		
		return totalBankLoan;
		
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
	
	public boolean getAutoInsuranceStatus(){
		
		return autoInsurance;
		
	}
	
	public void setAutoInsuranceStatus(boolean autoInsurance){
		
		this.autoInsurance = autoInsurance;
		
	}
	
	public boolean getHomeInsuranceStatus(){
		
		return homeInsurance;
		
	}
	
	public void setHomeInsuranceStatus(boolean homeInsurance){
		
		this.homeInsurance = homeInsurance;
		
	}
	
	public int getLifeTiles(){
		
		return lifeTiles;
		
	}
	
	public void setLifeTiles(int lifeTiles){
		
		this.lifeTiles = this.getLifeTiles() + lifeTiles;
		
	}
	
	public boolean getRetiredStatus(){
		
		return isRetired;
		
	}
	
	public void setRetiredStatus(boolean retired){
		
		this.isRetired = retired;
		
	}
	
	public int getBoardPosition(){
		
		return boardPosition;
		
	}
	
	public void setBoardPosition(int position){
		
		this.boardPosition = position;
		
	}
	
	public boolean getRetiredMillionaire(){
		
		return isRetiredMillionaire;
		
	}
	
	public void setRetiredMillionaire(boolean millionaire){
		
		this.isRetiredMillionaire = millionaire;
		
	}
	
	public void advanceOneSpace(){
		
		this.boardPosition = this.getBoardPosition() + 1;
	}
	
	public void advancePlayer(int roll){
		
		this.boardPosition = this.getBoardPosition() + roll;
		
	}
	
	public void setLostTurn(int turns){
		
		this.lostTurn = this.getLostTurn() + turns;
		
	}
	
	public int getLostTurn(){
		
		return this.lostTurn;
		
	}
	
	public void lowerLostTurn(){
		
		this.lostTurn--;
		
	}
	
	public void setHouseOwned(String houseOwned){
		
		this.houseOwned = houseOwned;
		
	}
	
	public String getHouseOwned(){
		
		return this.houseOwned;
		
	}
	
	public void setHouseTax(int houseTax){
		
		this.houseTax = houseTax;
		
	}
	
	public int getHouseTax(){
		
		return this.houseTax;
		
	}
	
	public void setHouseInsuranceCost(int houseInsuranceCost){
		
		this.houseInsuranceCost = houseInsuranceCost;
		
	}
	
	public int getHouseInsuranceCost(){
		
		return this.houseInsuranceCost;
		
	}
	
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
	
	
	public static void main(String[] args) {
		
		Player player1 = new Player(1, "Noah");
	
		
		
		System.out.println(player1);
		
		player1.increaseBankLoan(20000);
		
		System.out.println(player1.toString());
		
	} 
	

	
}

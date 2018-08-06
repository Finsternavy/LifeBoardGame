package backEnd;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameManager {
	
	// define magic numbers
	private static final int YOUR_VAR = -1;
	private static final int CHOOSE_JOB_TILE = 12;
	private static final int LOOSE_JOB_CHOOSE_NEW_JOB = 40;
	private static final int SPLIT_TILE = 50;
	
	int playersTurn = 0;
	int numberOfPlayers;
	HouseCards myHouseCards = new HouseCards();
	JobCards myJobCards = new JobCards();
	LifeTiles myLifeTiles = new LifeTiles();
	SalaryCards mySalaryCards = new SalaryCards();
	
	
	public GameManager() {
		
	}
	
	public void setPlayersTurn(int numberOfPlayers){
		
		int lastPlayersTurn = getPlayersTurn();
		
		if(lastPlayersTurn < (numberOfPlayers -1)){
			
			this.playersTurn = lastPlayersTurn + 1;
			gameFlow(Application.playersInPlay.get(playersTurn));
			
		}else{
			
			playersTurn = 0;
			gameFlow(Application.playersInPlay.get(playersTurn));
			
		}	
	}
	
	
	public int getPlayersTurn(){
		
		return playersTurn;
		
	}
	
	public void gameFlow(Player player){
		
		Scanner gameFlowScanner = new Scanner(System.in);
		Wheel wheel = new Wheel();
		
		if(player.getBoardPosition() == 0){
			
			gameSpaceFunction(player);
			
		}
		
		else if(player.getLostTurn() == 0){
			
			System.out.println("\n" + player.getName() + " It is your turn.  What would you like to do? \n" + "Type 1 to spin the wheel\n" +
					"Type 2 to buy stock\n" + "Type 3 to buy Auto Insurance\n" + "Type 4 to buy Home Insurance\n" + "Type 5 to pay back loan\n" +
					"Type 6 to check player information\n");
			
			if(gameFlowScanner.hasNextInt()){
			
				int playerSelection = gameFlowScanner.nextInt();
			
				if(playerSelection == 1){
				
					wheel.spinTheWheel();
					System.out.println("You spun a " + wheel.getLastSpin());
					
					if(player.getBoardPosition() < CHOOSE_JOB_TILE){
						
						player.setBoardPosition(player.getBoardPosition() + wheel.getLastSpin());
						
						if(player.getBoardPosition() >= CHOOSE_JOB_TILE){
							
							player.setBoardPosition(CHOOSE_JOB_TILE);
							System.out.println(player.getName() + ", your current board position is " + player.getBoardPosition() + "\n");
							gameSpaceFunction(player);
						
						}else{
							
							System.out.println(player.getName() + ", your current board position is " + player.getBoardPosition() + "\n");
							gameSpaceFunction(player);
							
							
						}
					
					}else if(player.getBoardPosition() >= CHOOSE_JOB_TILE && player.getBoardPosition() < LOOSE_JOB_CHOOSE_NEW_JOB){
						
						player.setBoardPosition(player.getBoardPosition() + wheel.getLastSpin());
						System.out.println(player.getName() + ", your current board position is " + player.getBoardPosition() + "\n");
						gameSpaceFunction(player);
						
					}else if(player.getBoardPosition() >= LOOSE_JOB_CHOOSE_NEW_JOB && player.getBoardPosition() < SPLIT_TILE){
						
						int tempPosition = player.getBoardPosition() + wheel.getLastSpin();
						
						
						if(tempPosition > SPLIT_TILE){
							
							int movesLeft = tempPosition - SPLIT_TILE;
							
							int playersNewPosition = SPLIT_TILE;
							
							System.out.println("Turn ahead! Do you want to turn left or right? Type 1 for left and 2 for right.");
							
							if(gameFlowScanner.hasNextInt()){
								
								int turnChoice = gameFlowScanner.nextInt();
								
								if(turnChoice == 1){
									
									if(movesLeft <= 7){
										
										player.setBoardPosition(playersNewPosition + movesLeft);
										gameSpaceFunction(player);
										
									}else{
										
										int newMovesLeft = movesLeft - 7;
									
										player.setBoardPosition(63 + newMovesLeft);
										gameSpaceFunction(player);
									
									}
									
								}else if(turnChoice == 2){
									
									player.setBoardPosition(57 + movesLeft);
									gameSpaceFunction(player);
									
								}else{
									
									System.out.println("Please enter 1 or 2 only.");
									gameSpaceFunction(player);
									
								}
								
							}
							
						}
						
					}else if(player.getBoardPosition() == SPLIT_TILE){
						
						gameSpaceFunction(player);
						
					}else if(player.getBoardPosition() > SPLIT_TILE && player.getBoardPosition() < 58){
						
						int playersNextPosition = player.getBoardPosition() + wheel.getLastSpin();
						
						if(playersNextPosition > 57){
							
							int movesLeft = playersNextPosition - 58;
							player.setBoardPosition(64 + movesLeft);
							gameSpaceFunction(player);
						
						}else{
							
							player.setBoardPosition(playersNextPosition);
							gameSpaceFunction(player);
							
						}
						//Need to add code to handle if board position is in range for next turn.
					}else if(player.getBoardPosition() >= 64 && player.getBoardPosition() < 76){
						
						player.setBoardPosition(player.getBoardPosition() + wheel.getLastSpin());
						gameSpaceFunction(player);
						
					}else if(player.getBoardPosition() >= 76 && player.getBoardPosition() < 87){
						
						int playersNextPosition = player.getBoardPosition() + wheel.getLastSpin();
						int movesLeft = playersNextPosition - 86;
						
						if(playersNextPosition <= 86){
							
							player.setBoardPosition(playersNextPosition);
							gameSpaceFunction(player);
							
						}else if(playersNextPosition > 86){
							
							System.out.println("Turn ahead.  Type 1 to turn left or 2 to turn right.");
							
							if(gameFlowScanner.hasNextInt()){
								
								int choice = gameFlowScanner.nextInt();
								
								if(choice == 1){
									
									if(playersNextPosition < 91){
										
										player.setBoardPosition(playersNextPosition);
										gameSpaceFunction(player);
										
									}else{
										
										player.setBoardPosition(99 + movesLeft);
										gameSpaceFunction(player);
										
									}
									
								}else if(choice == 2){
									
									player.setBoardPosition(91 + playersNextPosition);
									gameSpaceFunction(player);
									
								}else{
									
									System.out.println("Please type 1 or 2 only.  Try again.");
									
								}
								
							}
							
						}
						
					}else if(player.getBoardPosition() >= 87 && player.getBoardPosition() < 91){
						
						int newPosition = player.getBoardPosition() + wheel.getLastSpin();
						
						if(newPosition > 90){
							
							int movesLeft = newPosition - 90;
							player.setBoardPosition(99 + movesLeft);
							
						}else{
							
							player.setBoardPosition(newPosition);
							gameSpaceFunction(player);
							
						}
						
					}else if(player.getBoardPosition() > 98){
						
						int newPosition = player.getBoardPosition() + wheel.getLastSpin();
						
						if(newPosition >= 151){
							
							player.setBoardPosition(151);
							
							System.out.println("You have reached retirement! Would you like to retire to CountrySide Acres or Millionaire Estates?\n" +
												"Type 1 for CountrySide Acres or 2 for Millionaire Estates: \n");
							
							if(gameFlowScanner.hasNextInt()){
								
								int choice = gameFlowScanner.nextInt();
								
								if(choice == 1){
									
									player.setRetiredStatus(true);
									player.setRetiredMillionaire(false);
									
								}else if(choice == 2){
									
									player.setRetiredMillionaire(true);
									player.setRetiredStatus(true);
									
								}else{
									
									System.out.println("Please type 1 or 2 only.  Try again.");
									gameSpaceFunction(player);
									
								}
								
							}else{
								
								System.out.println("Please enter 1 or 2 only.  Try again");
								gameSpaceFunction(player);
								
							}
							
							
						}else{
						
							player.setBoardPosition(player.getBoardPosition() + wheel.getLastSpin());
							gameSpaceFunction(player);
							
						}
						
					}else if(player.getBoardPosition() == 151){
						
						
						gameSpaceFunction(player);
						
					}
				
				}else if(playerSelection == 2){
				
					System.out.println("Stock not available at this time. Select a new option.");
					gameFlow(player);
				
				}else if(playerSelection == 3){
				
					System.out.println("Are you sure you'd like to purchase Auto Insurance for $10,000?\n" + "Type 1 for yes or 2 for no.");
				
					if(gameFlowScanner.hasNext()){
					
						int autoSelection = gameFlowScanner.nextInt();
					
						if(autoSelection ==1){
						
							player.setAutoInsuranceStatus(true);
							player.removeFunds(10000);
							gameFlow(player);
						
						
						}else if(autoSelection == 2){
						
							gameFlow(player);
							
						
						}else{
						
							System.out.println("Invalid selection.  Please try again.");
							gameFlow(player);
						
						}
					
					}
				
				}else if(playerSelection == 4){
				
				
					int houseInsurancePrice = player.houseInsuranceCost;
				
					if(player.getHomeInsuranceStatus() == false){
					
						System.out.println("You do not own a home yet.");
						gameFlow(player);
					
					}else{
						//Need to program house variable to Player class
						System.out.println("Are you sure you'd like to purchase Home Insurance for " + houseInsurancePrice + ". Type 1 for yes or 2 for no.");
				
						if(gameFlowScanner.hasNext()){
					
							int autoSelection = gameFlowScanner.nextInt();
					
							if(autoSelection == 1){
							
								int fundsAvailable = player.getFunds();
							
								if(fundsAvailable >= houseInsurancePrice){
						
									player.setAutoInsuranceStatus(true);
									player.removeFunds(houseInsurancePrice);
								
								}else{
								
									System.out.println("Sorry! You do not have enough money.");
									gameFlow(player);
								
								}
						
							}else if(autoSelection == 2){
						
								gameFlow(player);
						
							}else{
						
								System.out.println("Invalid selection.  Please try again.");
								gameFlow(player);
						
							}
						
						}
					
					}
					
				}else if(playerSelection == 5){
				
					System.out.println("Your total bank loan balance is: " + player.getTotalBankLoan() + "\nHow much would you like to pay?\n");
					
					if(gameFlowScanner.hasNextInt()){
						
						int loanRepayAmount = gameFlowScanner.nextInt();
						
						if(player.getFunds() > loanRepayAmount){
						
							player.reduceBankLoan(loanRepayAmount);
							gameFlow(player);
						
						}else{
							
							System.out.println("You do not have enough money to complete this transaction. Try again\n");
							gameFlow(player);
							
						}
						
						
					}else{
						
						System.out.println("Please enter a whole number only.");
						gameFlow(player);
						
					}
					
					
				}else if(playerSelection == 6){	
					
					System.out.print(player.toString());
					gameFlow(player);
					
				}else{
					System.out.println("Invalid selection! Please try again.");
					gameFlow(player);
				}
			
			}
			
		}else{
			
			System.out.println(player.name + " Sorry, you lost this turn.");
			player.lowerLostTurn();
			setPlayersTurn(numberOfPlayers);
			
		}
		
	}
	

	public void gameSpaceFunction(Player player) {
		
		Scanner myScanner = new Scanner(System.in);
		
		int gameSpace = player.getBoardPosition();
		Wheel wheel = new Wheel();
		
		switch (gameSpace) {
		
		case 0: System.out.println(player.name + " Would you like to go to college or start your career? "
				+ "Type: 1 for Career or 2 for College");
		
				if(myScanner.hasNextInt()){
					
					int startChoice = myScanner.nextInt();
					
					if (startChoice == 1) {
					
						player.setBoardPosition(13);
						gameSpaceFunction(player);
							
					}else if(startChoice == 2){
					
						//Need code to select career and salary before spinning
						player.setBoardPosition(1);
						gameSpaceFunction(player);
					
					
					}else{

					
						System.out.println("Try Again! Enter 'Career' or 'College'");
						gameSpaceFunction(player);
					}
					
				}else{
					
					System.out.println("Please enter 1 or 2 only.");
					gameSpaceFunction(player);
					
				}
				
				break;
				
		case 1: player.increaseBankLoan(40000);
				System.out.println("Congratulations on starting college! ");
				System.out.println("$40,000 student loan has been taken out.");
				System.out.println("Let's get started! Type 1 to spin the wheel!");
				
				if(myScanner.hasNextInt()){
					
				int spinTheWheel = myScanner.nextInt();
				
					if (spinTheWheel == 1) {
						wheel.spinTheWheel();
						System.out.println("You spun a " + wheel.getLastSpin());
						player.setBoardPosition(player.getBoardPosition() + wheel.getLastSpin());
						System.out.println(player.getName() + ", your current board position is " + player.getBoardPosition() + "\n");
						gameSpaceFunction(player);
						
						//Switches to next player and starts their turn
						
				
						
					}else{
						
						System.out.println("Error! Command not recognised. Try again.");
						gameSpaceFunction(player);
					}
					
				}else{
					
					System.out.println("Error! Please type 1 only.");
					gameSpaceFunction(player);
					
				}
				
				break;
				
		case 2: System.out.println("Scholarship! Collect $20,000!");
				player.addFunds(20000);
				setPlayersTurn(numberOfPlayers);
			
				break;
				
		case 3:	System.out.println("Buy books and supplies. Pay $5,000");
				player.removeFunds(5000);
				setPlayersTurn(numberOfPlayers);

				break;
			
		case 4:	System.out.println("Make a new friend! Life Tile added.");
				player.setLifeTiles(1);
				setPlayersTurn(numberOfPlayers);
				
			
		case 5:	System.out.println("Part time job. Collect $5,000.");
				player.addFunds(5000);
				setPlayersTurn(numberOfPlayers);
				
			
		case 6:	System.out.println("Cram for exams. Lose next turn");
				player.setLostTurn(1);
				setPlayersTurn(numberOfPlayers);
				
			
		case 7:	System.out.println("Study in Europe! Life Tile added.");
				player.setLifeTiles(1);
				setPlayersTurn(numberOfPlayers);
				
			
		case 8:	System.out.println("Spring break in Florida! Pay $5,000.");
				player.removeFunds(5000);
				setPlayersTurn(numberOfPlayers);
				
			
		case 9:	System.out.println("Dean's list! Life Tile added.");
				player.setLifeTiles(1);
				setPlayersTurn(numberOfPlayers);
			
		case 10:	System.out.println("Write term paper. Lose next turn.");
					player.setLostTurn(1);
					setPlayersTurn(numberOfPlayers);
			
		case 11:	System.out.println("Graduation day! Life Tile added.");
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
					
					//Redo so it performs job search vise house search.. Ref case 38 for help.
		case CHOOSE_JOB_TILE:	System.out.println("Stop! Job Search. Select a job.");
					player.setDegree(true);
					myJobCards.returnJobCards(player, 3);
					System.out.println("Type 1 for: " + myJobCards.threeCardChoice.get(0).name + "\nType 2 for: " + myJobCards.threeCardChoice.get(1).name + "\n"
										+ "Type 3 for: " + myJobCards.threeCardChoice.get(2).name);
					
					if(myScanner.hasNextInt()){
						
						int cardSelection = myScanner.nextInt();
						
						if(cardSelection == 1){
							
							player.setJob(myJobCards.threeCardChoice.get(0).name); 
							
							
						}else if(cardSelection == 2){
							
							player.setJob(myJobCards.threeCardChoice.get(1).name);
							
						}else if(cardSelection == 3){
							
							player.setJob(myJobCards.threeCardChoice.get(2).name);
							
						}else{
							
							System.out.println("Invalid entry.  Try again");
							
						}
						
					}
					
					mySalaryCards.returnSalaryCards(3);
					System.out.println("Select a Salary: Type 1 for " + mySalaryCards.mySalaryChoices.get(0).getSalary() + "\nType 2 for: " +
										mySalaryCards.mySalaryChoices.get(1).getSalary() + "\nType 3 for: " + mySalaryCards.mySalaryChoices.get(2).getSalary());
					
					if(myScanner.hasNextInt()){
						
						int cardSelection = myScanner.nextInt();
						
						if(cardSelection == 1){
							
							player.setSalary(mySalaryCards.mySalaryChoices.get(0).getSalary());
							
							
						}else if(cardSelection == 2){
							
							player.setSalary(mySalaryCards.mySalaryChoices.get(1).getSalary());
							
						}else if(cardSelection == 3){
							
							player.setSalary(mySalaryCards.mySalaryChoices.get(2).getSalary());
							
						}else{
							
							System.out.println("Invalid entry.  Try again");
							
						}
						
					}
		
					player.setBoardPosition(13);
					gameFlow(player);
			
		case 13:	System.out.println("Stop! Job Search. Select a job.");
					player.setDegree(false);
					myJobCards.returnJobCards(player, 1);
					System.out.println("You drew: " + myJobCards.threeCardChoice.get(0).getName());
					
					if(myJobCards.threeCardChoice.get(0).getDegreeRequired() == true){
						
						System.out.println("Sorry! That career requires a degree.  Type 1 to draw again.");
	
						if(myScanner.hasNextInt()){
			
							int cardSelection = myScanner.nextInt();
			
							if(cardSelection == 1){
				
								gameSpaceFunction(player); 
				
				
							}else{
								
								System.out.println("Please type 1 to continue.");
								
							}
			
						}else{
							
							System.out.println("Please type 1 to continue.");
							
						}
						
						
						
					}else{
						
						player.setJob(myJobCards.threeCardChoice.get(0).getName());
						
					}
					
		
					mySalaryCards.returnSalaryCards(1);
					System.out.println("Select a Salary: Type 1");
		
					if(myScanner.hasNextInt()){
			
						int cardSelection = myScanner.nextInt();
			
						if(cardSelection == 1){
				
							player.setSalary(mySalaryCards.mySalaryChoices.get(0).getSalary());
							System.out.println("Your salary is: " + player.getSalary());
				
						}else{
				
							System.out.println("Invalid entry.  Try again");
				
						}
			
					}

					gameFlow(player);
					
					break;
			
		case 14:	System.out.println("Pay Day!");
					player.addFunds(player.getSalary());
					System.out.println("$" + player.getSalary() + " has been added to your funds. Your new funds total is: " + player.getFunds());
					setPlayersTurn(numberOfPlayers);
					
					break;
			
		case 15:	System.out.println("Rent apartment. Pay $5,000");
					player.removeFunds(5000);
					setPlayersTurn(numberOfPlayers);
					
					break;
				
		case 16: 	System.out.println("Raffle prize! Collect $10,000");
					player.addFunds(10000);
					setPlayersTurn(numberOfPlayers);
					
					break;
			
		case 17:	System.out.println("Pay Day!");
					player.addFunds(player.getSalary());
					System.out.println("$" + player.getSalary() + " has been added to your funds. Your new funds total is: " + player.getFunds());
					setPlayersTurn(numberOfPlayers);
			
		case 18:	System.out.println("Adopt a pet! Life Tile added!");
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 19:	System.out.println("Donate to favorite cherity.  Pay $5,000.\n");
					player.removeFunds(5000);
					setPlayersTurn(numberOfPlayers);
			
		case 20:	System.out.println("Birthday party! Life Tile added!");
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 21:	System.out.println("Ski accident! Pay $5,000 to Doctor.");
					
					if(player.getJob() == "Doctor"){

						System.out.println("Good thing I'm a Doctor!");
						
					}else{
						
						player.removeFunds(5000);
						
						for(int i = 0; i < Application.playersInPlay.size(); i++){
						
							if(Application.playersInPlay.get(i).getJob() == "Doctor"){
							
								Application.playersInPlay.get(i).addFunds(5000);
								System.out.println(Application.playersInPlay.get(i).getName() + " $5,000 has been added to your funds!");
							
							}else{
							
								System.out.println(Application.playersInPlay.get(i).getName() + " is not a Doctor.\n");
							
							}
						}
					}
					setPlayersTurn(numberOfPlayers);
					
			
		case 22:	System.out.println("Win marathon! Collect $10,000!");
					player.addFunds(10000);
					setPlayersTurn(numberOfPlayers);
			
		case 23:	System.out.println("Say NO to drugs! Life Tile added!");
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 24:	System.out.println("Don't drink and drive! Life Tile added!");
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 25:	System.out.println("Pay Day!");
					player.addFunds(player.getSalary());
					System.out.println("$" + player.getSalary() + " has been added to your funds. Your new funds total is: " + player.getFunds());
					setPlayersTurn(numberOfPlayers);
			
		case 26:	System.out.println("Flat tire. Lose next turn");
					player.setLostTurn(1);
					setPlayersTurn(numberOfPlayers);
			
		case 27:	System.out.println("STOP! Get married! Life Tile added!");
					player.setMarried(true);
					player.setLifeTiles(1);
					gameFlow(player);
			
		case 28:	System.out.println("Wedding reception. Pay $10,000");
					player.removeFunds(10000);
					setPlayersTurn(numberOfPlayers);
			
		case 29:	System.out.println("Happy honeymoon! Life tile added!");
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 30:	System.out.println("Buy furniture. Pay $10,000");
					player.removeFunds(10000);
					setPlayersTurn(numberOfPlayers);
			
		case 31:	System.out.println("Car accident. Pay $10,000 if not insured.");
					if(player.getAutoInsuranceStatus() == false){
						
						player.removeFunds(10000);
						setPlayersTurn(numberOfPlayers);
						
					}else{
						
						setPlayersTurn(numberOfPlayers);
						
					}
			
		case 32:	System.out.println("Move across country. Pay $10,000");
					player.removeFunds(10000);
					setPlayersTurn(numberOfPlayers);
			
		case 33:	System.out.println("Night School.  Pay $20,000 (Optional)\n"  + "Would you like to attend night school?" + "\nType 1 for yes or type 2 for no.");
					if(myScanner.hasNextInt()){
						
						int choice = myScanner.nextInt();
						
						if(choice == 1){
							
							myJobCards.returnJobCards(player, 2);
							System.out.println("Please select a new career:\n Type 1 for " + myJobCards.threeCardChoice.get(0).getName() + "\n" +
												"Type 2 for " + myJobCards.threeCardChoice.get(1).getName() + "\nOr type 3 to kee your current job of " +
												player.getJob());
							
							if(myScanner.hasNextInt()){
								
								int jobChoice = myScanner.nextInt();
								
								if(jobChoice == 1){
									
									player.setJob(myJobCards.threeCardChoice.get(0).getName());
									player.removeFunds(20000);
									
								}else if(jobChoice == 2){
									
									player.setJob(myJobCards.threeCardChoice.get(1).getName());
									player.removeFunds(20000);
									
								}else if(jobChoice == 3){
									
									System.out.println("You chose to keep your current job.");
									player.removeFunds(20000);
									
								}else{
									
									System.out.println("Sorry! Didn't get that.  Please try again.");
									gameSpaceFunction(player);
									
								}
								
							}else{
								
								System.out.println("Sorry! Didn't get that.  Please try again.");
								gameSpaceFunction(player);
								
							}
							
							mySalaryCards.returnSalaryCards(2);
							System.out.println("Please select a new Salary:\n Type 1 for " + mySalaryCards.mySalaryChoices.get(0).getSalary() + "\n" +
									"Type 2 for " + mySalaryCards.mySalaryChoices.get(1).getSalary() + "\nOr type 3 to kee your current salary of " +
									player.getSalary());
							
							if(myScanner.hasNextInt()){
								
								int salaryChoice = myScanner.nextInt();
								
								if(salaryChoice == 1){
									
									player.setSalary(mySalaryCards.mySalaryChoices.get(0).getSalary());
									
									
								}else if(salaryChoice == 2){
									
									player.setSalary(mySalaryCards.mySalaryChoices.get(1).getSalary());
									
									
								}else if(salaryChoice == 3){
									
									System.out.println("You chose to keep your current salary.");
									
									
								}else{
									
									System.out.println("Sorry! Didn't get that.  Please try again.");
									gameSpaceFunction(player);
									
								}
								
							}else{
								
								System.out.println("Sorry! Didn't get that.  Please try again.");
								gameSpaceFunction(player);
								
							}
							
							
							
							
						}else if(choice == 2){
							
							setPlayersTurn(numberOfPlayers);
							
						}else{
							
							System.out.println("Please type 1 or 2 only.  Please try again.");
							gameSpaceFunction(player);
							
						}
						
						setPlayersTurn(numberOfPlayers);
						
					}else{
						
						System.out.println("Please enter 1 or 2 only.  Please try again.");
						gameSpaceFunction(player);
						
					}
					
			
		case 34:	System.out.println("Pay Day!");
					player.addFunds(player.getSalary());
					System.out.println("$" + player.getSalary() + " has been added to your funds. Your new funds total is: " + player.getFunds());
					setPlayersTurn(numberOfPlayers);
			
		case 35:	System.out.println("Taxes due. Pay $" + player.getHouseTax());
					if(player.getJob() == "Accountant"){
						
						System.out.println("Good thing I'm an accountant!");
						setPlayersTurn(numberOfPlayers);
						
					}else{
						
						int tax = player.getSalary() / 2;
						player.removeFunds(tax);
						
						for(int i = 0; i <Application.playersInPlay.size(); i ++){
							
							if(Application.playersInPlay.get(i).getJob() == "Accountant"){
								
								Application.playersInPlay.get(i).addFunds(tax);
								
							}else{
								
								System.out.println(Application.playersInPlay.get(i).getName() + " is not an Accountant.");
								
							}
							
						}
						
						setPlayersTurn(numberOfPlayers);
						
					}
			
		case 36:	System.out.println("Win lottery! Collect $50,000");
					player.addFunds(50000);
					setPlayersTurn(numberOfPlayers);
			
		case 37:	System.out.println("Visit in-laws. Life tile added!");
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 38:	System.out.println("Stop! Buy a house. Draw a deed.");
					myHouseCards.returnHouseCards(3);
					System.out.println("Type 1 for: " + myHouseCards.threeHouseChoice.get(0).name + "\nType 2 for: " + myHouseCards.threeHouseChoice.get(1).name + "\n"
										+ "Type 3 for: " + myHouseCards.threeHouseChoice.get(2).name);
					
					if(myScanner.hasNextInt()){
			
						int houseSelection = myScanner.nextInt();
			
						if(houseSelection == 1){
				
							player.setHouseOwned(myHouseCards.threeHouseChoice.get(0).name); 
							player.setHouseTax(myHouseCards.threeHouseChoice.get(0).taxes); 
							player.setHouseInsuranceCost(myHouseCards.threeHouseChoice.get(0).insurancePrice);
							
							if(player.getFunds() >= myHouseCards.threeHouseChoice.get(0).price){
								
								player.removeFunds(myHouseCards.threeHouseChoice.get(0).price);
								
							}else{
								
								player.increaseBankLoan(myHouseCards.threeHouseChoice.get(0).price);
								
							}
				
						}else if(houseSelection == 2){
				
							player.setHouseOwned(myHouseCards.threeHouseChoice.get(1).name); 
							player.setHouseTax(myHouseCards.threeHouseChoice.get(1).taxes); 
							player.setHouseInsuranceCost(myHouseCards.threeHouseChoice.get(1).insurancePrice);
							
							if(player.getFunds() >= myHouseCards.threeHouseChoice.get(1).price){
								
								player.removeFunds(myHouseCards.threeHouseChoice.get(1).price);
								
							}else{
								
								player.increaseBankLoan(myHouseCards.threeHouseChoice.get(1).price);
								
							}
				
						}else if(houseSelection == 3){
				
							player.setHouseOwned(myHouseCards.threeHouseChoice.get(2).name); 
							player.setHouseTax(myHouseCards.threeHouseChoice.get(2).taxes); 
							player.setHouseInsuranceCost(myHouseCards.threeHouseChoice.get(2).insurancePrice);
							
							if(player.getFunds() >= myHouseCards.threeHouseChoice.get(2).price){
								
								player.removeFunds(myHouseCards.threeHouseChoice.get(2).price);
								
							}else{
								
								player.increaseBankLoan(myHouseCards.threeHouseChoice.get(2).price);
								
							}
				
						}else{
				
							System.out.println("Invalid entry.  Try again");
				
						}
			
					}else{
						
						System.out.println("Invalid selection. Try again.");
						
					}

					gameFlow(player);
			
		case 39:	System.out.println("Pay Day!");
					player.addFunds(player.getSalary());
					System.out.println("$" + player.getSalary() + " has been added to your funds. Your new funds total is: " + player.getFunds());
					setPlayersTurn(numberOfPlayers);
			
		case LOOSE_JOB_CHOOSE_NEW_JOB:	System.out.println("You're fired!!! Start a new career.");
					
					List<JobCards> jobsForYou = myJobCards.returnJobCards(player);
					// todo, let player pick the job, for now random
					JobCards card = jobsForYou.get(ThreadLocalRandom.current().nextInt(0, jobsForYou.size()));
					player.setJob(card.getName());
					
					mySalaryCards.returnSalaryCards(1);
					
					player.setSalary(mySalaryCards.mySalaryChoices.get(0).getSalary());
					
					System.out.println("Your new career is: " + player.getJob() + "\nYour new salary is: " + player.getSalary());
					
					setPlayersTurn(numberOfPlayers);	
					
			
		case 41:	System.out.println("Baby boy! Life tile added!");
					player.setKids(1);
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 42:	System.out.println("Inheritance! Collect $100,000");
					player.addFunds(100000);
					setPlayersTurn(numberOfPlayers);
			
		case 43:	System.out.println("Baby girl! Life tile added!");
					player.setKids(1);
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 44:	System.out.println("Win talent contest. Collect $10,000");
					player.addFunds(10000);
					setPlayersTurn(numberOfPlayers);
			
		case 45:	System.out.println("Pay Day");
					player.addFunds(player.getSalary());
					System.out.println("$" + player.getSalary() + " has been added to your funds. Your new funds total is: " + player.getFunds());
					setPlayersTurn(numberOfPlayers);
			
		case 46:	System.out.println("Twins! Life tile added!");
					player.setKids(2);
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 47:	System.out.println("Box seats at World Series. Pay $20,000");
					player.removeFunds(20000);
					setPlayersTurn(numberOfPlayers);
			
		case 48:	System.out.println("Baby girl! Life tile added!");
					player.setKids(1);
					player.setLifeTiles(1);
					setPlayersTurn(numberOfPlayers);
			
		case 49:	System.out.println("Attend Hollywood movie premiere. Pay $5,000");
					player.removeFunds(5000);
					setPlayersTurn(numberOfPlayers);
			
		case 50:	System.out.println("House flooded! Pay $40,000 if not insured.");
					if(player.isHomeInsuranceStatus() == false){
						
						player.removeFunds(40000);
						setPlayersTurn(numberOfPlayers);
						
					}else{
						
						System.out.println("Good thing I'm insured!");
						setPlayersTurn(numberOfPlayers);
						
					}
			
		case 51:	System.out.println("");
			
		case 52:	System.out.println("");
			
		case 53:	System.out.println("");
			
		case 54:	System.out.println("");
			
		case 55:	System.out.println("");
			
		case 56:	System.out.println("");
			
		case 57:	System.out.println("");
			
		case 58:	System.out.println("");
			
		case 59:	System.out.println("");
			
		case 60:	System.out.println("");
			
		case 61:System.out.println("");
			
		case 62:System.out.println("");
			
		case 63:System.out.println("");
			
		case 64:System.out.println("");
			
		case 65:System.out.println("");
			
		case 66:System.out.println("");
			
		case 67:System.out.println("");
			
		case 68:System.out.println("");
			
		case 69:System.out.println("");
			
		case 70:System.out.println("");
			
		case 71:System.out.println("");
			
		case 72:System.out.println("");
			
		case 73:System.out.println("");
			
		case 74:System.out.println("");
			
		case 75:System.out.println("");
			
		case 76:System.out.println("");
			
		case 77:System.out.println("");
			
		case 78:System.out.println("");
			
		case 79:System.out.println("");
			
		case 80:System.out.println("");
			
		case 81:System.out.println("");
			
		case 82:System.out.println("");
			
		case 83:System.out.println("");
			
		case 84:System.out.println("");
			
		case 85:System.out.println("");
			
		case 86:System.out.println("");
			
		case 87:System.out.println("");
			
		case 88:System.out.println("");
			
		case 89:System.out.println("");
			
		case 90:System.out.println("");
			
		case 91:System.out.println("");
			
		case 92:System.out.println("");
			
		case 93:System.out.println("");
			
		case 94:System.out.println("");
			
		case 95:System.out.println("");
			
		case 96:System.out.println("");
			
		case 97:System.out.println("");
			
		case 98:System.out.println("");
			
		case 99:System.out.println("");
			
		case 100:System.out.println("");
			
		case 101:System.out.println("");
			
		case 102:System.out.println("");
			
		case 103:System.out.println("");
			
		case 104:System.out.println("");
			
		case 105:System.out.println("");
			
		case 106:System.out.println("");
			
		case 107:System.out.println("");
			
		case 108:System.out.println("");
			
		case 109:System.out.println("");
			
		case 110:System.out.println("");
			
		case 111:System.out.println("");
			
		case 112:System.out.println("");
			
		case 113:System.out.println("");
			
		case 114:System.out.println("");
			
		case 115:System.out.println("");
			
		case 116:System.out.println("");
			
		case 117:System.out.println("");
			
		case 118:System.out.println("");
			
		case 119:System.out.println("");
			
		case 120:System.out.println("");
			
		case 121:System.out.println("");
			
		case 122:System.out.println("");
			
		case 123:System.out.println("");
			
		case 124:System.out.println("");
			
		case 125:System.out.println("");
			
		case 126:System.out.println("");
			
		case 127:System.out.println("");
			
		case 128:System.out.println("");
			
		case 129:System.out.println("");
			
		case 130:System.out.println("");
			
		case 131:System.out.println("");
			
		case 132:System.out.println("");
			
		case 133:System.out.println("");
			
		case 134:System.out.println("");
			
		case 135:System.out.println("");
			
		case 136:System.out.println("");
			
		case 137:System.out.println("");
			
		case 138:System.out.println("");
			
		case 139:System.out.println("");
			
		case 140:System.out.println("");
			
		case 141:System.out.println("");
			
		case 142:System.out.println("");
			
		case 143:System.out.println("");
			
		case 144:System.out.println("");
			
		case 145:System.out.println("");
			
		case 146:System.out.println("");
			
		case 147:System.out.println("");
			
		case 148:System.out.println("");
			
		case 149:System.out.println("");
			
		case 150:System.out.println("");
			
		case 151:System.out.println("");
		
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		

		
	}
	
}

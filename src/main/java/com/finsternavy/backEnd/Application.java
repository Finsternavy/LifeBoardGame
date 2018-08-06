package backEnd;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	
	static ArrayList<Player> playersInPlay = new ArrayList<Player>();
	
	static Scanner myScanner = new Scanner(System.in);
	
	public static void createPlayers(int numberOfPlayers){
		
		for (int i = 1; i <= numberOfPlayers; i++){
			
		
			
			String newPlayerID = new StringBuilder().append(i).toString();
			System.out.println("Player " + newPlayerID + ", Enter your name:");
			String playerObjectName = myScanner.nextLine();
			Player newPlayer = new Player(i, playerObjectName);
			playersInPlay.add(newPlayer);
			System.out.println(newPlayer.toString());
			
		}
		
	}
	
	public static void innitiateGame(int numberOfPlayers){
		
		createPlayers(numberOfPlayers);
		
		
	}
	
	public static void setNumberOfPlayers(GameManager manager){
		
		Scanner newScanner = new Scanner(System.in);
		System.out.println("How many players?");
		
		if(newScanner.hasNextInt()){
			int numberOfPlayers = newScanner.nextInt();
		
			if(numberOfPlayers > 0 && numberOfPlayers < 5){
				manager.numberOfPlayers = numberOfPlayers;
				innitiateGame(numberOfPlayers);
				
				}else{
			
					System.out.println("Please enter a number between 1 and 4.");
					setNumberOfPlayers(manager);
			
				}
		}else{
			
			System.out.println("Please enter a number only");
			setNumberOfPlayers(manager);
			
		}
		
	}

	public static void main(String[] args) {
		
		GameManager manager = new GameManager();
		
		setNumberOfPlayers(manager);
		
		
		
		manager.gameFlow(playersInPlay.get(0));
		
		System.out.println("Game stops here..?");
			
		

	}

}

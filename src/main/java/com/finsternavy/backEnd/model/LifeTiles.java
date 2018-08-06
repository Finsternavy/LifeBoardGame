package backEnd;

import java.util.ArrayList;
import java.util.Random;

public class LifeTiles {
	
	String name = "Life Tile";
	int tileID;
	int value;
	
	static ArrayList<LifeTiles> myLifeTiles = new ArrayList<LifeTiles>();
	
	public LifeTiles(int ID, int value){
		
		this.tileID = ID;
		this.value = value;
		
	}
	
	public LifeTiles(){
		
	}
	
	
	public void setTileValue(){

			Random r = new Random();
			int value = r.nextInt(10 - 1 + 1) + 1;
			int newValue = value * 10000;
			
			
			this.value = newValue;
		
	}
	
	public void createTiles(int tiles){
		
		int numOfTiles = tiles;
		
		for(int i = 0; i < numOfTiles; i++){
			
			LifeTiles newLifeTile = new LifeTiles();
			newLifeTile.setTileID(i);
			newLifeTile.setTileValue();
			
			
			myLifeTiles.add(newLifeTile);
			
			
			
		}
		
	}
	
	public void setTileID(int i){
		
		this.tileID = i + 1;
		
	}
	
	public int getTileID(){
		
		return this.tileID;
		
	}
	
	public void setValue(int value){
		
		this.value = value;
		
	}
	
	public int getValue(){
		
		return this.value;
		
	}
	
	/*public static void main(String[] args){
		
		LifeTiles test = new LifeTiles();
		
		test.createTiles(10);
		test.createTiles(10);
		
		
		
	}*/

}

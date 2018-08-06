package backEnd;

import java.util.ArrayList;
import java.util.Random;

public class HouseCards {
	
	String name;
	int price;
	int taxes;
	int insurancePrice;
	int numberOfHouses = 12;
	
	ArrayList<HouseCards> houseCards = new ArrayList<HouseCards>();
	ArrayList<String> houseNames = new ArrayList<String>();
	ArrayList<Integer> housePrices = new ArrayList<Integer>();
	ArrayList<Integer> houseTaxes = new ArrayList<Integer>();
	ArrayList<Integer> insurance = new ArrayList<Integer>();
	
	ArrayList<HouseCards> threeHouseChoice = new ArrayList<HouseCards>();
	
	public HouseCards(String name, int price, int taxes, int insurance){
		this.name = name;
		this.price = price;
		this.taxes = taxes;
		this.insurancePrice = insurance;
		
	}
	
	public HouseCards(){
		
		generateHouseCards();
		
	}
	
	public void generateHouseCards(){
		
		houseNames.add("Ranch Style");
		houseNames.add("Executive Cape");
		houseNames.add("Log Cabin");
		houseNames.add("Condo");
		houseNames.add("Tudor Style");
		houseNames.add("Modern Victorian");
		houseNames.add("Mansion");
		houseNames.add("Penthouse Suite");
		houseNames.add("Luxury Mountain Retreat");
		houseNames.add("Double Wide RV");
		houseNames.add("Mobile Home");
		houseNames.add("Small Cape");
		
		housePrices.add(140000);
		housePrices.add(400000);
		housePrices.add(120000);
		housePrices.add(100000);
		housePrices.add(180000);
		housePrices.add(500000);
		housePrices.add(800000);
		housePrices.add(700000);
		housePrices.add(600000);
		housePrices.add(300000);
		housePrices.add(80000);
		housePrices.add(160000);
		
		houseTaxes.add(15000);
		houseTaxes.add(40000);
		houseTaxes.add(10000);
		houseTaxes.add(10000);
		houseTaxes.add(20000);
		houseTaxes.add(50000);
		houseTaxes.add(80000);
		houseTaxes.add(70000);
		houseTaxes.add(60000);
		houseTaxes.add(30000);
		houseTaxes.add(10000);
		houseTaxes.add(15000);
		
		insurance.add(20000);
		insurance.add(40000);
		insurance.add(10000);
		insurance.add(10000);
		insurance.add(20000);
		insurance.add(50000);
		insurance.add(80000);
		insurance.add(70000);
		insurance.add(60000);
		insurance.add(30000);
		insurance.add(10000);
		insurance.add(20000);
		
		for(int i = 0; i < 12; i++){

			HouseCards newHouseCard = new HouseCards(houseNames.get(i), housePrices.get(i), houseTaxes.get(i), insurance.get(i));
			houseCards.add(newHouseCard);
		
		}
		
	}
	
	public int getInsurancePrice(int index){
		
		return houseCards.get(index).insurancePrice;
		
	}
	
	public void returnHouseCards(int toDraw){
		
		if(threeHouseChoice.size() > 0){
			
			threeHouseChoice.clear();
			returnHouseCards(toDraw);
			
		}else{
		
			int threeCards = toDraw;
			for(int i = 0; i < toDraw; i++){
			
				Random r = new Random();
				int value = r.nextInt(11 - 0 + 1) + 0;
			
			
				HouseCards choice = new HouseCards(houseCards.get(value).name, houseCards.get(value).price, houseCards.get(value).taxes, houseCards.get(value).insurancePrice);
				threeHouseChoice.add(choice);
			
			
			}
			
		}
		
	}
	
	/*public static void main(String[] args){
	
		HouseCards cards = new HouseCards();
		
		cards.returnHouseCards(10);
		
	}*/
	
			
			
		
	
	

	
}

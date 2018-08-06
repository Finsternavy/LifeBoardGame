package backEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum JobCards implements Card {
	
	//Superstar, Travel Agent, Teacher, Athlete, Salesperson, Doctor, Accountant, Artist, Police Officer
	SUPERSTAR("Superstar", false),
	TRAVEL_AGENT("Travel Agent", false),
	TEACHER("Teacher", true),
	ATHLETE("Athlete", false),
	SALESPERSON("Salesperson", false),
	DOCTOR("Doctor", true),
	ACCOUNTANT("Accountant", true),
	ARTIST("Artist", false),
	POLICE_OFFICE("Police Officer", false);
	
	private final String name;
	private final boolean degreeRequired;
	
	// todo fix draw logic to inspect player attribute to determine how many cards to draw
	public static List<JobCards> returnJobCards(Player player){
		// Draw cards from the cards left on the board in the GameManager
		return GameManager.drawJobCards(player.getCardsToDraw()).stream()
			.filter(jobCard -> player.hasDegree() || !jobCard.getDegreeRequired())
			.collect(Collectors.toList());
	}
	
	@Override
	public String getCardDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("JobTitle: ").append(this.name);
		return sb.toString();
	}
}

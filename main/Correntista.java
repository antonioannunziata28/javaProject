

package it.betacom.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Correntista {
	
	String name;
	private LocalDate since;
	private int bonus;
	
	
	
public Correntista(String name, String since) {
	
	
	
	this.name = name;
	
	String correctDate = since.replace(" ", "/");
	this.since = LocalDate.parse(correctDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	this.bonus = welcomeBonus();
	
	
}

private int welcomeBonus() {
	
	int bonus = 0;
	LocalDate today = LocalDate.now();
	int age = today.getYear() - since.getYear();
	
	if (age >= 18 && age <= 30) {
		bonus = 100;	
	}else if(age > 30 && age <= 50) {
		bonus = 150;
	}else {
		bonus = 200;
	}
	
	return bonus;
	}
	
	public int getBonus() {
		return bonus;
	}


}








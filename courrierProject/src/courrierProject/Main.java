package CourrierProject;

import java.util.ArrayList;
import java.util.List;

import Letter.Letter;


public class Main {
	public static void main (String [] args){
		
		City city = new City("Lille-Rouen-Orléans");
		System.out.println("Creating "+city);
		
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		int numberOfInhabitants = 100;
		for (int i=0 ; i<numberOfInhabitants ;i++){
			inhabitants.add(new Inhabitant("inhabitant-"+i,city));
		}
		System.out.println("Creating "+numberOfInhabitants);
		
		int numberOfDays = 6 ;
		System.out.println("Mailing letters for "+numberOfDays+" days");
		
		int currentDays= 1;
		
		while (currentDays<=numberOfDays || !city.postboxEmty()){
			System.out.println("*************************************");
			System.out.println("Day "+currentDays);
			city.distributeLetters();
			if (currentDays<=numberOfDays){
				
				/*
				 * create a list of inhabitants randomly choose to send a letter
				 */
		
				int randomNumberOfInhabitants = (int) (Math.random()*9)+1;
				for (int j=0 ; j<randomNumberOfInhabitants ;j++){
					int randomIndexInhabitant = (int) (Math.random()*(inhabitants.size()-1));
					Inhabitant sender = inhabitants.remove(randomIndexInhabitant);
					randomIndexInhabitant = (int) (Math.random()*(inhabitants.size()-1));
					Inhabitant receiver = inhabitants.remove(randomIndexInhabitant);
					Letter<?> create = sender.createRandomLetter(receiver);
					create.send();
					inhabitants.add(sender);
					inhabitants.add(receiver);
				} 	
			}
			currentDays++;
		}
		
		
		
	}
}

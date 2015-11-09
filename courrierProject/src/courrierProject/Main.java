package courrierProject;

import java.util.ArrayList;
import java.util.List;

import Letter.Letter;

public class Main {
	public static void main (String [] args){
		
		City city = new City("Lille-Rouen-Orléans");
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		int numberOfInhabitants = 100;
		
		for (int i=0 ; i<numberOfInhabitants ;i++){
			inhabitants.add(new Inhabitant("inhabitant-"+i,city));
		}
		
		int numberOfDays = 6 ;
		
		for (int i=0 ; i<=numberOfDays ; i++){
			if (i!=numberOfDays){
				/*
				 * create a list of inhabitants randomly choose
				 */
				int randomNumberOfInhabitants = (int) (Math.random()*numberOfInhabitants);
				List<Inhabitant> inhabitantsChoose = new ArrayList<Inhabitant>();
				for (int j=0 ; j<randomNumberOfInhabitants ;j++){
					int randomIndexInhabitant = (int) (Math.random()*(inhabitants.size()-1));
					inhabitantsChoose.add(inhabitants.remove(randomIndexInhabitant));
				}
				/*
				 * On remet les habitants choisit dans la liste d'habitants
				 */
				inhabitants.addAll(inhabitantsChoose);
				for (int j=0 ; j<inhabitantsChoose.size();j++){
					/*
					 * on va choisir un type de lettre au hasard qu'on va ensuite expédier
					 * à un autre habitant au hasard
					 */
					Inhabitant sender = inhabitantsChoose.get(j);
					Inhabitant receiver ;
					do {
						int randomIndexInhabitant = (int) (Math.random()*(inhabitants.size()-1));
						receiver = inhabitants.get(randomIndexInhabitant);
					}while (sender.equals(receiver));
					Letter<?> create = sender.createRandomLetter(receiver);
					sender.sendLetter(create);
				}
				
			}
		}
		 
	}
}

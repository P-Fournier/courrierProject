package courrierProject;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main (String [] args){
		City city = new City("Lille-Rouen-Orléans");
		List<Inhabitant> inhabitants = new ArrayList<Inhabitant>();
		for (int i=0 ; i<100 ;i++){
			inhabitants.add(new Inhabitant("inhabitant-"+i,city));
		}
	}
}

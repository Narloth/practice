//Author: Narloth
//Dateiname: ExampleFor.java
//Umschreibung der vorgegebenen for Schleife in eine for-each Schleife

public class ExampleFor {

	public static void main(String[] args) {
		//Es wird ein Array of Strings mit dem Namen 'days' erstellt und initialisiert (mit Werten befüllt)
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		//Die Variable i dient als Zähler. Die Schleife fängt bei 0 an zu zählen. 
		//Die Abbruchbedingung ist die Größe des Arrays (7), da die Schleife von 0 startet, wird sie mit Wert 6 verlassen (Sunday)
		//Die Zählvariable wird nach jedem Durchlauf um eins erhöht
		
		for(int i = 0; i < days.length; i++) {
			System.out.println(days[i]); //der für die Zählvariable entsprechende Wert wird auf der Konsole ausgegeben
		}
		
		System.out.println("\nFor each version: \n");
		
		//Dem Element item von Typ String wird bei jedem Durchlauf ein Wert aus dem Array days zugewiesen
		for (String item : days) {
			System.out.println(item); //Ausgabe des zugewiesenen Wertes bei jedem Schleifendurchlauf
		}

	}

}

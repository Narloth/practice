//Author: Eva D. Gergely
//Dateiname: ExampleIfElse.java
//Umschreibung der vorgegebenen if-else Abfrage in eine switch-case Abfrage

public class ExampleIfElse {

	public static void main(String[] args) {
		System.out.println("Urspruengliche Aufgabe - if else:\n");
		
		//Prüfung der Bedingung, wenn Bedingung true, wird der if Zweig ausgeführt
		if (args.length == 0) {
			System.out.println("No parameters found!");
		} else {
			//wenn Bedingung false, wird der else Zweig ausgeführt
			System.out.println("Found " + args.length + " parameters.");
		}

		System.out.println("Umgeaendert in eine switch-case Variante:\n");
		
		//Switch-case Abfrage
		
		//Der Wert von 'args.length' wird geprüft 
		switch(args.length) {
		case 0: //falls 'args.length' den Wert '0' hat, wird dieser Ausdruck ausgeführt
			System.out.println("No parameters found!");
			break;
		case 1: //falls 'args.length' den Wert '1' hat, wird dieser Ausdruck ausgeführt
			System.out.println("One parameter found.");
			break;
			
		default: //bei allen anderen Werten wird dieser Ausdruck ausgeführt
			System.out.println("Found " + args.length + " parameters.");
			break; //break nach dem default Zweig ist nicht erforderlich und könnte weggelassen werden
		}
	}

}

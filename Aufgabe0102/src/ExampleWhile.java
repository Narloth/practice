//Author: Eva D. Gergely
//Dateiname: ExampleWhile.java
//Umschreibung der vorgegebenen while Schleife in eine do while Schleife

public class ExampleWhile {

	public static void main(String[] args) {
		
		//Deklaration der Variable i
		int i = 0;
		
		//Bedingung wird erst am Ende geprüft, somit wird die Schleife mindestens einmal durchlaufen
		do {
			System.out.println(String.format("Loop %d", i));
			i++; //Die Variable i fungiert als Zählvariable und zählt die Schleifendurchläufe von 0 bis 9 (zehnmal)
		}while(i < 10); //Abbruchbedingung: wenn i denn Wert zehn erreicht, soll die Schleife abgebrochen werden
	}

}

//Author: Eva D. Gergely
//Dateiname: Test_Produkt04 (Aufgabe0205)
//sämtliche Möglichkeiten zum Aufrufen der verschiedenen Konstruktoren zeigen


public class Test_Produkt04 {

	public static void main(String[] args) {

		//Erstelle Instanz von Produkt04 mit Standardkonstruktor
		Produkt04 buch = new Produkt04();
		//Zeige default Werte von Produkt04
		System.out.println("Aktuelle Werte des Produktes Buch: " + buch.toString());

		//Erstelle Instanz von Produkt04 mit Individual Konstruktor
		Produkt04 buch02 = new Produkt04(1111, "Lord of the Rings", true, 20.99);
		//Zeige Werte von Produkt04
		System.out.println("Aktuelle Werte des Produktes Buch02: " + buch02.toString());
		//Aufrufe der Setter Methoden
		buch02.setIs_available(false);
		System.out.println("Aktuelle Werte des Produktes Buch02 / 2: " + buch02.toString());
		
		//Zeige geänderte Werte --> get
		boolean availability = buch02.getIs_available();
		System.out.println("Verfügbarkeit des Produktes Buch02 geändert. Aktueller Wert: " + availability);
		
		
	}

}

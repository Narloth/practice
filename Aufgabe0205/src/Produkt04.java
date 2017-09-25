//Author: Eva D. Gergely
//Dateiname: Produkt04 (Aufgabe0205)


public class Produkt04 {

	private int pnumber;
	private String name;
	private boolean is_available;
	private double price; 
	
	/*Konstruktor: "spezielle Methode"; wird bei der Erzeugung eines Objekts einer Klasse aufgerufen
	 *hat denselben Namen, wie die Klasse
	 *Konstruktoren haben keinen Rückgabedatentypen
	 *initialisiert eine Instanz und reserviert Speicherplatz (Initialisierungsroutine)
	 *wird in Verbindung mit dem Keyword "new" aufgerufen*/
	
	
	//Modifier optimal; ohne Modifier bekommt der Konstruktor default Sichtbarkeit ("package private")
	/*Standardkonstruktor
	 *Falls dieser nicht angelegt wird, wird vom Compiler automatisch ein (parameterloser) Standardkonstruktor (default constructor) erzeugt*/
	Produkt04() {
		
	}
	
	/*individual Konstruktor
	 *falls es mehrere gibt, so müssen sie sich durch die Parameterliste unterscheiden*/
	Produkt04(int pnumber, String name, boolean is_available, double price) {
		/*'this' bezieht sich auf die (aktuelle) Instanz
		 *mithilfe von 'this' kann man auf jedes Mitglied der Instanz zugreifen (Variablen und Methoden)*/
		this.pnumber = pnumber;
		this.name = name;
		this.is_available = is_available;
		this.price = price;
		}
	
	//get und set werden verwendet, damit man Variablenwerte entsprechend abrufen / speichern kann
	//set: wird benutzt um den Wert der Variablen zu speichern
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	
	//Die Methode 'get' wird für die Abfrage des Wertes einer Variable verwendet*/
	public int getPnumber() {
		return pnumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}
	
	public boolean getIs_available() {
		return is_available;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	
	/*'@Override': ein Vermerk, der dem Compiler signalisiert, dass eine existierende Methode überschrieben wird.
	 *Falls es einen Fehler gibt (z.B. Name der Methode falsch geschrieben), so wird der Compiler eine Fehlermeldung geben.
	 *Ohne dem Vermerk '@Override' gäbe es keine Warnung und die Methode würde als eine neue Methode behandelt werden.
	 *--> so wäre Troubleshooting schwieriger.*/
	
	@Override
	public String toString() {
		//Erzeugung einer Instanz der Klasse StringBuilder zur Laufzeit
		StringBuilder builder = new StringBuilder();
		//append: hängt den angegebenen String an
		builder.append("Produktnummer: ").append(this.pnumber); //this: Referenz zur aktuellen Instanz
		builder.append(" Produktname: ").append(this.name);
		builder.append(" Produkt verfügbar: ").append(this.is_available);
		builder.append(" Produktpreis: ").append(this.price);
		return builder.toString();
	}
	
}
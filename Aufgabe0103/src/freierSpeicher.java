//Author: Eva D. Gergely
//Dateiname: Aufgabe0103.java
//Berechnung des freien Speichers vor und nach dem Aufruf des Garbage Collectors

//Einbindung der für die Anwendung erforderlichen Klassen
import java.lang.Object;
import java.lang.Runtime; 


public class freierSpeicher {

	public static void main(String[] args) {
		
		//Die Variable 'rt' vom Typ 'Runtime' implementiert die Methode 'getRuntime()'
		//Diese Methode gibt das Laufzeitobjekt (runtime object) der aktuellen Anwendung zurück
		Runtime rt = Runtime.getRuntime();
		
		/*Die Java Virtual Machine ist ein Teil der Java-Laufzeitumgebung (JRE)
		 * JRE ist verantwortlich für die Ausführung des Java-Bytecodes
		 * Jedes gestartete Java-Programm wird in seiner eigenen VM ausgeführt*/
		
		//Die Menge des freien Speichers in der Java Virtual Machine wird mithilfe der Methode 'freeMemory()' berechnet
		System.out.println("Free memory before calling System.gc(): " + rt.freeMemory());
		//Ausgabe
		System.out.println("\nCalling the garbage collector. \n");
		//Garbage Collector wird mithilfe der Methode 'System.gc()' aufgerufen
		System.gc();
		//Menge des freien Speichers in der JVM wird erneut berechnet
		System.out.println("Free memory after calling System.gc(): " + rt.freeMemory());
	}

}

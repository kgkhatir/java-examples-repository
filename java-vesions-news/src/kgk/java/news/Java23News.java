
package kgk.java.news;

import java.util.concurrent.StructuredTaskScope;

//### 1. Modulimportdeklarationen (JEP 476, Preview): 
// Vereinfacht die Wiederverwendung modularer Bibliotheken durch das Importieren ganzer Module.
//import module java.logging;


/**
 * Java 23 (17. September 2024)
 * 
 * 1. Modulimportdeklarationen
 * 2. Markdown-Dokumentationskommentare
 * 3. Implizit deklarierte Klassen und Instanz-Main-Methoden
 * 4. Primitive Typen in Patterns, instanceof und switch
 * 5. Class-File-API
 * 6. Vector-API
 * 7. Stream Gatherers
 * 8. Strukturierte Nebenläufigkeit
 * 9. Scoped Values
 * 10. Flexible Konstruktorblöcke
 * 11. Veraltete Methoden in sun.misc.Unsafe zur Entfernung markiert (JEP 471): 
 * Kennzeichnet bestimmte Methoden für den zukünftigen Entfall.
 * 12. ZGC: Generational Mode by Default (JEP 474): 
 * Schaltet den Standardmodus des Z Garbage Collectors auf den Generationenmodus um.
 * 
 */
public class Java23News {

	//### 2. Markdown-Dokumentationskommentare (JEP 467): 
	// Ermöglicht die Verwendung von Markdown in Javadoc-Kommentaren.
	/**
	 * **Beschreibung:**
	 *
	 * Diese Methode berechnet die Summe zweier Zahlen.
	 *
	 * @param a Die erste Zahl.
	 * @param b Die zweite Zahl.
	 * @return Die Summe von a und b.
	 */
	public int add(int a, int b) {
	    return a + b;
	}
	
	
	public static void main(String[] args) {
		Java23News java23News= new Java23News(); 
		java23News.main();
	}
	
	//### 3. Implizit deklarierte Klassen und Instanz-Main-Methoden (JEP 477, Preview): 
	// Erleichtert den Einstieg in die Java-Programmierung für Anfänger.
	void main() {
	    System.out.println("Hallo, Welt!");
	    
	    //### 4. Primitive Typen in Patterns, instanceof und switch (JEP 455, Preview): 
	    // Ermöglicht das Pattern Matching mit primitiven Typen.
	    Object obj = 42;
	    if (obj instanceof Integer i) {
	    	System.out.println("Es ist eine Ganzzahl: " + i);
	    }
	    
	    //### 5. Class-File-API (JEP 466): 
	    // Bietet eine standardisierte API zum Parsen, Generieren und Transformieren von Java-Klassendateien.
//	    ClassFile cf = ClassFile.read("MyClass.class");
//	    cf.methods().forEach(method -> System.out.println(method.getName()));
	    
	    //### 6. Vector-API (JEP 469): 
	    // Führt eine API für Vektorberechnungen ein, die eine bessere Performance ermöglicht.
//		Vector<Integer> vector = Vector.of(1, 2, 3, 4);
//		Vector<Integer> result = vector.add(5);
	    
	    //### 7. Stream Gatherers (JEP 473, Zweite Preview): 
	    // Erweitert die Stream-API um benutzerdefinierte Zwischenoperationen.
//		List<String> result = Stream.of("a", "b", "c")
//		    .gather(Collectors.toList());
		
		//### 8. Strukturierte Nebenläufigkeit (JEP 480, Dritte Preview): 
	    // Vereinfacht die parallele Programmierung durch das Gruppieren verwandter Aufgaben.
		try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
//		    Future<String> user = scope.fork(() -> findUser());
//		    Future<Integer> order = scope.fork(() -> fetchOrder());
//
//		    scope.join();
//		    scope.throwIfFailed();
//
//		    System.out.println(user.resultNow() + " - " + order.resultNow());
		}
	    
		
		//### 9. Scoped Values (JEP 481, Dritte Preview): 
		// Ermöglicht das Teilen von unveränderlichen Daten innerhalb und zwischen Threads.
		ScopedValue<String> USER_ID = ScopedValue.newInstance();

		try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
//		    scope.fork(() -> {
//		        ScopedValue.where(USER_ID, "12345").run(() -> {
//		            System.out.println("User ID: " + USER_ID.get());
//		        });
//		    });
//
//		    scope.join();
		}
	}
	
}

//### 10. Flexible Konstruktorblöcke (JEP 482, Preview): 
// Erlaubt Anweisungen vor einem expliziten Konstruktoraufruf, um die Initialisierung zu verbessern.
class MyClass {
	private int value;
	
	public MyClass(int value) {
		System.out.println("Initialisierung");
		this.value = value;
	}
}
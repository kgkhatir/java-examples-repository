package kgk.java.news;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executors;

/**
 * Java Versionen 7 bis 22: Alle Neuigkeiten mit Beispielen
 */
public class JavaNewsUntilVesion22 {

	public static void main(String[] args) {
		
		//### Java 7 (2011)
		//### 1. Diamond Operator (<>)
		// Verkürzt die Schreibweise bei Generics.
		List<String> list = new ArrayList<>(); // Statt new ArrayList<String>()
		//### 2. Try-with-Resources
		// Ermöglicht automatische Schließung von Ressourcen.
		try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
//			System.out.println(br.readLine());
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
		} // Automatisch geschlossen
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//### 3. String in switch
		String day = "Monday";
		switch (day) {
		    case "Monday":
		        System.out.println("Start of the week!");
		        break;
		}
		//### 4. catch-Mehrfachausnahme
//		try {
//		    // Code
//		} catch (IOException | SQLException e) {
//		    e.printStackTrace();
//		}
		
		//### Java 8 (2014)
		//### 1. Lambda-Ausdrücke
		List<String> list2 = Arrays.asList("A", "B", "C");
		list2.forEach(s -> System.out.println(s));
		//### 2. Streams API
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
		//### 3. Optional
		Optional<String> name = Optional.ofNullable(null);
		System.out.println(name.orElse("Default Name"));
		//### 4. LocalDate, LocalTime, LocalDateTime
		LocalDate date = LocalDate.now();
		System.out.println("date: " + date);
		LocalTime time = LocalTime.now();
		System.out.println("time: " + time);
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("dateTime: " + dateTime);
		
		//### Java 9 (2017)
		//### 1. Modulsystem
//		module mymodule {
//		    requires java.base;
//		}
		//### 2. List.of(), Set.of(), Map.of()
		List<String> list3 = List.of("A", "B", "C");
		//### 3. var in for-Schleifen
		for (var entry : Map.of("A", 1, "B", 2).entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		//### Java 10 (2018)
		//### 1. var für lokale Variablen
		var name2 = "Java";
		
		//### Java 11 (2018 - LTS)
		//### 1. var in Lambda-Ausdrücken
		list.forEach((var s) -> System.out.println(s));
		//### 2. HTTP Client API
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		    .uri(URI.create("https://example.com"))
		    .build();
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		//### Java 12 (2019)
		//### 1. switch-Expressions
		String type = switch (day) {
		    case "MONDAY", "TUESDAY" -> "Weekday";
		    default -> "Other";
		};
		System.out.println(type);
				
		//### Java 13 (2019)
		//### 1. Text Blocks
		String text = """
		    Das ist ein mehrzeiliger
		    String.
		    """;
		System.out.println(text);
		
		//### Java 14 (2020)
		//### 1. record
		record Person(String name, int age) {}
		Person p = new Person("Alice", 25);
		System.out.println(p.name());

		//### Java 15 (2020)
		//### 1. Versiegelte Klassen
//		sealed class Animal permits Dog {}
//		final class Dog extends Animal {}

		//### Java 16 (2021)
		//### 1. record stabil
		
		//### Java 17 (2021 - LTS)
		//### 1. Pattern Matching für switch
		Object obj="Object";
		switch (obj) {
		    case String s -> System.out.println("String: " + s);
		    default -> System.out.println("Other type");
		}
		
		//### Java 18 (2022)
		//### 1. UTF-8 Standardkodierung
		
		//### Java 19 (2022)
		//### 1. Virtual Threads (Preview)
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
		    executor.submit(() -> System.out.println("Hello from Virtual Thread"));
		}
		
		//### Java 20 (2023)
		//### 1. Verbesserte Pattern Matching
		
		//### Java 21 (2023 - LTS)
		//### 1. Virtual Threads stabil
		Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread"));
		//### 2. String Templates (Preview)
		//*** in Java 23 (bzw. in den neueren Builds ab Java 22+) hat sich die API für String Templates geändert
//		String name3 = "Java";
//		String greeting = STR."Hello, \{name3}!";
		
		//### Java 22 (2024)
		//### 1. Verbesserte Stream API	
	}
}

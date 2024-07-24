package org.concerto.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Test Concerto
		LocalDate dataConcerto = LocalDate.of(2029, 12, 12);
		LocalTime oraConcerto = LocalTime.of(10, 20);
		
		Concerto c = new Concerto("Concert", dataConcerto, 30, oraConcerto, 22.50f);
		System.out.println(c.toString());
		
		//Test Evento
		Scanner scanner = new Scanner(System.in);

		System.out.println("Inserire titolo dell'evento");
		String titolo = scanner.nextLine();

		System.out.println("Inserire data dell'evento");
		String dataString = scanner.nextLine();

		String dataFormat = "dd/MM/yyyy";
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dataFormat);
		LocalDate data = LocalDate.parse(dataString, dateFormatter);

		System.out.println("Inserire posti totali dell'evento");
		String postiString = scanner.nextLine();
		int posti = Integer.parseInt(postiString);

		Evento e = new Evento(titolo, data, posti);
		System.out.println("Evento creato: " + e.toString() + " " + e.getPostiTotali());
		
		System.out.println("Vuole effettuare prenotazioni?");
		String sePrenotazioni = scanner.nextLine();

		int numeroPrenotazioni = 0;
		if (sePrenotazioni.equals("Yes")) {
			System.out.println("Quante prontazioni vuole effettuare?");
			String numeroPrenotazioniString = scanner.nextLine();
			numeroPrenotazioni = Integer.parseInt(numeroPrenotazioniString);
		} else if (sePrenotazioni.equals("No")) {
			System.out.println("Non effettueremo nessuna prenotazione.");
		} else {
			System.out.println("valore non valido, inserire 'Yes' o 'No'");
		}

		if (numeroPrenotazioni > 0) {
			for (int i = 0; i < numeroPrenotazioni; i++) {
				e.prenota();
			}
		}

		System.out.println("I posti prenotati sono: " + e.getPostiPrenotati());
		System.out.println("I posti disponibili sono: " + (e.getPostiTotali() - e.getPostiPrenotati()));

		System.out.println("Vuole effettuare disdette?");
		String seDisdette = scanner.nextLine();

		int numeroDisdette = 0;

		if (seDisdette.equals("Yes")) {
			System.out.println("Quante disdette vuole effettuare?");
			String numeroDisdetteString = scanner.nextLine();
			numeroDisdette = Integer.parseInt(numeroDisdetteString);
		} else if (seDisdette.equals("No")) {
			System.out.println("Non effettueremo nessuna disdetta");
		} else {
			System.out.println("valore non valido, inserire 'Yes' o 'No'");

		}
		if (numeroDisdette > 0) {
			for (int i = 0; i < numeroDisdette; i++) {
				e.disdici();
			}
			

		}

		System.out.println("I posti prenotati sono: " + e.getPostiPrenotati());
		System.out.println("I posti disponibili sono: " + (e.getPostiTotali() - e.getPostiPrenotati()));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

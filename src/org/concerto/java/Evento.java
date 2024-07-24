package org.concerto.java;

import java.time.LocalDate;

public class Evento {

	protected String titolo;
	protected LocalDate data;
	protected int postiTotali;
	protected int postiPrenotati;

//Costruttore

	public Evento(String titolo, LocalDate data, int postiTotali) {
		if (data.isBefore(LocalDate.now())) {
			System.out.println("La data inserita non è valida");
		}

		if (postiTotali < 0) {
			System.out.println("Numero di posti totali negativo");
		}

		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

    //Getter e Setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotali() {

		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
    //Metodo che prenota
	public void prenota() {
		if (data.isBefore(LocalDate.now())) {
			System.out.println("La data dell'evento è già passata");
		}
		if (postiPrenotati == postiTotali) {
			System.out.println("I posti disponibili sono esauriti, impossibile effettuare la prenotazione.");
		} else {
			this.postiPrenotati += 1;
		}
	}
	//Metodo che disdice
	public void disdici() {
		if (data.isBefore(LocalDate.now())) {
			System.out.println("La data dell'evento è già passata");
		}
		if (postiPrenotati == 0) {
			System.out.println("Non sono presenti prenotazioni, impossibile effettuare disdetta");
		} else {

			this.postiPrenotati -= 1;
		}
	}

	//Override
	@Override
	public String toString() {
		return data.toString() + " - " + titolo;
	}

}

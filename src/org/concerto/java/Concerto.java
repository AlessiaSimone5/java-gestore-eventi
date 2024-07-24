package org.concerto.java;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	protected LocalTime ora;
	protected float prezzo;

	// Costruttore
	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, float prezzo) {
		super(titolo, data, postiTotali);
		this.ora = ora;
		this.prezzo = prezzo;

	}

	// Getter e Setter
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	// Metodo per restituire data e ora formattata
	public static LocalDateTime getDataOra(LocalDate data, LocalTime ora) {
		LocalDateTime dataOraFormat = LocalDateTime.of(data, ora);
		return dataOraFormat;
	}

	// Metodo per restituire prezzo formattato
	public static String priceFormat(float prezzo) {
		DecimalFormat df = new DecimalFormat("##,##€");
		return df.format(prezzo);
	}

	// Override
	@Override
	public String toString() {
		return getDataOra(this.data, this.ora) + " - " + this.titolo + " - " + this.prezzo;
	}
}

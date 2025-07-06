package frage13;

import java.io.Serializable;

public class Kante implements Serializable{
	private int von;
	private int nach;
	
	public Kante(int von, int nach) {
		this.von = von;
		this.nach = nach;
	}

	public int getVon() {
		return von;
	}

	public int getNach() {
		return nach;
	}
}

package datenstrukturen;

public class Buch {
	
	private String name;
	private int seitenanzahl;
	private boolean status;
	
	public Buch(String name, int seitenanzahl, boolean status) {
		this.name = name;
		this.seitenanzahl = seitenanzahl;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getSeitenanzahl() {
		return seitenanzahl;
	}

	public boolean getStatus() {
		return status;
	}

}

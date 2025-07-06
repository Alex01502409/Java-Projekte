package graph;

public class GraphTester {

	public static void main(String[] args) {
		UnserGraph ug = new UnserGraph(13);
		// kleinster Knoten: 1
		// groesste Knoten: 13
		ug.addKante(1, 2);
		ug.addKante(1, 3);
		ug.addKante(1, 5);
		ug.addKante(2, 5);
		ug.addKante(3, 4);
		ug.addKante(3, 6);
		ug.addKante(4, 5);
		ug.addKante(4, 7);
		ug.addKante(5, 11);
		ug.addKante(6, 10);
		ug.addKante(7, 8);
		ug.addKante(7, 10);
		ug.addKante(8, 9);
		ug.addKante(9, 10);
		ug.addKante(11, 12);
		ug.addKante(12, 13);
		
		Tiefensuche ts = new Tiefensuche(ug, 1);
		ts.gibWegAus(1, 9);
		
		Breitensuche bs = new Breitensuche(ug, 1);
		bs.gibWegAus(1, 9);
	}
}

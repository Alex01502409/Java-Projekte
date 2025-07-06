package frage13;

public class GraphTester {
	public static void main(String[] args) {
		MainGraph graph = new MainGraph();
		graph.addKante(1, 2);
		graph.addKante(2, 3);
		graph.addKante(3, 4);
		graph.addKante(4, 5);
		
		System.out.println("Anzahl Kanten: " + graph.getAnzahlKante());
		graph.speicherNachbarschaften();
		graph.ladeNachbarschaften();
		graph.gibListeAus();
		
	}
}

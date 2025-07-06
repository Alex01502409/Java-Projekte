	package dijsktra;
	
	public class Tester {
	
		public static void main(String[] args) {
			Node haus1 = new Node("Haus 1", 50.98733183750385, 12.973071974996506, true);
			Node haus2 = new Node("Haus 2", 50.987406128348134, 12.972465795782034, false);
			Node haus5 = new Node("Haus 5", 50.98822669658213, 12.9728734915369, false);
			Node haus8 = new Node("Haus 8", 50.98929375129117, 12.970625800440361, false);
			
			haus1.addNachbar(haus2);
			haus2.addNachbar(haus5);
			haus2.addNachbar(haus8);
			haus5.addNachbar(haus8);
			
			Dijkstra weg = new Dijkstra(haus1, haus8);
			
			for(Node haus : weg.getReihenfolge())
				System.out.println(haus.getName());
			
			System.out.println(haus8.berechneEntfernung());
		}
	}

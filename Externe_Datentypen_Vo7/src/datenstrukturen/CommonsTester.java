package datenstrukturen;

import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class CommonsTester {
	
	public static void main(String[] args) {
		Line f = new Line(new Vector2D(0, 0), new Vector2D(1, 1), 0);
		Line g = new Line(new Vector2D(-2, 0), new Vector2D(0, 1), 0);
		
		Vector2D schnittpunkt = f.intersection(g);
		System.out.println(schnittpunkt); // Console: {2; 2}
	}

}
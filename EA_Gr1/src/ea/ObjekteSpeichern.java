package ea;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ObjekteSpeichern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p = new Person("Klaus", 50);
		p.bestimmeEinkomme();
		
		serialisieren(p);
		
		Person personNeu = deserialisieren();
		System.out.println(personNeu);

	}
	
	private static Person deserialisieren() {
		Person erg = null;
		ObjectInputStream ois = null;
		try {
			
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("data/ObjIFGr1.date")))); // ObjIFGr1.date Automatisch erstelt
			
			erg = (Person)ois.readObject();
			
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if (ois != null) {
				try {
					ois.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return erg;
	}
	
	private static void serialisieren(Person p) {
		ObjectOutputStream oos = null;
		
		try {
			
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("data/ObjIFGr1.date"))));
			oos.writeObject(p);
			oos.flush();					
			
		}catch(IOException ioex){
			ioex.printStackTrace();
		}finally {
			
			if(oos != null ) {
				try {
					oos.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
			
		}
		
	}

}

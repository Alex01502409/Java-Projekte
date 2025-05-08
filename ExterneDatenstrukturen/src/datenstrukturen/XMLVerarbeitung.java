package datenstrukturen;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLVerarbeitung {
	
	public static void main(String[] args) {
		schreibeXML();
		lesenXML();
	}

	private static void lesenXML() {
		try {
			DocumentBuilderFactory fabrik = DocumentBuilderFactory.newInstance();
			DocumentBuilder arbeiter = fabrik.newDocumentBuilder();
			
			File datei = new File("data/DozentenIFGruppe1.xml");
			
			Document doc = arbeiter.parse(datei);
			
			NodeList liste = doc.getElementsByTagName("dozent"); // NodeList != List Java
			
			for (int i = 0; i < liste.getLength(); i++) {
				System.out.println(liste.item(i).getTextContent());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void schreibeXML() {
		File file = new File("data/DozentenIFGruppe1.xml");
		try { // XML wird in Java des Factory Patterns (Fabrikmuster) erstellt
			DocumentBuilderFactory fabrik = DocumentBuilderFactory.newInstance();
			DocumentBuilder arbeiter = fabrik.newDocumentBuilder();
			
			Document doc = arbeiter.newDocument();
			
			Element root = doc.createElement("dozenten");
			
			Element dozent1 = doc.createElement("dozent");
			dozent1.appendChild(doc.createTextNode("Klaus Dohmen"));
			dozent1.setAttribute("buero", "6-127");
			root.appendChild(dozent1);
			
			Element dozent2 = doc.createElement("dozent");
			dozent2.appendChild(doc.createTextNode("knut Altroggen"));
			dozent2.setAttribute("buero", "8-307");
			root.appendChild(dozent2);
			
			doc.appendChild(root);
			
			/*---*/
			
			TransformerFactory transformerFabrik = TransformerFactory.newInstance();
			Transformer arbeiterTransformer = transformerFabrik.newTransformer(); 
			
			arbeiterTransformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Formatierung
			
			DOMSource domSource = new DOMSource(doc);
			StreamResult ziel = new StreamResult(file);
		
			
			arbeiterTransformer.transform(domSource, ziel);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}

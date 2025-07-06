package frage03;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Frage03 {

	public static void main(String[] args) {
		
		for(char c = 'a'; c <= 'z'; c++)
			System.out.print(c + " ");
		
		if (args.length != 2) {
			System.out.println("Bitte geben Sie Quell- und Zielverzeichnis als Argumente an.");
			return;
		}

		File quelle = new File(args[0]);
		File ziel = new File(args[1]);

		if (!quelle.exists() || !quelle.isDirectory()) {
			System.out.println("Quellverzeichnis existiert nicht oder ist kein Verzeichnis.");
			return;
		}

		if (!ziel.exists() || !ziel.isDirectory()) {
			System.out.println("Zielverzeichnis existiert nicht oder ist kein Verzeichnis.");
			return;
		}

		File[] dateien = quelle.listFiles();
		int kopiert = 0;

		for (File datei : dateien) {
			if (datei.isFile()) {
				Path quellePfad = datei.toPath();
				Path zielPfad = ziel.toPath().resolve(datei.getName());
				try {
					Files.copy(quellePfad, zielPfad, StandardCopyOption.REPLACE_EXISTING);
					System.out.println("Kopiert: " + datei.getName());
					kopiert++;
				} catch (IOException e) {
					System.out.println("Fehler beim Kopieren: " + datei.getName());
				}
			}
		}
		System.out.println("Anzahl kopierter Dateien: " + kopiert);
	}
}

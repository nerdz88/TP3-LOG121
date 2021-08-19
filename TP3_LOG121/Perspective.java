/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #3
 Étudiant(e)s: Pierre A Abdelli, Michael Couet , 
 			   Mihai Armasaru et Dave Vouma-Gagnon
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: Perspective.java
 Date créé: 2020-11-17
 Date dern. modif. 2020-12-02

 *******************************************************/
import Factory.PerspectiveChooser;

import java.awt.*;

public class Perspective implements Runnable {

	public static void main(String[] args) { EventQueue.invokeLater(new Perspective()); }

	public void run() {
		try {
			new PerspectiveChooser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

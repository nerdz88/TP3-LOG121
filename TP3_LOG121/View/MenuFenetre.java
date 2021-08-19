/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
Étudiant(e)s: Michael Couet, Mihai Armasaru et Pierre A Abdelli 
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: MenuFichier.java
Date créé: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package View;

import Model.ImageLoader;

import java.awt.event.ActionEvent;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static final String MENU_FICHIER_TITRE = "Fichier";
	private static final String MENU_FICHIER_CHARGER = "Charger";
	private static final String MENU_FICHIER_QUITTER = "Quitter";

	/**
	 * Constructeur
	 */
	public MenuFenetre() {
		ajouterMenuFichier();
	}

	/**
	 * Méthode pour aller chercher un fichier
	 * Cette classe est inspirer du code du TP1_LOG121
	 */
	private void ajouterMenuFichier() {

		JMenu menu = new JMenu(MENU_FICHIER_TITRE);
		JMenuItem charger = new JMenuItem(MENU_FICHIER_CHARGER);
		JMenuItem exit = new JMenuItem(MENU_FICHIER_QUITTER);

		charger.addActionListener((ActionEvent e) -> {

			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Choisir une image");
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filtre = new FileNameExtensionFilter("any", "png", ".jpg", "jpg", ".gif", "gif");
			fileChooser.addChoosableFileFilter(filtre);
			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					ImageLoader.il.loadImage(path);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

		});

		exit.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});

		menu.add(charger);
		menu.add(exit);

		add(menu);

	}

}

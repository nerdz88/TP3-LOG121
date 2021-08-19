/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
Étudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: ImageLoader.java
Date créé: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Model;

import Managers.GestionnaireMemento;
import ObserverPattern.ISubject;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageLoader {

	public static ImageLoader il = new ImageLoader();
	private Image image;
	private Toolkit t = Toolkit.getDefaultToolkit();
	private List<ISubject> perspectives = new ArrayList<>();

	private ImageLoader() {
	};

	/**
	 * Methode qui prend un path, charge l'image, et la distribue aux perspectives
	 * du instancies
	 * 
	 * @param path Le path du fichier image a charger
	 */
	public void loadImage(String path) throws IOException {

		image = t.getImage(path);
		for (ISubject s : perspectives) {
			if (s instanceof PerspectiveZoomAndPan)
				((PerspectiveZoomAndPan) s).setImage(path);
			if (s instanceof PerspectiveVignette)
				((PerspectiveVignette) s).setImage(path);
		}
	}

	// Accesseurs
	public Image getImage() {
		return this.image;
	}

	public void save() {
		for (ISubject s : perspectives) {
			if (s instanceof PerspectiveZoomAndPan)
				GestionnaireMemento.gm.saveToMemento(((PerspectiveZoomAndPan) s).saveToMemento());
			if (s instanceof PerspectiveVignette)
				GestionnaireMemento.gm.saveToMemento(((PerspectiveVignette) s).saveToMemento());
		}
	}

	public void load(GestionnaireMemento gm) {

	}

	/**
	 * Methode qui attache une perspective a l'ImageLoader
	 */
	public void attachPerspective(ISubject s) {
		perspectives.add(s);
	}

}

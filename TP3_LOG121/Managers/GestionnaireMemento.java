/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: GestionnaireMemento.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Managers;

import Model.IMemento;
import Model.ImageLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireMemento implements Serializable {

	public static GestionnaireMemento gm = new GestionnaireMemento();
	private List<IMemento> mementoList = new ArrayList<>();

	private GestionnaireMemento() {
	};

	/**
	 * Methode qui rajoute une Memento a la liste de memento
	 * @param m Memento a rajouter a la liste
	 */
	public void saveToMemento(IMemento m) {
		mementoList.add(m);
	}

	/**
	 * Methode non utiliser qui sauvegarde une instance du gestionnaire de Memento
	 */
	public void save() {

		try {
			ImageLoader.il.save();
			FileOutputStream file = new FileOutputStream("./tp3.txt");
			ObjectOutputStream obs = new ObjectOutputStream(file);
			obs.writeObject(this);
			obs.close();
			file.close();
		} catch (Exception e) {

		}

	}

	/**
	 * Methode non utiliser qui charge une instance du gestionnaire de Memento
	 */
	public void load() {
		try {
			FileInputStream file = new FileInputStream("./tp3.txt");
			ObjectInputStream ois = new ObjectInputStream(file);
			GestionnaireMemento gm = (GestionnaireMemento) ois.readObject();
			ois.close();
			file.close();
			ImageLoader.il.load(gm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Accesseur
	public IMemento getMemento() {
		return mementoList.remove(mementoList.size() - 1);
	}

	// Accesseur
	public List getMementos() {
		return mementoList;
	}

	/**
	 * Verifie si la liste de memento est vide
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return mementoList.isEmpty();
	}

}

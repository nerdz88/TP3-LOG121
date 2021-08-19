/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: GestionnaireDeCommandes.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Managers;

import Controller.ICommande;
import Controller.IRedo;
import Controller.IUndo;

import java.util.ArrayDeque;
import java.util.Deque;

public class GestionnaireDeCommandes {

	public static GestionnaireDeCommandes gdc = new GestionnaireDeCommandes();
	private Deque<ICommande> historiqueCommande = new ArrayDeque<>();
	private Deque<ICommande> redoList = new ArrayDeque<>();

	/**
	 * Constructeur
	 */
	private GestionnaireDeCommandes() {
	}

	/**
	 * Cette methode est tire de l'exemple Command Pattern GRANT2002
	 */
	public void faireCommande(ICommande c) {
		if (c instanceof IRedo) {
			redo();
			return;
		}
		if (c instanceof IUndo) {
			undo();
			return;
		}
		if (c.execute()) {
			historiqueCommande.push(c);
		} else {
			historiqueCommande.clear();
		}

		if (redoList.size() > 0)
			redoList.clear();
	}

	/**
	 * M�thode qui undo un action
	 */
	public void undo() {
		if (historiqueCommande.size() > 0) {
			ICommande undo;
			undo = historiqueCommande.pop();
			undo.undo();
			redoList.push(undo);
		}
	}

	public void redo() {
		if (redoList.size() > 0) {
			ICommande redo;
			redo = redoList.pop();
			redo.execute();
			historiqueCommande.push(redo);
		}
	}

	/**
	 * M�thode qui verifie si historique de commande est vide
	 * 
	 * @return
	 */
	public boolean undoListIsEmpty() {
		return historiqueCommande.isEmpty();
	}

	/**
	 * M�thode qui v�rifie si la liste de redo est vide.
	 * 
	 * @return
	 */
	public boolean redoListIsEmpty() {
		return redoList.isEmpty();
	}

	/**
	 * M�thode qui affiche la grosseur l'historique de commande.
	 */
	public void histoComSize() {
		System.out.println(historiqueCommande.size());
	}

}

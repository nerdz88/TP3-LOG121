/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #3
 �tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: ClickCommand.java
 Date cr��: 2020-11-17
 Date dern. modif. 2020-12-02

 *******************************************************/
package Controller;

import Controller.Mediator.IMediator;
import Model.PerspectiveZoomAndPan;

import java.awt.event.MouseEvent;

public class CommandeClick implements ICommande {

	private IMediator m;
	private PerspectiveZoomAndPan p;
	private MouseEvent e;

	/**
	 * Constructeur
	 * @param p Une Perspective a appliquer la commande
	 * @param e L'evenement de la sourie
	 * @param m Le mediateur qui gere l'affichage des boutons
	 */
	public CommandeClick(PerspectiveZoomAndPan p, MouseEvent e, IMediator m) {
		this.m = m;
		this.p = p;
		this.e = e;
	}

	/**
	 * M�thode pour executer le click
	 */
	@Override
	public boolean execute() {
		m.click(p, e);
		return true;
	}

	/**
	 * Methode qui defait un click
	 */
	@Override
	public boolean undo() {
		m.undoClick(p, e);
		return true;
	}

	/**
	 * Methode qui refait un click
	 */
	@Override
	public boolean redo() {
		return true;
	}
}

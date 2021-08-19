/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: BtnRedo.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Controller.Buttons;

import Controller.Mediator.IMediator;
import Controller.IRedo;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BtnRedo extends JButton implements IRedo {

	/**
	 * Constructeur
	 *
	 * @param al le ActionLister du bouton
	 * @param m l'instance du mediateur que l'on veut enregistrer
	 */
	public BtnRedo(ActionListener al, IMediator m) {
		super("Redo");
		addActionListener(al);
		m.registerBtnRedo(this);
		setEnabled(false);
	}

}

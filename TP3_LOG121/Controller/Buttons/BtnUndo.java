/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: BtnUndo.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Controller.Buttons;

import Controller.ICommande;
import Controller.Mediator.IMediator;
import Controller.IUndo;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BtnUndo extends JButton implements IUndo {

    /**
     * Constructeur
     *
     * @param al le ActionLister du bouton
     * @param m l'instance du mediateur que l'on veut enregistrer
     */
    public BtnUndo(ActionListener al, IMediator m) {
        super("Undo");
        addActionListener(al);
        m.registerBtnUndo(this);
        setEnabled(false);
    }

}

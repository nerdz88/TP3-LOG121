/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: Translate.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Controller;

import Controller.Mediator.IMediator;
import Model.PerspectiveZoomAndPan;

import java.awt.event.MouseEvent;

public class Translate implements ICommande {

    private IMediator m;
    private PerspectiveZoomAndPan p;
    private MouseEvent e;

    /**
     * Constructeur
     * @param p Une Perspective a appliquer la commande
     * @param e L'evenement de la sourie
     * @param m Le mediateur qui gere l'affichage des boutons
     */
    public Translate(PerspectiveZoomAndPan p, MouseEvent e, IMediator m) {
        this.p = p;
        this.e = e;
        this.m = m;
    }
    
    /**
     * M�thode pour executer le translation
     */
    @Override
    public boolean execute() {
        m.translate(p,e);
        return true;
    }

    /**
     * M�thode pour executer le undo de la translation
     */
    @Override
    public boolean undo() {
        m.undoTranslate(p,e);
        return true;
    }

    /**
     * M�thode pour executer le redo de la translation
     */
    public boolean redo() {
        m.redoTranslate(p);
        return true;
    }

}

/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: Zoom.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Controller;

import Controller.Mediator.IMediator;
import Model.PerspectiveZoomAndPan;

import java.awt.event.MouseWheelEvent;

public class Zoom implements ICommande {

    private IMediator m;
    private PerspectiveZoomAndPan p;
    private MouseWheelEvent e;
    
    /**
     * Constructeur
     * @param p Une Perspective a appliquer la commande
     * @param e L'evenement de la sourie
     * @param m Le mediateur qui gere l'affichage des boutons
     */
    public Zoom(PerspectiveZoomAndPan p, MouseWheelEvent e, IMediator m) {
        this.e = e;
        this.p = p;
        this.m = m;
    }
    /**
     * M�thode pour executer le zoom
     */
    @Override
    public boolean execute() {
        m.zoom(p,e);
        return true;
    }
    
    /**
     * M�thode pour executer le undo du zoom
     */
    @Override
    public boolean undo() {
        m.undoZoom(p,e);
        return true;
    }

    /**
     * M�thode pour executer le redo du zoom
     */
    public boolean redo(){
        m.redoZoom(p);
        return true;
    }
}

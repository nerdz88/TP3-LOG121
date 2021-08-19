/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Michael Couet, Mihai Armasaru et Pierre A Abdelli 
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: PerspectiveZoomAndPan.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Model;

import Managers.GestionnaireMemento;
import ObserverPattern.IObserver;
import ObserverPattern.ISubject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerspectiveZoomAndPan implements ISubject, IPerspective {

    protected double zoomScale = 1;
    protected double zoom = 0.04;
    protected int x;
    protected int y;
    protected Point click;
    private BufferedImage i;
    private List<IObserver> observers = new ArrayList<>();
    private Memento m;

    public PerspectiveZoomAndPan() { }

    //Accesseurs
    public int getPositionX() { return this.x; }
    public int getPositionY() { return this.y; }
    public double getZoomScale() { return this.zoomScale; }
    public Image getImage() { return this.i; }

    //Mutateurs
    public void setImage(String path) throws IOException {

        this.i = ImageIO.read(new File(path));
        notifyObservers();
    }

    /**
     * Executeur la commande zoom sur la perspective
     * @param e parametre de l'evenement de la sourie
     */
    public void zoom(MouseWheelEvent e) {
        zoomScale -= e.getPreciseWheelRotation() * zoom;
        notifyObservers();
    }

    /**
     * Executeur de la commande click qui recois un MouseEvent et definie le point de depart
     * "click" pour la commande translate
     * @param e l'evenement du Mouse Listener
     */
    public void click(MouseEvent e) {
        click = e.getPoint();
        m = saveToMemento();
    }

    /**
     * Executeur de la commande translate qui recois un MouseEvent et qui effectuent la
     * translation. Cette methode notifie aussi les observateurs du changement.
     * @param e
     */
    public void translate(MouseEvent e) {

        x += e.getX() - click.x;
        y += e.getY() - click.y;
        click = e.getPoint();
        notifyObservers();

    }

    /**
     * Methode qui defait une commande zoom et qui remet la perspective a une isntance de memento
     * @param e l'evement du Mouse Event
     */
    public void undoTranslate(MouseEvent e) {

        x += e.getX() - click.x;
        y += e.getY() - click.y;
        click = e.getPoint();
        restoreFromMemento(m);
        notifyObservers();

    }

    /**
     * Methode qui refait une commande translate et qui remet la perspective a une instance de memento
     * a partir du gestionnaire de Memento
     */
    public void redoTranslate() {
        Memento m = (Memento) GestionnaireMemento.gm.getMemento();
        restoreFromMemento(m);
    }

    /**
     * Methode qui refait une commande Zoom et qui remet la perspective a une instance de memento
     * a partir du gestionnaire de Memento
     */
    public void redoZoom() {
        Memento m = (Memento) GestionnaireMemento.gm.getMemento();
        restoreFromMemento(m);
    }

    /**
     * Methode undo non definie pour le translate
     */
    public void undo() {
        System.out.println("UNDOOOOO");
    }

    /**
     * Methode undo non definie pour le zoom
     */
    public void undoZoom(MouseWheelEvent e) {
        zoomScale += e.getPreciseWheelRotation() * zoom;
        notifyObservers();
    }

    /**
     * Methode qui sauvegarde l'etat de la perspective dans un memento
     * @return un nouveau memento de la perspective
     */
    public Memento saveToMemento() {
        System.out.println("Saving perspective to Memento.");
        return new Memento(this);
    }

    /**
     * Methode qui remet les parametres de la perspective a partir de son memento
     * @param m Le memento sauvegarder de la perspectives
     */
    public void restoreFromMemento(Memento m) {
        System.out.println("RESTORING FROM MEMENTO !!!!!");
        PerspectiveZoomAndPan p = m.getSavedPerspective();
        this.zoomScale = p.zoomScale;
        this.zoom = p.zoom;
        this.x = p.x;
        this.y = p.y;
        this.click = p.click;
        this.i = p.i;
        this.observers = p.observers;
        notifyObservers();
    }

    //Attache l'observateur de ce sujet
    @Override
    public void attach(IObserver o) {
        observers.add(o);
    }

    //Detache l'observateur de ce sujet
    @Override
    public void detach(IObserver o) {
        observers.remove(o);
    }

    //Notifie les observateurs que l'etat du sujet a changer
    @Override
    public void notifyObservers() {
        for(IObserver o : observers){
            o.update();
        }
    }

    /**
     * Methode non implanter qui charge les parametre d'un memento sauvegarder
     */
    @Override
    public void load() {

    }

    /**
     * Methode non implanter qui sauvegarde l'instance d'un Memento de cette perspective
     */
    @Override
    public void save() {

    }

    /*
    Classe interne de Perspective qui applique le patron Memento, pour conserver
    une les parametres de la classe et de la charger ulterieurement
     */
    public static class Memento implements IMemento {

        private final PerspectiveZoomAndPan p;

        public Memento (PerspectiveZoomAndPan p) {
            this.p = new PerspectiveZoomAndPan();
            this.p.zoomScale = p.zoomScale;
            this.p.zoom = p.zoom;
            this.p.x = p.x;
            this.p.y = p.y;
            this.p.click = p.click;
            this.p.i = p.i;
            this.p.observers = p.observers;
        }

        //Accesseurs
        private PerspectiveZoomAndPan getSavedPerspective() {
            return p;
        }
    }

}

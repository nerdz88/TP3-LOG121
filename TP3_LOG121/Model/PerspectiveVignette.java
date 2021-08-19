/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: PerspectiveVignette.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Model;

import ObserverPattern.IObserver;
import ObserverPattern.ISubject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerspectiveVignette implements ISubject, IPerspective {

    private List<IObserver> observers = new ArrayList<>();
    private Image i;

    public void setImage(String path) throws IOException {
        i = ImageIO.read(new File(path));
        notifyObservers();
    }

    public Image getImage() { return this.i; }

    @Override
    public void attach(IObserver o) {
        observers.add(o);
    }

    @Override
    public void detach(IObserver o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(IObserver o : observers) {
            o.update();
        }
    }

    /**
     * Methode qui sauvegarde les parametres de cette perspective dans un memento
     * @return nouvelle instance de Memento de cette perspective
     */
    public Memento saveToMemento() {
        System.out.println("SAVING TO MEMENNTTOOO !!!!");
        return new Memento(this);
    }

    /**
     * Methode qui charge les parametres de cette perspective a partir d'un Memento
     */
    public void restoreFromMemento(Memento m) {
        System.out.println("RESTORING FROM MEMENNTTOOO !!!!");
        PerspectiveVignette p = (PerspectiveVignette) m.getSavedPerspective();
        this.i = p.i;
        notifyObservers();
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

        private final PerspectiveVignette p;

        public Memento (PerspectiveVignette p) {
            this.p = new PerspectiveVignette();
            this.p.i = p.i;
        }

        //Accesseurs
        private PerspectiveVignette getSavedPerspective() {
            return p;
        }
    }

}

/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
Étudiant(e)s: Michael Couet, Mihai Armasaru et Pierre A Abdelli 
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: AbstractPanneau.java
Date créé: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package View;

import ObserverPattern.IObserver;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPanneau extends JPanel implements IObserver {

    protected static final long serialVersionUID = 1L;
    protected double zoomScale = 1;
    protected Image img;
    protected int x;
    protected int y;

}

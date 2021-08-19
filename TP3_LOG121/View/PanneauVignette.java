/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Michael Couet, Mihai Armasaru et Pierre A Abdelli 
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: View.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package View;

import Model.PerspectiveVignette;
import ObserverPattern.IObserver;

import javax.swing.*;
import java.awt.*;

public class PanneauVignette extends JLabel implements IObserver {

    private Image i;
    private PerspectiveVignette pv;
    private final int HEIGHT = 400;
    private final int WIDTH = 400;
    /**
     * Constructeur
     * @param pv
     */
    public PanneauVignette(PerspectiveVignette pv) {
        this.pv = pv;
    }

    /**
     * Methode du patron observer qui mets a jour la vue
     */
    @Override
    public void update() {
        this.i = pv.getImage();
        Image newI = i.getScaledInstance(WIDTH,HEIGHT,Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(newI));
        revalidate();
        repaint();
    }
}

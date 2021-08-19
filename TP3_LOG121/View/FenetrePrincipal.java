/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
Étudiant(e)s: Michael Couet, Mihai Armasaru et Pierre A Abdelli 
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: FenetrePrincipal.java
Date créé: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package View;

import javax.swing.*;
import java.awt.*;

public class FenetrePrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 - Perspective";
    private static final Dimension DIMENSION = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
            Toolkit.getDefaultToolkit().getScreenSize().height);
    /**
     * Constructeur
     */
    public FenetrePrincipal() {

        MenuFenetre menuFenetre = new MenuFenetre();
        setJMenuBar(menuFenetre);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(DIMENSION);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new BorderLayout(1, 1));

    }

}

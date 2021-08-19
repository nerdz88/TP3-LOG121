/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
Étudiant(e)s: Michael Couet, Mihai Armasaru et Pierre A Abdelli 
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: PerspectiveChooser.java
Date créé: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Factory;

import Controller.*;
import Controller.Buttons.BtnLoad;
import Controller.Buttons.BtnRedo;
import Controller.Buttons.BtnSave;
import Controller.Buttons.BtnUndo;
import Controller.Mediator.CommandMediator;
import Controller.Mediator.IMediator;
import Managers.GestionnaireDeCommandes;
import Managers.GestionnaireMemento;
import Model.ImageLoader;
import Model.PerspectiveZoomAndPan;
import Model.PerspectiveVignette;
import ObserverPattern.IObserver;
import View.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class PerspectiveChooser implements IFactory {

    IMediator med = new CommandMediator();
    
    /**
     * Constructeur
     */
    public PerspectiveChooser() {

        initialize();

    }

    /**
     * Méhode qui créer les panneaux et les boutons.
     */
    public void initialize() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        BtnUndo btnUndo = new BtnUndo(e -> GestionnaireDeCommandes.gdc.faireCommande(new CommandeUndo()), med);
        BtnRedo btnRedo = new BtnRedo(e -> GestionnaireDeCommandes.gdc.faireCommande(new CommandeRedo()), med);
        BtnSave btnSave = new BtnSave(e -> GestionnaireMemento.gm.save(),med);
        BtnLoad btnLoad = new BtnLoad(e -> GestionnaireMemento.gm.load(),med);

        JPanel panelWest = new JPanel();
        panelWest.setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height / 2));

        JPanel panelEast = new JPanel();
        panelEast.setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height / 2));

        JPanel panelSouth = new JPanel();
        panelSouth.setPreferredSize(new Dimension(screenSize.width, screenSize.height / 3));

        JPanel panelNorth = new JPanel();
        panelNorth.setBorder(new LineBorder(Color.GRAY, 2));

        panelNorth.add(btnUndo);
        panelNorth.add(btnRedo);
        panelNorth.add(btnSave);
        panelNorth.add(btnLoad);

        //Initialization des subjects
        PerspectiveZoomAndPan pDroite = new PerspectiveZoomAndPan();
        PerspectiveZoomAndPan pGauche = new PerspectiveZoomAndPan();
        PerspectiveVignette pV = new PerspectiveVignette();

        //Ajout des perspectives a l'image Loader
        ImageLoader.il.attachPerspective(pDroite);
        ImageLoader.il.attachPerspective(pGauche);
        ImageLoader.il.attachPerspective(pV);

        //Initialization des observateurs
        AbstractPanneau zapDroite = new PanneauZoomAndPan(pDroite, med);
        AbstractPanneau zapGauche = new PanneauZoomAndPan(pGauche, med);
        JLabel vignette = new PanneauVignette(pV);

        //Ajout des observateurs au sujets
        pDroite.attach(zapDroite);
        pGauche.attach(zapGauche);
        pV.attach((IObserver)vignette);

        panelWest.add(zapGauche, BorderLayout.WEST);
        panelEast.add(zapDroite, BorderLayout.EAST);
        panelSouth.add(vignette, BorderLayout.CENTER);

        FenetrePrincipal fenetrePrincipal = new FenetrePrincipal();
        fenetrePrincipal.add(panelWest, BorderLayout.WEST);
        fenetrePrincipal.add(panelEast, BorderLayout.EAST);
        fenetrePrincipal.add(panelNorth, BorderLayout.NORTH);
        fenetrePrincipal.add(panelSouth, BorderLayout.SOUTH);

    }

}

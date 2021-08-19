/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Michael Couet, Mihai Armasaru et Pierre A Abdelli 
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: PanneauZoomAndPan.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package View;

import Controller.CommandeClick;
import Controller.Mediator.IMediator;
import Controller.Translate;
import Controller.Zoom;
import Managers.GestionnaireDeCommandes;
import Model.PerspectiveZoomAndPan;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;

public class PanneauZoomAndPan extends AbstractPanneau {

	/**
	 * Cette Classe est inspire de :
	 * SOURCE
	 * https://stackoverflow.com/questions/27915214/how-can-i-drag-images-with-the-mouse-cursor-in-java-gui
	 * https://stackoverflow.com/questions/19643637/zoom-using-mouse-and-graphics
	 * https://www.onooks.com/zoom-and-pan-in-java-using-affinetransform/
	 */
	private PerspectiveZoomAndPan p;
	private IMediator m;

	/**
	 * Constructeur
	 * @param p Perspective a laquelle est attacher la vue,
	 * @param m le mediateur qui gere l'affichage des boutons
	 */
	public PanneauZoomAndPan(PerspectiveZoomAndPan p, IMediator m) {

		this.m = m;
		this.p = p;
		init();

	}

	/**
	 * M�thode qui initialise les actions de la sourie
	 */
	private void init() {

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GestionnaireDeCommandes.gdc.faireCommande(new CommandeClick(p, e, m));
			}

		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				GestionnaireDeCommandes.gdc.faireCommande(new Translate(p, e, m));
			}

		});
		addMouseWheelListener(new MouseAdapter() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				GestionnaireDeCommandes.gdc.faireCommande(new Zoom(p, e, m));
			}

		});

	}

	/**
	 * M�thode pour dessiner l'image
	 */
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(x, y);
		g2.scale(zoomScale, zoomScale);
		g2.drawImage(img, x, y, this);

	}


	public Dimension getPreferredSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Dimension(screenSize.width / 2, screenSize.height / 2);
	}

	/**
	 * Methode du patron observer qui mets a jour la vue
	 */
	@Override
	public void update() {
		this.img = p.getImage();
		this.zoomScale = p.getZoomScale();
		this.x = p.getPositionX();
		this.y = p.getPositionY();
		revalidate();
		repaint();
	}
}
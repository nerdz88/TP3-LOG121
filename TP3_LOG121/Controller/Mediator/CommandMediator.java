/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
Étudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: CommandMediator.java
Date créé: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Controller.Mediator;

import Controller.Buttons.BtnLoad;
import Controller.Buttons.BtnRedo;
import Controller.Buttons.BtnSave;
import Controller.Buttons.BtnUndo;
import Managers.GestionnaireDeCommandes;
import Model.PerspectiveZoomAndPan;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class CommandMediator implements IMediator {

	BtnUndo btnUndo;
	BtnRedo btnRedo;
	BtnSave btnSave;
	BtnLoad btnLoad;

	/**
	 * 
	 */
	public void click(PerspectiveZoomAndPan p, MouseEvent e) {
		if (GestionnaireDeCommandes.gdc.redoListIsEmpty())
			btnRedo.setEnabled(false);
		btnUndo.setEnabled(true);
		btnSave.setEnabled(true);
		p.click(e);
	}

	/**
	 * 
	 */
	public void zoom(PerspectiveZoomAndPan p, MouseWheelEvent e) {
		if (GestionnaireDeCommandes.gdc.redoListIsEmpty())
			btnRedo.setEnabled(false);
		btnUndo.setEnabled(true);
		btnSave.setEnabled(true);
		p.zoom(e);
	}

	/**
	 * 
	 */
	public void translate(PerspectiveZoomAndPan p, MouseEvent e) {
		if (GestionnaireDeCommandes.gdc.redoListIsEmpty())
			btnRedo.setEnabled(false);
		btnUndo.setEnabled(true);
		btnSave.setEnabled(true);
		p.translate(e);
	}

	/**
	 * 
	 */
	@Override
	public void undoZoom(PerspectiveZoomAndPan p, MouseWheelEvent e) {
		btnRedo.setEnabled(true);
		btnSave.setEnabled(true);
		p.undoZoom(e);
		if (GestionnaireDeCommandes.gdc.undoListIsEmpty())
			btnUndo.setEnabled(false);
	}

	/**
	 * 
	 */
	public void undoTranslate(PerspectiveZoomAndPan p, MouseEvent e) {
		btnRedo.setEnabled(true);
		btnSave.setEnabled(true);
		p.undoTranslate(e);
		if (GestionnaireDeCommandes.gdc.undoListIsEmpty())
			btnUndo.setEnabled(false);
	}

	/**
	 * 
	 */
	public void undoClick(PerspectiveZoomAndPan p, MouseEvent e) {
		btnRedo.setEnabled(true);
		btnSave.setEnabled(true);
		p.click(e);
		if (GestionnaireDeCommandes.gdc.undoListIsEmpty())
			btnUndo.setEnabled(false);
	}

	/**
	 * 
	 */
	public void save() {
		btnSave.setEnabled(false);
	}

	/**
	 * 
	 */
	public void redoZoom(PerspectiveZoomAndPan p) {
		p.redoZoom();
	}

	/**
	 * 
	 */
	public void redoTranslate(PerspectiveZoomAndPan p) {
		p.redoTranslate();
	}

	/**
	 * 
	 */
	@Override
	public void undo() {

	}

	/**
	 * 
	 */
	@Override
	public void redo() {
	}

	/**
	 * 
	 */
	@Override
	public void registerBtnUndo(BtnUndo btnUndo) {
		this.btnUndo = btnUndo;
	}

	/**
	 * 
	 */
	@Override
	public void registerBtnRedo(BtnRedo btnRedo) {
		this.btnRedo = btnRedo;
	}

	@Override
	public void registerBtnSave(BtnSave btnSave) {
		this.btnSave = btnSave;
	}

	public void registerBtnLoad(BtnLoad btnLoad) {
		this.btnLoad = btnLoad;
	}

}

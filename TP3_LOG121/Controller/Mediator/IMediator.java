/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
Étudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: IMediator.java
Date créé: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Controller.Mediator;

import Controller.Buttons.BtnLoad;
import Controller.Buttons.BtnRedo;
import Controller.Buttons.BtnSave;
import Controller.Buttons.BtnUndo;
import Model.PerspectiveZoomAndPan;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface IMediator {

    void undoZoom(PerspectiveZoomAndPan p, MouseWheelEvent e);
    void undoTranslate(PerspectiveZoomAndPan p, MouseEvent e);
    void undoClick(PerspectiveZoomAndPan p, MouseEvent e);
    void redoTranslate(PerspectiveZoomAndPan p);
    void redoZoom(PerspectiveZoomAndPan p);
    void undo();
    void redo();
    void click(PerspectiveZoomAndPan p, MouseEvent e);
    void zoom(PerspectiveZoomAndPan p, MouseWheelEvent e);
    void translate(PerspectiveZoomAndPan p, MouseEvent e);

    void registerBtnUndo(BtnUndo u);
    void registerBtnRedo(BtnRedo r);
    void registerBtnSave(BtnSave s);
    void registerBtnLoad(BtnLoad l);

}

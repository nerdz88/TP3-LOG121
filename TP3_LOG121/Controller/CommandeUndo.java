/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #3
 �tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: CommandeUndo.java
 Date cr��: 2020-11-17
 Date dern. modif. 2020-12-02

 *******************************************************/
package Controller;

public class CommandeUndo implements IUndo, ICommande {

    /**
     * Cette classe n'est utiliser qu'a titre semantique pour la gestion des commandes Redo
     */
    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean undo() {
        return false;
    }

    @Override
    public boolean redo() {
        return false;
    }
}

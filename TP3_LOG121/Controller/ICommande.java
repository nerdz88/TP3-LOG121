/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #3
�tudiant(e)s: Pierre A Abdelli et Dave Vouma-Gagnon
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: ICommand.java
Date cr��: 2020-11-17
Date dern. modif. 2020-12-02

*******************************************************/
package Controller;

public interface ICommande {

    boolean execute();
    boolean undo();
    boolean redo();

}

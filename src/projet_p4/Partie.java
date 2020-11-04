/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_p4;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author mlenorma
 */
public class Partie {
    
    Joueur[] ListeJoueurs = new Joueur[2];
    Jeton[] ListeJetons = new Jeton[21];
    Joueur joueurActuel;
    Grille[][] grille = new Grille[6][7];
    
    public void attribuerCouleursAuxJoueurs(){
        
        String Couleur[] = new String[2];
        Couleur[0] = "Jaune";
        Couleur[1]= "Rouge";
        
        Random nbAleat = new Random();
        int nb = nbAleat.nextInt(1);
       
        ListeJoueurs[0].CouleurJoueur = Couleur[nb];
        
        if ("Jaune".equals(ListeJoueurs[0].CouleurJoueur)){
            ListeJoueurs[1].CouleurJoueur = "Rouge";
        }
        else{
            ListeJoueurs[1].CouleurJoueur = "Jaune";
        }
        
        System.out.println("La couleur du joueur 1 est : " + ListeJoueurs[0].CouleurJoueur+" et la couleur du joueur 2 est : " + ListeJoueurs[1].CouleurJoueur);
    }
    
    public Joueur ProchainJoueur(Joueur joueur_1){
        if(ListeJoueurs[0]== joueurActuel){
            return ListeJoueurs[1];
        }
        else{
            return ListeJoueurs[0];
        }
    }
    
    public void initialiserPartie(){
        //on met ici en place notre grille
        
        
    }
    
}

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
    Joueur joueurActuel;
    Grille grilleJeu = new Grille();
    
    public void attribuerCouleursAuxJoueurs(){
        Random nbAleat = new Random();
        boolean couleurJeton;
        couleurJeton = nbAleat.nextBoolean();
        if (couleurJeton){
            ListeJoueurs[0].CouleurJoueur = "Rouge";
            ListeJoueurs[1].CouleurJoueur = "Jaune";
        }
        else{
            ListeJoueurs[0].CouleurJoueur = "Jaune";
            ListeJoueurs[1].CouleurJoueur = "Rouge";
        }
    }   
    
    public Joueur ProchainJoueur(Joueur unJoueur){
        if(ListeJoueurs[0]== joueurActuel){
            return ListeJoueurs[1];
        }
        else{
            return ListeJoueurs[0];
        }
    }
    
    public void initialiserPartie(){
        //on met ici en place notre grille
        grilleJeu.viderGrille();
        
        //on cree ici les joueurs 
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo du premier joueur : ");
        Joueur Joueur1 = new Joueur(sc.nextLine());
        System.out.println("Choix du pseudo du deuxième joueur : ");
        Joueur Joueur2 = new Joueur(sc.nextLine());
        ListeJoueurs[0] = Joueur1;
        ListeJoueurs[1] = Joueur2;
        
        attribuerCouleursAuxJoueurs();
        System.out.println(Joueur1.Nom + " a pour couleur "+Joueur1.CouleurJoueur);
        System.out.println(Joueur2.Nom + " a pour couleur "+Joueur2.CouleurJoueur);
        
        //on assimile ensuite des jetons aux deux joueurs
        int Compteur =0;
        for (int i=0; 1<5; i++){
            int ligneTrouNoir = nbAleat.nextInt(6);
            int colonneTrouNoir = nbAleat.nextInt(7);
            if(Compteur<2){
                if (!grilleJeu.placerTrouNoir(ligneTrouNoir, colonneTrouNoir)){
                    Compteur = Compteur--;
                }
                else{
                    Compteur = Compteur + 1;
                }
            }   
            if(!grilleJeu.placerTrouNoir(ligneTrouNoir, colonneTrouNoir)){
                i--;
            }
            
        }
        
        //on place alors les 3 derniers desintegrateurs
        int menu_jouer(){
            
        }
        
    }
    
}

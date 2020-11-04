/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_p4;

import java.util.Random;


/**
 *
 * @author mlenorma
 */
public class Jeton {
    String CouleurJeton; 
    
    //on crée le constructeur de la classe
    public Jeton (String couleur_jeton){
        CouleurJeton=couleur_jeton;
    }
 
    public String lireCouleur(){
        
        //on crée un tableau de deux lignes contenant les deux couleurs de jeton possibles
        String Couleur[] = new String[2]; 
        Couleur[0] = "Jaune"; 
        Couleur[1]= "Rouge";
        
        //la couleur du jeton est aléatoire donc on crée un nb aleatoire correspondant au numero de la case du tableau, et donc a une des deux couleurs
        Random nbAleat = new Random();
        int nb = nbAleat.nextInt(1);
        
        CouleurJeton = Couleur[nb];
        
        return(CouleurJeton);
        }
    }


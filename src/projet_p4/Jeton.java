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
    
    public Jeton (String couleur_jeton){
        CouleurJeton=couleur_jeton;
    }
 
    public String lireCouleur(){
        
        String Couleur[] = new String[2];
        Couleur[0] = "Jaune";
        Couleur[1]= "Rouge";
        
        Random nbAleat = new Random();
        int nb = nbAleat.nextInt(1);
        
        CouleurJeton = Couleur[nb];
        
        return(CouleurJeton);
        }
    }


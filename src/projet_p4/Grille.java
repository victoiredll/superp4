/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_p4;

/**
 *
 * @author mlenorma
 */
public class Grille {
    Cellule[][] Cellules = new Cellule[6][7];
    
    public boolean Colonnevide(Jeton jetonActuel, int nbcolonne){
        boolean colonnevide = true;
        for (int i=0 ; i<Cellules.length; i++){ 
            if (Cellules[i][nbcolonne+1].affecterJeton(jetonActuel)){
                colonnevide = true;
            }
            else {
                colonnevide = false;
            }
        }
    return colonnevide; 
    }
    public boolean ajouterJetonDansColonne(Joueur joueurActuel, int nbcolonne){
        int i=0;
        while (Cellules[i][nbcolonne].JetonCourant!=null){
        i=i+1;
    }
        Jeton jetonDuJoueur = joueurActuel.retirer_jeton(); 
        Cellules[i][nbcolonne].JetonActuel = jetonDuJoueur; 
        
        if (Cellules[i][nbcolonne].presenceTrouNoir()){
            Cellules[i][nbcolonne].activerTrouNoir();
            
        }
        if (Cellules[i][nbcolonne]).presenceDesintegrateur()){
            Cellules[i][nbcolonne].recupererDesintegrateur();
            joueurActuel.obtenirDesintegrateur();     
    }
        
     return true;   
    }
        
    
}

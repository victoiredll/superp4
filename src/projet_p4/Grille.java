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
    
    
    public boolean ajouterJetonDansColonne(Jeton jetonactuel, int nbcolonne){
        boolean colonnevide = true;
        for (int i=0 ; i<Cellules.length; i++){ //on décrémente d'abord 
            if (Cellules[i][nbcolonne+1].affecterJeton(jetonactuel)){
                colonnevide = true;
            }
            else {
                colonnevide = false;
            }
        }
    return colonnevide; }
}

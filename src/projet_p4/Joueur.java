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
public class Joueur {
    String Nom; 
    String CouleurJoueur; 
    Jeton[] ListeJetons = new Jeton[21];
    int nombreDesintegrateurs; 
    int nombreJetons_restants; 
    
    public  Joueur(String unNom, String couleur_joueur) {

        Nom = unNom;
        CouleurJoueur = couleur_joueur;
        nombreDesintegrateurs = 0;
        nombreJetons_restants = 0; 
    }
    
    public boolean ajouter_jeton(Jeton jeton_a_ajouter){
        
            ListeJetons[nombreJetons_restants]=jeton_a_ajouter;
            nombreJetons_restants=nombreJetons_restants+1;
            
            if (nombreJetons_restants <=21){
                return true; 
                
            }
            else {
                    return false;
                    }      
    }   
    public Jeton retirer_jeton (){
        nombreJetons_restants=nombreJetons_restants-1;
        return ListeJetons[nombreJetons_restants];
        }
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs= nombreDesintegrateurs+1;
    }
    
    public boolean utiliserDesintegrateur(){
        if (nombreDesintegrateurs==0){
            return false; 
        }
        else {
            nombreDesintegrateurs= nombreDesintegrateurs-1 ;
            return true; 
        }
    }
    public void affectation_couleur (String couleur){
        CouleurJoueur = couleur; 
    }
    
}

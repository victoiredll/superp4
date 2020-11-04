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
public class Joueur { //on crée la classe Joueur avec ses attributs 
    String Nom; 
    String CouleurJoueur; 
    Jeton[] ListeJetons = new Jeton[21]; //liste complète des jetons 
    int nombreDesintegrateurs; 
    int nombreJetons_restants; 
    
    public  Joueur(String unNom, String couleur_joueur) { //creation du constructeur joueur 

        Nom = unNom;
        CouleurJoueur = couleur_joueur;
        nombreDesintegrateurs = 0; //on attribue au joueur un nombre de desintegrateur et de jetons 
        //qui évoluera au cours de la partie
        //on les initialise à 0
        nombreJetons_restants = 0; 
    }
    
    public boolean ajouter_jeton(Jeton jeton_a_ajouter){ //on ajoute le jeton à la liste
        
            ListeJetons[nombreJetons_restants]=jeton_a_ajouter;
            nombreJetons_restants=nombreJetons_restants+1; //on augmente le nombre de jetons restants au joueur 
            
            if (nombreJetons_restants <=21){ //pour un soucis de cohérence, il ne peut y avoir que 21 jetons maximum
                return true; 
                
            }
            else {
                    return false;
                    }      
    }   
    public Jeton retirer_jeton (){ //on retire un jeton à la liste 
        nombreJetons_restants=nombreJetons_restants-1; //on diminue le nombre de jetons restants 
        return ListeJetons[nombreJetons_restants]; //ici, pas besoin de crer un objet car on enlève seulement un jeton 
        }
    public void obtenirDesintegrateur(){ //cette fonction permet d'augmenter le nombre de désintégrateurs possédé par le joueur 
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

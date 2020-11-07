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
public class Joueur { //on cr�e la classe Joueur avec ses attributs 
    String Nom; 
    String CouleurJoueur; 
    Jeton[] ListeJetons = new Jeton[21]; //liste compl�te des jetons 
    int nombreDesintegrateurs; 
    int nombreJetons_restants; 
    
    public  Joueur(String unNom) { //creation du constructeur joueur 

        Nom = unNom;
        nombreDesintegrateurs = 0; //on attribue au joueur un nombre de desintegrateur et de jetons 
        //qui �voluera au cours de la partie
        //on les initialise � 0
        nombreJetons_restants = 0; 
    }
    
    public boolean ajouter_jeton(Jeton jeton_a_ajouter){ //on ajoute le jeton � la liste
        
            ListeJetons[nombreJetons_restants]=jeton_a_ajouter;
            nombreJetons_restants=nombreJetons_restants+1; //on augmente le nombre de jetons restants au joueur 
            
            if (nombreJetons_restants <=21){ //pour un soucis de coh�rence, il ne peut y avoir que 21 jetons maximum
                return true; 
                
            }
            else {
                    return false;
                    }      
    }   
    public Jeton retirer_jeton (){ //on retire un jeton � la liste 
        nombreJetons_restants=nombreJetons_restants-1; //on diminue le nombre de jetons restants 
        return ListeJetons[nombreJetons_restants]; //ici, pas besoin de crer un objet car on enl�ve seulement un jeton 
        }
    public void obtenirDesintegrateur(){ //cette fonction permet d'augmenter le nombre de d�sint�grateurs poss�d� par le joueur 
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
        public void affectation_Couleur(String couleur) {
        CouleurJoueur=couleur;
        if (couleur != "rouge"  && couleur != "jaune") { //oblige le joueur a faire le choix entre deux couleurs 
            System.out.println("Erreur couleur");
        }
    }

    
}

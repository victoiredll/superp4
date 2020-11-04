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
public class Cellule {
    Jeton jetonCourant; 
    boolean trouNoir; 
    boolean Desintegrateur; 
    
    //on crée le constructeur de la classe cellule
    public Cellule(Jeton jetoncourant, boolean trounoir, boolean desintegrateur){
        jetonCourant = jetoncourant = null; //lorsque la cellule est créee il n'y a pas de jeton
        trouNoir = trounoir = false;        //il n'y a pas de trou noir pour le moment
        Desintegrateur = desintegrateur = false; //il n'y a pas de desintegrateur non plus
    }
    
    public boolean affecterJeton(Jeton jeton_1){
        if (jetonCourant == null){
            jetonCourant = jeton_1;
            return true;
        }
        else{
            return false;
        }
    }
    
    
    //cette methode permet de recuperer le jeton de la cellule en question
    public Jeton recupererJeton(){
        Jeton jeton_2 = jetonCourant; //On assigne une reference au jeton
        jetonCourant = null; //on enleve ce jeton de la cellule grace a sa reference et s'il était deja null en renvoie null
        return jeton_2; 
    }
    
    public boolean supprimerJeton(){
        if (jetonCourant == null){
            return false;
        }
        else{
            jetonCourant = null;
            return true;
        }
    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant == null){
            return "vide";
        }
        else{
            String couleurJetonC = jetonCourant.lireCouleur();
            return couleurJetonC; 
        }
        
    }
    
    //renvoie vrai quand on place un trou noir sur une cellule ou faux s'il est deja placé
     public boolean placerTrouNoir(){
        if (trouNoir==true){
            return false;
        }   
        else{
            trouNoir = true;
            return true;
            }
    }
    
    public boolean presenceTrouNoir(){
        return trouNoir;
    }
    
    public boolean activerTrouNoir(){
        if(trouNoir==true){
            jetonCourant=null;
            trouNoir=false;
            System.out.println("Le trou noir a aspiré votre pion...");
            return true;
        }
        else{
            return false;
              
        }
    }
       
    public boolean placerDesintegrateur(){
        if (Desintegrateur == true){
            return false;
        }
        else{
            Desintegrateur=true;
            return true;
        }
    }
    
    public boolean presenceDesintegrateur(){
        return Desintegrateur;
    }

    public boolean recupererDesintegrateur(){
        if (presenceDesintegrateur()==true){
            Desintegrateur = false;
            return true;
        }
        else {
            return false;
        }
    }  
    
}

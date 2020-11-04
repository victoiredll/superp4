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
    
    public Cellule(Jeton jetoncourant, boolean trounoir, boolean desintegrateur){
        jetonCourant = jetoncourant = null;
        trouNoir = trounoir = false;
        Desintegrateur = desintegrateur = false;
        
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
    
    public Jeton recupereJeton(){
        return jetonCourant;
    }
    
    public boolean supprimerJeton(){
        if (jetonCourant != null){
            jetonCourant = null;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean presenceTrouNoir(){
        if (trouNoir==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean placerTrouNoir(){
        if (trouNoir == false){
            trouNoir = true;
            return true;
        }   
        else{
            trouNoir = false;
            return false;
            }
    }
    
    
    public boolean presenceDesintegrateur(){
        if (Desintegrateur==true){
            return true;
        }
        else {
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
   
    public String lireCouleurDuJeton(){
        String couleurJetonC = jetonCourant.lireCouleur();
        return couleurJetonC;
    }

    public boolean recupererDesintegrateur(){
        if (presenceDesintegrateur()==true){
            jetonCourant=null;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean activerTrouNoir(){
        if(presenceTrouNoir()==true){
            supprimerJeton();
            trouNoir=false;
            return true;
        }
        else{
            return false;
              
        }
    }  
    
}

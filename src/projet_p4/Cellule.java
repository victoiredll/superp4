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
    
    // methode qui ajoute le jeton en paramètre	à la cellule, et retourne vrai si l’ajout s’est	bien passé, ou faux sinon
    public boolean affecterJeton(Jeton jeton_1){
        if (jetonCourant == null){ // cas ou il n'y a pas de jeton
            jetonCourant = jeton_1;
            return true;
        }
        else{ // cas ou il y a deja un jeton 
            return false;
        }
    }
    
    
    //cette methode permet de recuperer le jeton de la cellule en question
    public Jeton recupererJeton(){
        Jeton jeton_2 = jetonCourant; //On renvoie une reference au jeton
        jetonCourant = null; //on enleve ce jeton de la cellule grace a sa reference et s'il était deja null en renvoie null
        return jeton_2; 
    }
    
    //	supprime le jeton et renvoie vrai si la	suppression s’est bien passée, ou faux autrement
    public boolean supprimerJeton(){
        if (jetonCourant == null){ //cas ou il n'ya deja pas de jeton present
            return false;
        }
        else{
            jetonCourant = null; // s'il y en a un, on lui assigne null ce qui le supprime
            return true;
        }
    }
    
    //renvoie la couleur du jeton occupant la cellule
    public String lireCouleurDuJeton(){
        if (jetonCourant == null){ //cas ou il n'y a pas de jeton
            return "vide";
        }
        else{
            String couleurJetonC = jetonCourant.lireCouleur(); //on fait appel la methode lirecouleur de la classe jeton et on l'assigen a une variable
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
    
    //renvoie vrai si un trou noir est présent sur la cellule et faux si ce n'est pas le cas
    public boolean presenceTrouNoir(){
        return trouNoir;
    }
    
    //active le	trou noir : le trou noir engloutit le jeton et disparait. 
    //Retourne vrai si tout s’est correctement déroulé, ou faux	sinon  
    public boolean activerTrouNoir(){
        if(trouNoir==true){
            jetonCourant=null;
            trouNoir=false;
            System.out.println("Le trou noir a aspiré votre pion ");
            return true;
        }
        else{
            return false;
              
        }
    }
    
    //ajoute un	désintégrateur à l’endroit indiqué et retourne vrai si l’ajout s’est bien passé, ou faux sinon
    public boolean placerDesintegrateur(){
        if (Desintegrateur == true){
            return false;
        }
        else{
            Desintegrateur=true;
            return true;
        }
    }
    
    //renvoie vrai si un desintégrateur	est présent sur	la cellule et faux si ce n'est pas le cas
    public boolean presenceDesintegrateur(){
        return Desintegrateur;
    }
    
    //supprime le désintégrateur présent de la cellule, et renvoie vrai, ou faux sinon	
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

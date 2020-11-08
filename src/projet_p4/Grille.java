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
    
    public Grille (){ //creatioj des 42 cellules de la grille
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                Cellules[i][j]=new Cellule();
            }
        }
    }
    
    //ajoute le	jeton dans la colonne ciblée, sur la cellule vide la plus basse. Renvoie faux si la colonne était pleine
    public boolean ajouterJetonDansColonne(Joueur joueurActuel, int nbcolonne){
        int i=0;
        while (Cellules[i][nbcolonne].jetonCourant ==null){ //tant que la case du tableau cellules visee est vide
        i=i+1;
    }
        Jeton jetonDuJoueur = joueurActuel.retirer_jeton(); //on renvoie le jeton retiré de la liste des jetons du joueur
        Cellules[i][nbcolonne].jetonCourant = jetonDuJoueur; //et on le place dans la cellule visee
        
        if (Cellules[i][nbcolonne].presenceTrouNoir()){ //s'il y a un trou noir
            Cellules[i][nbcolonne].activerTrouNoir(); //il aspire le jeton de la case visee
            
        }
        if ((Cellules[i][nbcolonne]).presenceDesintegrateur()){ //s'il y a un desintegrateur
            Cellules[i][nbcolonne].recupererDesintegrateur(); //il est recuperé
            joueurActuel.obtenirDesintegrateur(); //et assigné au joueur en train de jouer son tour
    } 
     return true;   
    }      
    
    /* public boolean ajouterJetonDansColonne (Jeton couleur_jeton,int nbcolonne) {

        boolean b =true;
        for( int i =5; i< Cellules.length; i--) {
            if (Cellules [i][nbcolonne-1].affecterJeton(couleur_jeton)){
                b =true;                
            }
            else {
                b = false; 
            }
        }
        return b ;
    }
    */
    
    //methode qui verifie si la grille est remplie. renvoie true si oui et faux sinon
    public boolean etreRemplie(){
        boolean x;
        x=true; //x correspond a l'etat de la grille 
        for (int i =0; i < Cellules.length; i++){
            for (int j = 0;  j< Cellules.length; j++){
                if (Cellules [i][j] == null) {
                 x = false; //si l'etat est nul, la colonne n'est pas remplie
                }

                else {
                    x = true;
                }
            }
        }
    return x;

    }

//permet de vider la grille de jeu
public void viderGrille() {
    for (int i =0; i < Cellules.length; i++){
     for (int j = 0;  j< Cellules.length; j++){
        Cellules [i][j].jetonCourant = null; //enleve le jeton present dans la case 
        Cellules [i][j].trouNoir = false; //retire le trou noir present dans la case
        Cellules [i][j].Desintegrateur = false;//retire le desintegrateur present dans la case 
       
    }  
    }
}

//nous permet d'afficher la grille sur la surface d'execution du jeu
// nous avons un bug au niveau des bornes que l'on arrive pas a resoudre dans cette methode
public void  afficherGrilleSurConsole(){
    for(int i=0;i<6;i++){
        for(int j=0;j<7;i++){
            if (Cellules[i][j].trouNoir ==true) {  //afficher un "!" quand il y a un trou noir
               System.out.print("!");
            }
            else if (Cellules[i][j].Desintegrateur== true){ //afficher un "D" lorsquil y a un desintegrateur
                System.out.println("D");
            }
            else if ((Cellules[i][j].lireCouleurDuJeton())=="rouge") { //afficher la couleur du joueur a qui appartient le jeton
               System.out.print("Rouge");
            }
            else if ((Cellules[i][j].lireCouleurDuJeton())=="jaune") {    
               System.out.print("Jaune");
            }
            else{
                System.out.print(" "); //s'il n'y a rien dans la case on affiche seulement un espace
            }
        }
    }
}
public boolean celluleOccupee(int nbligne, int nbcolonne){ //renvoie vrai si la cellule est occupee et faux si non
    if (Cellules[nbligne][nbcolonne].recupererJeton()==null){ 
        return false;
    }else{
        return true;
    }
}
 
public String lireCouleurDuJeton(int nbligne, int nbcolonne){ //indique la couleur du jeton dans la case ciblee
   return Cellules[nbligne][nbcolonne].recupererJeton().lireCouleur();
}       
 
public boolean etreGagnantePourJoueur(Joueur joueurActuel){ //renvoi vrai si le joueur en parametre, soit le joueur actuel est gagnant de la partie 
    boolean y;
    y=false;
    for (int i=0;i<6;i++){
        for (int j=0;j<7;i++){

            if ((lireCouleurDuJeton(i,j).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i+1,j).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i+2,j).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i+3,j).equals(joueurActuel.CouleurJoueur))){
//on cr�e les conditions d'une ligne de quatre pions de la m�me couleur 
    y=true;
    }

    if (lireCouleurDuJeton(i,j).equals(joueurActuel.CouleurJoueur) && (lireCouleurDuJeton(i,j+1).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i,j+2).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i,j+3).equals(joueurActuel.CouleurJoueur))){
//on cr�e les conditions d'une colonne de quatres pions de la m�me couleur 
        y=true;
    }

    if (lireCouleurDuJeton(i,j).equals(joueurActuel.CouleurJoueur) && (lireCouleurDuJeton(i+1,j+1).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i+2,j+2).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i+3,j+3).equals(joueurActuel.CouleurJoueur))){
//on se place dans le cas d'une diagonale de pions de la m�me couleur 
        y=true;
    }

    if (lireCouleurDuJeton(i,j).equals(joueurActuel.CouleurJoueur) && (lireCouleurDuJeton(i+1,j-1).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i+2,j-2).equals(joueurActuel.CouleurJoueur)) && (lireCouleurDuJeton(i+3,j-3).equals(joueurActuel.CouleurJoueur))){
//dans les deux sens 
        y=true;

    }
    }
    }
    return y; 
}
 
public void tasserGrille (int nbligne,int nbcolonne){
    //on ne s'int�resse qu'aux colonnes car en ligne la grille ne se tasse pas 
//permet � la grille de se tasser si il y a un �v�nement tel qu'un d�sintgrateur ou un trou noir 
    for (int i = nbligne ; i <6 ; i++) {
        if (i == 5) { //si une case inf�rieure est vide, le pion se met dans celle-ci 
            Cellules[i][nbcolonne].jetonCourant =null;
            }
        else {
        Cellules[i][nbcolonne].jetonCourant = Cellules[i +1][nbcolonne].jetonCourant ;
        }
    }     
}
public boolean colonneRemplie(){
//permet d'indiquer si la colonne est remplie 
    boolean z;
    z=false;
    for (int i=0;i<6;i++){
    z=celluleOccupee(0,i);
}

return z;

}
 
public boolean placerTrouNoir(int i, int j){
//permet d'ajouter un trou noir et renvoie vrai si il y a bien eu un ajout, dans tous les autres cas il renvoie faux 

    boolean x;
    
    if(Cellules[i][j].trouNoir==false){
    Cellules[i][j].trouNoir = true;
    x=true;
    }
    else {
        x=false;
    }
    return x;
}

public boolean placerDesintegrateur(int nbligne ,int nbcolonne) {
//ajoute un d�sint�grateur et renvoie vrai si il y a bien eu un ajout, renvoie faux dans tous les autres cas

 if (Cellules[nbligne][nbcolonne].Desintegrateur==false) {
     Cellules[nbligne][nbcolonne].Desintegrateur = true;
     System.out.println("Désintégrateur bien placé");
     return true;
}
    else {
     return false;
 }
 }

public boolean supprimerJeton(int nbligne, int nbcolone){
//enl�ve un jeton et renvoie vrai si il a bien �t� enlev� 
    boolean y;
    y=false;
    if (Cellules[nbligne][nbcolone].jetonCourant==null){ //cas ou il n'ya pas de jeton ou qu'il a deja ete supprime
        y=false;
    }
    else{  //cas s'il il y a un jeton : on le supprime
        Cellules[nbligne][nbcolone].jetonCourant=null; 
        y=true;
    }
    return y;
}
  
public Jeton recupererJeton(int ligne, int colonne){
    //permet d'enlever un jeton et permet de le recuperer par le joueur 
    Jeton arecuperer = Cellules[ligne][colonne].recupererJeton() ; //on renvoie le jeton recupere
    Cellules[ligne][colonne].supprimerJeton(); //on supprime le jeton de la grille 
    return arecuperer; //on a recupere le jeton et il a ensuite ete supprime de la grille
   
} 
    
}

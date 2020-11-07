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
        while (Cellules[i][nbcolonne].jetonCourant !=null){
        i=i+1;
    }
        Jeton jetonDuJoueur = joueurActuel.retirer_jeton(); 
        Cellules[i][nbcolonne].jetonCourant = jetonDuJoueur; 
        
        if (Cellules[i][nbcolonne].presenceTrouNoir()){
            Cellules[i][nbcolonne].activerTrouNoir();
            
        }
        if ((Cellules[i][nbcolonne]).presenceDesintegrateur()){
            Cellules[i][nbcolonne].recupererDesintegrateur();
            joueurActuel.obtenirDesintegrateur();     
    } 
     return true;   
    }      
public boolean ajouterJetonDansColonne (Jeton couleur_jeton,int nbcolonne) {

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

    public boolean etreRemplie(){
        boolean x;
        x=true; //x correspond � l'�tat de la grille 
        for (int i =0; i < Cellules.length; i++){
            for (int j = 0;  j< Cellules.length; j++){
                if (Cellules [i][j] == null) {
                 x = false; //si l'�tat est nul, la colonne n'est pas remplie
                }

                else {
                    x = true;
                }
            }
        }
    return x;

    }


public void viderGrille() {
    for (int i =0; i < Cellules.length; i++){
     for (int j = 0;  j< Cellules.length; j++){
        Cellules [i][j].jetonCourant = null; //enl�ve le jeton pr�sent dans la case 
        Cellules [i][j].trouNoir = false; //retire le trou noir pr�sent dans la case
        Cellules [i][j].Desintegrateur = false;//retire le d�sint�grateur pr�sent dans la case 
       
    }  
    }
}

public void  afficherGrilleSurConsole(){
    for(int i=0;i<Cellules.length;i++){
        for(int j=0;j<Cellules[0].length;i++){
            if (Cellules[i][j].presenceTrouNoir()==true) {   
               System.out.print("!");
            }
            if ((Cellules[i][j].lireCouleurDuJeton())=="rouge") {   
               System.out.print("Rouge");
            }
            if ((Cellules[i][j].lireCouleurDuJeton())=="jaune") {    
               System.out.print("Jaune");
            }
            else{
                System.out.print(" ");
            }
        }
}
}
public boolean celluleOccupee(int nbligne, int nbcolonne){ //renvoie vrai si la cellule est occup�e
    if (Cellules[nbligne][nbcolonne].recupererJeton()==null){
        return false;
    }else{
        return true;
    }
}
 
public String lireCouleurDuJeton(int nbligne, int nbcolonne){ //indique la couleur dans la case 
   return Cellules[nbligne][nbcolonne].recupererJeton().lireCouleur();
}       
 
public boolean  etreGagnantePourJoueur(Joueur joueurActuel){ //renvoi vrai si le joueur en param�tre, soit le joueur actuel est gagnant de la partie 
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
   

public boolean placerTrouNoir(int nbligne, int nbcolone){
//permet d'ajouter un trou noir et renvoie vrai si il y a bien eu un ajout, dans tous les autres cas il renvoie faux 

    boolean x;
    x=false;
    if(Cellules[nbligne][nbcolone].trouNoir==false){
    Cellules[nbligne][nbcolone].trouNoir = true;
    x=true;
    }
    else {
        x=false;
    }
    return x;
}

public boolean placerDesintegrateur(int nbligne ,int nbcolonne) {
//ajoute un d�sint�grateur et renvoie vrai si il y a bien eu un ajout, renvoie faux dans tous les autres cas

 if (Cellules[nbligne][nbcolonne].Desintegrateur) {
     Cellules[nbligne][nbcolonne].Desintegrateur = true;
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
    if (Cellules[nbligne][nbcolone].jetonCourant==null){
        y=false;
    }
    else{
        Cellules[nbligne][nbcolone].jetonCourant=null;
        y=true;
    }
    return y;
}
  
public Jeton recupererJeton(int ligne, int colonne){
    //permet d'enlever un jeton et permet de le r�cup�rer par le joueur 

    Jeton arecuperer = Cellules[ligne][colonne].recupererJeton() ;
    Cellules[ligne][colonne].supprimerJeton(); //on supprime le jeton de la grille 
    return arecuperer;
   
} 
    
}

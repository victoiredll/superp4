/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_p4;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author mlenorma
 */
public class Partie {
    
    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurActuel;
    Grille grilleJeu = new Grille();
    Random nbAleat = new Random();
    
    // cette methode permet d'assigner les deux couleurs aux joueurs
    public void attribuerCouleursAuxJoueurs(){
        
        boolean couleurJeton;
        couleurJeton = nbAleat.nextBoolean();
        if (couleurJeton){ //si couleurjeton = true
            ListeJoueurs[0].CouleurJoueur = "Rouge"; //le premier joueur est rouge
            ListeJoueurs[1].CouleurJoueur = "Jaune"; //le deuxieme jaune
        }
        else{ //si false
            ListeJoueurs[0].CouleurJoueur = "Jaune"; //le premier joueur a les jetons jaunes
            ListeJoueurs[1].CouleurJoueur = "Rouge"; //le deuxieme les rouges
        }
    }   
    
    public Joueur ProchainJoueur(Joueur unJoueur){
        if(ListeJoueurs[0]== joueurActuel){ //si le joueur en train de jouer actuellement
            return ListeJoueurs[1]; //le prochain joueur a jouer est le deuxieme joueur
        }
        else{ //meme demarche avec le deuxieme joueur en train de jouer actuellement 
            return ListeJoueurs[0];
        }
    }
    
    public void initialiserPartie(){
        //on met ici en place notre grille
        grilleJeu.viderGrille();
        
        //on cree ici les joueurs 
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo du premier joueur : ");
        //on attribue une couleur aléatoire qu'on définit après, l'opérateur joueur attend deux paramètres
        Joueur Joueur1 = new Joueur(sc.nextLine());
        System.out.println("Choix du pseudo du deuxième joueur : ");
        Joueur Joueur2 = new Joueur(sc.nextLine());
        ListeJoueurs[0] = Joueur1;
        ListeJoueurs[1] = Joueur2;
        
        attribuerCouleursAuxJoueurs(); //on attribue et annonce quelles sont les conditions de jeu pour les joueurs (nom et couleur)
        System.out.println(Joueur1.Nom + " a pour couleur "+Joueur1.CouleurJoueur);
        System.out.println(Joueur2.Nom + " a pour couleur "+Joueur2.CouleurJoueur);
        
        //on place aléatoirement trous noirs grace a un compteur en parcourant la grille
        int Compteur =0;
        for (int i=0; i<6; i++){
            int ligneTrouNoir = nbAleat.nextInt(6);
            int colonneTrouNoir = nbAleat.nextInt(7);
            if(Compteur<2){ //sil y a moins de deux trous noir
                if (grilleJeu.placerTrouNoir(ligneTrouNoir, colonneTrouNoir)==false){ //sil ny a pas de trou noir dans la case visee
                    Compteur = Compteur-1; //le compteur baisse de 1
                }
                else{
                    Compteur = Compteur + 1; //sil y a un trou noir, le compteur augmente de 1
                }
            }   
            if(grilleJeu.placerTrouNoir(ligneTrouNoir, colonneTrouNoir)==false){ //s'il n'y a pas de trou noir dans la case visee, on incremente de 1
                i++;
            }
        }
        //on place alors les 3 derniers desintegrateurs de facon aleatoire
        for(int i=0; i<3; i++){
            int ligneDesintegrateur = nbAleat.nextInt(6);
            int colonneDesintegrateur = nbAleat.nextInt(7);
            if ((grilleJeu.placerDesintegrateur(ligneDesintegrateur, colonneDesintegrateur)==true)||(grilleJeu.Cellules[ligneDesintegrateur])!=null){
                i++;
            }
            
        }
        
        //on decide de quel joueur commence de facon aleatoire
        Random rand = new Random(); 
        int premier_joueur; 
        premier_joueur=rand.nextInt(1);//le chiffre aleatoire entre 0 et 1 correspond au joueur qui commence
        if (premier_joueur == 1){
            System.out.println (Joueur1.Nom + " doit commencer"); 
            joueurActuel=Joueur1; 
        }
        else {
            System.out.println(Joueur2.Nom + " doit commencer"); 
            joueurActuel = Joueur2;
        }
        grilleJeu.afficherGrilleSurConsole();//on affiche ensuite la grille de jeu pour commencer la partie
    }
    
    //on initialise un menu de jeu permettant au joueur de choisir ce qu'il veut faire
    public int menuJoueur(){
        //on presente les differentes options du menu
        Scanner sc = new Scanner(System.in);
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1: Jouer un jeton");
        System.out.println("2: Recuperer un jeton");
        System.out.println("2: Désintégrer un jeton");
        int choixMenu = sc.nextInt(); //on donne la possibilite a l'utilisateur de choisir le numero correspondant a l'option qu'il veut
        
        while (choixMenu >3 || choixMenu <1){ //si le choix ne correspond pas aux numeros d'option possible
            System.out.println("Erreur ! Ce choix n'existe pas, veuillez un saisir un nouveau :"); //la console affiche un message d'erreur
            choixMenu = sc.nextInt(); //et il doit re entrer un choix
        }
        return choixMenu;
    }
    
    
    public void jouerJeton(){
        Scanner sc = new Scanner(System.in);
        boolean resultataction;
        System.out.println("Saisissez une colonne");
        int colonne = sc.nextInt()-1; //-1 car on commence a 0 en java contrairement au language courant
        while (colonne < 0 || colonne >6){ //si le choix du numero de colonne est impossible
            System.out.println("Erreur ! Veuillez saisir une colonne qui existe : "); //message d'erreur
            colonne = sc.nextInt()-1; //on re entre un chiffre
        }
        resultataction = grilleJeu.ajouterJetonDansColonne(joueurActuel, colonne);
        while (!resultataction){ //cas ou la colonne est deja pleine
            System.out.println("La colonne est déjà pleine, siasissez une autre colonne : ");
            colonne = sc.nextInt()-1; //on repropose d'entrer un numero de colonne
            resultataction = grilleJeu.ajouterJetonDansColonne(joueurActuel, colonne);
        }
    }
    
    public boolean recupererJeton(){
        int nbcolonne;
        int nbligne ;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Saisissez les coordonnées du jeton à récupérer : ");
        
        //on commence par demander d'entrer la colonne
        System.out.println("Saisissez la colonne : ");
        nbcolonne = sc.nextInt()-1;
        while (nbcolonne >6 || nbcolonne <0){ //cas ou le numero saisi ne correspond pas aux bornes des colonnes
            System.out.println("Erreur ! Veuillez saisir une colonne qui existe : ");
            nbcolonne = sc.nextInt()-1;
        }
        
        //on demande ensuite d'entrer la ligne
        System.out.println("Saisissez la ligne : ");
        nbligne = sc.nextInt()-1;
        while (nbligne>5 || nbligne <0){ //cas ou le numero saisi ne correspond pas aux bornes des lignes
            System.out.println("Erreur ! Veuillez saisir une ligne qui existe : ");
            nbligne = sc.nextInt()-1;
        }
        boolean x;
        x=false;
        if (grilleJeu.Cellules[nbligne][nbcolonne].jetonCourant != null){
            if (grilleJeu.Cellules[nbligne][nbcolonne].lireCouleurDuJeton()==joueurActuel.CouleurJoueur) {
           
            joueurActuel.ajouter_jeton(grilleJeu.recupererJeton(nbligne, nbcolonne));
            grilleJeu.tasserGrille(nbligne,nbcolonne);
            x=true;
        }
        else{
            x=false;
        }
        }
        return x;
    }
    
    //action du desintegrateur s'il y en a un
    public boolean desintegrerJeton(){
        
        if (joueurActuel.nombreDesintegrateurs == 0){ //on ne fait rien sil ny a pas de desintegrateur
            return false;
        }
        
        int colonne;
        int ligne;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Saisissez les coordonées du jeton à désintégrer : ");
        
        System.out.println("Saisissez la colonne : ");
        colonne = sc.nextInt()-1;
        while (colonne >6 || colonne <0){ //cas ou le numero saisi ne correspond pas aux bornes des colonnes
            System.out.println("Erreur ! Veuillez saisir une colonne qui existe : ");
            colonne = sc.nextInt()-1;
        }
        
        System.out.println("Saisissez la ligne : ");
        ligne = sc.nextInt()-1;
        while (ligne>5 || ligne <0){ //cas ou le numero saisi ne correspond pas aux bornes des lignes
            System.out.println("Erreur ! Veuillez saisir une ligne qui existe : ");
            ligne = sc.nextInt()-1;
        }
        boolean x; 
        x=false;
        if ((grilleJeu.Cellules[ligne][colonne].jetonCourant)!= null){ 
                if (grilleJeu.Cellules[ligne][colonne].lireCouleurDuJeton()==joueurActuel.CouleurJoueur){
            grilleJeu.supprimerJeton(ligne, colonne);
            grilleJeu.tasserGrille(ligne, colonne);
            joueurActuel.utiliserDesintegrateur();
            x=true;
        }
        else {
            x=false;
        }
    }
        return x;
    }
    
    
    public void debuterPartie(){
        initialiserPartie();
        menuJoueur(); 
        
    }   
}

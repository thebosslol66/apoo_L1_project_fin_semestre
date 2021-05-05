/**
 *Class Game
 *Class qui gere le jeu, nouvelle partie, nouveau joueur, la boucle du jeu, fin du jeu
 */

public class Game{
	
	/**
	 *La grille de la partie
	 */
	private Grid m_grid;
	
	/**
	 * Le joueur de la partie
	 */
	private Player m_player;
	
	/**
	*Le de
	*/
	private Dice m_dice;
	/**
	 *Creer une nouvelle partie
	 *@param width La largeur de la grille
	 *@param height La hauteur de la grille
	 */
	public void newGame(int width, int height){
		m_grid = new Grid(width, height);
		m_player = m_grid.getNewPlayer();
		
		
		
	}
	
	
	/**
	/* La boucle du jeu
	/*  Elle gere les deplacemets du joueur, ainsi que les echanges entre le plateau et le joueur
	*/
	public void loopGame(){
	char choix;	
	Dice m_dice = new Dice(6);
	
	int nbDice = 0;
	do {
		
		displayGame();
		nbDice = m_dice.launch();
		
		choix = Clavier.saisirChar();	
		while ( (choix != 'q' && choix != 'Q') && (choix != 'r' && choix != 'R') && (choix != 'a' &&  choix != 'A') && (choix != 'p' && choix != 'P')) {
		Ecran.afficherln(Translation.wrongWriting);
		choix = Clavier.saisirChar();	
		
		}
		Cell cellule = m_grid.getCell(m_player.getPosition());	

	
			
	} while (choix != 'q' && choix != 'Q' && !m_player.hasNoRed() && !m_player.hasFullRed());
	
	
	
	}
	
	
	
	
	
	
	/**
	* Affichage du jeu :
	 *Afficher la position
	* Les pions rouges restants
	* La grille
	* Les choix de l'utilisateur
	 */
	private void displayGame(){
	Ecran.afficherln(Translation.position," : ","[",m_player.getPosition().getX(),"] [",m_player.getPosition().getY(),"]");	
	Ecran.afficher(Translation.redChip," : ");
	displayRedChip();
	Ecran.sautDeLigne();
	Ecran.afficherln(m_grid.toDebugDisplay(m_player.getPosition()));
	Ecran.sautDeLigne();
	Ecran.afficherln(Translation.actions);	
		
	}
	
	
	/**
	*Resultat de la partie
	*Victoire
	*Defaite
	*Abandon
	*/
	public void endGame(){
	if (m_player.hasNoRed()) {
	Ecran.afficherln(Translation.success);
	Ecran.afficherln(Translation.goodBye);

		
	}
	else if (m_player.hasFullRed()){
	Ecran.afficherln(Translation.defeat);
	Ecran.afficherln(Translation.youLose);	
		
		
	}
	else {
	Ecran.afficherln(Translation.putGreenChipCell);
	Ecran.afficherln("Il(s) restai(ent) ",m_player.getNumberRedChip(),"pions rouges sur la grille");
	Ecran.afficherln(Translation.seeGridBelow);
	Ecran.afficher(m_grid.toDebugDisplay(m_player.getPosition()));
		
		
	}
	}
	


	
	/**
	*Affiche les pieces rouges en possession du joueur
	 */
private void displayRedChip(){
        int lengthStorage = m_player.getStorageLength();
        int NumberRedShip = m_player.getNumberRedChip();
        Ecran.afficher("[");

        for (int i =0; i< lengthStorage-1; i++){
            if (i < NumberRedShip){
            Ecran.afficher("R, ");

            }
            else {
            Ecran.afficher("., ");
            }

        }
        if (lengthStorage == NumberRedShip){
        Ecran.afficher("R]");
        }
        else {
        Ecran.afficher(".]");

        }
	}
	
	
}

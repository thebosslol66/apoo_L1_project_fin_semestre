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
	
	
	private Rules m_rule;
	
	
	/**
	 *Creer une nouvelle partie
	 *@param rule Les regles pour definir la taille du jeu ainsi que les regles de la partie
	 */
	public void newGame(Rules rule){
		m_rule = rule;
		m_grid = new Grid(m_rule.getGridWidth(), m_rule.getGridHeight(), m_rule.hasChoucrouteRule());
		m_player = m_grid.getNewPlayer();
		m_dice = new Dice(m_rule.getNumberSidesDice());
	}
	
	
	/**
	/* La boucle du jeu
	/*  Elle gere les deplacemets du joueur, ainsi que les echanges entre le plateau et le joueur
	*/
	public void loopGame(){
	char choix;	
	
	
	int nbDice = 0;
		
		displayGame();
		
		Ecran.afficherln(Translation.actions);
		
		choix = Clavier.saisirChar();	
		while ( (choix != 'q' && choix != 'Q') && (choix != 'r' && choix != 'R') && (choix != 'a' &&  choix != 'A') && (choix != 'p' && choix != 'P')) {
		Ecran.afficherln(Translation.wrongWriting);
		choix = Clavier.saisirChar();
		}
		m_rule.loop(m_grid, m_player, choix);
		
	while (choix != 'q' && choix != 'Q' && !m_rule.hasWin(m_grid, m_player) && !m_rule.hasLose(m_grid, m_player)) {
		
		nbDice = m_dice.launch();
		Ecran.afficherln(Translation.Dice ," = ", nbDice);
		
		movePlayer(nbDice);
		displayGame();
		
		Ecran.afficherln(Translation.actions);
		
		choix = Clavier.saisirChar();	
		while ( (choix != 'q' && choix != 'Q') && (choix != 'r' && choix != 'R') && (choix != 'a' &&  choix != 'A') && (choix != 'p' && choix != 'P')) {
		Ecran.afficherln(Translation.wrongWriting);
		choix = Clavier.saisirChar();	
		
		}
		
		m_rule.loop(m_grid, m_player, choix);
	}
	displayGame();
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
	m_rule.printExtraInformation(m_grid, m_player);
	if (Main.DEBUG){
		Ecran.afficherln(m_grid.toDebugDisplay(m_player.getPosition()));
	} else {
		Ecran.afficherln(m_grid.toDisplay(m_player.getPosition()));
	}
	Ecran.sautDeLigne();
	}
	
	
	/**
	*Resultat de la partie
	*Victoire / Defaite
	*Abandon
	*/
	public void endGame(){
	if (m_rule.hasWin(m_grid, m_player) || m_rule.hasLose(m_grid, m_player)) {
		m_rule.endGame(m_grid, m_player);
	}
	else {
	Ecran.afficherln(Translation.putGreenChipCell);
	Ecran.formater(Translation.numberRedChipStayOnGrid,m_player.getNumberRedChip());
	Ecran.sautDeLigne();
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
	
	
	/**
	*Deplacer le joueur
	*@param nbCellMove le nbre de case(s) que le joueur avance
	 */
	private void movePlayer(int nbCellMove){
	
	m_player.setPosition( (m_player.getPosition().getX() + nbCellMove) % m_grid.getWidth(), (int)((m_player.getPosition().getX() + nbCellMove) / m_grid.getWidth() + m_player.getPosition().getY())%m_grid.getHeight() );
	
	
	}
	
}

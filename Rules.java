/**
 * Classe regroupant les règles du jeu
 */
public class Rules {
	
	
	private int idRule;
	/**
	*Constructeur qui initialise les valeurs initiales 
	*
	*/
	Rules(){
		
		
		
	}
	
	// ..
	// DeplacementMax
	//getNumberSidesDice() --- retourne la variable global private
	// fct loop (grid ,player  ,caractere (action))
	
	/**
	*La fonction qui ret
	*@return Le nombre de faces du des
	*/
	private int getNumberSidesDice(){
	
		
		
	return sidesDice;
	}
	
	
	/**
	*La boucle du jeu qui choisit quel type de règle du jeu le joueur veut
	*@param grid La grille
	*@param player Le joueur
	*@param cara Le type de regle que le joueur a choisit
	*/
	public void loop(Grid grid, Player player,char cara){
		
		switch(idRule){
			case 1:{
				
			loopRule1(grid, player, cara);
			}break;
			case 2:{
			
			loopRule2();
			}break;
			
		}
		
	}
	
	/**
	*La boucle du jeu qui choisit quel type de règle du jeu le joueur veut
	*@param grid La grille
	*@param player Le joueur
	*/
	public boolean hasWin(Grid grid, Player player){
		switch(idRule){
			case 1:{
				return hasWinRule1(Grid grid, Player player);
			} break;
			case 2:{
				return hasWinRule2(Grid grid, Player player);
			} break;
		}
		
	}
	
	
	public boolean hasLose(Grid grid, Player player){
		switch(idRule){
			case 1:{
				return hasLoseRule1(Grid grid, Player player);
			} break;
			case 2:{
				return hasLoseRule2(Grid grid, Player player);
			} break;
		}
		
	}
	
	
	
	
	
	private loopRule1(Grid grid, Player player, char choix){
	
	switch (choix) {
		
		
			case 'P':
			case 'p': {
				
				if (!grid.getCell(m_player.getPosition()).hasChip()) { // la case  etait vide
			
				grid.getCell(m_player.getPosition()).setChip(player.removeRedChip());
					
				Ecran.afficherln(Translation.putEmptyCell);
					
				}
				else if (grid.getCell(m_player.getPosition()).hasRedChip()) { // la case est deja occupee par un pion rouge, le depot n a pas lieu .... pion rouge +1
				Ecran.afficherln(Translation.putRedChipCell);	
				player.addRedChip(grid.getCell(m_player.getPosition()).clearChip());
				
					
					
				}
				else if (grid.getCell(m_player.getPosition()).hasGreenChip()){ // la case est deja occupee par un pion vert : le depot n a pas lieu .... pion rouge +0
				Ecran.afficherln(Translation.putGreenChipCell);	
					
					
				}
				else {
				Ecran.afficherln(Translation.mystere);	
					
				}
				
				Ecran.afficherln(Translation.Dice ," = ", nbDice);
				movePlayer(nbDice);
				
			}break;
			
			case 'R':
			case 'r': {
				
				if (!grid.getCell(m_player.getPosition()).hasChip())  {// case vide
				Ecran.afficherln(Translation.takeEmptyCell);
					
					
				}
				else if (grid.getCell(m_player.getPosition()).hasRedChip()){ // case occupee par un pion rouge
				Ecran.afficherln(Translation.takeRedChipCell);	
				player.addRedChip(grid.getCell(m_player.getPosition()).clearChip());
				grid.getCell(m_player.getPosition()).setChip(grid.removeGreenChip());
				
				
				}
				
				else if (cellule.hasGreenChip()) { // case occupee par un pion vert 
				Ecran.afficherln(Translation.takeGreenChipCell);	
				
				grid.addGreenChip(cellule.clearChip());
				grid.getCell(m_player.getPosition()).setChip(player.removeRedChip());
					
				}
				
				
				Ecran.afficherln(Translation.Dice ," = ", nbDice);
				movePlayer(nbDice);
				
			
			} break;
				
			case 'A':	
			case 'a': {
				Ecran.afficherln(Translation.skip);
				Ecran.afficherln(Translation.Dice ," = ", nbDice);
				movePlayer(nbDice);
				
			} break;
			
			case 'Q': 
			case 'q': {
				
			} break;	
				
				
				
		}
	}
	
	
	
	
	/**
	*Deplacer le joueur
	*@param nbCellMove le nbre de case(s) que le joueur avance
	 */
	private void movePlayer(int nbCellMove, Player player, Grid grid){
	
	player.setPosition( (player.getPosition().getX() + nbCellMove) % grid.getWidth(), (int)((player.getPosition().getX() + nbCellMove) / grid.getWidth() + player.getPosition().getY())%grid.getHeight() );
	
	
	}

}
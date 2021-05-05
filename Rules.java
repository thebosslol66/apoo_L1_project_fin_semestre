/**
 * Classe regroupant les regles du jeu
 */
public class Rules {
	
	
	private int m_idRule;
	
	private boolean m_choucrouteRule;
	
	
	private int m_sidesDice;
	
	private int m_maxMove;
	
	private int m_actualMove;
	
	
	/**
	*Constructeur qui initialise les valeurs initiales 
	*
	*/
	Rules(int idRule){
		m_idRule = idRule;
		
		switch(m_idRule){
			case 1:{
				m_sidesDice = 6;
				m_choucrouteRule = false;
				m_maxMove = -1;
			
			}break;
			case 2:{
				m_sidesDice = 6;
				m_choucrouteRule = true;
				m_maxMove = -1;
			
			}break;
			case 3:{
				m_sidesDice = 6;
				m_choucrouteRule = false;
				m_maxMove = 20;
				m_actualMove = <0;
			
			}break;
		}
		
		
	}
	
	// ..
	//getNumberSidesDice() --- retourne la variable global private
	// fct loop (grid ,player  ,caractere (action))
	
	public boolean hasChoucrouteRule(){
		return m_choucrouteRule;
	}
	
	
	/**
	*La fonction qui ret
	*@return Le nombre de faces du des
	*/
	public int getNumberSidesDice(){
	return m_sidesDice;
	}
	
	
	/**
	*La boucle du jeu qui choisit quel type de regle du jeu le joueur veut
	*@param grid La grille
	*@param player Le joueur
	*@param cara Le type de regle que le joueur a choisit
	*/
	public void loop(Grid grid, Player player,char cara){
		
		switch(m_idRule){
			case 1:{ 	
			loopRule1(grid, player, cara);
			}break;
			case 2:{
			loopRule2(grid, player, cara);
			}break;
			case 3:{
			loopRule3(grid, player, cara);
			}break;
		}
		
	}
	
	/**
	*La boucle du jeu qui choisit quel type de regle du jeu le joueur veut
	*@param grid La grille
	*@param player Le joueur
	*/
	public boolean hasWin(Grid grid, Player player){
		switch(m_idRule){
			case 1:{
				return hasWinRule1(grid, player);
			}
			case 2:{
				return hasWinRule2(grid, player);
			}
			case 3:{
				return hasWinRule3(grid, player);
			}
		}
		return false;
	}
	
	
	public boolean hasLose(Grid grid, Player player){
		switch(m_idRule){
			case 1:{
				return hasLoseRule1(grid, player);
			}
			case 2:{
				return hasLoseRule2( grid, player);
			}
			case 3:{
				return hasLoseRule3( grid, player);
			}
		}
		return false;
	}
	
	
	private boolean hasWinRule1(Grid grid, Player player){
		return player.hasNoRed();
	}
	
	private boolean hasWinRule2(Grid grid, Player player){
		return player.hasNoRed();
	}
	private boolean hasWinRule3(Grid grid, Player player){
		return player.hasNoRed() && m_actualMove <= m_maxMove;
	}
	
	private boolean hasLoseRule1(Grid grid, Player player){
		return player.hasFullRed();
	}
	
	private boolean hasLoseRule2(Grid grid, Player player){
		return player.hasFullRed();
	}
	
	private boolean hasLoseRule3(Grid grid, Player player){
		return player.hasFullRed() || m_actualMove > m_maxMove;
	}
	
	
	private void loopRule1(Grid grid, Player player, char choix){
	
	switch (choix) {
		
		
			case 'P':
			case 'p': {
				
				if (!grid.getCell(player.getPosition()).hasChip()) { // la case  etait vide
			
				grid.getCell(player.getPosition()).setChip(player.removeRedChip());
					
				Ecran.afficherln(Translation.putEmptyCell);
					
				}
				else if (grid.getCell(player.getPosition()).hasRedChip()) { // la case est deja occupee par un pion rouge, le depot n a pas lieu .... pion rouge +1
				Ecran.afficherln(Translation.putRedChipCell);	
				player.addRedChip(grid.getCell(player.getPosition()).clearChip());
				
					
					
				}
				else if (grid.getCell(player.getPosition()).hasGreenChip()){ // la case est deja occupee par un pion vert : le depot n a pas lieu .... pion rouge +0
				Ecran.afficherln(Translation.putGreenChipCell);	
					
					
				}
				else {
				Ecran.afficherln(Translation.mystere);	
					
				}
				
			}break;
			
			case 'R':
			case 'r': {
				
				if (!grid.getCell(player.getPosition()).hasChip())  {// case vide
				Ecran.afficherln(Translation.takeEmptyCell);
					
					
				}
				else if (grid.getCell(player.getPosition()).hasRedChip()){ // case occupee par un pion rouge
				Ecran.afficherln(Translation.takeRedChipCell);	
				player.addRedChip(grid.getCell(player.getPosition()).clearChip());
				grid.getCell(player.getPosition()).setChip(grid.removeGreenChip());
				
				
				}
				
				else if (grid.getCell(player.getPosition()).hasGreenChip()) { // case occupee par un pion vert 
				Ecran.afficherln(Translation.takeGreenChipCell);	
				
				grid.addGreenChip(grid.getCell(player.getPosition()).clearChip());
				grid.getCell(player.getPosition()).setChip(player.removeRedChip());
					
				}
				
				
			
			} break;
				
			case 'A':	
			case 'a': {
				Ecran.afficherln(Translation.skip);
				
				
			} break;
			
			case 'Q': 
			case 'q': {
				
			} break;	
				
				
				
		}
	}
	
	private void loopRule2(Grid grid, Player player, char choix){
		switch (choix) {
		
		
			case 'P':
			case 'p': {
				
				if (!grid.getCell(player.getPosition()).hasChip()) { // la case  etait vide
			
				grid.getCell(player.getPosition()).setChip(player.removeRedChip());
					
				Ecran.afficherln(Translation.putEmptyCell);
					
				}
				else if (grid.getCell(player.getPosition()).hasRedChip()) { // la case est deja occupee par un pion rouge, le depot n a pas lieu .... pion rouge +1
				Ecran.afficherln(Translation.putRedChipCell);	
				player.addRedChip(grid.getCell(player.getPosition()).clearChip());

				}
				else if (grid.getCell(player.getPosition()).hasGreenChip()){ // la case est deja occupee par un pion vert : le depot n a pas lieu .... pion rouge +0
				Ecran.afficherln(Translation.putGreenChipCell);	
				}
				else if (grid.getCell(player.getPosition()).hasChoucrouteChip()){ // la case est deja occupee par un pion choucroute : le depot n a pas lieu .... pion rouge +0
				Ecran.afficherln(Translation.putGreenChipCell);//Changer le texte
				}
				else {
				Ecran.afficherln(Translation.mystere);	
					
				}
				
			}break;
			
			case 'R':
			case 'r': {
				
				if (!grid.getCell(player.getPosition()).hasChip())  {// case vide
				Ecran.afficherln(Translation.takeEmptyCell);
					
					
				}
				else if (grid.getCell(player.getPosition()).hasRedChip()){ // case occupee par un pion rouge
				Ecran.afficherln(Translation.takeRedChipCell);	
				player.addRedChip(grid.getCell(player.getPosition()).clearChip());
				grid.getCell(player.getPosition()).setChip(grid.removeGreenChip());
				}
				
				else if (grid.getCell(player.getPosition()).hasGreenChip()) { // case occupee par un pion vert 
				Ecran.afficherln(Translation.takeGreenChipCell);	
				
				grid.addGreenChip(grid.getCell(player.getPosition()).clearChip());
				grid.getCell(player.getPosition()).setChip(player.removeRedChip());
					
				}
				else if (grid.getCell(player.getPosition()).hasChoucrouteChip()){ // la case est deja occupee par un pion choucroute : on supprime la choucroute ainsi qu'un pion rouge du joueur et on reduit de 1 son stockage
					//Ajouter texte de choucroute
					grid.getCell(player.getPosition()).clearChip()
					player = new Player(player.getStorageLength()-1, player.getNumberRedChip()-1);
				}
				
				
			
			} break;
				
			case 'A':	
			case 'a': {
				Ecran.afficherln(Translation.skip);
				
				
			} break;
			
			case 'Q': 
			case 'q': {
				
			} break;	
				
				
				
		}
	}
	
	
	private void loopRule1(Grid grid, Player player, char choix){
		m_actualMove += 1;
		switch (choix) {
		
		
			case 'P':
			case 'p': {
				
				if (!grid.getCell(player.getPosition()).hasChip()) { // la case  etait vide
			
				grid.getCell(player.getPosition()).setChip(player.removeRedChip());
					
				Ecran.afficherln(Translation.putEmptyCell);
					
				}
				else if (grid.getCell(player.getPosition()).hasRedChip()) { // la case est deja occupee par un pion rouge, le depot n a pas lieu .... pion rouge +1
				Ecran.afficherln(Translation.putRedChipCell);	
				player.addRedChip(grid.getCell(player.getPosition()).clearChip());
				
					
					
				}
				else if (grid.getCell(player.getPosition()).hasGreenChip()){ // la case est deja occupee par un pion vert : le depot n a pas lieu .... pion rouge +0
				Ecran.afficherln(Translation.putGreenChipCell);	
					
					
				}
				else {
				Ecran.afficherln(Translation.mystere);	
					
				}
				
			}break;
			
			case 'R':
			case 'r': {
				
				if (!grid.getCell(player.getPosition()).hasChip())  {// case vide
				Ecran.afficherln(Translation.takeEmptyCell);
					
					
				}
				else if (grid.getCell(player.getPosition()).hasRedChip()){ // case occupee par un pion rouge
				Ecran.afficherln(Translation.takeRedChipCell);	
				player.addRedChip(grid.getCell(player.getPosition()).clearChip());
				grid.getCell(player.getPosition()).setChip(grid.removeGreenChip());
				
				
				}
				
				else if (grid.getCell(player.getPosition()).hasGreenChip()) { // case occupee par un pion vert 
				Ecran.afficherln(Translation.takeGreenChipCell);	
				
				grid.addGreenChip(grid.getCell(player.getPosition()).clearChip());
				grid.getCell(player.getPosition()).setChip(player.removeRedChip());
					
				}
				
				
			
			} break;
				
			case 'A':	
			case 'a': {
				Ecran.afficherln(Translation.skip);
				
				
			} break;
			
			case 'Q': 
			case 'q': {
				
			} break;	
				
				
				
		}
	}

}
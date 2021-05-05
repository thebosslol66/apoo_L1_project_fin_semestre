/**
 * Classe regroupant les règles du jeu
 */
public class Rules {
	
	
	private int idRule;
	
	
	private boolean choucrouteRule;
	
	
	/**
	*Constructeur qui initialise les valeurs initiales 
	*
	*/
	Rules(){
		
		
		
	}
	
	
	public boolean hasChoucrouteRule(){
		return choucrouteRule;
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
	int sidesDice;
		
		
	return sidesDice;
	}
	
	
	/**
	*La boucle du jeu qui choisit quel type de règle du jeu le joueur veut
	*@param grid La grille
	*@param player Le joueur
	*@param cara Le type de regle que le joueur a choisit
	*/
	public void loop(Grid grid, Player player,String cara){
		
		switch(idRule){
			case 1:
				
			
			
			case 2:
			
			
			
		}
		
	}
	
	public boolean hasWin(Grid grid, Player player){
		switch(idRule){
			case 1:{
				return hasWinRule1(grid, player);
			} break;
			case 2:{
				return hasWinRule2(grid, player);
			} break;
			
			default:{
				return hasWinRule1(grid, player);
			} break;
		}
		
	}
	
	
	private boolean hasWinRule1(Grid grid, Player player){
		return player.hasNoRed();
	}
	
	private boolean hasWinRule2(Grid grid, Player player){
		return player.hasNoRed();
	}
	
	public boolean hasLose(Grid grid, Player player){
		switch(idRule){
			case 1:{
				return hasLoseRule1(grid, player);
			} break;
			case 2:{
				return hasLoseRule2(grid, player);
			} break;
			
			default:{
				return hasLoseRule1(grid, player);
			} break;
		}
		
	}
	
	private boolean hasLoseRule1(Grid grid, Player player){
		return player.hasFullRed();
	}
	
	private boolean hasLoseRule2(Grid grid, Player player){
		return player.hasFullRed();
	}

}
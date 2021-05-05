/**
 * Classe regroupant les règles du jeu
 */
public class Rules {
	
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
				
			Game.newGame();
			Game.loopGame();
			
			case 2:
			
			
			
		}
		
	}
	
	
	
	
	

}
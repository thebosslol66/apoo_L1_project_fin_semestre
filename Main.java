public class Main {
	public static void main( String [] args){
		//Grid grid = new Grid(4, 3);
		//Player player = grid.getNewPlayer();
		//Ecran.afficher(grid.toDebugDisplay(player.getPosition()));
		
		Game gameAvecUnPetitG = new Game();
		gameAvecUnPetitG.newGame(4,3);
		gameAvecUnPetitG.loopGame();
		gameAvecUnPetitG.endGame();
	}
	
}
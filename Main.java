public class Main {
	public static void main( String [] args){
		
		Game gameAvecUnPetitG = new Game();
		gameAvecUnPetitG.newGame(4,3, new Rules(1));
		gameAvecUnPetitG.loopGame();
		gameAvecUnPetitG.endGame();
	}
	
}
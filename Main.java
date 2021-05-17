public class Main {
	public static void main( String [] args){
		Rules.afficherRegles(Translation.Rules);
		Game gameAvecUnPetitG = new Game();
		Ecran.afficherln(Translation.ruleChoice);
		int choice = Clavier.saisirInt();
		while (choice > 0 && choice <= Rules.nbRules){
			gameAvecUnPetitG.newGame(new Rules(choice));
			gameAvecUnPetitG.loopGame();
			gameAvecUnPetitG.endGame();
			
			Rules.afficherRegles(Translation.Rules);
			Ecran.afficherln(Translation.ruleChoice);
			choice = Clavier.saisirInt();
		}
		Ecran.afficherln("********* Fin du programme *********");
	}
	
}
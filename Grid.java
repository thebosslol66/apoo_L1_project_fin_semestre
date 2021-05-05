/**
 *Classe qui contient le plateau du jeu avec les positions des pions et la liste des pions vert hors du plateau
  */
public class Grid {
	
	/**
	 * Largeur de la grille
	 */
	private int m_width;
	
	/**
	 * Hauteur de la grille
	 */
	private int m_height;
	
	/**
	 * Tableau contenant la liste de toutes les cases du jeu avec ou sans les pions
	 */
	private Cell[][] m_caseList;
	
	/**
	 * La banque contenant les pions vert qui ne nont pas sur le plateau
	 */
	private Storage m_bank;
	
	
	/**
	 * Constructeur qui initialise la grille
	 *@param width Largeur de la nouvelle grille
	 *@param height Hauteur de la nouvelle grille
	 */
	public Grid(int width, int height, boolean createChoucrouteGrid){
		m_width = width;
		m_height = height;
		m_caseList = new Cell[m_height][m_width];
		m_bank = new Storage((int)Math.ceil(m_width*m_height/2));
		
		if (createChoucrouteGrid){
			setCaseChoucrouteDistribution();
		}
		else{
			setCaseDistribution()
		}
	}
	
	/**
	 *Creer un nouveau joueur par rapport a la grille avec le nombre de pions rouge de depart
	 *@return Le joueur initialise pour la grille
	 */
	public Player getNewPlayer(){
		Player player = new Player((int)Math.ceil(m_width*m_height/2), (int)Math.ceil(m_width*m_height/2) - (int)Math.ceil(m_width*m_height/3));
		return player;
	}
	
	/**
	 *Initialise la grille avec les pions de couleur sur la grille ainsi que la banque de pions vert
	 */
	private void setCaseDistribution(){
		int nbRedCeil = (int)Math.ceil((m_width*m_height)/3);
		int nbGreenCeil = (int)Math.ceil((m_width*m_height)/3);
		
		for (int i = 0; i < m_height; i++){
			for (int j = 0; j < m_width; j++){
				m_caseList[i][j] = new Cell();
			}
		}
		
		int pos;
		Chip newChip;
		
		while ((nbRedCeil + nbGreenCeil) > 0){
			if (nbRedCeil > 0){
				pos = (int)(Math.random()*((m_width*m_height)-(int)Math.ceil(m_width*m_height/3)*2+nbRedCeil + nbGreenCeil));
				for (int i = 0; i <= pos; i++){
					if (m_caseList[(int)(i/m_width)][i-((int)(i/m_width)*m_width)].hasChip()){
						pos += 1;
					}
				}
				newChip = new Chip();
				newChip.setRed();
				m_caseList[(int)(pos/m_width)][pos-((int)(pos/m_width)*m_width)].setChip(newChip);
				nbRedCeil -=1;
			}
			
			if (nbGreenCeil > 0){
				pos = (int)(Math.random()*((m_width*m_height)-(int)Math.ceil(m_width*m_height/3)*2+nbRedCeil + nbGreenCeil));
				for (int i = 0; i <= pos; i++){
					if (m_caseList[(int)(i/m_width)][i-((int)(i/m_width)*m_width)].hasChip()){
						pos += 1;
					}
				}
				newChip = new Chip();
				newChip.setGreen();
				m_caseList[(int)(pos/m_width)][pos-((int)(pos/m_width)*m_width)].setChip(newChip);
				nbGreenCeil -=1;
			}
		}
		
		for (int i=0; i < Math.floor(m_width*m_height/3); i++){
			addGreenChip();
		}
	}
	

	/**
	 *Initialise la grille avec les pions de couleur sur la grille ainsi que la banque de pions vert et ajoute le pion choucroute
	 */
	private void setCaseChoucrouteDistribution(){
		int nbRedCeil = (int)Math.ceil((m_width*m_height)/3);
		int nbGreenCeil = (int)Math.ceil((m_width*m_height)/3);
		int nbChoucrouteCeil = (int)Math.floor((m_width*m_height)/6);
		
		for (int i = 0; i < m_height; i++){
			for (int j = 0; j < m_width; j++){
				m_caseList[i][j] = new Cell();
			}
		}
		
		int pos;
		Chip newChip;
		
		while ((nbRedCeil + nbGreenCeil + nbChoucrouteCeil) > 0){
			if (nbRedCeil > 0){
				pos = (int)(Math.random()*((m_width*m_height)-((int)Math.ceil(m_width*m_height/3)*2 + (int)Math.floor((m_width*m_height)/6))+nbRedCeil + nbGreenCeil + nbChoucrouteCeil));
				for (int i = 0; i <= pos; i++){
					if (m_caseList[(int)(i/m_width)][i-((int)(i/m_width)*m_width)].hasChip()){
						pos += 1;
					}
				}
				newChip = new Chip();
				newChip.setRed();
				m_caseList[(int)(pos/m_width)][pos-((int)(pos/m_width)*m_width)].setChip(newChip);
				nbRedCeil -=1;
			}
			
			if (nbGreenCeil > 0){
				pos = (int)(Math.random()*((m_width*m_height)-((int)Math.ceil(m_width*m_height/3)*2 + (int)Math.floor((m_width*m_height)/6))+nbRedCeil + nbGreenCeil + nbChoucrouteCeil));
				for (int i = 0; i <= pos; i++){
					if (m_caseList[(int)(i/m_width)][i-((int)(i/m_width)*m_width)].hasChip()){
						pos += 1;
					}
				}
				newChip = new Chip();
				newChip.setGreen();
				m_caseList[(int)(pos/m_width)][pos-((int)(pos/m_width)*m_width)].setChip(newChip);
				nbGreenCeil -=1;
			}
			
			if (nbChoucrouteCeil > 0){
				pos = (int)(Math.random()*((m_width*m_height)-((int)Math.ceil(m_width*m_height/3)*2 + (int)Math.floor((m_width*m_height)/6))+nbRedCeil + nbGreenCeil + nbChoucrouteCeil));
				for (int i = 0; i <= pos; i++){
					if (m_caseList[(int)(i/m_width)][i-((int)(i/m_width)*m_width)].hasChip()){
						pos += 1;
					}
				}
				newChip = new Chip();
				newChip.setChoucroute();
				m_caseList[(int)(pos/m_width)][pos-((int)(pos/m_width)*m_width)].setChip(newChip);
				nbChoucrouteCeil -=1;
			}
		}
		
		for (int i=0; i < Math.floor(m_width*m_height/3); i++){
			addGreenChip();
		}
	}
	
	/**
	 *Permet d'obtenir la largeur de la grille
	 *@return La largeur de la grille
	 */
	public int getWidth(){
		return m_width;
	}
	
	/**
	 *Permet d'obtenir la hauteur de la grille
	 *@return La hauteur de la grille
	 */
	public int getHeight(){
		return m_height;
	}
	
	/**
	 *Retourne la case a la position x et y
	 *@param x La position en x de la case
	 *@param y La position en y de la case
	 *@return La case en position x et y
	 */
	public Cell getCell(int x, int y){
			return m_caseList[y][x];
	}
	
	public Cell getCell(Position position){
			return m_caseList[position.getY()][position.getX()];
	}
	
	/**
	 *Permet de visualiser la grille
	 *@return Le texte de l'affichage de la grille avec la position des pions en clair
	 */
	public String toDebugDisplay(){
		String result = "+";
		for (int i=0; i < m_width; i++){
			result += " - ";
		}
		result += "+\n";
		
		for (int i = 0; i < m_height; i++){
			result += "|";
			for (int j=0; j < m_width; j++){
				result += " ";
				if (m_caseList[i][j].hasRedChip()){
					result += "R";
				}
				else if (m_caseList[i][j].hasGreenChip()){
					result += "G";
				}
				else {
					result += ".";
				}
				result += " ";
			}
			result += "|\n";
			
		}
		return result;
	}
	/**
	 *Permet de visualiser la grille avec le joueur
	 *@param position La position du joeur
	 *@return @return Le texte de l'affichage de la grille avec la position du joueur et des pions en clair
	 */
	public String toDebugDisplay(Position position){
		String result = "+";
		for (int i=0; i < m_width; i++){
			result += " - ";
		}
		result += "+\n";
		
		for (int i = 0; i < m_height; i++){
			result += "|";
			for (int j=0; j < m_width; j++){
				
				if (position.isEqual(j,i)){
					result += "[";
				}
				else {
					result += " ";
				}
				
				if (m_caseList[i][j].hasRedChip()){
					result += "R";
				}
				else if (m_caseList[i][j].hasGreenChip()){
					result += "G";
				}
				else if (m_caseList[i][j].hasChoucrouteChip()){
					result += "C";
				}
				else {
					result += ".";
				}
				if (position.isEqual(j,i)){
					result += "]";
				}
				else {
					result += " ";
				}
			}
			result += "|\n";
			
		}
		
		
		
		result += "+";
		for (int i=0; i < m_width; i++){
			result += " - ";
		}
		result += "+\n";
		
		return result;
	}
	
	/**
	 *Grille du jeu avec le joueur
	 *@param position La position du joeur
	 *@return @return Le texte de l'affichage de la grille avec la position du joueur
	 */
	public String toDisplay(Position position){
		String result = "+";
		for (int i=0; i < m_width; i++){
			result += " - ";
		}
		result += "+\n";
		
		for (int i = 0; i < m_height; i++){
			result += "|";
			for (int j=0; j < m_width; j++){
				
				if (position.isEqual(j,i)){
					result += "[";
				}
				else {
					result += " ";
				}
				
				result += ".";
				
				if (position.isEqual(j,i)){
					result += "]";
				}
				else {
					result += " ";
				}
			}
			result += "|\n";
			
		}
		
		
		
		result += "+";
		for (int i=0; i < m_width; i++){
			result += " - ";
		}
		result += "+\n";
		
		return result;
	}
	
	public String toString(){
		return "";
		
	}
	
	/**
	 *Ajoute un pion a la banque
	 *@param chip Le pion de couleur vert qu'il viens de prendre
	 */
	public void addGreenChip(Chip chip){
		if (chip.isGreen()){
			m_bank.addChip(chip);
		}
	}
	
	/**
	 *Ajoute un pion vert a la banque
	 */
	private void addGreenChip(){
		Chip chip = new Chip();
		chip.setGreen();
		m_bank.addChip(chip);
	}
	
	/**
	 *Supprime un pion a la banque
	 *@return Le pion qui viens d'etre retire a la banque
	 */
	public Chip removeGreenChip(){
		return m_bank.removeChip();
	}
	
}
public class Cell{
	
	/**
	 * Variable qui garde en memoire le pion de la case
	 */
	private Chip m_chip;
	
	/**
	 * Constructeur d'une case avec un pion dedans
	 *@param chip Un pion qui possede deja une couleur
	 */
	public Cell(Chip chip){
		m_chip = chip;
	}
	
	/**
	 * Constructeur d'une case vide
	 */
	
	public Cell(){
		m_chip = null;
	}
	
	/**
	 * Permet de savoir si la case possede un pion
	 * @return vrai si la case posede un pion
	 */
	public boolean hasChip(){
		if (m_chip != null){
			return true;
		}
		return false;
	}
	
	/**
	 * Donne la couleur du pion de la case
	 *@return La couleur du pion de la case si il existe sinon renvoie une chaine vide
	 */
	public String getChipColor() {
		if (hasChip()){
			return m_chip.getColor();
		}
		return "";
		
	}
	
	/**
	 * Verifie si la case possede un pion vert
	 * @return vrai si le pion est de couleur verte sinon faux
	 */
	public boolean hasGreenChip(){
		return "green" == getChipColor();
	}
	
	/**
	 * Verifie si la case possede un pion rouge
	 * @return vrai si le pion est de couleur rouge sinon faux
	 */
	public boolean hasRedChip(){
		return "red" == getChipColor();
	}
	
	
	/**
	 * Attribut un nouveau pion a la case en remplacant l'ancien
	 *@param chip Le nouveau pion de la case avec sa couleur deja definit
	 */
	public void setChip(Chip chip){
		m_chip = chip;
	}
	
	/**
	 * Supprime le pion de la case
	 * @return Le pion de la case
	 */
	public Chip clearChip(){
		Chip temporalyChip = m_chip;
		m_chip = null;
		return temporalyChip;
	}
}
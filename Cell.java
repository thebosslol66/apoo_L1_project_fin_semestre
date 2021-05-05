/**
 *Class Cell
 *La classe qui gere les cases, avec les pions
 */

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
	 * Verifie si la case possede un pion vert
	 * @return vrai si le pion est de couleur verte sinon faux
	 */
	public boolean hasGreenChip(){
		if (hasChip()){
			return m_chip.isGreen();
		}
		return false;
	}
	
	/**
	 * Verifie si la case possede un pion rouge
	 * @return vrai si le pion est de couleur rouge sinon faux
	 */
	public boolean hasRedChip(){
		if (hasChip()){
			return m_chip.isRed();
		}
		return false;
	}
	
	
	/**
	 * Verifie si la case possede un pion choucroute
	 * @return vrai si le pion est une choucroute sinon faux
	 */
	public boolean hasChoucrouteChip(){
		if (hasChip()){
			return m_chip.isChoucroute();
		}
		return false;
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
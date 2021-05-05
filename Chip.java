/**
 *Classe des pions sur le plateau et dans les storages
 */

 public class Chip {
	
	/**
	 * Gaarde en memoire la couleur du pion
	 */
	private String m_color = null;
	
	/**
	 * Met la couleur du pion a vert
	 */
	public void setGreen(){
		m_color  = "green";
	}
	
	/**
	 * Met la couleur du pion a rouge
	 */
	public void setRed(){
		m_color = "red";
	}
	
	/**
	 * Verifie si le pion possede une couleur
	 */
	private boolean hasColor(){
		if (m_color != null){
			return true;
		}
		return false;
	}
	
	/**
	 * Permet de connaitre la couleur du pion
	 * @return Le texte de la couleur du pion
	 */
	public String getColor(){
		if (hasColor()){
			return m_color;
		}
		return "";
	}
	
	/**
	 *Permet de savoir si le pion est vert
	 * @return vrai si le pion est vert sinon faux
	 */
	public boolean isGreen(){
		return m_color  == "green";
	}
	
	/**
	 *Permet de savoir si le pion est rouge
	 * @return vrai si le pion est rouge sinon faux
	 */
	public boolean isRed(){
		return m_color == "red";
	}
}
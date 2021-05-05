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
	 *Met la couleur du pion a choucroute
	 */
	public void setChoucroute(){
		m_color = "choucroute";
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
	
	/**
	 *Permet de savoir si le pion est une choucroute
	 * @return vrai si le pion est une choucroute sinon faux
	 */
	public boolean isChoucroute(){
		return m_color == "choucroute";
	}
}
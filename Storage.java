/**
 *Classe contenant les set de pion du joueur et du plateau de jeu
 */
public class Storage {
	
	/**
	 *Liste des pions
	 */
	private Chip[] m_chipList;
	
	/**
	 *Constructeur d'un stockage avec un maximum
	 *@param maxStore Le nombre maximum de pions a stocker
	 */
	public Storage(int maxStore){
		m_chipList = new Chip[maxStore];
	}
	
	/**
	 *Verifie si le stockage est vide
	 *@return vrai si le stockage est vide sinon faux
	 */
	public boolean isEmpty(){
		if (m_chipList[0] == null){
			return true;
		}
		return false;
	}
	
	/**
	 *Verifie si le stockage est plein
	 *@return vrai si le stockage est plein sinon faux
	 */
	public boolean isFull(){
		if (m_chipList[m_chipList.length -1] != null){
			return true;
		}
		return false;
	}
	
	/**
	 *Ajoute un pion au stockage
	 *@param chip Un pion avec une couleur
	 */
	public void addChip(Chip chip){
		for (int i = m_chipList.length-1; i > 0; i--){
				if (m_chipList[(i-1)] != null && m_chipList[i] == null){
					m_chipList[i] = chip;
				}
		}
		if (m_chipList[0] == null){
			m_chipList[0] = chip;
		}
	}
	
	/**
	 *Supprime un pion du stockage 
	 *@return Le pion qui a ete enleve de la liste
	 */
	public Chip removeChip(){
		Chip chipToRemove;
		for (int i = 0; i < m_chipList.length -1; i++){
				if (m_chipList[i] != null && m_chipList[i+1] == null){
					chipToRemove = m_chipList[i];
					m_chipList[i] = null;
					return chipToRemove;
				}
		}
		if (m_chipList[m_chipList.length -1] != null){
			chipToRemove = m_chipList[m_chipList.length -1];
			m_chipList[m_chipList.length -1] = null;
			return chipToRemove;
		}
		return null;
	}
	
	/**
	 *Donne la taille totale du stockage
	 *@return La taille du stockage
	 */
	public int getLength(){
		return m_chipList.length;
	}
	
	/**
	 *Donne le nombre de pion que contient le stockage
	 *@return Le nombre de pion du stockage
	 */
	public int getChipNumber(){
		int nbChip = 0;
		for (int i = 0; i < m_chipList.length ; i++){
				if (m_chipList[i] != null){
					nbChip += 1;
				}
		}
		return nbChip;
	}
	
}
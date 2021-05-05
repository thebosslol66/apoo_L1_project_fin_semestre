public class Player{
	
	/**
	 *Stocke les pions rouges du joueur
	 */
	private Storage m_bank;
	
	/**
	 *La position du joueur
	 */
	private Position m_position;
	
	/**
	 *Constructeur d'un joueur avec un maximum de pions rouge qu'il peux posseder
	 *@param maxStorage Le nombre maximal de pion rouge que peux posseder le joueur
	 */
	public Player(int maxStorage, int playerStorage){
		m_bank = new Storage(maxStorage);
		m_position = new Position();
		for (int i=0; i < playerStorage; i++){
			addRedChip();
		}
	}
	
	/**
	 *Verifie si le joueur n'a plus de pion rouge sur lui
	 *@return vrai si le joueur n'as plus de pion rouge sinon faux
	 */
	public boolean hasNoRed(){
		return m_bank.isEmpty();
	}
	
	/**
	 *Verifie si le joueur ne peux plus prendre de pion rouge
	 *@return vrai si le jouer n'as plus de place pour les pions rouge
	 */
	public boolean hasFullRed(){
		return m_bank.isFull();
	}
	
	/**
	 *Ajoute un pion au joueur
	 *@param chip Le pion de couleur rouge qu'il vien de prendre
	 */
	public void addRedChip(Chip chip){
		if (chip.isRed()){
			m_bank.addChip(chip);
		}
	}
	
	/**
	 *Ajoute un pion rouge au joueur
	 */
	private void addRedChip(){
		Chip chip = new Chip();
		chip.setRed();
		m_bank.addChip(chip);
	}
	
	/**
	 *Supprime un pion au joueur
	 *@return Le pion qui viens d'etre retire au joueur
	 */
	public Chip removeRedChip(){
		return m_bank.removeChip();
	}
	
	/**
	 *Change la position du joueur
	 *@param x La nouvelle position du joueur en x
	 *@param y La nouvelle position du joueur en y
	 */
	public void setPosition(int x, int y){
		m_position.setXY(x,y);
	}
	
	/**
	 *Change la position du joueur
	 *@param position La nouvelle position du joueur
	 */
	public void setPosition(Position position){
		m_position = position;
	}
	
	/**
	 *Permet d'avoir la position du joueur
	 *@return La position du joueur
	 */
	public Position getPosition(){
		return m_position;
	}
	
	
	/**
	 *Permet de connaitre la taille du stockage du joueur
	 *@return La taille maximale du stockage du joueur
	 */
	public int getStorageLength(){
		return m_bank.getLength();
	}
	
	/**
	 *Donne le nombre de pion rouge du joueur
	 *@return Le nombre de pion rouge que le joueur possede
	 */
	public int getNumberRedChip(){
		return m_bank.getChipNumber();
	}
}
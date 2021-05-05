public class Position {
	/**
	 * Position en x
	 */
	private int m_x;
	
	/**
	 * Position en x
	 */
	private int m_y;
	
	/**
	 *Constructeur d'une position avec une position definit
	 *@param x Position en x
	 *@param y Position en y
	 */
	public Position(int x, int y){
		m_x = x;
		m_y = y;
	}
	
	/**
	 *Constructeur d'une position avec une position par defaut
	 */
	public Position(){
		m_x = 0;
		m_y = 0;
	}
	
	/**
	 *Definit la position en x
	 *@param x Nouvelle position en x
	 */
	public void setX(int x){
		m_x = x;
	}
	
	/**
	 *Definit la position en y
	 *@param y Nouvelle position en y
	 */
	public void setY(int y){
		m_y = y;
	}
	
	/**
	 *Definit la position en x et y
	 *@param x Nouvelle position en x
	 *@param y Nouvelle position en y
	 */
	public void setXY(int x, int y){
		setX(x);
		setY(y);
	}
	
	/**
	 *Verifie si deux positions sont identiques
	 *@param position la position avec laquelle on compare
	 *@return vrai si les deux positions sont les meme sinon faux
	 */
	public boolean isEqual(Position position){
		if (m_x == position.getX() && m_y == position.getY()){
			return true;
		}
		return false;
	}
	
	/**
	 *Verifie si deux positions sont identiques
	 *@param x La position en x a comparer
	 *@param y La position en y a comparer
	 *@return vrai si les deux positions sont les meme sinon faux
	 */
	public boolean isEqual(int x, int y){
		if (m_x == x && m_y == y){
			return true;
		}
		return false;
	}
	
	/**
	 *Permet d'obtenir la position en x
	 *@return x la position de l'object en x
	 */
	public int getX(){
		return m_x;
	}
	
	/**
	 *Permet d'obtenir la position en y
	 *@return y la position de l'object en y
	 */
	public int getY(){
		return m_y;
	}
}
public class Dice {
	
	/**
	 *Contient le nombre de face d'un de
	 */
	private int m_nbFaces;
	
	/**
	 *Constructeur d'un de
	 *@param nbFaces Nombres de face que le de possede
	 */
	public Dice(int nbFaces){
		if (nbFaces <2){
			m_nbFaces = 2;
		}
		else {
			m_nbFaces = nbFaces;
		}
	}
	
	/**
	 *Simule le lance d'un de
	 *@return Le nombre sur lequel le de est tombe compris entre 1 et nbFace
	 */
	public int launch(){
		
		return (1+(int)(Math.random()*m_nbFaces));
	}
	
}
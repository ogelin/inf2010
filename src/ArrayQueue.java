

public class ArrayQueue<AnyType> implements Queue<AnyType>
{
	private int size = 0;		//Nombre d'elements dans la file.
	private int startindex = 0;	//Index du premier element de la file
	private AnyType[] table;
   
	@SuppressWarnings("unchecked")
	public ArrayQueue() 
	{
		// On initialise le tableau avec 1 case
		this.table = (AnyType[]) new Object[1];
		
	}
	
	//Indique si la file est vide
	public boolean empty() 
	{ 
		return size == 0; 
	}
	
	//Retourne la taille de la file
	public int size() 
	{ 
		return size; 
	}
	
	//Retourne l'element en tete de file
	//Retourne null si la file est vide
	//complexit� asymptotique: O(1)
	public AnyType peek()
	{
		if (empty()){
		return null; 
		}
		else return table[startindex]; 
		
	}
	
	//Retire l'element en tete de file
	//complexit� asymptotique: O(1)
	public void pop() throws EmptyQueueException
	{ 
		// Si la file est vide on ne veut rien faire.
		if (empty()){
			throw new EmptyQueueException();
		}
//		
		for (int i = 0; i<size; i++ ){
			table [i] = table [i+1]; 
		}
		
		this.size = size - 1;
		
	}
	
	//Ajoute un element a la fin de la file
	//Double la taille de la file si necessaire (utiliser la fonction resize definie plus bas)
	//complexit� asymptotique: O(1) ( O(N) lorsqu'un redimensionnement est necessaire )
	public void push(AnyType item)
	{
		//A completer
		// Si le tableau est plein on veut appeler resize, ici on double la capacite.
		if (size >= table.length){
			this.resize(2);		
		}
		
		table [size] = item;
		size++;

	}
   
	//Redimensionne la file. La capacite est multipliee par un facteur de resizeFactor.
	//Replace les elements de la file au debut du tableau
	//complexit� asymptotique: O(N)
	@SuppressWarnings("unchecked")
	private void resize(int resizeFactor)
	{
		
		AnyType[] tmp = (AnyType[]) new Object[table.length*resizeFactor]; 	
		
		for (int i = 0; i<this.size; i++){
			tmp [i] = this.table [i]; 
		}
		
		this.table = tmp; 
		
	}   
}
//
// Ceci est écrit par Hugo. Je voulais simplement essayer de rediger et faire un pull request sur github :P
// C'est tout. Bye!
//

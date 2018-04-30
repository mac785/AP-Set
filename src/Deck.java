/**
 * The Deck class represents a stack of cards. 
 */
public class Deck {
	private Card[] Deck;
	private int topOfDeck;
	
	/**
	 * constructor - makes a deck with every combination of card.
	 */
	public Deck()
	{
		//--------------------
		// TODO: insert your code here.
		Deck = new Card [81];
		
		int counter = 0;
		
		for (int icon = 0; icon < 3; icon ++)
			for (int groupSize = 0; groupSize < 3; groupSize ++)
				for (int numGroups = 0; numGroups < 3; numGroups ++)
					for (int bracket = 0; bracket < 3; bracket ++)
					{
						Deck[counter] = new Card(icon, groupSize, numGroups, bracket);
						counter ++;
					}
		shuffle();
		//--------------------
		
	}
	
	/**
	 * dealCard - returns the card at the "top" of the deck, moving the
	 * "top" down one. 
	 * If the "top" is low enough to be past the end of the deck,
	 * then return null.
	 * @return the next card.
	 */
	public Card dealCard()
	{
		Card c = null;
		//--------------------
		// TODO: Insert your code here.
		if (topOfDeck >= 0)
		{
			c = Deck [topOfDeck];
			topOfDeck -= 1;
		}
		//--------------------
		return c;
	}
	
	/**
	 * shuffle - shuffles the cards in the deck by swapping many times.
	 * resets "top of deck" to the beginning.
	 * Note: no return value; just updates private variables.
	 */
	public void shuffle()
	{
		//--------------------
		// TODO: insert your code here.
		// Hint #1: (int)(Math.random()*52) will give you an integer from 0..51, inclusive.
		// Hint #2: 52 is not the number you want for this deck.
		for (int i = 0; i < 150; i++)
		{
			int a = (int)(Math.random()*81);
			int b = (int)(Math.random()*81);
			
			Card temp = Deck[a];
			Deck[a] = Deck[b];
			Deck[b] = temp;
		}
		topOfDeck = 80;
		//--------------------
		
	}
	
	/**
	 * outOfCards - determines whether the "top of deck" has extended beyond the end of the Deck.
	 * @return - boolean; whether the top of deck is past the end of the deck
	 */
	public boolean outOfCards()
	{
		boolean pastEndOfDeck = false;
		//--------------------
		//TODO: insert your code here
		if (topOfDeck < 0)
			pastEndOfDeck = true;
		//--------------------
		return pastEndOfDeck;
	}
	
	
	/**
	 * toString - lists all the cards in the deck.
	 * @return a String with all the cards in it, in the current order, 
	 * with a marker (e.g., "-->" vs. "   ") where the top of the Deck is.
	 */
	public String toString()
	{
		String result = "";
		//--------------------
		// TODO: insert your code here. (optional, but suggested)
		// this is not something you'll use in the game, but might be handy
		//    for debugging.
		for (int i = 0; i > 81; i++)
		{
			if (i == topOfDeck)
				result += "-->";
			else
				result += "   ";
			result += Deck[i] + "\n";
		}
		//--------------------
		return result;
	}
	
}

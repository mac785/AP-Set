/**
 * the Board class holds and displays 12 - 15 cards. (Typically,
 * it holds 12, but if the player is stumped, they can deal 3 more - this
 * is an advanced feature, so don't worry about it for now.)
 * Cards are selected in groups of three - if they form a "SET," they are
 * removed from the board and another three cards are automatically 
 * dealt into the vacated spots.
 */
public class Board {
	
	Card[] displayedCards;
	Deck gameDeck;
	/**
	 * constructor - set up the board's variables, including dealing 12 cards.
	 */
	public Board()
	{
		displayedCards = new Card[15];
		gameDeck = new Deck();
		//--------------------
		// fill the first 12 slots with cards from the deck.
		// leave the last 3 as null for now.
		// TODO: Insert your code here.
		for(int i=0; i<12; i++){
			Card tempCard = gameDeck.dealCard();
			displayedCards[i] = tempCard;
		}
		//--------------------
	}
	
	/**
	 * getCardAtLoc - accesses the card at a given location
	 * @param loc
	 * @return a copy of the card that is stored at location loc,
	 * 			or null, if there is none there.
	 * precondition: loc is a valid location from 0-14, inclusive.
	 */
	public Card getCardAtLoc(int loc)
	{
		Card c = null;
		//--------------------
		// TODO: Insert your code here
		c = displayedCards[loc];
		//--------------------
		return c;
	}
	
	/**
	 * isLegal - determines whether the three cards at the given locations
	 * are a "SET."
	 * @param cardLocation0
	 * @param cardLocation1
	 * @param cardLocation2  // alternately, use a small array.
	 * @return whether (true/false) these cards are a "SET."
	 * A SET is formed when for each of the four categories, all the cards 
	 * are the same, or all are different. For example, here is a "SET":
	 * 0: {**} {**} {**}
	 * 1: [**] [**]
	 * 2: <**>
	 * this is a "SET" because: a) the brackets are different on all three 
	 * cards; b) the number of groups is different on all three cards; 
	 * c) the size of the groups are the same on all three cards; and d)
	 * the icon is the same on all three cards.
	 * Here's another example of a "SET":
	 * 0: {•} {•}
	 * 1: {ooo} {ooo}
	 * 2: {**} {**}
	 * In this case the brackets and number of groups are constant, but
	 * the icon and the size of the groups are all different.
	 * Here's an example of a non-"SET."
	 * 0: {o} {o}
	 * 1: <•> <•> <•>
	 * 2: [o]
	 * In this case, the group sizes are all the same, the number of groups
	 * are all different, the brackets are all different, BUT two of the
	 * cards have the icon "o" and one has the icon "•." So this is NOT a "SET."
	 * Another example of a non-"SET.":
	 * 0: {**} {**} {**}
	 * 1: {•}
	 * 2: <ooo> <ooo>
	 * In this case, it is the bracket types that fail; there are two cards with
	 * curly brackets and one with angle brackets.
	 * Note: If you are given the same card twice (or three times), it is illegal.
	 * Note: If any of the cards are null, it is illegal.
	 */
	public boolean isLegal(Card a, Card b, Card c)
	{
		boolean legal = false;
		//--------------------
		// Hint: there is a fancy math trick for making this work, involving
		//       factors of 3. You should not need a ton of "if" statements!!!!
		//       See me if you have questions.
		
		//Jamie Notes: Add the three values for each parameter together and divide by three. If there is no remainder, then it is all good.
		
		// TODO: insert your code here.
		if (a!=null&&b!=null&&c!=null&&
			((a.GetMySize()+b.GetMySize()+c.GetMySize())%3==0)&&
			((a.GetMyBracket()+b.GetMyBracket()+c.GetMyBracket())%3==0)&&
			((a.GetMyGroup()+b.GetMyGroup()+c.GetMyGroup())%3==0)&&
			((a.GetMyIcon()+b.GetMyIcon()+c.GetMyIcon())%3==0)&&
			a!=b&&a!=c&&b!=c) {
			legal = true;
		}
		//--------------------
		return legal;
	}
	
	/**
	 * dealThreeCards - if there are fewer than 15 cards on the board,
	 * and if there are still cards in the deck, deal three cards from
	 * the deck and put them into the first three locations that contain
	 * null.
	 */
	public void dealThreeCards(int totalCardsOnBoard)
	{
		//--------------------
		// TODO: insert your code here.	
		for(int i=0; i<totalCardsOnBoard; i++){
			if(displayedCards[i] == null){
				displayedCards[i] = gameDeck.dealCard();
			}
		}
		//--------------------
	}
	
	/**
	 * remove3Cards - removes three cards from the board by replacing them with null.
	 * Optional: if there are remaining cards in locations 12, 13, or 14, move
	 * them into empty locations.
	 * If there are fewer than 12 cards remaining and there are cards in the deck,
	 * fill in empty places with three cards dealt from the deck.
	 * @param cardLocation0
	 * @param cardLocation1
	 * @param cardLocation2 // alternate version: an array of locations
	 * note: no return value; only private member variables changed.
	 * prerequisite: all three locations are within 0-14, all point to non-null cards,
	 * and there are no duplicates.
	 */
	 // TODO: 
	 // 1: write the remove3Cards() method signature.
	 // MAKE SURE THAT YOU COMMUNICATE THIS WITH THE REST OF YOUR TEAM.
	 // 2: go to BoardTest.java and write a test to make sure that this is
	 // working - I think you can base it on the number of cards left.
	 // 3: write the method and make sure that it passes the test.
	public void remove3Cards(Card a, Card b, Card c){
		for (int i=0;i<15;i++){
			if (a==displayedCards[i]){
				displayedCards[i] = null;
			}
			else if(b==displayedCards[i]){
				displayedCards[i] = null;
			}
			else if(c==displayedCards[i]){
				displayedCards[i] = null;
			}
		}
		for (int i=0; i<3;i++){
			if(displayedCards[12+i]!=null){
				for(int x=0; x<12;x++){
					if(displayedCards[x]==null){
						displayedCards[x] = displayedCards[12+i];
						displayedCards[12+i] = null;
					}
				}
			}
		}
	}
	/**
	 * getNumCardsOnBoard
	 * @return the number of non-null cards on the board
	 */
	public int getNumCardsOnBoard()
	{
		int numCards = 0;
		//--------------------
		// TODO: insert your code here
		for(int i =0;i<15;i++){
			if (displayedCards[i]!=null){
				numCards++;
			}
		}
		//--------------------
		return numCards;
	}
	// TODO: write the Board's getNumCardsOnBoard method.
	
	/**
	 * toString - displays the contents of the board, along with numbers (or letters)
	 * to identify the cards for the user's input.
	 * @return - a string describing the board.
	 */
	public String toString()
	{
		String result = "";
		//--------------------
		// TODO: insert your code here.
		
		 int counter = 0;
		 
		for (int x=0; x<3;x++){
			for (int i=0; i<(cardsInUse()/3); i++){
				result += displayedCards[counter];
				result += "   ";
				counter++;
			}
			result += "\n";
		}
		
		/*
		for (Card c : displayedCards)
			if (c == null)
				result +="null\n";
			else
				result += c.toString() + "\n";
		*/
		//--------------------
		return result;
	}
	public boolean isGameOver(){
		boolean result = true;
		for(int i=0;i<cardsInUse();i++){
			for(int x=0;x<i+1;x++){
				for(int y=0;y<x+1;y++){;
					if(((x!=i && x!=y && y!=i && 
						isLegal(displayedCards[x],displayedCards[y],displayedCards[i]))) ||
						(!gameDeck.outOfCards() && getNumCardsOnBoard()<12)){
						result = false;
					}
					
				}
			}
		}
		return result;
	}
	public int cardsInUse(){
		int result = 0;
		for(int i=0; i<15; i++){
			if (displayedCards[i] != null){
				result++;
			}
		}
		return result;
	}
	//Ignore this, it was for my testing purposes
	public boolean isGameOverComplex(){
		boolean result = true;
		for(int i=0;i<cardsInUse();i++){
			for(int x=0;x<i+1;x++){
				for(int y=0;y<x+1;y++){;
					if((x!=i && x!=y && y!=i && isLegal(displayedCards[x],displayedCards[y],displayedCards[i]))){
						result = false;
					}
					
				}
			}
		}
		return result;
	}
}

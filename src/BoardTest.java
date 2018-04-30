import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest 
{

	Board theBoard;
	@Before
	public void setUp() throws Exception 
	{
		theBoard = new Board();
	}

	@Test
	public void testIsLegal() 
	{
		Card a = new Card(0,0,0,2);
		Card b = new Card(1,0,1,2);
		Card c = new Card(2,0,2,2);
		Card d = new Card(1,1,1,1);
		Card e = new Card(1,2,1,0);
		
		assertTrue(theBoard.isLegal(a, b, c));
		assertTrue(theBoard.isLegal(b, d, e));
		assertFalse(theBoard.isLegal(a, b, d));
		assertFalse(theBoard.isLegal(c, d, e));
		assertFalse(theBoard.isLegal(a, a, a));
		assertFalse(theBoard.isLegal(b, null, c));
	}

	@Test
	public void testGetNumCardsOnBoardAndDeal3() 
	{
		Board secondBoard = new Board();
		secondBoard.dealThreeCards(12);
		System.out.println(secondBoard);
		assertEquals(12,secondBoard.getNumCardsOnBoard());
		secondBoard.dealThreeCards(15);
		assertEquals(15,secondBoard.getNumCardsOnBoard());
	}

	@Test
	public void testRemove3AndGetNum()
	{
		//-------------------- 
		// TODO: Insert your code here. 
		// When you have, delete the fail message below.
		Board thirdBoard = new Board();
		Card a = thirdBoard.displayedCards[1];
		Card b = thirdBoard.displayedCards[2];
		Card c = thirdBoard.displayedCards[3];
		thirdBoard.remove3Cards(a, b, c);
		assertEquals(9,thirdBoard.getNumCardsOnBoard());
	}
	@Test
	public void testGameOverComplex(){
		Board secondBoard = new Board();
		secondBoard.dealThreeCards(12);
		System.out.println(secondBoard);
		assertEquals(12,secondBoard.getNumCardsOnBoard());
		secondBoard.dealThreeCards(15);
		assertEquals(15,secondBoard.getNumCardsOnBoard());
		
		assertEquals(false, secondBoard.isGameOverComplex());
	}
	
}

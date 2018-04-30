import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The Referee class keeps track of a Board, which in turn 
 * holds a deck of cards. The Referee is responsible for communicating 
 * the player and the board to make sure that the board is displayed 
 * regularly, the user is asked for "SET"s of cards, and the board is
 * consulted on whether the user is correct before removing them.
 * If the board is empty, or the player gives up, the player can play again.
 * Advanced: if the player is stumped with 12 cards, give him/her the
 * chance to add three more cards.
 */
public class Referee {
	private Board theBoard;
	/**
	 * constructor
	 */
	// TODO: write the Referee's constructor method.
	
	public Referee() {
		theBoard = new Board();
	}
	/**
	 * playGame - the main game loop for the program.
	 */
	public void playGame()
	{
		System.out.println("Playing game."); // placeholder code
		theBoard.dealThreeCards(12);
		System.out.println("Cards Dealt");
		while (theBoard.isGameOver() == false) {
			System.out.println("Entered Ref loop");
			theBoard.dealThreeCards(12);
			System.out.println(theBoard);
			getMove();
			System.out.println("\n\n\n\n\n\n\n");
		}
		System.out.println("You Win!");
	}
	
	/**
	 * Asks the player for a move and keeps asking until it gets a valid move, then it makes the move.
	 */
	private void getMove() {
		System.out.println("What is the first card you would like to pick?");
		int firstChoice = getInt();
		System.out.println("What is the second card you would like to pick?");
		int secondChoice = getInt();
		System.out.println("What is the third card you would like to pick?");
		int thirdChoice = getInt();
		Card card1 = theBoard.getCardAtLoc(firstChoice - 1);
		Card card2 = theBoard.getCardAtLoc(secondChoice - 1);
		Card card3 = theBoard.getCardAtLoc(thirdChoice - 1);
		
		while (theBoard.isLegal(card1, card2, card3) == false){
			System.out.println("You can't make that move! Please try again.");
			System.out.println("What is the first card you would like to pick?");
			firstChoice = getInt();
			System.out.println("What is the second card you would like to pick?");
			secondChoice = getInt();
			System.out.println("What is the third card you would like to pick?");
			thirdChoice = getInt();
			card1 = theBoard.getCardAtLoc(firstChoice - 1);
			card2 = theBoard.getCardAtLoc(secondChoice - 1);
			card3 = theBoard.getCardAtLoc(thirdChoice - 1);
		}
		
		theBoard.remove3Cards(card1, card2, card3);
	}
	
	
	/**
	 * waits for the user to enter an integer and keeps asking until it gets one.
	 * @return the integer the user types in.
	 */
	public int getInt()
	{   // I've written this one for you. 
		// It's a little complicated, and I don't expect you to follow it yet,
		// but if you are curious, I've included an explanation. - HH
		Scanner keyboardReader = new Scanner(System.in);
		int result;
		while (true)
		{
			/* we're about to do something that might crash the program - 
			  ask the user for an integer. If they do, great, but they
			  might give us a string that doesn't translate, like "four thousand
			  ninety six" or "as;jken dinka;ds  askdfj ", and then the program
			  will die with a message that there is an "InputMismatchException."
			  So we acknowledge that this is risky with a "try" statement. By 
			  doing so, we can "catch" the exception BEFORE it stops the program
			  and deal with that situation INSTEAD of crashing. The program execution
			  jumps straight from the line where the error occurs (in this case, 
			  the nextInt command) to the "catch" block.
			  So this loop has us continue to ask for numbers until the nextInt()
			  doesn't throw an exception, at which point, it will break out. */
			try 
			{
				result = keyboardReader.nextInt();
				break; // leave the loop now.
			}
			catch (InputMismatchException nfe)
			{
				System.out.println("Please enter an integer.");
			}
			keyboardReader.next(); // clears any extra characters.
		}
		return result;
	}
}

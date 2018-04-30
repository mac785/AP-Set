import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

	private Card A,B,C,D,E;
	
	@Before
	public void setUp() throws Exception {
		A = new Card(2,2,0,0);
		B = new Card(1,0,0,1);
		C = new Card(1,1,2,1);
		D = new Card(0,0,1,2);
		E = new Card(1,2,1,0);
	}

	@Test
	public void testToString() {
		assertEquals("[•••]",			A.toString());
		assertEquals("{o}",				B.toString());
		assertEquals("{oo}{oo}{oo}", 	C.toString());
		assertEquals("<*> <*>",			D.toString());
		assertEquals("[ooo] [ooo]",		E.toString());
		
		assertNotEquals("<ooo>", 		A.toString());
		assertNotEquals("{oo}", 			B.toString());
		assertNotEquals("",				C.toString());
	}

}


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCases {

	@Test
	public void verifyMessageTypesForCategoryA() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageTypes((byte) 'a'),
				new char[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'X'});
	}

	@Test
	public void verifyMessageTypesForCategoryD() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageTypes((byte) 'd'), new char[]{' '});
	}

	@Test
	public void verifyMessageTypesForCategoryF() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageTypes((byte) 'f'), new char[]{' '});
	}

	@Test
	public void verifyMessageTypesForCategoryC() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageTypes((byte) 'C'), new char[]{' '});
	}

	@Test
	public void verifyMessageTypesForCategoryH() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageTypes((byte) 'H'),
				new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P'});
	}

	@Test
	public void verifyMessageTypesForCategoryK() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageTypes((byte) 'k'),
				new char[]{' ', 'F', 'I', 'R', 'T', 'A', 'B', 'O', 'C', 'X', 'Y'});
	}

	@Test
	public void verifyMessageTypesForCategoryQ() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageTypes((byte) 'q'),
				new char[]{' ', 'F', 'I', 'R', 'T', 'A', 'B', 'O', 'C', 'X', 'Y'});
	}

	@Test
	public void verifyMessageTypesForCategoryY() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(new char[]{' ', 'I'},
				targetMethods.getMessageTypes((byte) 'Y'));
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void verifyMessageTypesForCategoryAUpperCase() {
		TargetMethods targetMethods = new TargetMethods();
		targetMethods.getMessageTypes((byte) 'A');
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void verifyMessageTypesForCategoryS() {
		TargetMethods targetMethods = new TargetMethods();
		targetMethods.getMessageTypes((byte) 's');
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void verifyMessageTypesForUnsupportedCategory() {
		TargetMethods targetMethods = new TargetMethods();
		targetMethods.getMessageTypes((byte) 10);
	}

	@Test
	public void verifyMessageLengthForCategoryA() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('a', ' ', ' '), 43);
	}

	@Test
	public void verifyMessageLengthForCategoryATypeA() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('a', 'A', ' '), 43);
	}

	@Test
	public void verifyMessageLengthForCategoryD() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('d', ' ', ' '), 30);
	}

	@Test
	public void verifyMessageLengthForCategoryF() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('f', ' ', ' '), 72);
	}

	@Test
	public void verifyMessageLengthForCategoryK() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('k', ' ', ' '), 43);
	}

	@Test
	public void verifyMessageLengthForCategoryKTypeR() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('k', 'R', 'G'), 43);
	}

	@Test
	public void verifyMessageLengthForCategoryQ() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('q', ' ', ' '), 29);
	}

	@Test
	public void verifyMessageLengthForCategoryQTypeE() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('q', 'X', 'M'), 29);
	}

	@Test
	public void verifyMessageLengthForCategoryC() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('C', ' ', ' '), 450);
	}

	@Test
	public void verifyMessageLengthForCategoryH() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('H', 'P', ' '), 450);
	}

	@Test
	public void verifyMessageLengthForCategoryHTypeG() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('H', 'G', ' '), 450);
	}

	@Test
	public void verifyMessageLengthForCategoryY() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('Y', ' ', ' '), 27);
	}

	@Test
	public void verifyMessageLengthForCategoryYTypeI() {
		TargetMethods targetMethods = new TargetMethods();
		assertEquals(targetMethods.getMessageLength('Y', 'I', ' '), 27);
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void verifyMessageLengthForCategoryAIndicatorI() {
		TargetMethods targetMethods = new TargetMethods();
		targetMethods.getMessageLength('a', ' ', 'I');
	}

}

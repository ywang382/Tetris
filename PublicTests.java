package tests;

import org.junit.Test; 
import model.*;

import static org.junit.Assert.*;

public class PublicTests {
	
	final int ROWS = 22, COLS = 10;
	
	@Test
	public void testMoveDown() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(6);  // S
		
		// first piece appearance
		assertTrue(TestingSupport.correctResults("data/pubStartS.txt", game.toString()));

		process(Action.MOVEDOWN, game, 4);
		assertTrue(TestingSupport.correctResults("data/pubTestMoveDown.txt", game.toString()));
	}
	
	@Test
	public void testMoveRight() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(3);  // T
		
		// first piece appearance
		assertTrue(TestingSupport.correctResults("data/pubStartT.txt", game.toString()));

		process(Action.MOVERIGHT, game, 3);
		assertTrue(TestingSupport.correctResults("data/pubTestMoveRight.txt", game.toString()));
	}
	
	@Test
	public void testMoveLeft() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(4);  // J
		
		// first piece appearance
		assertTrue(TestingSupport.correctResults("data/pubStartJ.txt", game.toString()));

		process(Action.MOVELFT, game, 2);
		assertTrue(TestingSupport.correctResults("data/pubTestMoveLeft.txt", game.toString()));
	}
	
	@Test
	public void testFall() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(1);  // I
		
		// first piece appearance
		assertTrue(TestingSupport.correctResults("data/pubStartI.txt", game.toString()));

		process(Action.FALL, game, 4);
		assertTrue(TestingSupport.correctResults("data/pubTestFall.txt", game.toString()));
	}
	
	@Test 
	public void simpleIRotate() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(1);
		
		//initial placement
		assertTrue(TestingSupport.correctResults("data/pubStartI.txt", game.toString()));
		

		//rotates 4 times and checks
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubIRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubIRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubIRotate3.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubIRotate4.txt", game.toString()));
	}
	
	@Test 
	public void simpleORotate() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(2);
		
		//initial placement
		assertTrue(TestingSupport.correctResults("data/pubStartO.txt", game.toString()));

		//rotates 4 times and checks
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubStartO.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubStartO.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubStartO.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubStartO.txt", game.toString()));
	}

	@Test 
	public void simpleTRotate() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(3);
		
		//rotate which should not work
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubStartT.txt", game.toString()));

		//rotates should work. Does 4 of them
		//move down so rotation is possible
		game.processCell(Action.MOVEDOWN);
		assertTrue(TestingSupport.correctResults("data/pubTRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubTRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubTRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubTRotate3.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubTRotate0.txt", game.toString()));
	}

	@Test 
	public void simpleJRotate() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(4);
		
		//initial placement
		assertTrue(TestingSupport.correctResults("data/pubStartJ.txt", game.toString()));

		//does four rotates to check
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubJRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubJRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubJRotate3.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubJRotate0.txt", game.toString()));
	}

	@Test 
	public void simpleLRotate() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(5);
		
		//initial placement
		assertTrue(TestingSupport.correctResults("data/pubStartL.txt", game.toString()));
		
		//does four rotates to check
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubLRotate1.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubLRotate2.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubLRotate3.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubLRotate0.txt", game.toString()));
	}

	@Test
	public void simpleSRotate() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(6);

		//rotate which should not work
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubStartS.txt", game.toString()));

		//rotates should work, rotates 4 times
		//move down first to allow rotation
		game.processCell(Action.MOVEDOWN);
		assertTrue(TestingSupport.correctResults("data/pubSRotate0.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubSRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubSRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubSRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubSRotate0.txt", game.toString()));
	}

	@Test
	public void simpleZRotate() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(7);

		//rotate which should not work
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubStartZ.txt", game.toString()));

		//rotates should work, rotates 4 times
		//move down first to allow rotation
		game.processCell(Action.MOVEDOWN);
		assertTrue(TestingSupport.correctResults("data/pubZRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubZRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubZRotate0.txt", game.toString()));
		
		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubZRotate1.txt", game.toString()));

		game.processCell(Action.ROTATE);
		assertTrue(TestingSupport.correctResults("data/pubZRotate0.txt", game.toString()));
	}
	
	@Test
	public void testGame0() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(7);
		process(Action.MOVERIGHT, game, 3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		process(Action.MOVELFT, game, 5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		process(Action.MOVELFT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		process(Action.MOVEDOWN, game, 3);
		game.processCell(Action.ROTATE);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		process(Action.MOVELFT, game, 2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(7);
		process(Action.MOVELFT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(4);
		process(Action.MOVERIGHT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVERIGHT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 2);
		process(Action.ROTATE, game, 2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		process(Action.MOVERIGHT, game, 2);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		process(Action.MOVERIGHT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(2);
		game.processCell(Action.FALL);
		
		assertTrue(TestingSupport.correctResults("data/pubTestGame0.txt", game.toString()));
	}

	@Test
	public void testGame1() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 6);
		game.processCell(Action.ROTATE);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		process(Action.MOVEDOWN, game, 3);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(7);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(2);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 3);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(5);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.ROTATE);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.MOVERIGHT);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(4);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.MOVELFT);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(1);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(5);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVEDOWN);
		game.processCell(Action.FALL);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(2);
		game.processCell(Action.MOVEDOWN);
		game.nextAnimationStep(2);
		game.processCell(Action.MOVEDOWN);
		
		assertTrue(TestingSupport.correctResults("data/pubTestGame1.txt", game.toString()));
	}

	@Test
	public void testgame2() {
		Tetris game = new Tetris(ROWS, COLS);
		game.nextAnimationStep(1);
		process(Action.MOVELFT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(4);
		process(Action.MOVERIGHT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		process(Action.MOVELFT, game, 5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.MOVELFT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		process(Action.MOVEDOWN, game, 2);
		process(Action.MOVERIGHT, game, 2);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.MOVERIGHT);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		process(Action.MOVERIGHT, game, 4);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		game.processCell(Action.MOVELFT);
		process(Action.MOVEDOWN, game, 2);
		game.processCell(Action.ROTATE);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(5);
		game.processCell(Action.FALL);
		game.nextAnimationStep(7);
		game.processCell(Action.FALL);
		game.nextAnimationStep(6);
		game.processCell(Action.FALL);
		game.nextAnimationStep(4);
		game.processCell(Action.FALL);
		game.processCell(Action.FALL);
		game.nextAnimationStep(7);
		game.processCell(Action.FALL);
		game.nextAnimationStep(3);
		game.processCell(Action.FALL);
		game.nextAnimationStep(1);
		game.processCell(Action.FALL);
		
		assertTrue(TestingSupport.correctResults("data/pubTestGame2.txt", game.toString()));
	}
	
	/**
	 * Performs processCell on the game with the given action, N times
	 * @param action
	 * @param game
	 * @param N
	 */
	private void process(Action action, Game game, int N) {
		for (int i = 0; i < N; i++) {
			game.processCell(action);
		}
	}
}

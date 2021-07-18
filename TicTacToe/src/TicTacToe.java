
public class TicTacToe {

	public static void main(String[] args) throws Exception {
		/*
		 * We create a board and a game object
		 */
		Board b = new Board();
		Game g = new Game(b);
		/*
		 * We start the game
		 */
		g.gameLoop();
	}

}




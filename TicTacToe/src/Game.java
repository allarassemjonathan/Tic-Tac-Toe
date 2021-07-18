// will need an import or two
import java.util.*;
public class Game {
	private Board gameBoard;
	
	/**
	 * Don't forget the constructor and don't forget to add comments!
	 */
	public Game(Board gameBoard){
		this.gameBoard = gameBoard;
		
	}
	/**
	 * 
	 * @throws Exception if inputs are strings
	 * or if inputs are not between 1 and 9
	 * 
	 *  This method is the core of the game
	 */
	public void gameLoop() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		
		int locationX;
		int locationO;
		boolean okX = false;
		boolean okO = false;
		/*
		 * while true , the scanner will grab inputs from our two players!
		 */
		while(true) {
			do {
				try {
					/*
					 * input of player X is collected
					 */
					locationX = sc.nextInt();
					if(locationX >= 1 && locationX <= 9) {
						okX = false;
					}
					this.gameBoard.play('X', locationX);
					
				}
				catch(InputMismatchException e) {
					System.out.println("STRING ARE NOT ALLOW!");
					okX = true;
					sc.next();
					continue;
				}
			}while(okX);
			
			if(this.gameBoard.hasWon('X')) {
				break;
			}
			if(this.gameBoard.isFull()) {
				System.out.println("THE GAME IS DRAW! NO ONE WON! START A NEW GAME");
				break;
			}
			
			do {
				try {
					/*
					 * input of player O is collected
					 */
					locationO = sc.nextInt();
					this.gameBoard.play('O', locationO);
					if(locationO >= 1 && locationO <= 9) {
						okO = false;
					}
				}
				catch(InputMismatchException e) {
					System.out.println("STRING ARE NOT ALLOW!");
					okO = true;
					sc.next();
				}
			}while(okO);
			/*
			 * If one player win break the loop
			 */
			if(this.gameBoard.hasWon('O')) {
				break;
			}
			/*
			 * If the game is full break the loop
			 */
			if(this.gameBoard.isFull()) {
				System.out.println("THE GAME IS DRAW! NO ONE WON! START A NEW GAME");
				break;
			}
	
		}
	
	}
		
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {
    private static final int SIZE = 3;
    private static final char EMPTY = ' ';
    private char[][] currentBoard;
	
	/**
	 * Creates an empty Board
	 */
	public Board(){
		currentBoard = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.currentBoard[i][j] = EMPTY;
			}
		}
	}
	
	/**
	 * @param location should be between 1 and 9 inclusive
	 * @return 0-indexed row for the given location
	 */
	public static int getRow(int location){
		// Integer division truncates any fractional part
		return (location-1) / SIZE;
	}
	
	/**
	 * @return 0-indexed column for the given location
	 */
	public static int getColumn(int location){
	   return (location-1) % SIZE;
	}
	
	/**
	 * Add move onto the board
	 * @throws Exception if location is invalid or already full
	 */
	public void play(char currentPlayer, int location) throws Exception {
	   // implement and throw exception if invalid
		boolean invalid = false;
		int countor = 0;
		do {
			try {
				/*
				 * As long as the inputs are invalid you are stuck 
				 * in this loop
				 */
				if(invalid) {
					Scanner sc = new Scanner(System.in);
					location = sc.nextInt();
					invalid = false;
				}
				if(this.isFull()) {
					throw new Exception("BOARD IS FULL, START A NEW GAME!");
				}
				else if(this.isFilled(this.getRow(location), this.getColumn(location))) {
					throw new Exception("THIS POSITION IS ALREADY FILLED BY YOUR OPPONENT");
				}
				this.currentBoard [this.getRow(location)][this.getColumn(location)] = currentPlayer;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("ENTER A NUMBER BETWEEN 1 AND 9");
				invalid = true;	
			}
			/*
			 * This provide a second layer to handle exceptions. If a user enter an unappropriated number
			 * the exceptions will be handle inside the play method and thus pass the inputMismatch 
			 * exceptions handler of the gameLoop method. If then the user follows with a string
			 * the play method will be able to handle that.
			 */
			catch(InputMismatchException e) {
				System.out.println("ENTER A NUMBER!!");
				invalid = true;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				invalid = true;
				
			}
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(this.currentBoard[i][j] + " ");
				}
				System.out.println();
			}
		}while(invalid);
	}
	
	/**
	 * @return true if the currentBoard already has an 'X' or an 'O' at
	 * [row][column].
	 */
	public boolean isFilled(int row, int col) {		
		return (this.currentBoard[row][col] != EMPTY);
	}
	
	/**
	 * @return true if all of the spaces on the board are occupied
	 */
	public boolean isFull(){
		Boolean check = true;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				Boolean test = (this.currentBoard[i][j] == 'X' || this.currentBoard[i][j] == 'O' );
				check = check && test;
			}
			
		}
		return check;
	}
	
	/**
	 * @return true currentPlayer has won the game
	 */
	
	public boolean hasWon(char currentPlayer) {
		/*
		 * This arraylist will hold the locations grabbed from the positions
		 * played by players X and O
		 */
		ArrayList<Integer> arrayloc = new ArrayList<>();
		/*
		 * num will allow us to convert filled position of the array 
		 * in locations where our currentPlayer played
		 */
		Integer num = 1;
		Integer countorLD = 0;
		Integer countorRD = 0;
		Integer countorLC = 0;
		Integer countorMC = 0;
		Integer countorRC = 0;
		Integer countorFR = 0;
		Integer countorSR = 0;
		Integer countorTR = 0;
		Boolean hasWin = false;
			/*
			 *  We pass the location into an array
			 */
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if(this.currentBoard[i][j] == currentPlayer) {
						arrayloc.add(num);
					}
					num++;
				}
			}
			
			/*
			 *The criteria for the winning of one player are the following:
			 *
			 * For locations an array of the location of one player,
			 * Left starting diagonal alignment: locations mod4 = 1 (LD)
			 * Right starting diagonal alignment:locations mod2 = 1 and location !=1 and 9
			 * 
			 * Left column alignment: locations mod3 = 1
			 * Middle column alignment: locations mod3 = 2
			 * Right column alignment: locations mod3 = 0
			 * 
			 * First row alignment: locations div3 = 0
			 * Second row alignment: locations div3 = 1
			 * Third row alignment: locations div3 = 2
			 * 
			 */
			for (int i = 0; i< arrayloc.size(); i++) {
				if(arrayloc.get(i) % 4 == 1) {
					countorLD++;
				}
				if(arrayloc.get(i) % 2 == 1 && arrayloc.get(i)!=1 && arrayloc.get(i)!=9){
					countorRD++;
				}
				if(arrayloc.get(i) % 3 == 1) {
					countorLC++;
				}
				if(arrayloc.get(i) % 3 == 2) {
					countorMC++;
				}
				if(arrayloc.get(i) % 3 == 0) {
					countorRC++;
				}
				if((arrayloc.get(i)-1)/3 == 0) {
					countorFR++;
				}
				if((arrayloc.get(i)-1)/3 == 1) {
					countorSR++;
				}
				if((arrayloc.get(i)-1)/3 == 2) {
					countorTR++;
				}

			}
			
			/*
			 * If one of these countors's value is 3 then hasWin will be true
			 * One player will win and the game will stop
			 */
			
			hasWin = (countorLD == 3)||(countorRD == 3)||(countorLC == 3)|| (countorMC == 3)||(countorRC == 3)||(countorFR == 3)||(countorSR == 3)||(countorTR == 3);
			if(hasWin) {
				System.out.println(currentPlayer + " WON!!");
			}
			return hasWin;
		
	 }
}

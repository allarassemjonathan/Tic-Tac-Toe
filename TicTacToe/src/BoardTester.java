import java.util.Scanner;
public class BoardTester {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		/*
		Integer countorLD = 0;
		Integer countorRD = 0;
		Integer countorLC = 0;
		Integer countorMC = 0;
		Integer countorRC = 0;
		Integer countorFR = 0;
		Integer countorSR = 0;
		Integer countorTR = 0;
		Boolean hasWin = false;
		
		
		
		ArrayList<Integer> arrayloc = new ArrayList<>();
		
		arrayloc.add(1);
		//arrayloc.add(2);
		arrayloc.add(3);
		//arrayloc.add(5);
		//arrayloc.add(6);
		arrayloc.add(4);
		//arrayloc.add(7);
		//arrayloc.add(8);
		arrayloc.add(9);
		
		
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
	
		
		hasWin = (countorLD == 3)||(countorRD == 3)||(countorLC == 3)|| (countorMC == 3)||(countorRC == 3)||(countorFR == 3)||(countorSR == 3)||(countorTR == 3);
		if(hasWin) {
			System.out.println("Someone won");
		}
		else {
			System.out.println("Nobody wins");
		}
		
		if(countorLD == 3) {
			System.out.println("left to right diagonal");
		}
		else {
			System.out.println("no left to right diagonal");
		}
		if(countorRD == 3) {
			System.out.println("right to left diagonal");
		}
		else {
			System.out.println("no rigth to left diagonal");
		}
		if(countorLC == 3) {
			System.out.println("left row alignment");
		}
		else {
			System.out.println("no left row alignment");
		}
		if(countorMC == 3) {
			System.out.println("middle column alignment");
		}
		else {
			System.out.println("no middle column alignment");
		}
		if(countorRC == 3) {
			System.out.println("right column alignment");
		}
		else {
			System.out.println("no right column alignment");
		}
		if(countorFR == 3) {
			System.out.println("first row alignment");
		}
		else {
			System.out.println("no first row alignment");
		}
		if(countorSR == 3) {
			System.out.println("second row alignment");
		}
		else {
			System.out.println("no second row alignment");
		}
		if(countorTR == 3) {
			System.out.println("third row alignment");
		}
		else {
			System.out.println("no third row alignment");
		}
	*/
		Board b = new Board();
		int locationX;
		int locationO;
		
		
		while(true) {
			
			locationX = sc.nextInt();
			b.play('X', locationX);
			if(b.hasWon('X')) {
				break;
			}
			if(b.isFull()) {
				System.out.println("THE GAME IS DRAW! NO ONE WON! START A NEW GAME");
				break;
			}
			
			
			locationO = sc.nextInt();
			b.play('O', locationO);
			if(b.hasWon('O')) {
				break;
			}
			if(b.isFull()) {
				System.out.println("THE GAME IS DRAW! NO ONE WON! START A NEW GAME");
				break;
			}
			
			
			
		}
		
	}

	public static boolean testGetColumn(){
		Board b = new Board();
		
		int testMove0 = 4;
		int expectedCol0 = 0;
		if (b.getColumn(testMove0) != expectedCol0) {
			return false;	
		}
		
		int testMove1 = 5;
		int expectedCol1 = 1;
		if (b.getColumn(testMove1) != expectedCol1) {
			return false;	
		}
		
		int testMove2 = 3;
		int expectedCol2 = 2;
		if (b.getColumn(testMove2) != expectedCol2) {
			return false;	
		}
	
		return true;
	}
	
}

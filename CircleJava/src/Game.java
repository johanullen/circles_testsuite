import java.util.Random;
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board b = new Board(9,9);
		b.printBoard();
		putRandom(b,50);
		b = new Board(9,9);
		b.printBoard();
		
		//putColumn(b,1);
		//putRow(b,4);
	}
	
	private static void putColumn(Board b, int x){
		System.out.println("Fill " + x +"th column");
		for(int i=0; i<9; i++){
			put(b,x,i);
		}
	}
	
	private static void putRow(Board b, int y){
		System.out.println("Fill " + y + "th row");
		for(int i=0; i<9; i++){
			put(b,i,y);
		}
	}
	
	private static void putRandom(Board b, int n){
		System.out.println("Put " + n +" random");
		int totS=0;
		for(int i=0; i<n; i++){
			int x = randInt(0,8);
			int y = randInt(0,8);
			totS+=put(b,x,y);	
		}
		System.out.println("Total score = " + totS);
	}
	
	private static int put(Board b, int x, int y){
		int score=0;
		try {
			System.out.println("Mark at " + x + ", " + y);
			score = b.put(x, y);
			System.out.println("Score: " + score);
			b.printBoard();
		} catch (Exception e) {
			System.out.println("Illegal position: " + x + ", " + y);
			// e.printStackTrace();
		}
		return score;
	}
	
	private static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}

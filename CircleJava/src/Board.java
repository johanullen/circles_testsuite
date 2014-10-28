public class Board {
	private int xLim;
	private int yLim;
	private boolean[][] board;

	public Board(int Xlim, int Ylim) {
		this.yLim = Ylim;
		this.xLim = Xlim;
		board = new boolean[Xlim][Ylim];
		for (int i = 0; i < Xlim; i++) {
			for (int j = 0; j < Ylim; j++) {
				board[i][j] = false;
			}
		}
	}

	public int put(int x, int y) throws Exception {
		if (board[x][y]) {
			throw new Exception("position " + x + ", " + y
					+ " is already placed");
		}
		if (x > xLim || x < 0) {
			throw new Exception("x=" + x + " is out of bounds");
		}
		if (y > yLim || y < 0) {
			throw new Exception("y=" + y + " is out of bounds");
		}
		board[x][y] = true;
		return calcScore(x, y);
	}

	public boolean[][] getBoard() {
		return board;
	}

	public void printBoard() {
		System.out.print("   ");
		for (int x = 0; x < xLim; x++) {
			System.out.print(" " + x + " ");
		}
		System.out.println("");
		for (int y = 0; y < yLim; y++) {
			System.out.print(" " + y + " ");
			for (int x = 0; x < xLim; x++) {
				if (board[x][y]) {
					System.out.print("|O|");
				} else {
					System.out.print("| |");
				}
			}
			System.out.println("");
			System.out.print("   ");
			for (int x = 0; x < xLim; x++) {
				System.out.print("===");
			}
			System.out.println("");
		}
	}

	private int calcScore(int x, int y) {
		int score = 0;
		int count;
		// first calc right-left
		count = 1; // for the new mark
		count += count(x, y, 1, 0); // for right of new mark
		count += count(x, y, -1, 0); // for left of new mark
		// System.out.println(count);
		if (count % 3 == 0) {
			score += count / 3;
		}
		// second calc up-down
		count = 1; // for the new mark
		count += count(x, y, 0, 1); // for up of new mark
		count += count(x, y, 0, -1); // for down of new mark
		// System.out.println(count);
		if (count % 3 == 0) {
			score += count / 3;
		}
		// third calc diag up/right-down/left
		count = 1; // for the new mark
		count += count(x, y, 1, 1); // for up/right of new mark
		count += count(x, y, -1, -1); // for down/left of new mark
		// System.out.println(count);
		if (count % 3 == 0) {
			score += count / 3;
		}
		// forth calc diag up/left-down/right
		count = 1; // for the new mark
		count += count(x, y, -1, 1); // for up/left of new mark
		count += count(x, y, 1, -1); // for down/right of new mark
		// System.out.println(count);
		if (count % 3 == 0) {
			score += count / 3;
		}
		return score;
	}

	private int count(int x, int y, int dX, int dY) {
		int count = 0;

		while ((x + dX) >= 0 && (y + dY) >= 0 && (x + dX) < xLim
				&& (y + dY) < yLim) {
			x += dX;
			y += dY;
			if (board[x][y]) {
				count++;
				// System.out.println("counting pos: " + x + ", " + y);
			} else {
				break;
			}
		}
		return count;
	}
}

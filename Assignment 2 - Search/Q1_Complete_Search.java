import java.util.*;

public class Q1_Complete_Search {


	public static int[] game(String[][] board){

		//Get number of row and columns
		int numRow = board.length;
		int numCol = board[0].length;
		int nextNumBalls = getNumOfBalls(board, numRow, numCol);
		int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE};

		array = findSolution(0,board,numRow, numCol, nextNumBalls, array);


		return array;
	}



	private static int[] findSolution(int numMoves, String[][] board, int numRow, int numCol, int nextNumBalls, int[] array){

		int currentNumBalls = getNumOfBalls(board, numRow, numCol);
		boolean moved = false;
		String[][] actualBoard = deepCopy(board, numRow, numCol);



		if(currentNumBalls > 1) {
			for(int i = 0; i < numRow; i++){
				for(int j =0; j < numCol; j++){

					boolean foundBall = board[i][j].equals("o");

					if(foundBall){

						if(checkUpMove(board, i, j, numRow, numCol)){

							actualBoard[i][j] = ".";
							actualBoard[i-1][j] = ".";
							actualBoard[i-2][j] = "o";

							int tempNumMoves = numMoves + 1;

							moved = true;

							array = findSolution(tempNumMoves, actualBoard, numRow, numCol, nextNumBalls, array);

							actualBoard = deepCopy(board, numRow, numCol);

						}

						if(checkDownMove(board, i, j, numRow, numCol)){

							actualBoard[i][j] = ".";
							actualBoard[i+1][j] = ".";
							actualBoard[i+2][j] = "o";

							int tempNumMoves = numMoves + 1 ;

							moved = true;

							array = findSolution(tempNumMoves, actualBoard, numRow, numCol, nextNumBalls, array);

							actualBoard = deepCopy(board, numRow, numCol);

						}
						if(checkLeftMove(board, i, j, numRow, numCol)){

							actualBoard[i][j] = ".";
							actualBoard[i][j-1] = ".";
							actualBoard[i][j-2] = "o";

							int tempNumMoves = numMoves + 1;

							moved = true;

							array = findSolution(tempNumMoves, actualBoard, numRow, numCol, nextNumBalls, array);

							actualBoard = deepCopy(board, numRow, numCol);

						}
						if(checkRightMove(board, i, j, numRow, numCol)){

							actualBoard[i][j] = ".";
							actualBoard[i][j+1] = ".";
							actualBoard[i][j+2] = "o";


							int tempNumMoves = numMoves + 1 ;

							moved = true;

							array = findSolution(tempNumMoves, actualBoard, numRow, numCol, nextNumBalls, array);

							actualBoard = deepCopy(board, numRow, numCol);


						}
					}
				}
			}

		}


		if(!moved || currentNumBalls == 1){

			if(currentNumBalls < array[0]  ) {
				array[0] = currentNumBalls;
				array[1] = numMoves;
			}

		}

		return array;

	}



	private static boolean checkUpMove (String[][] aBoard, int row, int col, int numRow, int numCol){

		if(row < 2) return false;							// Cannot move, it will be out of the box

		if(!aBoard[row-1][col].equals("o")) return false;	// Cannot move, no ball up of current location

		if(!aBoard[row-2][col].equals(".")) return false;   //Cannot move, no empty space after 1 hop

		//if all conditions pass, move accepted
		return true;
	}


	private static boolean checkDownMove (String[][] aBoard, int row, int col, int numRow, int numCol){

		if(row >= numRow - 2) return false;					// Cannot move, it will be out of the box

		if(!aBoard[row+1][col].equals("o")) return false;	// Cannot move, no ball down of current location

		if(!aBoard[row+2][col].equals(".")) return false;   //Cannot move, no empty space after 1 hop

		//if all conditions pass, move accepted
		return true;
	}



	private static boolean checkLeftMove (String[][] aBoard, int row, int col, int numRow, int numCol){

		if(col < 2) return false;							// Cannot move, it will be out of the box

		if(!aBoard[row][col-1].equals("o")) return false;	// Cannot move, no ball left of current location

		if(!aBoard[row][col-2].equals(".")) return false;   //Cannot move, no empty space after 1 hop

		//if all conditions pass, move accepted
		return true;
	}



	private static boolean checkRightMove (String[][] aBoard, int row, int col, int numRow, int numCol){

		if(col >= numCol - 2) return false;							// Cannot move, it will be out of the box

		if(!aBoard[row][col+1].equals("o")) return false;	// Cannot move, no ball right of current location

		if(!aBoard[row][col+2].equals(".")) return false;   //Cannot move, no empty space after 1 hop

		//if all conditions pass, move accepted
		return true;
	}


	private static String[][] deepCopy (String[][] array, int numRow, int numCol){

		String[][] copy = new String[numRow][numCol];

		for(int i = 0; i< numRow; i++){
			copy[i] = array[i].clone();
		}

		return copy;
	}


	private static int getNumOfBalls(String aBoard[][], int numRow, int numCol){

		int numOfBalls = 0;

		for(int i = 0; i < numRow; i++) {
			for (int j = 0; j < numCol; j++) {
				if(aBoard[i][j].equals("o")) numOfBalls++;
			}
		}
		return numOfBalls;
	}





}

import java.util.*;

public class Q1_Graph_Traversals {

	public static int find_exit(String[][][] jail) {

		Hashtable<Integer, ArrayList<int[]>> alreadyPast = new Hashtable<Integer, ArrayList<int[]>>();
		ArrayList<int[]> allCoordinates = new ArrayList<int[]>();
		allCoordinates.add(findStartPoint(jail));
		alreadyPast.put(0, allCoordinates);

		return find_exit(jail, 0, false, alreadyPast);
	}

	private static int find_exit(String[][][] jail, int moves, boolean escaped, Hashtable<Integer, ArrayList<int[]>> alreadyPast) {

		escaped = false;
		ArrayList<int[]> current = alreadyPast.get(moves);

		for (int[] array : current) {
			int level = array[0];
			int row = array[1];
			int column = array[2];
			if (checkIfExitPoint(jail, level, row, column)) {
				int result = moves + 1;
				return result;
			}


			if (level > 0 && jail[level - 1][row][column].equals(".")) {
				escaped = true;
				int newMoves = moves + 1;
				int newLevel = level - 1;
				jail[level][row][column] = "old";
				jail[newLevel][row][column] = "current";

				int[] newCoordinates = new int[3];
				newCoordinates[0] = newLevel;
				newCoordinates[1] = row;
				newCoordinates[2] = column;

				ArrayList<int[]> currentCoordinates = alreadyPast.get(newMoves);
				if (currentCoordinates == null) currentCoordinates = new ArrayList<int[]>();

				currentCoordinates.add(newCoordinates);

				alreadyPast.put(newMoves, currentCoordinates);


			}

			if (level < jail.length - 1 && jail[level + 1][row][column].equals(".")) {
				escaped = true;
				int newMoves = moves + 1;
				int newLevel = level + 1;
				jail[level][row][column] = "old";
				jail[newLevel][row][column] = "current";

				int[] newCoordinates = new int[3];
				newCoordinates[0] = newLevel;
				newCoordinates[1] = row;
				newCoordinates[2] = column;


				ArrayList<int[]> currentCoordinates = alreadyPast.get(newMoves);
				if (currentCoordinates == null) currentCoordinates = new ArrayList<int[]>();

				currentCoordinates.add(newCoordinates);

				alreadyPast.put(newMoves, currentCoordinates);


			}
			if (row > 0 && jail[level][row - 1][column].equals(".")) {
				escaped = true;
				int newMoves = moves + 1;
				int newRow = row - 1;
				jail[level][row][column] = "old";
				jail[level][newRow][column] = "current";

				int[] newCoordinates = new int[3];
				newCoordinates[0] = level;
				newCoordinates[1] = newRow;
				newCoordinates[2] = column;

				ArrayList<int[]> currentCoordinates = alreadyPast.get(newMoves);
				if (currentCoordinates == null) currentCoordinates = new ArrayList<int[]>();

				currentCoordinates.add(newCoordinates);

				alreadyPast.put(newMoves, currentCoordinates);


			}
			if (row < jail[level].length - 1 && jail[level][row + 1][column].equals(".")) {
				escaped = true;
				int newMoves = moves + 1;
				int newRow = row + 1;
				jail[level][row][column] = "old";
				jail[level][newRow][column] = "current";

				int[] newCoordinates = new int[3];
				newCoordinates[0] = level;
				newCoordinates[1] = newRow;
				newCoordinates[2] = column;

				ArrayList<int[]> currentCoordinates = alreadyPast.get(newMoves);
				if (currentCoordinates == null) currentCoordinates = new ArrayList<int[]>();

				currentCoordinates.add(newCoordinates);

				alreadyPast.put(newMoves, currentCoordinates);

			}

			if (column > 0 && jail[level][row][column - 1].equals(".")) {
				escaped = true;
				int newMoves = moves + 1;
				int newColumn = column - 1;
				jail[level][row][column] = "old";
				jail[level][row][newColumn] = "current";
				int[] newCoordinates = new int[3];
				newCoordinates[0] = level;
				newCoordinates[1] = row;
				newCoordinates[2] = newColumn;

				ArrayList<int[]> currentCoordinates = alreadyPast.get(newMoves);
				if (currentCoordinates == null) currentCoordinates = new ArrayList<int[]>();

				currentCoordinates.add(newCoordinates);

				alreadyPast.put(newMoves, currentCoordinates);

			}

			if (column < jail[level][row].length - 1 && jail[level][row][column + 1].equals(".")) {
				escaped = true;
				int newMoves = moves + 1;
				int newColumn = column + 1;
				jail[level][row][column] = "old";
				jail[level][row][newColumn] = "current";

				int[] newCoordinates = new int[3];
				newCoordinates[0] = level;
				newCoordinates[1] = row;
				newCoordinates[2] = newColumn;
				ArrayList<int[]> currentCoordinates = alreadyPast.get(newMoves);
				if (currentCoordinates == null) currentCoordinates = new ArrayList<int[]>();

				currentCoordinates.add(newCoordinates);

				alreadyPast.put(newMoves, currentCoordinates);

			}

		}

		if (!escaped) return -1;
		else {
			int result = moves + 1;
			return find_exit(jail, result, escaped, alreadyPast);
		}

	}


	private static boolean checkIfExitPoint(String[][][] jail, int level, int row, int column) {

		if (level > 0 && jail[level - 1][row][column].equals("E")) return true;
		if (level < jail.length - 1 && jail[level + 1][row][column].equals("E")) return true;

		if (row > 0 && jail[level][row - 1][column].equals("E")) return true;
		if (row < jail[level].length - 1 && jail[level][row + 1][column].equals("E")) return true;

		if (column > 0 && jail[level][row][column - 1].equals("E")) return true;
		if (column < jail[level][row].length - 1 && jail[level][row][column + 1].equals("E")) return true;

		return false;
	}

	private static int[] findStartPoint(String[][][] jail) {
		int[] location = new int[3];

		for (int level = 0; level < jail.length; level++) {
			for (int row = 0; row < jail[level].length; row++) {
				for (int column = 0; column < jail[level][row].length; column++) {

					if (jail[level][row][column].equals("S")) {
						location[0] = level;
						location[1] = row;
						location[2] = column;
						break;
					}
				}
			}
		}

		return location;
	}

	public static void main(String[] args) {

	}

}

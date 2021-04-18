
/**
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows
 * and 10 columns This utility works with negative and positive numbers This is
 * a utility class - there are no private data members
 * 
 * @author Mark Kasule
 *
 */
import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {
	}

	/**
	 * read from the file
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {

		// read file
		Scanner readThisFile = new Scanner(file);

		// read values as strings
		String[][] dataList = new String[10][10];

		// will hold elements from dataList as doubles
		double[][] doubleList = new double[10][10];

		// count row
		int countRow = 0;
		int countCol = 0;

		// has next
		for (int row = 0; row < dataList.length; row++) {

			for (int col = 0; col < countRow; col++) {

				// count rows and cols
				if (dataList[row] != null)
					countRow++;
				if (dataList[col] != null)
					countCol++;

				// create array
				String str = dataList[countRow][countCol];
				// convert to double
				doubleList[countRow][countCol] = Double.parseDouble(str);
			}

		}
		// close file
		readThisFile.close();
		return doubleList;
	}

	/**
	 * write to a file
	 * 
	 * @param data
	 * @param outputFile
	 * @throws java.io.FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {

		// check is passed file exits
		if (outputFile.exists()) {
			// create a file
			PrintWriter writeToFile = new PrintWriter(outputFile);

			// write to file
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					writeToFile.print(data[i][j]);
				}
				// close file
				writeToFile.close();
			}
		} else {
			System.out.println("File does not exit");
		}

	}

	/**
	 * calculate the total sum of all elements in 2d array
	 * 
	 * @param data
	 * @return total
	 */
	public static double getTotal(double[][] data) {

		double total = 0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data.length; col++)
				total += data[row][col];
		}
		return total;
	}

	/**
	 * calculate the average
	 * 
	 * @param data
	 * @return average
	 */
	public static double getAverage(double[][] data) {
		double average = getTotal(data) / (data.length);
		return average;
	}

	/**
	 * calculate the row total
	 * 
	 * @param data
	 * @param row
	 * @return row total
	 */
	public static double getRowTotal(double[][] data, int row) {

		double rowTotal = 0;

		for (int i = 0; i < data.length; i++) {
			rowTotal += data[row][i];
		}
		return rowTotal;
	}

	/**
	 * calculates the total of columns
	 * 
	 * @param data
	 * @param col
	 * @return col total
	 */
	public static double getColumnTotal(double[][] data, int col) {

		double colTotal = 0;

		for (int j = 0; j < data.length; j++) {
			colTotal += data[j][col];
		}
		return colTotal;
	}

	/**
	 * calculates the highest row value
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getHighestInRow(double[][] data, int row) {

		// holds highest number is a row
		double largestRow = data[row][0];

		for (int i = 1; i < data.length; i++) {
			if (largestRow < data[row][i]) {
				largestRow = data[row][i];
			}
		}
		return largestRow;
	}

	/**
	 * calculates the highest row index
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {

		// holds highest index is a row
		int largestRowIndex = 0;

		// holds highest number is a row
		double largestRow = data[row][0];

		for (int i = 1; i < data.length; i++) {
			if (data[row][largestRowIndex] < data[row][i]) {
				// largest number
				largestRow = data[row][i];
				// largest index
				largestRowIndex = i;
			}
		}
		return largestRowIndex;

	}

	/**
	 * calculates the lowest value in row
	 * 
	 * @param data
	 * @param row
	 * @return lowest row value
	 */
	public static double getLowestInRow(double[][] data, int row) {

		// holds highest number is a row
		double lowestRow = data[row][0];

		for (int i = 1; i < data.length; i++) {
			if (lowestRow > data[row][i]) {
				lowestRow = data[row][i];
			}
		}
		return lowestRow;
	}

	/**
	 * calculates the lowest index in a row
	 * 
	 * @param data
	 * @param row
	 * @return lowest index
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {

		// holds highest index is a row
		int lowestRowIndex = 0;

		// holds highest number is a row
		double lowestRow = data[row][0];

		for (int i = 1; i < data.length; i++) {
			if (data[row][lowestRowIndex] > data[row][i]) {
				// largest number
				lowestRow = data[row][i];
				// largest index
				lowestRowIndex = i;
			}
		}
		return lowestRowIndex;

	}

	/**
	 * largest value in column
	 * 
	 * @param data
	 * @param col
	 * @return highest value
	 */
	public static double getHighestInColumn(double[][] data, int col) {

		// holds highest number is a row
		double largestCol = data[0][col];

		for (int i = 1; i < data.length; i++) {
			if (largestCol < data[i][col]) {
				largestCol = data[i][col];
			}
		}
		return largestCol;

	}

	/**
	 * get highest col index
	 * 
	 * @param data
	 * @param col
	 * @return highest index
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {

		// holds highest index is a row
		int largestColIndex = 0;

		// holds highest number is a row
		double largestRow = data[0][col];

		for (int i = 1; i < data.length; i++) {
			if (data[largestColIndex][col] < data[i][col]) {
				// largest number
				largestRow = data[i][col];
				// largest index
				largestColIndex = i;
			}
		}
		return largestColIndex;

	}

	public static double getLowestInColumn(double[][] data, int col) {
	

		// holds highest number is a row
		double lowestCol = data[0][col];

		for (int i = 1; i < data.length; i++) {
			if (lowestCol > data[i][col]) {
				lowestCol = data[i][col];
			}
		}
		return lowestCol;
	}

	/**
	 * Get lowest lowest col index
	 * 
	 * @param data
	 * @param col
	 * @return lowest index
	 */
	public static double getLowestInColumnIndex(double[][] data, int col) {

		// holds highest index is a row
		int lowestColIndex = 0;

		// holds highest number is a row
		double lowestCol = data[0][col];

		for (int i = 1; i < data.length; i++) {
			if (data[lowestColIndex][col] > data[i][col]) {
				// largest number
				lowestCol = data[i][col];
				// largest index
				lowestColIndex = i;
			}
		}
		return lowestColIndex;

	}

}

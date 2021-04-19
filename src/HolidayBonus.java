
public class HolidayBonus {
	/**
	 * no-arg constructor
	 */
	public HolidayBonus() {
	}

	/**
	 * 
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {

		// 5000 highest
		// 1000 lowest
		// 2000 other stores
		// 0 for < 0 sales at all
		// 5000 if the rest didn't sell anything

		// number of stores
		int storeNumber = data.length;
		// hold bonus array
		double[] bonuses = new double[storeNumber];

		for (int i = 0; i < bonuses.length; i++) {
			for (int j = 0; j < bonuses.length; j++) {
				if (i == TwoDimRaggedArrayUtility.getHighestInRowIndex(data, i)) {
					if (data[i][j] > 0)
						bonuses[i] += high;		//add 5000
				} else if (i == TwoDimRaggedArrayUtility.getLowestInRowIndex(data, i)) {
					if (data[i][j] > 0)
						bonuses[i] += low;		//add 1000
				} else { 
					bonuses[i] += other;
				}
			}
		}
		return bonuses;
	}

	/**
	 * calculate the sum of all bonuses
	 * @param data
	 * @return
	 * 
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {

		// call the bonus array
		double[] bonusList = calculateHolidayBonus(data, high, low, other);

		// accumulate total
		double bonusTotal = 0;

		for (int i = 0; i < bonusList.length; i++)
			bonusTotal += bonusList[i];

		// return total
		return bonusTotal;
	}

}

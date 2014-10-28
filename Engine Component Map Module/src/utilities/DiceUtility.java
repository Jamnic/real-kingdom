package utilities;

import java.util.Random;

import architecture.Utility;

/**
 * Simulates a simple dice object, providing randomization when it is needed.
 */
public final class DiceUtility extends Utility {

	/* ========== Public ========== */
	/**
	 * Returns randomized number from 0 to given <code>k</code> parameter. If k is less or equal zero, method returns 0.
	 * 
	 * @param k
	 *            - maximum number which can be obtained with randomization (exclusive).
	 * @return Returns randomized number from 0 to given <code>k</code> parameter. If k is less or equal zero, method
	 *         returns 0.
	 */
	public int roll(final int k) {

		return k > 0 ? random.nextInt(k) : 0;

	}

	/**
	 * Returns the result of comparing <code>roll</code> method result, with 0. It simulates a test of 1/k chances
	 * success.
	 * 
	 * @param k
	 *            - maximum number which can be obtained with randomization (exclusive).
	 * @return True, if rolled number is equal to 0, or false if not.
	 */
	public boolean check(final int k) {

		return roll(k) == 0;

	}

	/* ========== Private ========== */
	private Random random = new Random();

}

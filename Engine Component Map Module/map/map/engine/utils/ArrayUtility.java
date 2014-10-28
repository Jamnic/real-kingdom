package map.engine.utils;

import architecture.Utility;

public class ArrayUtility extends Utility {

	/* ========== Public ========== */
	public Object[][] initialize2DArray(final int width, final int height, Object defaultValue) {

		Object array[][] = new Object[width][];

		for (int i = 0; i < width; ++i) {
			array[i] = new Object[height];

			for (int j = 0; j < height; ++j)
				array[i][j] = defaultValue;

		}

		return array;

	}

	/* ========== Private ========== */
}

package engine.world.algorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Board;
import model.Coords;
import model.Field;
import architecture.Algorithm;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import deprecated.to.reuse.Step;

public class SimpleRoutingAlgorithmImpl extends Algorithm implements RoutingAlgorithm {

	/* ========== Public ========== */
	@Override
	public List<Step> calculateStepByStepRoute(Board board, Coords start, Coords destination) {

		initialize(board);

		List<Step> steps = new LinkedList<Step>();

		if (!start.equals(destination)) {

			Field startField = board.getBoard()[start.getX()][start.getY()];
			Field destinationField = board.getBoard()[destination.getX()][destination.getY()];

			addStartFieldToTheQueue(startField);

			markArrayForShortestPath(searchingQueue, destinationField);

			followMarkedArrayToCalculateStepByStepRoute(steps, startField, destinationField);

			Collections.reverse(steps);

			clearMarkerArray();

		}

		return steps;

	}

	/* ========== Private ========== */
	private int[][] markerArray;
	private Queue<Field> searchingQueue;
	private Board board;

	private void initialize(Board givenBoard) {

		searchingQueue = new LinkedList<Field>();

		this.board = givenBoard;

		int width = givenBoard.length;

		markerArray = new int[width][];

		for (int i = 0; i < width; ++i) {

			int height = givenBoard[i].length;

			markerArray[i] = new int[height];
			for (int j = 0; j < height; ++j)
				markerArray[i][j] = 0;

		}

		searchingQueue = new LinkedList<Field>();

	}

	private void addStartFieldToTheQueue(Field start) {

		Coords coords = start.getCoords();
		markerArray[coords.getX()][coords.getY()] = 1;

		searchingQueue.add(start);

	}

	private boolean markArrayForShortestPath(Queue<Field> searchingQueue, Field endField) {

		Field field = searchingQueue.poll();

		if (field == null)
			return false;

		Coords coords = field.getCoords();
		int y = coords.getY();
		int x = coords.getX();

		int actualIndex = markerArray[x][y];

		if (field.equals(endField))
			return true;

		markSurroundingFieldsAndAddToQueue(searchingQueue, x, y, ++actualIndex);

		return markArrayForShortestPath(searchingQueue, endField);

	}

	private void markSurroundingFieldsAndAddToQueue(Collection<Field> collection, int x, int y, int actualIndex) {

		tryToAddField(x + 1, y - 1, collection, actualIndex);
		tryToAddField(x + 1, y + 0, collection, actualIndex);
		tryToAddField(x + 1, y + 1, collection, actualIndex);
		tryToAddField(x + 0, y - 1, collection, actualIndex);
		tryToAddField(x + 0, y + 1, collection, actualIndex);
		tryToAddField(x - 1, y - 1, collection, actualIndex);
		tryToAddField(x - 1, y + 0, collection, actualIndex);
		tryToAddField(x - 1, y + 1, collection, actualIndex);

	}

	private void tryToAddField(int x, int y, Collection<Field> collection, int actualIndex) {

		Optional<Field> fieldOptional; // = mapManager.getFieldFromGameMap(new Coords(x, y));

		// if (fieldOptional.isPresent() && markerArray[x][y] == 0) {
		// markerArray[x][y] = actualIndex;
		//
		// collection.add(fieldOptional.get());
		// }

	}

	private void followMarkedArrayToCalculateStepByStepRoute(List<Step> steps, Field start, Field destination) {

		int actualIndex = getActualIndexOfEndField(destination);

		Field previousField = destination;
		Field closerField = destination;

		while (closerField != null && !start.equals(closerField)) {

			List<Field> surroundingFields = getSurroundingFields(closerField.getCoords());

			closerField = findFieldCloserToStart(--actualIndex, surroundingFields);

			steps.add(new Step(closerField, previousField));

			previousField = closerField;

		}

	}

	private List<Field> getSurroundingFields(Coords coords) {

		int x = coords.getX();
		int y = coords.getY();

		List<Field> surroundingFields = Lists.newArrayList();

		tryToAddField(surroundingFields, new Coords(x + 1, y));
		tryToAddField(surroundingFields, new Coords(x, y + 1));
		tryToAddField(surroundingFields, new Coords(x - 1, y));
		tryToAddField(surroundingFields, new Coords(x, y - 1));

		return surroundingFields;
	}

	private void tryToAddField(List<Field> surroundingFields, Coords coords2) {
		// Optional<Field> field = mapManager.getFieldFromGameMap(coords2);
		// if (field.isPresent())
		// surroundingFields.add(field.get());
	}

	private int getActualIndexOfEndField(Field endField) {

		Coords coords = endField.getCoords();

		return markerArray[coords.getX()][coords.getY()];

	}

	private Field findFieldCloserToStart(int actualIndex, List<Field> surroundingFields) {

		for (Field field : surroundingFields) {
			Coords coords = field.getCoords();
			int y = coords.getY();
			int x = coords.getX();

			if (markerArray[x][y] == actualIndex)
				return field;
		}

		return null; // TODO critical
	}

	private void clearMarkerArray() {

		for (int i = 0; i < markerArray.length; ++i)
			for (int j = 0; j < markerArray[i].length; ++j)
				markerArray[i][j] = 0;

		searchingQueue = new LinkedList<Field>();

	}

}

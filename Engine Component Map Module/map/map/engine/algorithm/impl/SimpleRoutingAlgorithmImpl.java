package map.engine.algorithm.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import map.engine.Board;
import map.engine.Step;
import map.engine.algorithm.RoutingAlgorithm;
import map.engine.model.FieldMapWrapper;
import map.engine.utils.Coords;
import architecture.Algorithm;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class SimpleRoutingAlgorithmImpl extends Algorithm implements RoutingAlgorithm {

	/* ========== Public ========== */
	/**
	 * Returns list of Step from start Field to the destination Field.
	 */
	public List<Step> calculateStepByStepRoute(final Board board, FieldMapWrapper start,
			FieldMapWrapper destination) {

		initialize(board);

		List<Step> steps = new LinkedList<Step>();

		if (!start.equals(destination)) {

			addStartFieldToTheQueue(start);

			markArrayForShortestPath(searchingQueue, destination);

			followMarkedArrayToCalculateStepByStepRoute(steps, start, destination);

			Collections.reverse(steps);

			clearMarkerArray();

		}

		return steps;

	}

	/* ========== Private ========== */
	private int[][] markerArray;
	private Queue<FieldMapWrapper> searchingQueue;

	private void initialize(Board board) {

		arrays.initialize2DArray(board.getWidth(), board.getHeight(), 0);

		searchingQueue = new LinkedList<FieldMapWrapper>();

	}

	private void addStartFieldToTheQueue(FieldMapWrapper start) {

		Coords coords = start.getCoords();
		markerArray[coords.getX()][coords.getY()] = 1;

		searchingQueue.add(start);

	}

	private boolean markArrayForShortestPath(Queue<FieldMapWrapper> searchingQueue, FieldMapWrapper endField) {

		FieldMapWrapper field = searchingQueue.poll();

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

	private void markSurroundingFieldsAndAddToQueue(Collection<FieldMapWrapper> collection, int x, int y,
			int actualIndex) {

		tryToAddField(x + 1, y - 1, collection, actualIndex);
		tryToAddField(x + 1, y + 0, collection, actualIndex);
		tryToAddField(x + 1, y + 1, collection, actualIndex);
		tryToAddField(x + 0, y - 1, collection, actualIndex);
		tryToAddField(x + 0, y + 1, collection, actualIndex);
		tryToAddField(x - 1, y - 1, collection, actualIndex);
		tryToAddField(x - 1, y + 0, collection, actualIndex);
		tryToAddField(x - 1, y + 1, collection, actualIndex);

	}

	private void tryToAddField(int x, int y, Collection<FieldMapWrapper> collection, int actualIndex) {

		Optional<FieldMapWrapper> fieldOptional = mapManager.getFieldFromGameMap(new Coords(x, y));

		if (fieldOptional.isPresent() && markerArray[x][y] == 0) {
			markerArray[x][y] = actualIndex;

			collection.add(fieldOptional.get());
		}

	}

	private void followMarkedArrayToCalculateStepByStepRoute(List<Step> steps, FieldMapWrapper start,
			FieldMapWrapper destination) {

		int actualIndex = getActualIndexOfEndField(destination);

		FieldMapWrapper previousField = destination;
		FieldMapWrapper closerField = destination;

		while (closerField != null && !start.equals(closerField)) {

			List<FieldMapWrapper> surroundingFields = getSurroundingFields(closerField.getCoords());

			closerField = findFieldCloserToStart(--actualIndex, surroundingFields);

			steps.add(new Step(closerField, previousField));

			previousField = closerField;

		}

	}

	private List<FieldMapWrapper> getSurroundingFields(Coords coords) {

		int x = coords.getX();
		int y = coords.getY();

		List<FieldMapWrapper> surroundingFields = Lists.newArrayList();

		tryToAddField(surroundingFields, new Coords(x + 1, y));
		tryToAddField(surroundingFields, new Coords(x, y + 1));
		tryToAddField(surroundingFields, new Coords(x - 1, y));
		tryToAddField(surroundingFields, new Coords(x, y - 1));

		return surroundingFields;
	}

	private void tryToAddField(List<FieldMapWrapper> surroundingFields, Coords coords2) {
		Optional<FieldMapWrapper> field = mapManager.getFieldFromGameMap(coords2);
		if (field.isPresent())
			surroundingFields.add(field.get());
	}

	private int getActualIndexOfEndField(FieldMapWrapper endField) {

		Coords coords = endField.getCoords();

		return markerArray[coords.getX()][coords.getY()];

	}

	private FieldMapWrapper findFieldCloserToStart(int actualIndex, List<FieldMapWrapper> surroundingFields) {

		for (FieldMapWrapper field : surroundingFields) {
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

		searchingQueue = new LinkedList<FieldMapWrapper>();

	}

}

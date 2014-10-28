package map.engine.managers.impl;

import java.util.List;

import map.engine.Board;
import map.engine.Step;
import map.engine.managers.RouteManager;
import map.engine.model.FieldMapWrapper;
import architecture.Manager;

// TODO javadoc
public class RouteManagerImpl extends Manager implements RouteManager {

	/* ========== Public ========== */
	// TODO javadoc
	public List<Step> calculateStepByStepRoute(final Board board, FieldMapWrapper start, FieldMapWrapper destination) {

		return routingAlgorithm.calculateStepByStepRoute(board, start, destination);

	}

	/* ========== Private ========== */
}

package engine.world.algorithm;

import java.util.List;

import model.Board;
import model.Coords;
import deprecated.to.reuse.Step;

/**
 * Returns list of Step from start {@link Coords} to the destination {@link Coords}.
 */
public interface RoutingAlgorithm {

	/**
	 * Returns list of Step from start {@link Coords} to the destination {@link Coords}.
	 */
	List<Step> calculateStepByStepRoute(Board board, Coords start, Coords destination);

}
package map.engine.algorithm;

import java.util.List;

import map.engine.Board;
import map.engine.Step;
import map.engine.model.FieldMapWrapper;

// TODO javadoc
public interface RoutingAlgorithm {

	// TODO javadoc
	List<Step> calculateStepByStepRoute(final Board board, FieldMapWrapper start, FieldMapWrapper destination);

}

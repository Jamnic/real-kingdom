package map.engine.managers;

import java.util.List;

import map.engine.Board;
import map.engine.Step;
import map.engine.model.FieldMapWrapper;

// TODO javadoc
public interface RouteManager {

	// TODO javadoc
	List<Step> calculateStepByStepRoute(final Board board, FieldMapWrapper start, FieldMapWrapper destination);

}

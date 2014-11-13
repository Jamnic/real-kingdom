package engine.world;

import java.util.List;

import model.Board;
import model.Coords;

import com.google.common.base.Optional;

import deprecated.to.reuse.Route;
import deprecated.to.reuse.Step;
import engine.world.algorithm.RoutingAlgorithm;
import engine.world.algorithm.SimpleRoutingAlgorithmImpl;

public class RouteManagerImpl implements RouteManager {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public Optional<Route> createRoute(Board board, Coords start, Coords destination) {

		List<Step> steps = routingAlgorithm.calculateStepByStepRoute(board, start, destination);

		if (steps != null) {
			Route route = new Route();

			route.setSteps(steps);
			route.setStart(destination);
			route.setDestination(destination);

			return Optional.of(route);
		}

		return Optional.absent();
	}

	/* ========== Components ========== */
	private final static RoutingAlgorithm routingAlgorithm = new SimpleRoutingAlgorithmImpl();

}

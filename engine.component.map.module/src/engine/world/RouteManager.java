package engine.world;

import model.Board;
import model.Coords;

import com.google.common.base.Optional;

import deprecated.to.reuse.Route;

/**
 * Returns list of Step from start {@link Coords} to the destination {@link Coords}.
 */
public interface RouteManager {

	/**
	 * Returns list of Step from start {@link Coords} to the destination {@link Coords}.
	 */
	Optional<Route> createRoute(Board board, Coords start, Coords destination);

}

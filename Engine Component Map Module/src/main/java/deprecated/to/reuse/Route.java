package deprecated.to.reuse;

import java.util.List;

import model.Field;

public class Route {

	public Route(List<Step> steps) {
		super();

		this.steps = steps;
	}

	/* Properties */
	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public Field getDestination() {
		return destination;
	}

	public Field getStart() {
		return start;
	}

	public void setStart(Field start) {
		this.start = start;
	}

	/* Private */
	private Field destination;
	private Field start;
	private List<Step> steps;

}

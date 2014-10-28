package map.engine;

import java.util.List;

import map.engine.model.FieldMapWrapper;

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
	
	public FieldMapWrapper getDestination() {
		return destination;
	}

	public FieldMapWrapper getStart() {
		return start;
	}

	public void setStart(FieldMapWrapper start) {
		this.start = start;
	}

	/* Private */
	private FieldMapWrapper destination;
	private FieldMapWrapper start;
	private List<Step> steps;

}

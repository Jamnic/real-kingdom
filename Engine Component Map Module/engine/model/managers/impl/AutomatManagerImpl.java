package model.managers.impl;

import java.util.LinkedList;
import java.util.List;

import architecture.Manager;
import engine.taskable.model.AutomatTaskableWrapper;

public class AutomatManagerImpl extends Manager implements AutomatManager {

	/* ========== Public ========== */
	public void processTasks() {

		for (AutomatTaskableWrapper automatTaskWrapper : creatureTaskWrappers) {
			if (automatTaskWrapper.getTask() == null) {
				taskManager.assignNewRandomTaskForAutomat(automatTaskWrapper);
			} else {
				automatTaskWrapper.getTask().execute(automatTaskWrapper.getWrappedObject());
			}
		}

	}

	/* ========== Private ========== */
	private List<AutomatTaskableWrapper> creatureTaskWrappers = new LinkedList<AutomatTaskableWrapper>();

}

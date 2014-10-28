package model.managers.impl;

import java.util.LinkedList;
import java.util.List;

import architecture.Manager;
import engine.taskable.model.CreatureTaskableWrapper;

public class CreatureManagerImpl extends Manager implements CreatureManager {

	/* ========== Public ========== */
	public void processTasks() {

		for (CreatureTaskableWrapper creatureTaskWrapper : creatureTaskWrappers) {
			if (creatureTaskWrapper.getTask() == null) {
				taskManager.assignNewRandomTaskForCreature(creatureTaskWrapper);
			} else {
				creatureTaskWrapper.getTask().execute(creatureTaskWrapper.getWrappedObject());
			}
		}

	}

	/* ========== Private ========== */
	private List<CreatureTaskableWrapper> creatureTaskWrappers = new LinkedList<CreatureTaskableWrapper>();

}

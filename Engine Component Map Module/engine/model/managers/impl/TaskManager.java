package model.managers.impl;

import engine.taskable.model.AutomatTaskableWrapper;
import engine.taskable.model.CreatureTaskableWrapper;

public interface TaskManager {

	void processTasks();
	
	void assignNewRandomTaskForCreature(CreatureTaskableWrapper creature);

	void assignNewRandomTaskForAutomat(AutomatTaskableWrapper automatTaskWrapper);

}
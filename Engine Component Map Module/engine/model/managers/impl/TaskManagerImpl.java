package model.managers.impl;

import architecture.Manager;
import engine.model.Automat;
import engine.model.Creature;
import engine.taskable.RandomJobAutomatTask;
import engine.taskable.RandomMovementCreatureTask;
import engine.taskable.model.AutomatTaskableWrapper;
import engine.taskable.model.CreatureTaskableWrapper;
import engine.taskable.task.Task;

public class TaskManagerImpl extends Manager implements TaskManager {

	/* ========== Public ========== */
	@Override
	public void processTasks() {

		creatureManager.processTasks();

	}
	
	@Override
	public void assignNewRandomTaskForCreature(CreatureTaskableWrapper creatureTaskWrapper) {
		
		Task<Creature> task = new RandomMovementCreatureTask();
		
		creatureTaskWrapper.setTask(task);

	}

	@Override
	public void assignNewRandomTaskForAutomat(AutomatTaskableWrapper automatTaskWrapper) {

		Task<Automat> task = new RandomJobAutomatTask();
		
		automatTaskWrapper.setTask(task);
		
	}

	/* ========== Private ========== */
}

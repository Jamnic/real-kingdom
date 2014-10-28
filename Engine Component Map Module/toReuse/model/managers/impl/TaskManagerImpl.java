//package model.managers.impl;
//
//import deprecated.architecture.Manager;
//import deprecated.engine.model.Creature;
//import engine.taskable.model.CreatureTaskableWrapper;
//import engine.taskable.task.RandomMovementCreatureTask;
//import engine.taskable.task.Task;
//
//public class TaskManagerImpl extends Manager implements TaskManager {
//
//	/* ========== Public ========== */
//	@Override
//	public void processTasks() {
//
//		creatureManager.processTasks();
//
//	}
//
//	@Override
//	public void assignNewRandomTaskForCreature(CreatureTaskableWrapper creatureTaskWrapper) {
//
//		Task<Creature> task = new RandomMovementCreatureTask();
//
//		creatureTaskWrapper.setAnotherTask(task);
//
//	}
//
//	/* ========== Private ========== */
//}

package deprecated.to.reuse;
//package model.managers.impl;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import deprecated.architecture.Manager;
//import engine.taskable.model.CreatureTaskableWrapper;
//
//public class CreatureManagerImpl extends Manager implements CreatureManager {
//
//	/* ========== Public ========== */
//	public void processTasks() {
//
//		for (CreatureTaskableWrapper creatureTaskWrapper : creatureTaskWrappers) {
//			if (creatureTaskWrapper.getCurrentTask() == null) {
//				taskManager.assignNewRandomTaskForCreature(creatureTaskWrapper);
//			} else {
//				creatureTaskWrapper.getCurrentTask().execute(creatureTaskWrapper.getWrappedObject());
//			}
//		}
//
//	}
//
//	/* ========== Private ========== */
//	private List<CreatureTaskableWrapper> creatureTaskWrappers = new LinkedList<CreatureTaskableWrapper>();
//
//}

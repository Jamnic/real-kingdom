package deprecated.to.reuse;
//package map.engine.managers.impl;
//
//import map.engine.Board;
//import map.engine.GameMap;
//import map.engine.managers.MapManager;
//import map.engine.utils.Coords;
//
//import com.google.common.base.Optional;
//
//import deprecated.architecture.Manager;
//import engine.picturable.model.CreaturePicturableWrapper;
//import engine.picturable.model.FieldMapWrapper;
//
///**
// * Default implementation of {@link MapManager}.<br>
// * <br>
// */
//public class MapManagerImpl extends Manager implements MapManager {
//
//	/* ========== Public ========== */
//	/** {@inheritDoc} */
//	public void createNewGameMap(final int width, final int height) {
//
//		archivePreviousMap();
//
//		generateGameMap(width, height);
//
//	}
//
//	/** {@inheritDoc} */
//	public boolean putCreature(CreaturePicturableWrapper creature, FieldMapWrapper field) {
//
//		if (fieldAndCreatureAreNotOccupied(creature, field)) {
//			field.setOccupyingEntity(creature);
//			creature.setOccupiedField(field);
//
//			return true;
//		}
//
//		return false;
//
//	}
//
//	/** {@inheritDoc} */
//	public boolean pickCreature(CreaturePicturableWrapper creature) {
//
//		Optional<FieldMapWrapper> occupiedField = creature.getOccupiedField();
//		if (occupiedField.isPresent()) {
//
//			checkIfFieldIsOccupiedByProperCreature(creature, occupiedField);
//
//			occupiedField.get().setOccupyingEntity(null);
//			creature.setOccupiedField(null);
//
//			return true;
//		}
//
//		log.warn(this.getClass(), "Trying to pick creature " + creature + " from nowhere!");
//		return false;
//	}
//
//	/** {@inheritDoc} */
//	@Override
//	public boolean moveCreature(CreaturePicturableWrapper creature, FieldMapWrapper field) {
//
//		Optional<FieldMapWrapper> previousField = creature.getOccupiedField();
//
//		if (gameMap.isPresent())
//		
//		if (previousField.isPresent()) {
//			routeManager.calculateStepByStepRoute(gameMap.get().getBoard(), creature.getOccupiedField().get(), field);
//			// TODO
//		}
//		
//		
//		
////		if (!pickCreature(creature))
////			log.warn(this.getClass(), "You are moving creature " + creature + " from nowhere!");
////
////		if (putCreature(creature, field))
////			return true;
////		else
////			tryToRollbackMovement(creature, previousField);
//
//		return false;
//
//	}
//
//	/** {@inheritDoc} */
//	@Override
//	public void printGameMap() {
//
//		if (gameMap.isPresent())
//			printMap(gameMap.get().getBoard());
//
//		else
//			log.err(this.getClass(),
//					"Map was not initialized! Please, initialize map before attempting to obtain any Field.");
//
//	}
//
//	/** {@inheritDoc} */
//	@Override
//	public Optional<FieldMapWrapper> getFieldFromGameMap(final Coords coords) {
//
//		if (gameMap.isPresent())
//			return gameMap.get().getBoard().get(coords);
//
//		log.err(this.getClass(),
//				"Map was not initialized! Please, initialize map before attempting to obtain any Field.");
//
//		return Optional.absent();
//
//	}
//
//	/* ========== Private ========== */
//	private Optional<GameMap> gameMap = Optional.absent();
//
//	private void archivePreviousMap() {
//
//		if (gameMap.isPresent())
//			archiveManager.archiveMap(gameMap.get().getBoard());
//
//	}
//
//	private void generateGameMap(final int width, final int height) {
//
//		Board generatedBoard = terrainGeneratorAlgorithm.generateBoard(width, height);
//
//		GameMap newlyGeneratedGameMap = new GameMap(generatedBoard);
//
//		gameMap = Optional.of(newlyGeneratedGameMap);
//
//	}
//
//	private boolean fieldAndCreatureAreNotOccupied(CreaturePicturableWrapper creature, FieldMapWrapper field) {
//
//		if (field.getOccupyingCreature().isPresent() && !field.getOccupyingCreature().get().equals(creature)) {
//
//			log.err(this.getClass(), "This field is already occupied. " + creature + " is not able to step on " + field);
//
//			return false;
//		}
//
//		if (creature.getOccupiedField().isPresent() && !creature.getOccupiedField().get().equals(field)) {
//			log.err(this.getClass(), "This creature is already occupying other field. " + creature
//					+ " is not able to step on " + field);
//
//			return false;
//		}
//
//		return true;
//	}
//
//	private void checkIfFieldIsOccupiedByProperCreature(CreaturePicturableWrapper creature,
//			Optional<FieldMapWrapper> occupiedField) {
//
//		Optional<CreaturePicturableWrapper> occupyingCreature = occupiedField.get().getOccupyingCreature();
//
//		if (!occupyingCreature.isPresent() || !occupyingCreature.get().equals(creature))
//			log.warn(this.getClass(), "Bug was found. Creature " + creature + " occupied a field, but field "
//					+ occupiedField + " had wrong information about occupying creature (or absence of it).");
//
//	}
//
//	private void tryToRollbackMovement(CreaturePicturableWrapper creature, Optional<FieldMapWrapper> previousField) {
//
//		if (previousField.isPresent() && !putCreature(creature, previousField.get()))
//			log.err(this.getClass(), "Cannot rollback movement of the creature! " + creature
//					+ " cannot be put on previous field " + previousField);
//
//	}
//
//	private void printMap(Board board) {
//
//		for (FieldMapWrapper[] row : board.getBoard()) {
//
//			for (FieldMapWrapper field : row)
//				System.out.print(fieldManager.printFieldPicture(field));
//
//			System.out.println();
//
//		}
//
//	}
//
//}

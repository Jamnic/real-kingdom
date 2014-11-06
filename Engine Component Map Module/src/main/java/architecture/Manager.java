package architecture;


/**
 * Abstraction over all {@link Manager} implementing classes.<br>
 * <br>
 * 
 * <b>Architecture</b><br>
 * {@link Manager}s provide calculations and modifications over all {@link Entity} classes. More complicated
 * calculations may be delegated to the {@link Algorithm} classes.<br>
 * <br>
 * 
 * <b>Coding conventions</b><br>
 * {@link Manager}s should be provided with proper interfaces.<br>
 * <br>
 */
public abstract class Manager extends EngineComponentMapModule {
}

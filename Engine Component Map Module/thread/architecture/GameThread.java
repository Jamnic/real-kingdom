package architecture;

import main.managers.GameComponentContainer;

/**
 * Abstraction over all {@link GameThread} implementing classes.<br>
 * <br>
 * 
 * <b>Architecture</b><br>
 * {@link GameThread} is used to all processes and threading in game.<br>
 * <br>
 * 
 * <b>Coding conventions</b><br>
 * {@link GameThread}s should be provided with proper interfaces.<br>
 * <br>
 */
public abstract class GameThread extends GameComponentContainer {
}

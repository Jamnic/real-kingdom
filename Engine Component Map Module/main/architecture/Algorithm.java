package architecture;

import main.managers.GameComponentContainer;

/**
 * Abstraction over all {@link Algorithm} implementing classes.<br>
 * <br>
 * 
 * <b>Architecture</b><br>
 * {@link Algorithm}s are being used by {@link Manager}s to delegate more complicated calculations. Algorithms should be
 * easily replaced when needed to.<br>
 * <br>
 * 
 * <b>Coding conventions</b><br>
 * Algorithms should have interface. One interface can be implemented by several classes, which means, that
 * {@link Algorithm} can be replaced by another.<br>
 * <br>
 */
public abstract class Algorithm extends GameComponentContainer {
}

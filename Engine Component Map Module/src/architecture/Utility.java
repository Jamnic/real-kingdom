package architecture;


/**
 * Abstraction over all {@link Utility} implementing classes.<br>
 * <br>
 * 
 * <b>Architecture</b><br>
 * {@link Utility} classes are mostly simple classes, which can be used everywhere. They provide simple services (eg.
 * logging, randomizing).<br>
 * <br>
 * 
 * <b>Coding conventions</b><br>
 * It should not have any interface, because it should be kept simple.<br>
 * <br>
 */
public abstract class Utility extends GameComponentContainer {
}

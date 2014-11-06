package utilities;

import architecture.Utility;

/**
 * Logging utility class. Can log messages to the console with specified levels of importance. Each level can be
 * configured during creation of logger or later through setters.
 */
@SuppressWarnings("rawtypes")
public final class LoggerUtility extends Utility {

	/* ========== Public ========== */
	/**
	 * Constructs {@link LoggerUtility} with specified parameters.
	 * 
	 * @param errorEnabled
	 *            - if <code>true</code> enables error logs.
	 * @param warningEnabled
	 *            - if <code>true</code> enables warning logs.
	 * @param infoEnabled
	 *            - if <code>true</code> enables info logs.
	 * @param debugEnabled
	 *            - if <code>true</code> enables debug logs.
	 */
	public LoggerUtility(boolean errorEnabled, boolean warningEnabled, boolean infoEnabled, boolean debugEnabled) {

		super();

		this.warningEnabled = warningEnabled;
		this.debugEnabled = debugEnabled;
		this.errorEnabled = errorEnabled;
		this.infoEnabled = infoEnabled;
	}

	/**
	 * Logs given message with [INFO] info log.
	 * 
	 * @param cls
	 *            - class of reporting object.
	 * @param logMessage
	 *            - message to be displayed.
	 */
	public synchronized void info(Class cls, String logMessage) {
		if (infoEnabled)
			System.out.println("[INFO] " + cls.getSimpleName() + ": " + logMessage);
	}

	/**
	 * Logs given message with [DEBUG] debug log.
	 * 
	 * @param cls
	 *            - class of reporting object.
	 * @param debugMessage
	 *            - message to be displayed.
	 */
	public synchronized void debug(Class cls, String debugMessage) {
		if (debugEnabled)
			System.out.println("[DEBUG] " + cls.getSimpleName() + ": " + debugMessage);
	}

	/**
	 * Logs given message with [ERROR] error log.
	 * 
	 * @param cls
	 *            - class of reporting object.
	 * @param errorMessage
	 *            - message to be displayed.
	 */
	public synchronized void err(Class cls, String errorMessage) {
		if (errorEnabled)
			System.err.println("[ERROR] " + cls.getSimpleName() + ": " + errorMessage);
	}

	/**
	 * Logs given message with [WARNING] warning log.
	 * 
	 * @param cls
	 *            - class of reporting object.
	 * @param warningMessage
	 *            - message to be displayed.
	 */
	public synchronized void warn(Class cls, String warningMessage) {
		if (warningEnabled)
			System.out.println("[WARNING] " + cls.getSimpleName() + ": " + warningMessage);
	}

	/**
	 * Sets the [ERROR] messages visible or not.
	 */
	public synchronized void setErrorMessages(boolean errorEnabled) {
		this.errorEnabled = errorEnabled;
	}

	/* ========== Private ========== */
	private boolean warningEnabled;
	private boolean debugEnabled;
	private boolean errorEnabled;
	private boolean infoEnabled;

}

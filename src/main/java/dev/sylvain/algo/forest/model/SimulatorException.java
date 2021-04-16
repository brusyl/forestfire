/**
 * 
 */
package dev.sylvain.algo.forest.model;

/**
 * Specific exception throws in config loading context
 * @author sbrunon
 *
 */
public class SimulatorException extends Exception {

	private static final long serialVersionUID = -5563979534042298681L;

	/**
	 * 
	 */
	public SimulatorException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SimulatorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SimulatorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SimulatorException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SimulatorException(Throwable cause) {
		super(cause);
	}
}

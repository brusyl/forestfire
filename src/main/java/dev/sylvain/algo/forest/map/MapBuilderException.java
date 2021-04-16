/**
 * 
 */
package dev.sylvain.algo.forest.map;

/**
 * Specific exception throws in config loading context
 * @author sbrunon
 *
 */
public class MapBuilderException extends Exception {

	private static final long serialVersionUID = -5563979534042298681L;

	/**
	 * 
	 */
	public MapBuilderException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MapBuilderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MapBuilderException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public MapBuilderException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MapBuilderException(Throwable cause) {
		super(cause);
	}
	
	

}

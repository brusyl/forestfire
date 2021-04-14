/**
 * 
 */
package dev.sylvain.algo.forest.conf;

/**
 * Specific exception throws in config loading context
 * @author sbrunon
 *
 */
public class ConfigLoaderException extends Exception {

	private static final long serialVersionUID = -1891543816182267392L;

	/**
	 * 
	 */
	public ConfigLoaderException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConfigLoaderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConfigLoaderException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ConfigLoaderException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ConfigLoaderException(Throwable cause) {
		super(cause);
	}
	
	

}

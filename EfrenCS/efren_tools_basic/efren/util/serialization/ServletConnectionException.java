package efren.util.serialization;

public class ServletConnectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6158113234146745528L;
	
	/**
	 * 
	 */
	public ServletConnectionException() {
		super();
	}
	/**
	 * 
	 */
	public ServletConnectionException(String message) {
		super(message);
	}
	
	/**
	 * 
	 */
    public ServletConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}

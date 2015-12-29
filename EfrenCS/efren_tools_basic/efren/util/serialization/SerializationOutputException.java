package efren.util.serialization;

public class SerializationOutputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4066413670167311348L;
	
	/**
	 * 
	 */
	public SerializationOutputException() {
		super();
	}
	/**
	 * 
	 */
	public SerializationOutputException(String message) {
		super(message);
	}
	
	/**
	 * 
	 */
    public SerializationOutputException(String message, Throwable cause) {
        super(message, cause);
    }

}

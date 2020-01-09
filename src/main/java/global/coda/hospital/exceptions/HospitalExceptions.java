package global.coda.hospital.exceptions;

/**
 * @author VC
 *
 */
public class HospitalExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor.
	 */
	public HospitalExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message            for handle.
	 * @param cause              for handle.
	 * @param enableSuppression  for handle.
	 * @param writableStackTrace for handle.
	 */
	public HospitalExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message for handle.
	 * @param cause   for handle.
	 */
	public HospitalExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message for handle.
	 */
	public HospitalExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause for handle.
	 */
	public HospitalExceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

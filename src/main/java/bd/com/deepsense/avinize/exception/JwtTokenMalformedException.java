package bd.com.deepsense.avinize.exception;

import javax.naming.AuthenticationException;

public class JwtTokenMalformedException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public JwtTokenMalformedException(String msg) {
		super(msg);
	}

}

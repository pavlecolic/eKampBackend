package org.unibl.etf.ekamp.exceptions;

import org.springframework.http.HttpStatus;

public class UnathorizedException extends HttpException {

    public UnathorizedException() { super(HttpStatus.UNAUTHORIZED, null); }

    public UnathorizedException(Object data)  { super(HttpStatus.UNAUTHORIZED, data);}
}

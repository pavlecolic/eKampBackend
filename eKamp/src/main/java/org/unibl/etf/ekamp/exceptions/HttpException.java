package org.unibl.etf.ekamp.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class HttpException extends RuntimeException {

    private HttpStatus status;
    private Object data;

    public HttpException(HttpStatus status, Object data) {
        this.status = status;
        this.data = data;
    }
    public HttpException() {
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.data = null;
    }
    public HttpException(Object data) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, data);
    }
}

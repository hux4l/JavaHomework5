package sk.ness.academy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Article not found")
public class NotFoundException extends RuntimeException {

    public NotFoundException(final String message) {
        super(message);
    }
}

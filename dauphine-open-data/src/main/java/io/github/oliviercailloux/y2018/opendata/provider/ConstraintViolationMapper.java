package io.github.oliviercailloux.y2018.opendata.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

/**
 * Convert an ugly ConstraintViolationException into a pretty Response adapted to the accept-type of the request
 */
@Provider
public class ConstraintViolationMapper
        implements ExceptionMapper<ConstraintViolationException> {
    
    // We need the request header to infer the Response type
    @Context
    private HttpHeaders headers;
    

    // We embed the ConstraintViolationResponse because it will probably not be used by other classes
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ConstraintViolationResponse {
        int code;
        String name;
        String message;
    }
    
    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ConstraintViolationResponse(
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        Response.Status.BAD_REQUEST.getReasonPhrase(),
                        prepareMessage(exception)))
                .type(getAcceptedMediaType())
                .build();
    }
    
    private MediaType getAcceptedMediaType() {
        
        // Try the Accept-Type header first
        List<MediaType> accepts = headers.getAcceptableMediaTypes();
        if (accepts != null && accepts.size() > 0) {
            if (accepts.get(0).equals(MediaType.WILDCARD_TYPE)) {
                if (accepts.size() > 1) {
                    return accepts.get(1);
                }
            }
            else {
                return accepts.get(0);
            }
        }

        // Then Content-Type
        if (headers.getMediaType() != null) {
            return headers.getMediaType();
        }
        
        // Default to plain text
        return MediaType.TEXT_PLAIN_TYPE;
    }
    
    private String prepareMessage(ConstraintViolationException exception) {
        StringBuilder msg = new StringBuilder();
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            msg.append(cv.getPropertyPath()).append(" ").append(cv.getMessage());
        }
        return msg.toString();
    }
}
package com.smartcampus.exception.mapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionMapper.class.getName());

    @Override
    public Response toResponse(Throwable exception) {
        LOGGER.log(Level.SEVERE, "Unhandled exception caught by global mapper", exception);

        if (exception instanceof WebApplicationException) {
            WebApplicationException webEx = (WebApplicationException) exception;
            int status = webEx.getResponse().getStatus();

            return Response.status(status)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(Map.of(
                            "error", webEx.getClass().getSimpleName(),
                            "message", exception.getMessage() != null ? exception.getMessage() : "Request failed",
                            "status", status
                    ))
                    .build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON)
                .entity(Map.of(
                        "error", "Internal Server Error",
                        "message", "An unexpected error occurred. Please contact the administrator.",
                        "status", 500
                ))
                .build();
    }
}
package com.demo.news.feed.ExceptionHandling;

import com.demo.news.feed.enums.ErrorCode;
import com.demo.news.feed.model.response.ErrorResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor{
    /**
     * Exception Handling for mandatory attributes and empty request body for the request received
     * @param ex
     * @return
     */
    /*@ExceptionHandler(value = { MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
           Exception ex) {
        ErrorResponse errors = new ErrorResponse();

        if(ex instanceof  MethodArgumentNotValidException) {
        ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().forEach((error) -> {
                String errorMessage = error.getDefaultMessage();
                errors.setMessage(errorMessage);
                errors.setErrorCode(SuccessFailureCode.FAILURE.getCode());
            });
        }else {
            errors.setMessage("Please provide required parameters");
            errors.setCode(SuccessFailureCode.FAILURE.getCode());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }*/

    /*@ExceptionHandler(InvalidJwtCustomizeException.class)
    public ResponseEntity<Object> handleJwtCustomizeException(InvalidJwtCustomizeException jwtException) {
        AuthorizationErrorResponse response = new AuthorizationErrorResponse();
        response.setCode(HttpStatus.UNAUTHORIZED.value());
        response.setMessage(ErrorCodeDescription.AUTHORIZATION_FAILED.getMessage());
        List<JSONObject> list = new ArrayList<>();
        JSONObject json = new JSONObject();
        json.put("message", ErrorCodeDescription.INVALID_AUTH_TOKEN.getMessage());
        json.put("field", ErrorCodeDescription.JWT_AUTH_PROVIDER.getMessage());

        JSONObject jsonNew = new JSONObject();
        jsonNew.put("message", ErrorCodeDescription.INVALID_TOKEN.getMessage());
        jsonNew.put("field", ErrorCodeDescription.OAUTH_JWT_AUTH_PROVIDER.getMessage());

        list.add(json);
        list.add(jsonNew);
        response.setFields(list);

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }*/

   /* @ExceptionHandler(value ={AuthenticationHeaderMissingExeception.class, MissingRequestHeaderException.class})
    public ResponseEntity<Object> handleAuthenticationHeaderMissingException(Exception ex) {
        AuthorizationErrorResponse response = new AuthorizationErrorResponse();
        response.setCode(HttpStatus.UNAUTHORIZED.value());
        response.setMessage(ErrorCodeDescription.AUTHORIZATION_FAILED.getMessage());
        List<JSONObject> list = new ArrayList<>();
        JSONObject json = new JSONObject();
        json.put("message", ErrorCodeDescription.AUTH_HEADER_REQUIRED.getMessage());
        json.put("field", ErrorCodeDescription.JWT_AUTH_PROVIDER.getMessage());

        JSONObject jsonNew = new JSONObject();
        jsonNew.put("message", ErrorCodeDescription.INVALID_AUTH_TOKEN.getMessage());
        jsonNew.put("field", ErrorCodeDescription.OAUTH_JWT_AUTH_PROVIDER.getMessage());

        list.add(json);
        list.add(jsonNew);
        response.setFields(list);

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }*/
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleInternalServerErrorException(Exception ex) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode());
        response.setMessage(ErrorCode.INTERNAL_SERVER_ERROR.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*@ExceptionHandler(EventException.class)
    public ResponseEntity<Object> handleEventException(EventException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        error.setCode(SuccessFailureCode.FAILURE.getCode());

        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/
}

package br.com.desafio.totalshake.exception.handler;

import br.com.desafio.totalshake.exception.ExceptionResponse;
import br.com.desafio.totalshake.exception.PedidoNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGenericException(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PedidoNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handlePedidoNotFound(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).toList();
        System.out.println("Validation error list: " + validationList);
        var exceptionResponse = new ExceptionResponse(LocalDateTime.now(), validationList.toString(), request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, status);
    }
}

package br.com.devdojo.demo.error;


import org.springframework.http.HttpStatus;

public class CustomErrorType {
    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMesage() {
        return errorMessage;
    }
}

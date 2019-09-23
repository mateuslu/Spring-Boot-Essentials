package br.com.devdojo.demo.error;

import br.com.devdojo.demo.error.ErrorDetail;
import br.com.devdojo.demo.error.ResourceNotFoundDetails;

public class ValidationErrorDatails extends ErrorDetail {
    private String fild;
    private String fildeMessage;

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;
        private String fild;
        private String fildeMessage;


        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder fild(String fild) {
            this.fild = fild;
            return this;
        }

        public Builder fildeMessage(String fildeMessage) {
            this.fildeMessage = fildeMessage;
            return this;
        }

        public ValidationErrorDatails build() {
            ValidationErrorDatails ValidationErrorDatails = new ValidationErrorDatails();
            ValidationErrorDatails.setStatus(status);
            ValidationErrorDatails.setDetail(detail);
            ValidationErrorDatails.setDeveloperMessage(developerMessage);
            ValidationErrorDatails.setTitle(title);
            ValidationErrorDatails.setTimestamp(timestamp);
            ValidationErrorDatails.fildeMessage = fildeMessage;
            ValidationErrorDatails.fild = fild;
            return ValidationErrorDatails;
        }
    }


}

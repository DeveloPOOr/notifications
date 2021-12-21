package org.tinkoff.notifications.constraint;

public enum ApplicationError {
    NO_EMPLOYEE("No such employee", 404),
    NO_PRESENT("No such present", 404),
    NO_PROJECT("No such project¨", 404),
    NO_NOTIFICATION("No such notification", 404),
    ACCESS_DENIED("You are not allowed to edit this information", 401);

    public final String message;
    public final int code;

    ApplicationError(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ApplicationException exception(String args) {
        return new ApplicationException(this, args);
    }

    public static class ApplicationException extends RuntimeException {

        public final ApplicationExceptionCompanion companion;

        ApplicationException(ApplicationError error, String message) {
            super(error.message + " : " + message);
            this.companion =
                    new ApplicationExceptionCompanion(error.code, error.message + " " + message);
        }

        public record ApplicationExceptionCompanion(int code, String message) {}
    }
}

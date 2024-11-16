package com.system.dates.exceptions;

public class exceptions extends RuntimeException {
    public class appointmentHourConflictoException extends RuntimeException {
        public appointmentHourConflictoException(String message) {
            super(message);
        }
    }

    public class appointmentDuplicadaException extends RuntimeException {
        public appointmentDuplicadaException(String message) {
            super(message);
        }
    }
    
}

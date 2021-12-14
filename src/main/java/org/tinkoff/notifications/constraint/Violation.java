package org.tinkoff.notifications.constraint;

import lombok.Data;

@Data
public class Violation {

    private final String fieldName;

    private final String message;

}

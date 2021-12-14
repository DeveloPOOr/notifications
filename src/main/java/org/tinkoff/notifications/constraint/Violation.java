package org.tinkoff.notifications.constraint;

import lombok.Data;


public record Violation(String fieldName, String message) {}

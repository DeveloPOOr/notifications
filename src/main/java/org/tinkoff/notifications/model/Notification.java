package org.tinkoff.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {
    private long id;
    private String type;
    private Employee employee;
}

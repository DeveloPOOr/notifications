package org.tinkoff.notifications.dto;

import lombok.*;
import org.tinkoff.notifications.model.Employee;

@Data
@AllArgsConstructor
public class NotificationDto {
    private String type;
    private Employee employee;
}


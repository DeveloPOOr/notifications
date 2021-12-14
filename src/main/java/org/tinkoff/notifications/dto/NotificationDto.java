package org.tinkoff.notifications.dto;

import lombok.*;
import org.tinkoff.notifications.model.Employee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class NotificationDto {

    @Pattern(regexp = "(ANNIVERSIRY)|(BIRTHDAY)", message = "Уведомлеие либо день рождение либо годовщина")
    @NotNull(message = "Уведомлеие либо день рождение либо годовщина")
    private String type;

    private Employee employee;
}


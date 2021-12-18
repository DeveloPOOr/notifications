package org.tinkoff.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.tinkoff.notifications.model.Employee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class NotificationDto {

    @Pattern(
            regexp = "(ANNIVERSIRY)|(BIRTHDAY)",
            message = "Уведомление либо день рождения либо годовщина")
    @NotNull(message = "Уведомление либо день рождения либо годовщина")
    private String type;

    private Employee employee;
}

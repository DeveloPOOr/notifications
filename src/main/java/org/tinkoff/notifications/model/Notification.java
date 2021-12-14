package org.tinkoff.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private long id;

    @Pattern(regexp = "(ANNIVERSIRY)|(BIRTHDAY)", message = "Уведомлеие либо день рождение либо годовщина")
    @NotNull(message = "Уведомлеие либо день рождение либо годовщина")
    private String type;

    private Employee employee;
}

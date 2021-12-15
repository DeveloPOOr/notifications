package org.tinkoff.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private long id;

    @Length(min = 3, max = 40, message = "Имя проекта быть от 3 до 40 символов")
    @NotNull(message = "Имя проекта быть от 3 до 40 символов")
    private String name;

    @Length(max = 200, message = "Описание проекта слишком длинное")
    private String description;
}

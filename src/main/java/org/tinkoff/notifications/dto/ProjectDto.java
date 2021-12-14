package org.tinkoff.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ProjectDto {

    @Length(min = 3, max = 40, message = "Имя проекта быть от 3 до 40 символов")
    @NotNull(message = "Имя проекта быть от 3 до 40 символов")
    private String name;

    @Length(max = 200, message = "Описание проекта слишком длинное")
    private String description;
}
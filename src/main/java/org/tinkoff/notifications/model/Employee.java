package org.tinkoff.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id;

    @Length(min = 3, max = 40, message = "Длина ФИО должна быть от 3 до 40 символов")
    @NotNull(message = "Длина ФИО должна быть от 3 до 40 символов")
    private String full_name;

    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Введите пожалуйста корректный номер")
    private String phone;

    private Set<Project> projects;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Введите корректую дату рождения")
    @NotNull(message = "Введите корректую дату рождения")
    private String birthday;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Введите корректную дату начала работы")
    @NotNull(message = "Введите корректную дату начала работы")
    private String start_work;

    private List<Present> wishlist;

    @Length(min = 3, max = 20, message = "Длина города должна быть от 3 до 20 символов")
    @NotNull(message = "Длина города должна быть от 3 до 20 символов")
    private String city;
}

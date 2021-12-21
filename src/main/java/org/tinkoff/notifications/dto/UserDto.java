package org.tinkoff.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.User;

import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Present;
import org.tinkoff.notifications.model.Project;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;

    @Length(min = 3, max = 40, message = "Длина ФИО должна быть от 3 до 40 символов")
    @NotNull(message = "Длина ФИО должна быть от 3 до 40 символов")
    private String full_name;

    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Введите пожалуйста корректный номер")
    private String phone;


    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Введите корректую дату рождения")
    @NotNull(message = "Введите корректую дату рождения")
    private String birthday;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Введите корректную дату начала работы")
    @NotNull(message = "Введите корректную дату начала работы")
    private String start_work;


    @Length(min = 3, max = 20, message = "Длина города должна быть от 3 до 20 символов")
    @NotNull(message = "Длина города должна быть от 3 до 20 символов")
    private String city;
}

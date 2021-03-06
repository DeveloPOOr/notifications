package org.tinkoff.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Present {
    private long id;

    @Length(min = 3, max = 40, message = "Имя подарка быть от 3 до 40 символов")
    @NotNull(message = "Имя подарка быть от 3 до 40 символов")
    private String name;

    @Pattern(
            regexp =
                    "(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?")
    private String link;

    @Length(max = 200, message = "Описание подарка слишком длинное")
    private String description;

    private long employee_id;
}

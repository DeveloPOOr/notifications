package org.tinkoff.notifications.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tinkoff.notifications.model.Present;
import org.tinkoff.notifications.model.Project;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String full_name;
    private String phone;
    private Project project;
    private Date birthday;
    private Date start_work;
    private List<Present> wishlist;
    private String city;
}
package org.tinkoff.notifications.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String full_name;
    private String phone;
    private Date birthday;
    private Date start_work;
    private String city;
}
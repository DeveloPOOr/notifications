package org.tinkoff.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long id;
    private String full_name;
    private String phone;
    private Project project;
    private Date birthday;
    private Date start_work;
    private List<Present> wishlist;
    private String city;
}

package org.tinkoff.notifications.controller;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.dto.UserDto;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.service.EmployeeService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private EmployeeService employeeService;
    private JdbcUserDetailsManager userDetailsManager;
    private PasswordEncoder passwordEncoder;

    public AuthController(EmployeeService employeeService, JdbcUserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public Employee register(@RequestBody @Valid UserDto userDto) {
        userDetailsManager.createUser(new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), Set.of(new SimpleGrantedAuthority("USER"))));
        Employee employee = new Employee();
        employee.setCity(userDto.getCity());
        employee.setBirthday(userDto.getBirthday());
        employee.setFull_name(userDto.getFull_name());
        employee.setStart_work(userDto.getStart_work());
        employee.setPhone(userDto.getPhone());
        employee.setUsername(userDto.getUsername());
        return employeeService.save(employee);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("username") String username) {
        userDetailsManager.deleteUser(username);
    }
}

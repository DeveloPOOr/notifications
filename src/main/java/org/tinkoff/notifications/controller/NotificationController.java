package org.tinkoff.notifications.controller;

import org.springframework.web.bind.annotation.*;
import org.tinkoff.notifications.dto.NotificationDto;
import org.tinkoff.notifications.model.Employee;
import org.tinkoff.notifications.model.Notification;
import org.tinkoff.notifications.service.EmployeeService;
import org.tinkoff.notifications.service.NotificationService;

import static org.tinkoff.notifications.constraint.ApplicationError.NO_NOTIFICATION;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final NotificationService notificationService;
    private final EmployeeService employeeService;

    public NotificationController(NotificationService notificationService, EmployeeService employeeService) {
        this.notificationService = notificationService;
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public void saveNotification(@RequestBody NotificationDto notificationDto, @RequestParam("employee_id") long employee_id) {
        Employee employee = employeeService.findById(employee_id);
        notificationDto.setEmployee(employee);
        notificationService.save(notificationDto);
    }

    @GetMapping("/get")
    public Notification findById(@RequestParam("notification_id")long notification_id) {
        Notification notification = notificationService.findById(notification_id);
        if(notification == null) {
            throw NO_NOTIFICATION.exception(String.format("with id %d", notification_id));
        }
        return notification;
    }

    @PatchMapping("/update")
    public void updateNotification(@RequestBody Notification notification) {
        Notification notificationCheck = notificationService.findById(notification.getId());
        if(notificationCheck == null) {
            throw NO_NOTIFICATION.exception(String.format("with id %d", notification.getId()));
        }
        notificationService.update(notification);
    }

    @DeleteMapping("/delete")
    public void deleteNotification(@RequestBody Notification notification) {
        Notification notificationCheck = notificationService.findById(notification.getId());
        if(notificationCheck == null) {
            throw NO_NOTIFICATION.exception(String.format("with id %d", notification.getId()));
        }
        notificationService.delete(notification);
    }
}

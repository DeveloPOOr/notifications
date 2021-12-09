package org.tinkoff.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectDto {
    private String name;
    private String description;
}
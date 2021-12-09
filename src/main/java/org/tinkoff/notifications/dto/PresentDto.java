package org.tinkoff.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PresentDto {
    private String name;
    private String link;
    private String description;
}

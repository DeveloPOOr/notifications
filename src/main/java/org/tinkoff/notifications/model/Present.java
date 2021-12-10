package org.tinkoff.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Present {
    private long id;
    private String name;
    private String link;
    private String description;
}

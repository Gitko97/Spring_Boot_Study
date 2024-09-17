package org.example.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoRequest {

    private String title;
    private Long order;
    private Boolean completed;

}

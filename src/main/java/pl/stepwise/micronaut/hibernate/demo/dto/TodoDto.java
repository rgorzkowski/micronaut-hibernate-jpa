package pl.stepwise.micronaut.hibernate.demo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto implements Serializable {

    private Long id;

    private String name;

    private boolean completed;
}

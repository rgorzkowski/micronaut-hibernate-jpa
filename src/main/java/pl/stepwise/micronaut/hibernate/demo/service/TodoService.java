package pl.stepwise.micronaut.hibernate.demo.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

import io.micronaut.spring.tx.annotation.Transactional;
import pl.stepwise.micronaut.hibernate.demo.dto.TodoDto;
import pl.stepwise.micronaut.hibernate.demo.model.Todo;
import pl.stepwise.micronaut.hibernate.demo.repository.TodoRepository;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@Singleton
public class TodoService {

    private static final Logger log = getLogger(TodoService.class);

    @Inject
    private TodoRepository todoRepository;

    @Transactional()
    public TodoDto save(TodoDto dto) {
        final Todo todo = new Todo();
        todo.setName(dto.getName());
        todoRepository.save(todo);
        log.info("Persisted todo(id: {})", todo.getId());
        return TodoDto.builder()
                .id(todo.getId())
                .name(todo.getName())
                .completed(todo.isCompleted())
                .build();
    }

    @Transactional(readOnly = true)
    public List<TodoDto> findAll() {
        return todoRepository.findAll().stream()
                .map(t -> TodoDto.builder()
                        .id(t.getId())
                        .name(t.getName())
                        .completed(t.isCompleted())
                        .build()
                ).collect(Collectors.toList());
    }
}

package pl.stepwise.micronaut.hibernate.demo.endpoint;

import javax.inject.Inject;

import java.util.List;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import pl.stepwise.micronaut.hibernate.demo.dto.TodoDto;
import pl.stepwise.micronaut.hibernate.demo.service.TodoService;
import org.h2.tools.Server;

@Controller("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Get("/")
    public HttpResponse<List<TodoDto>> index() {
        final List<TodoDto> all = todoService.findAll();
        return HttpResponse.ok(all);
    }

    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Post("/")
    public HttpResponse<TodoDto> save(@Body TodoDto dto) {
        final TodoDto saved = todoService.save(dto);
        return HttpResponse.created(saved);
    }

    @Inject
    private Server server;

}
package org.example.service;

import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void add() {
        when(this.todoRepository.save(any(TodoEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        TodoRequest expected = new TodoRequest();
        expected.setTitle("Test Title");

        System.out.println(expected);
        TodoEntity actual = this.todoService.add(expected);
        System.out.println(actual);
        assertEquals(expected.getTitle(), actual.getTitle());
    }

    @Test
    void searchById() {
    }
}
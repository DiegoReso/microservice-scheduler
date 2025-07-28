package com.reso.scheduler.controller;


import com.reso.scheduler.business.TaskService;
import com.reso.scheduler.business.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO,
                                              @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(taskService.createTask(token,taskDTO ));
    }
}

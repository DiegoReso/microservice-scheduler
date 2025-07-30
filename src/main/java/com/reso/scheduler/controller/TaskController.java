package com.reso.scheduler.controller;


import com.reso.scheduler.business.TaskService;
import com.reso.scheduler.business.dto.TaskDTO;
import com.reso.scheduler.infrastructure.enums.StatusTaskEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/events")
    public ResponseEntity<List<TaskDTO>> getAllTasks(
            @RequestParam("eventAfter") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime eventAfter,
            @RequestParam("eventBefore") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime eventBefore,
            @RequestParam("status") StatusTaskEnum statusTaskEnum) {
        List<TaskDTO> listTaskDTO = taskService.getTaskByPeriod(eventAfter,eventBefore,statusTaskEnum);
        return ResponseEntity.ok(listTaskDTO);
    }

    @GetMapping("/search-by-email")
    public ResponseEntity<List<TaskDTO>> getTaskByEmail(@RequestParam("email") String email){
        List<TaskDTO> listTaskDTO = taskService.getTaskByEmail(email);
        return ResponseEntity.ok(listTaskDTO);
    }

}

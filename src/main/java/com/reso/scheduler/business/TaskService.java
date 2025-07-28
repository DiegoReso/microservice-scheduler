package com.reso.scheduler.business;

import com.reso.scheduler.business.dto.TaskDTO;
import com.reso.scheduler.business.mapper.TaskConverter;
import com.reso.scheduler.business.mapper.TaskUpdateConverter;
import com.reso.scheduler.infrastructure.entity.TaskEntity;
import com.reso.scheduler.infrastructure.enums.StatusTaskEnum;
import com.reso.scheduler.infrastructure.repository.TaskRepository;
import com.reso.scheduler.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private TaskConverter taskConverter;
    private JwtUtil jwtUtil;
    private TaskUpdateConverter taskUpdateConverter;

    public TaskDTO createTask(String token, TaskDTO dto) {
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setCreateDate(LocalDateTime.now());
        dto.setStatusTaskEnum(StatusTaskEnum.PENDING);
        dto.setUserEmail(email);
        TaskEntity entity = taskConverter.toTaskEntity(dto);

        return taskConverter.toTaskDTO(taskRepository.save(entity));
    }

}

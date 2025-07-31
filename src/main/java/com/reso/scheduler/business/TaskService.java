package com.reso.scheduler.business;

import com.reso.scheduler.business.dto.TaskDTO;
import com.reso.scheduler.business.mapper.TaskConverter;
import com.reso.scheduler.business.mapper.TaskUpdateConverter;
import com.reso.scheduler.infrastructure.entity.TaskEntity;
import com.reso.scheduler.infrastructure.enums.StatusTaskEnum;
import com.reso.scheduler.infrastructure.exceptions.ResourceNotFoundException;
import com.reso.scheduler.infrastructure.repository.TaskRepository;
import com.reso.scheduler.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;
    private final JwtUtil jwtUtil;
    private final TaskUpdateConverter taskUpdateConverter;

    public TaskDTO createTask(String token, TaskDTO dto) {
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setCreateDate(LocalDateTime.now());
        dto.setStatusTaskEnum(StatusTaskEnum.PENDING);
        dto.setUserEmail(email);
        TaskEntity entity = taskConverter.toTaskEntity(dto);
        return taskConverter.toTaskDTO(taskRepository.save(entity));
    }

    public List<TaskDTO> getTaskByPeriod(LocalDateTime eventDateAfter, LocalDateTime eventDateBefore, StatusTaskEnum statusTaskEnum) {
        return taskRepository.findByEventDateBetweenAndStatusTaskEnum(eventDateAfter, eventDateBefore, statusTaskEnum).stream().map(taskConverter::toTaskDTO).collect(Collectors.toList());
    }

    public List<TaskDTO> getTaskByEmail(String email) {
        return taskRepository.findByUserEmail(email).stream().map(taskConverter::toTaskDTO).toList();
    }

    public void deleteTaskById(String id) {

        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task id: '" + id + "' not found ");
        }
        taskRepository.deleteById(id);
    }

    public TaskDTO updateStatusTask(String id, StatusTaskEnum statusTaskEnum) {
         TaskEntity entity =  taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task id: '" + id + "' not found"));
         entity.setStatusTaskEnum(statusTaskEnum);
         TaskEntity entityUpdated = taskRepository.save(entity);
         return taskConverter.toTaskDTO(entityUpdated);
    }

    public TaskDTO updateTask(TaskDTO dto, String id){
        TaskEntity entity = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task id: '" + id + "' not found"));
        taskUpdateConverter.updateTask(dto, entity);
        return taskConverter.toTaskDTO(entity);
    }

}

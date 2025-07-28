package com.reso.scheduler.business.mapper;

import com.reso.scheduler.business.dto.TaskDTO;
import com.reso.scheduler.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskConverter {

    TaskEntity toTaskEntity(TaskDTO dto);

    TaskDTO toTaskDTO(TaskEntity entity);

    List<TaskEntity> toTaskEntityList(List<TaskDTO> dtoList);

    List<TaskDTO> toTaskDTOList(List<TaskEntity> dtoList);

}

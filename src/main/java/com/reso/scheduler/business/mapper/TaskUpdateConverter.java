package com.reso.scheduler.business.mapper;

import com.reso.scheduler.business.dto.TaskDTO;
import com.reso.scheduler.infrastructure.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskUpdateConverter {

    void updateTask(TaskDTO dto, @MappingTarget TaskEntity entity);
}

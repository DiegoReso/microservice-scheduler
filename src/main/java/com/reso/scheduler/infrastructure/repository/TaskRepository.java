package com.reso.scheduler.infrastructure.repository;


import com.reso.scheduler.infrastructure.entity.TaskEntity;
import com.reso.scheduler.infrastructure.enums.StatusTaskEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String> {

    List<TaskEntity> findByEventDateBetweenAndStatusTaskEnum(LocalDateTime eventDateAfter,
                                                             LocalDateTime eventDateBefore,
                                                             StatusTaskEnum statusTaskEnum);

    List<TaskEntity> findByUserEmail(String email);

    boolean existsById(String id);
}

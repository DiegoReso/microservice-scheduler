package com.reso.scheduler.infrastructure.entity;

import com.reso.scheduler.infrastructure.enums.StatusTaskEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("task")
public class TaskEntity {

    @Id
    private String id;
    private String nameTask;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime eventDate;
    private String userEmail;
    private LocalDateTime changeDate;
    private StatusTaskEnum statusTaskEnum;
}
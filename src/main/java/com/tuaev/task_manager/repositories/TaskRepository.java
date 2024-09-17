package com.tuaev.task_manager.repositories;

import com.tuaev.task_manager.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM tasks WHERE status = :status", nativeQuery = true)
    Page<Task> listTasks(@Param("status") String status, Pageable pageable);
}

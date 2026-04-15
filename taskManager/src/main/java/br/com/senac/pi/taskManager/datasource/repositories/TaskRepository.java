package br.com.senac.pi.taskManager.datasource.repositories;

import br.com.senac.pi.taskManager.domain.entities.TaskPriority;
import br.com.senac.pi.taskManager.domain.entities.Task;
import br.com.senac.pi.taskManager.domain.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {
    public List<Task> findAllByPriorityOrderByDueDateAsc(TaskPriority priority);
    public List<Task> findByStatusOrderByDueDateAsc(TaskStatus status);

}

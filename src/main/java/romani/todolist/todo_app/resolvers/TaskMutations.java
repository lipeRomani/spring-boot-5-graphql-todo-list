package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.repositories.TaskRepository;

@Service
public class TaskMutations implements GraphQLMutationResolver {

    private TaskRepository taskRepository;

    @Autowired
    public TaskMutations(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(String title, String description, String status, String userId) {
        Task task = new Task(title, description, status, userId);
        return taskRepository.save(task);
    }
}

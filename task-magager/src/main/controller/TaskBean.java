package bean;

import model.Task;
import dao.TaskDAO;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class TaskBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private TaskDAO taskDAO = new TaskDAO();
    private Task task = new Task();
    private List<Task> tasks;

   
    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = taskDAO.getAll();
        }
        return tasks;
    }


    public void createTask() {
        taskDAO.create(task);
        task = new Task(); 
        tasks = taskDAO.getAll(); 

   
    public void editTask(Task task) {
        this.task = task;
        
    }

    
    public void deleteTask(Task task) {
        taskDAO.delete(task.getId());
        tasks = taskDAO.getAll(); 

   
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

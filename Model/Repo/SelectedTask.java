package Model.Repo;

import Model.Task;

public class SelectedTask {
    private static SelectedTask _instance;
    private Task actualTask;

    public SelectedTask(Task actualTask) {
        this.actualTask = actualTask;
    }

    public static SelectedTask get_instance() {
        return _instance;
    }

    public static Task addTask(Task taskToUse) {
        if (_instance==null){
            _instance=new SelectedTask(taskToUse);
        }
        return _instance.actualTask;
    }

    public void closeTask(){
        _instance=null;
    }

    public Task getActualTask() {
        return actualTask;
    }
}

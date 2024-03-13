package Model.Repo;

import Model.Task;

public class SelectedTask {
    private static SelectedTask _instance;
    private Task actualTask;

    public SelectedTask(Task actualTask) {
        this.actualTask = actualTask;
    }

    /**
     * Devuelve la instancia actual
     * @return Devuelve la instancia actual
     */
    public static SelectedTask get_instance() {
        return _instance;
    }

    /**
     * Añade una tarea a la instancia actual
     * @param taskToUse Recibe la tarea que queremos instanciar
     * @return
     */
    public static Task addTask(Task taskToUse) {
        if (_instance==null){
            _instance=new SelectedTask(taskToUse);
        }
        return _instance.actualTask;
    }

    /**
     * Establece la instacia actual a null
     */
    public void closeTask(){
        _instance=null;
    }

    /**
     * Devuelve la tarea instanciada
     * @return Devuelve la tarea instanciada
     */
    public Task getActualTask() {
        return actualTask;
    }
}

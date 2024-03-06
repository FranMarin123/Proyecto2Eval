package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Project {
    private List<User> members = new ArrayList<>();
    private User boss;
    private String name;
    private String descripcion;
    private List<Task> tasks = new ArrayList<>();

    public Project( User boss, String name, String descripcion) {
        this.boss = boss;
        this.name = name;
        this.descripcion = descripcion;
        this.tasks= new ArrayList<>();
        this.members =new ArrayList<>();
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        boss = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proyect: ").append(name).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Jefe del Equipo: ").append(boss).append("\n");
        sb.append("Miembros del Equipo:\n");
        for (User member : members) {
            sb.append("\t- ").append(member).append("\n");
        }
        sb.append("Tareas del Equipo:\n");
        for (Task task : tasks) {
            sb.append("\t- ").append(task).append("\n");
        }
        return sb.toString();
    }

    /**
     * Crea y añade un integrante
     * @param u Usuario que introduce el jefe
     * @return introduce el miembro al proyecto
     */
    public boolean añadeUsuario(User u) {;
        return members.add(u);
    }

    public List<User> leeUser() {
        return members;
    }

    /**
     * Elimina el mienbro del proyecto mediante un iterator
     * @param nombre el nombre del usuario para eliminarlo
     * @return elimina el usuario
     */
    public int eliminaUser(String nombre) {
        int eliminados = 0;
        Iterator<User> iterator = members.iterator();
        while (iterator.hasNext()) {
            User tmpUser = iterator.next();
            if (tmpUser.getName().equalsIgnoreCase(nombre)) {
                iterator.remove();
                eliminados++;
            }
        }
        return eliminados;
    }
    /**
     * Crea y añade un tarea
     * @param t tarea que introduce el jefe
     * @return introduce el miembro al proyecto
     */
    public boolean creaTask(Task t) {
        return tasks.add(t);
    }

    public List<Task> leeTask() {
        return tasks;
    }
    /**
     * Elimina el tarea del proyecto
     * @param nombre el nombre de la tarea para eliminarlo
     * @return elimina la tarea
     */
    public int eliminaTask(String nombre) {
        int eliminados = 0;
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task tmpTask = iterator.next();
            if (tmpTask.getName().equalsIgnoreCase(nombre)) {
                iterator.remove();
                eliminados++;
            }
        }
        return eliminados;
    }

}

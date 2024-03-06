package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Project {
    private List<User> member= new ArrayList<>();
    private User boss;
    private String name;
    private String descripcion;
    private List<Task> tasks = new ArrayList<>();

    public Project( User boss, String name, String descripcion) {
        this.boss = boss;
        this.name = name;
        this.descripcion = descripcion;
        this.tasks= new ArrayList<>();
        this.member=new ArrayList<>();
    }

    public List<User> getMember() {
        return member;
    }

    public void setMember(List<User> member) {
        this.member=member;
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
        return "Project " + name+
                "member=" + member +
                ", boss=" + boss +
                ", descripcion='" + descripcion + '\'' +
                ", tareas=" + tasks;
    }

    /**
     * Crea y añade un integrante
     * @param u Usuario que introduce el jefe
     * @return introduce el miembro al proyecto
     */
    public boolean añadeUsuario(User u) {;
        return member.add(u);
    }

    public List<User> leeUser() {
        return member;
    }

    /**
     * Elimina el mienbro del proyecto
     * @param nombre el nombre del usuario para eliminarlo
     * @return elimina el usuario
     */
    public int eliminaUser(String nombre) {
        int eliminados = 0;
        Iterator<User> iterator = member.iterator();
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

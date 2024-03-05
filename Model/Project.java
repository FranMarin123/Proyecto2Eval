package Model;

import java.util.List;

public class Project {
    private List<User> member;
    private User boss;
    private String name;
    private String descripcion;
    private List<Task> tasks;

    public Project(List<User> member, User boss, String name, String descripcion, List<Task> tasks) {
        this.member = member;
        this.boss = boss;
        this.name = name;
        this.descripcion = descripcion;
        this.tasks = tasks;
    }

    public List<User> getMember() {
        return member;
    }

    public void setMember(List<User> member) {
        this.member = member;
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
}

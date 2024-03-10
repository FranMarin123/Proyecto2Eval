package test;

import Model.Project;
import Model.Task;
import Model.User;
import Enum.Estado;

public class testModel {
    public static void main(String[] args) {

    User user1 = new User("jose antonio","12354","josant@gmail.com","josant",2);
    User user2 = new User("Mart","3563","marta@gmail.com","marta",2);
    User user3 = new User("anto","3563","antonio@gmail.com","antonio",5);

    Task task=new Task(Estado.Sin_Iniciar,user2,"verificar","comprobar_datos");
    Task task2=new Task(Estado.Iniciada,user2,"controlador","Gestionar");
    Project project = new Project(user1,"gestor","aplicacion de Gestor");
    project.createUser(user2);
    project.createUser(user3);
    project.createTask(task);
    project.createTask(task2);
    System.out.println(project);
    System.out.println("Aqui quitamos el usuario a travez del nombre del usuario");
    project.DeleteUser("antonio");
    System.out.println(project);
    System.out.println("ahora cambiemos el estado de tarea");
    task2.setEstado(Estado.Finalizado);
    System.out.println(project);
    }
}

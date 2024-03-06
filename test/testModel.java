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
    Task task2=new Task(Estado.En_Proceso,user2,"controlador","Gestionar");
    Project project = new Project(user1,"gestor","aplicacion de Gestor");
    project.añadeUsuario(user2);
    project.añadeUsuario(user3);
    project.creaTask(task);
    project.creaTask(task2);
        System.out.println(project);
        System.out.println("Aqui quitamos el usuario a travez del nombre del usuario");
        project.eliminaUser("antonio");
        System.out.println(project);

    }
}

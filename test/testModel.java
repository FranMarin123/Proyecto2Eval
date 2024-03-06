package test;

import Model.Project;
import Model.Task;
import Model.User;
import Enum.Estado;

public class testModel {
    public static void main(String[] args) {

    User user1 = new User("josant","12354","josant@gmail.com","jose Antonio",2);
    User user2 = new User("Marta","3563","marta@gmail.com","marta",2);
    User user3 = new User("antonio","3563","antonio@gmail.com","anto",5);

    Task task=new Task(Estado.Sin_Iniciar,user2,"verificar","comprobar_datos");
    Task task2=new Task(Estado.En_Proceso,user2,"controlador","Gestionar");


    }
}

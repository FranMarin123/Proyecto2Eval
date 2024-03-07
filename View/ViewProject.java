package View;

import Interfaces.iViewProject;
import Model.Project;
import Model.User;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ViewProject implements iViewProject {

    /**
     * @author Javier Fernández
     * Método para mostrar el Menu Proyectos de 5 opciones para elegir
     * Method to display the project menu with 5 options to choose
     */
    @Override
    public int menuProject() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("      === \uD83C\uDF1F MENÚ PROYECTO \uD83C\uDF1F ===    ");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("  = [1]. MOSTRAR PROYECTOS \uD83D\uDC40️ ");
        System.out.println("  == [2]. CREAR PROYECTOS \uD83D\uDEE0️      ");
        System.out.println("  === [3]. ELIMINAR PROYECTOS \uD83D\uDDD1️️        ");
        System.out.println("  ==== [4]. ENTRAR EN UN PROYECTO \uD83C\uDF10️️        ");
        System.out.println("  ===== [5]. SALIR / CERRAR SESION \uD83D\uDEAA️        ");
        System.out.println("╚══════════════════════════════════════╝");

        try {
            // Obtén la opción seleccionada del usuario
            String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");

            // Convierte la entrada del usuario a un entero
            int selectedOption = Integer.parseInt(userInput);

            // Retorna la opción seleccionada
            System.out.print("✅ Opción seleccionada: ");
            switch (selectedOption) {
                case 1:
                    System.out.println(selectedOption + " (Mostrar Proyectos)");
                    break;
                case 2:
                    System.out.println(selectedOption + " (Crear Proyectos)");
                    break;
                case 3:
                    System.out.println(selectedOption + " (Eliminar Proyectos)");
                    break;
                case 4:
                    System.out.println(selectedOption + " (Entrar en un Proyecto)");
                    break;
                case 5:
                    System.out.println(selectedOption + " (Salir / Cerrar Sesión)");
                    break;
                default:
                    System.out.println(selectedOption);
                    break;
            }
            return selectedOption;

        } catch (NumberFormatException e) {
            // Manejo de error en caso de que la entrada no sea un número entero
            System.out.println("❌ Opción no válida. Por favor, ingresa un número valido.");
            return -1;
        }
    }

    /**
     * @author Javier Fernández
     * Metodo para crear un proyecto
     * Method to create a project
     */
    @Override
    public Project createProject() {
        // Muestra el menu
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         === CREAR PROYECTO ===       ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre: ");
        String projectNameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Descripción: ");
        String projectDescriptionInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        // Crea un objeto Project temporal con la entrada del usuario
        Project temporaryProject = new Project(null, projectNameInput, projectDescriptionInput);

        // Devuelve el objeto Project temporal
        return temporaryProject;
    }


    /**
     * @author Javier Fernández
     * Metodo para eliminar un proyecto
     * Method to delete a project
     */
    @Override
    public void removeProject() {
        // Muestra el menu
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       === ELIMINAR PROYECTO ===      ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre: ");
        String usernameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Descripción: ");
        String descriptionInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");
    }

    @Override
    public String enterProject() {
        // Mostar proyectos
        listProject();

        // Muestra el menu
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║ === ESCRIBE EL PROYECTO QUE DESEA MODIFICAR === ║");
        System.out.println("╠═════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre: ");
        String usernameInput = scanner.nextLine();
        System.out.println("╚═════════════════════════════════════════════════╝");

        return usernameInput;
    }

    @Override
    public Project listProject() {
        // Muestra el menu
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          ===  PROYECTOS ===          ║");
        System.out.println("╠══════════════════════════════════════╣");
/*
        // Verifica que la lista de proyectos no sea nula antes de intentar mostrarla.
        List<Project> projects = Project.getProjects();
        if (projects != null && !projects.isEmpty()) {
            System.out.println("║ Detalles de Proyectos:");

            // Itera sobre la lista de proyectos y muestra detalles.
            for (Project project : projects) {
                System.out.println("║ - Nombre: " + project.getName());
                System.out.println("║   Descripción: " + project.getDescripcion());

                // Muestra los nombres de los usuarios asociados al proyecto.
                List<User> projectMembers = project.getMembers();
                if (projectMembers != null && !projectMembers.isEmpty()) {
                    System.out.println("║   Usuarios en el Proyecto:");
                    for (User member : projectMembers) {
                        System.out.println("║   - " + member.getNameUser());
                    }
                } else {
                    System.out.println("║   No hay usuarios asociados a este proyecto.");
                }

                System.out.println("║ ------------------------------------");
            }
        } else {
            System.out.println("║ No hay proyectos disponibles.");
        }

        System.out.println("╚══════════════════════════════════════╝");*/
        return null;
    }

    @Override
    public void modifyProject() {

    }
}
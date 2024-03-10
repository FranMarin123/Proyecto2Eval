package View;

import Interfaces.iViewProject;
import Model.Project;
import Model.User;

import javax.swing.*;
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
        System.out.println("      === \uD83C\uDF1F MENÚ PRINCIPAL \uD83C\uDF1F ===    ");
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
    public Project removeProject() {
        // Muestra el menu
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       === ELIMINAR PROYECTO ===      ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre: ");
        String projectNameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Descripción: ");
        String descriptionInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        // Crear y devolver un nuevo objeto Project con la información ingresada
        return new Project(null, projectNameInput, descriptionInput);
    }

    /**
     * @author Javier Fernández
     * Metodo para mostrar un proyecto
     * Method to show a project
     * @return
     */
    @Override
    public Project showProject() {
        Project currentProject = null;

        if (currentProject != null) {
            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║           ===  PROYECTO ===          ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println(" * Detalles del Proyecto *");
            System.out.println(" \uD83D\uDC64 Nombre: " + currentProject.getName());
            System.out.println(" \uD83D\uDCDD Descripción: " + currentProject.getDescripcion());

            // Mostrar el jefe del equipo
            User boss = currentProject.getBoss();
            if (boss != null) {
                System.out.println(" \uD83D\uDC68‍🚀 Jefe del Equipo: " + boss.getNameUser());
            } else {
                System.out.println(" ❌ No hay jefe del equipo asignado.");
            }

            if (currentProject.getMembers() != null && !currentProject.getMembers().isEmpty()) {
                System.out.println(" \uD83E\uDD16 Miembros del Proyecto:");

                for (User member : currentProject.getMembers()) {
                    System.out.println(" \uD83E\uDD16 - " + member.getNameUser());
                }
            } else {
                System.out.println(" ❌ No hay usuarios asociados a este proyecto.");
            }
        } else {
            System.out.println(" ❌ No hay proyecto actual.");
        }
        return currentProject;
    }

    @Override
    public Project listProject(List<Project> projects) {
        Project selectedProject = null;

        if (projects != null && !projects.isEmpty()) {
            int projectIndex = 1;

            System.out.println();
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║        === LISTA DE PROYECTOS ===      ║");
            System.out.println("╠════════════════════════════════════════╣");

            // Mostrar la lista de proyectos
            for (Project project : projects) {
                System.out.println(" [" + projectIndex + "] " + project.getName());
                projectIndex++;
            }

            System.out.println("╚══════════════════════════════════════╝");
        }
        return selectedProject;
    }
}
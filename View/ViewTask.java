package View;

import Interfaces.iViewTask;
import Model.Project;
import Model.Task;

import javax.swing.*;
import java.util.Scanner;

public class ViewTask implements iViewTask {
    @Override
    public int menuTask() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                  === \uD83C\uDF1F MENÚ PROYECTO \uD83C\uDF1F ===    ");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.println("  = [1]. MOSTRAR MIEMBROS \uD83D\uDC40️ ");
        System.out.println("  == [2]. AÑADIR MIEMBROS ➕️      ");
        System.out.println("  === [3]. ELIMINAR MIEMBROS \uD83D\uDDD1️️        ");
        System.out.println("  ==== [4]. AÑADIR TAREA ➕️️        ");
        System.out.println("  ===== [5]. ELIMINAR TAREA \uD83D\uDDD1️️        ");
        System.out.println("  ====== [6]. MOSTRAR TAREA DE TU USUARIO \uD83D\uDC40️        ");
        System.out.println("  ======= [7]. MOSTRAR TODAS TAREA DE TU PROYECTO \uD83D\uDC40️        ");
        System.out.println("  ======== [8]. SELECCIONAR TAREA ☑️️        ");
        System.out.println("  ========= [9]. SALIR PROYECTO \uD83D\uDEAA️        ");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        try {
            // Obtiene la opción seleccionada del usuario
            String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");

            // Convierte la entrada del usuario a un entero
            int selectedOption = Integer.parseInt(userInput);

            // Mensaje opción seleccionada
            System.out.print("✅ Opción seleccionada: ");
            switch (selectedOption) {
                case 1:
                    System.out.println(selectedOption + " (Mostrar Miembros)");
                    break;
                case 2:
                    System.out.println(selectedOption + " (Añadir Miembros)");
                    break;
                case 3:
                    System.out.println(selectedOption + " (Eliminar Miembros)");
                    break;
                case 4:
                    System.out.println(selectedOption + " (Añadir Tarea)");
                    break;
                case 5:
                    System.out.println(selectedOption + " (Eliminar Tarea)");
                    break;
                case 6:
                    System.out.println(selectedOption + " (Mostrar Tarea de tu Usuario)");
                    break;
                case 7:
                    System.out.println(selectedOption + " (Mostrar Todas Tarea de tu Proyecto)");
                    break;
                case 8:
                    System.out.println(selectedOption + " (Seleccionar Tarea)");
                    break;
                case 9:
                    System.out.println(selectedOption + " (Salir Proyecto)");
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

    @Override
    public Task createTask() {
        // Muestra el menu
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          === CREAR TAREA ===         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre Usuario Asigando: ");
        String taskNameUserInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Nombre Tarea: ");
        String taskNameTaskInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Descripción: ");
        String taskDescriptionInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        // Crea un objeto Task temporal con la entrada del usuario
        Task temporaryTask = new Task(taskNameUserInput, taskNameTaskInput, taskDescriptionInput);

        // Devuelve el objeto Project temporal
        return temporaryTask;
    }

    @Override
    public void removeTask() {

    }

    @Override
    public void showTask() {

    }

    @Override
    public void listTask() {

    }
}

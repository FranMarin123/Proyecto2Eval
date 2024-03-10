package View;

import Interfaces.iViewTask;
import Model.Task;

import javax.swing.*;
import java.util.ArrayList;
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

        // Solicitar la entrada del usuario
        String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");

        // Convertir la entrada a un entero y devolverlo
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número válido.");
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
    public Task removeTask() {

        return null;
    }

    @Override
    public void showTask(Task taskToShow) {

    }

    @Override
    public void listTask(ArrayList<Task> tasks) {

    }
}

package View;

import Interfaces.IViewMainMenu;

import javax.swing.*;

public class MainMenu implements IViewMainMenu {

    /**
     * @author Javier Fernández
     * Método para mostrar el Menu Prinicpal de 6 opciones para elegir
     * Method to display the main menu with 6 options to choose
     */
    public void displayMainMenu() {
        // Muestra el menu
        int maxAttempts = 3;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            // Muestra el menú
            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║          === \uD83C\uDF1F MENÚ PRINCIPAL \uD83C\uDF1F ===           ║");
            System.out.println("║ = [1]. PROYECTOS \uD83D\uDDC2️                     ║");
            System.out.println("║ == [2]. TAREAS \uD83D\uDCCB                  ║");
            System.out.println("║ === [3]. Insertar \uD83D\uDCE5                 ║");
            System.out.println("║ ==== [4]. Actualizar \uD83D\uDD04              ║");
            System.out.println("║ ===== [5]. Borrar \uD83D\uDDD1️                 ║");
            System.out.println("╚══════════════════════════════════════╝");

            String userInput = JOptionPane.showInputDialog(null, "· Selecciona una opción (Intento " + attempt + " de " + maxAttempts + "):");

            if (isValidOption(userInput)) {
                break;
            } else {
                System.out.println("❌ Opción no válida. Por favor, ingresa un número entre 1 y 5.");
                if (attempt < maxAttempts) {
                    System.out.println("\uD83D\uDD04 Inténtalo de nuevo.");
                } else {
                    System.out.println("❌ Has agotado los intentos. Saliendo del programa.");
                    System.exit(0);
                }
            }
        }
    }

    private boolean isValidOption(String userInput) {
        try {
            int option = Integer.parseInt(userInput);
            return option >= 1 && option <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

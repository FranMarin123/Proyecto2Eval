package View;

import Interfaces.iViewMainMenu;

import javax.swing.*;

public class MainMenu implements iViewMainMenu {

    /**
     * @author Javier Fernández
     * Método para mostrar el Menu Prinicpal de 6 opciones para elegir
     * Method to display the main menu with 6 options to choose
     */
    public void displayMainMenu() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("      === \uD83C\uDF1F MENÚ PRINCIPAL \uD83C\uDF1F ===    ");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("  = [1]. REGISTRAR USER \uD83D\uDCDD️ ");
        System.out.println("  == [2]. LOGIN USER \uD83D\uDD10      ");
        System.out.println("  === [3]. SALIR \uD83D\uDEAA️        ");
        System.out.println("╚══════════════════════════════════════╝");

        String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");
    }
}

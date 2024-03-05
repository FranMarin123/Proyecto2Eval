package View;

import java.util.Scanner;

public class ViewUser {

    public static void displayLogIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         === INICIAR SESIÓN ===       ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print("\uD83D\uDC64 Nombre de usuario: ");
        String usernameInput = scanner.nextLine();
        System.out.print("\uD83D\uDD10 Contraseña: ");
        String passwordInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        int maxAttempts = 3;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("· Selecciona una opción (Intento " + attempt + " de " + maxAttempts + "): ");
            String userInput = scanner.nextLine();

            if (isValidOption(userInput)) {
                break; // Salir del bucle si la opción es válida
            } else {
                System.out.println("❌ Opción no válida. Por favor, ingresa un número entre 1 y 6.");
                if (attempt < maxAttempts) {
                    System.out.println("\uD83D\uDD04 Inténtalo de nuevo.");
                } else {
                    System.out.println("❌ Has agotado los intentos.");
                }
            }
        }
    }

    private static boolean isValidOption(String userInput) {
        try {
            int option = Integer.parseInt(userInput);
            return option >= 1 && option <= 6;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
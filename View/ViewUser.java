package View;

import java.util.Scanner;

public class ViewUser {

    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de registro
     *
     * Method to display the registration menu
     */
    public static void displayRegister() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          === REGISTRARSE ===         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
        String usernameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Contraseña: ");
        String passwordInput = scanner.nextLine();
        System.out.print(" \uD83D\uDCE7 Correo Electrónico: ");
        String emailInput = scanner.nextLine();
        System.out.print(" \uD83D\uDC68 Nombre: ");
        String nameInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        if (registerUser(usernameInput, passwordInput, emailInput, nameInput)) {
            System.out.println("✅ Inicio de sesión exitoso.");
            System.out.println("\uD83D\uDC4B ¡Bienvenido, "+ usernameInput + "!");
        } else {
            System.out.println("❌ Error en el registro. Por favor, inténtalo de nuevo.");
        }
    }


    private static boolean registerUser(String username, String password, String email, String name) {
        return true;
    }

    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de inicio de sesión
     *
     * Method to display the log in menu
     */
    public static void displayLogIn() {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 3;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║        === INICIAR SESIÓN ===        ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
            String usernameInput = scanner.nextLine();
            System.out.print(" \uD83D\uDD10 Contraseña: ");
            String passwordInput = scanner.nextLine();
            System.out.println("╚══════════════════════════════════════╝");

            if (isValidLogin(usernameInput, passwordInput)) {
                System.out.println("✅ Inicio de sesión exitoso.");
                System.out.println("\uD83D\uDC4B ¡Bienvenido, "+ usernameInput + "!");
                break;
            } else {
                System.out.println("❌ Inicio de sesión fallido. Usuario o contraseña incorrectos.");
                if (attempt < maxAttempts) {
                    System.out.println("Inténtalo de nuevo. Intento " + (attempt + 1) + " de " + maxAttempts + ".");
                } else {
                    System.out.println("❌ Has agotado los intentos de inicio de sesión.");
                }
            }
        }
    }

    private static boolean isValidLogin(String username, String password) {
        return true;
    }
}
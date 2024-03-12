package View;

import Interfaces.iViewLogin;
import Model.User;

import java.util.Scanner;

public class ViewLogin implements iViewLogin {
    Scanner scanner = new Scanner(System.in);

    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de registro
     * Method to display the registration menu
     */
    public User displayRegister() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        === \uD83D\uDD11 REGISTRARSE \uD83D\uDD11 ===         ║");
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

        // Crear un usuario temporal con los datos ingresados por el usuario
        User temporaryUser = new User(usernameInput, passwordInput, emailInput, nameInput);

        // Puedes devolver este usuario temporal o utilizarlo según tus necesidades
        return temporaryUser;
    }

    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de inicio de sesión
     * Method to display the log in menu
     */
    public User displayLogIn() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        === \uD83D\uDD11 INICIAR SESIÓN \uD83D\uDD11 ===        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
        String usernameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Contraseña: ");
        String passwordInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        // Crear un usuario temporal con los datos ingresados por el usuario
        return new User(usernameInput, passwordInput, null, null);
    }

    /**
     * @Author: Javier Fernández
     * Metodo para mostrar mensaje de inicio de sesión exitoso
     * Method to display a successful login message
     */
    public void showMessageStartSessionSuccessful() {
        System.out.println("✅ Inicio de sesión exitoso.");
    }
    public void showMessageStartSessionFailed() {
        System.out.println("❌ Inicio de sesión fallido. Usuario o contraseña incorrectos.");
    }
}
package View;

import Interfaces.iViewLogin;
import Model.User;

import java.util.Scanner;

public class ViewLogin implements iViewLogin {

    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de registro
     * Method to display the registration menu
     */
    public User displayRegister() {
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

        // Crear un usuario temporal con los datos ingresados por el usuario
        User temporaryUser = new User(usernameInput, passwordInput, emailInput, nameInput, '0');

        // Puedes devolver este usuario temporal o utilizarlo según tus necesidades
        return temporaryUser;
    }
    
    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de inicio de sesión
     * Method to display the log in menu
     */
    public void displayLogIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        === INICIAR SESIÓN ===        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
        String usernameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Contraseña: ");
        String passwordInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");
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
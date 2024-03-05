package Serializator;

import java.io.*;


public class Serializator {

    public static boolean serializeObject(Object obj, String fileName) {
        boolean comp = false;
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
        } catch (IOException e) {
        }
        return comp;
    }

    // Función para deserializar un objeto desde un archivo
    public static Object deserializeObject(String fileName) {
        Object obj = null;
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            obj = objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return obj;
    }
}



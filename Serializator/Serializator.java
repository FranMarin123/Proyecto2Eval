package Serializator;

import java.io.*;


public class Serializator {

        public static void serializeObject(Object obj, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
        } catch (IOException e) {
        }
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



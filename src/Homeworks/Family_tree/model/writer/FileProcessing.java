package Homeworks.family_tree.model.writer;

// import java.io.*; // либо
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Класс обработка файлов
 */

public class FileProcessing implements WritingFileInter, ReadingFileInter {
    // Используем интерфейс Serializable, и другие классы для создания методов
    // чтения, сохранения и записи, которые импортируеим из java.io.*

    @Override
    public boolean createSaveWriteFile(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object readFile(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

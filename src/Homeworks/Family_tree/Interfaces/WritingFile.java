package Homeworks.family_tree.Interfaces;

import java.io.Serializable;

/**
 * Интерфейс, Записывание файла
 */
public interface WritingFile {

    /**
     * Метод, записать файл
     */

    boolean createSaveWriteFile(Serializable serializable, String filePath);

}

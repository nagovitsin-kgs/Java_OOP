package Homeworks.family_tree.writer;

import java.io.Serializable;

/**
 * Интерфейс, Записывание файла
 */
public interface WritingFileInter {

    /**
     * Метод, записать файл
     */

    boolean createSaveWriteFile(Serializable serializable, String filePath);

}

package Lesson_01.Ex006.Interface;

import Lesson_01.Ex006.Document.TextDocument;

public interface Saveable {
    void SaveAs(TextDocument document, String path);
}

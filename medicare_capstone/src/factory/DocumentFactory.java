package factory;

import javax.swing.text.Document;

public abstract class DocumentFactory {
    public abstract Document createDocument(String type);
}

package factory;

public class ConcreteDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument(String type) {
        if (type.equalsIgnoreCase("INVOICE")) {
            return new Invoice();
        } else if (type.equalsIgnoreCase("REPORT")) {
            return new Report();
        }
        return null;
    }
}

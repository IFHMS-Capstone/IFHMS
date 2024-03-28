package factory;

import javax.swing.text.Document;

public class Invoice implements Document {
    @Override
    public void displayInfo() {
        System.out.println("This is an invoice document.");
    }
}

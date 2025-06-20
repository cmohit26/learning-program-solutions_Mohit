package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise2.code;

public class Main {
    // DocumentFactoryTest.java
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.createDocument();
        word.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
    }
}

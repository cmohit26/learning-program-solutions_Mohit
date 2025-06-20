package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise2.code;

// WordDocumentFactory.java
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

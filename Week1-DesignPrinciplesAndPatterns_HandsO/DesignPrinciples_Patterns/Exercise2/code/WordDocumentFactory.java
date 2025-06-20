package DeepSkilling.EngConcepts.DesignPrinciples_Patterns.Exercise2.code;

// WordDocumentFactory.java
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

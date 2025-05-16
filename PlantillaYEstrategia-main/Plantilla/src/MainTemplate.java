public class MainTemplate {
    public static void main(String[] args) {
        System.out.println("Analizando documentos con el patrón Template Method...\n");

        DataMiner doc = new DocDataMiner();
        DataMiner pdf = new PDFDataMiner();
        DataMiner csv = new CSVDataMiner();

        System.out.println("---- DOC ----");
        doc.mine("documento.doc");

        System.out.println("\n---- PDF ----");
        pdf.mine("archivo.pdf");

        System.out.println("\n---- CSV ----");
        csv.mine("datos.csv");
    }
}

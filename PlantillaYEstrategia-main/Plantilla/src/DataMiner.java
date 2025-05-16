public abstract class DataMiner {

    public final void mine(String path) {
        File file = openFile(path);
        RawData rawData = extractData(file);
        Data data = parseData(rawData);
        Analysis analysis = analyzeData(data);
        sendReport(analysis);
        closeFile(file);
    }

    public abstract File openFile(String path);
    public abstract RawData extractData(File file);
    public abstract Data parseData(RawData rawData);

    public Analysis analyzeData(Data data) {
        System.out.println("Analizando datos...");
        return new Analysis(); // Implementación por defecto
    }

    public void sendReport(Analysis analysis) {
        System.out.println("Enviando reporte...");
    }

    public void closeFile(File file) {
        System.out.println("Cerrando archivo...");
    }
}

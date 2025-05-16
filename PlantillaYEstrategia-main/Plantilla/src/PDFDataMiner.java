public class PDFDataMiner extends DataMiner {

    @Override
    public File openFile(String path) {
        System.out.println("Abriendo archivo PDF: " + path);
        return new File(path);
    }

    @Override
    public RawData extractData(File file) {
        System.out.println("Extrayendo datos desde PDF...");
        return new RawData();
    }

    @Override
    public Data parseData(RawData rawData) {
        System.out.println("Parseando datos del PDF...");
        return new Data();
    }

    @Override
    public void closeFile(File file) {
        System.out.println("Cerrando archivo PDF...");
    }
}

public class CSVDataMiner extends DataMiner {

    @Override
    public File openFile(String path) {
        System.out.println("Abriendo archivo CSV: " + path);
        return new File(path);
    }

    @Override
    public RawData extractData(File file) {
        System.out.println("Extrayendo datos desde CSV...");
        return new RawData();
    }

    @Override
    public Data parseData(RawData rawData) {
        System.out.println("Parseando datos del CSV...");
        return new Data();
    }

    @Override
    public void closeFile(File file) {
        System.out.println("Cerrando archivo CSV...");
    }
}

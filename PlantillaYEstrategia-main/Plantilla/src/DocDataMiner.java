public class DocDataMiner extends DataMiner {

    @Override
    public File openFile(String path) {
        System.out.println("Abriendo archivo DOC: " + path);
        return new File(path);
    }

    @Override
    public RawData extractData(File file) {
        System.out.println("Extrayendo datos desde DOC...");
        return new RawData();
    }

    @Override
    public Data parseData(RawData rawData) {
        System.out.println("Parseando datos del DOC...");
        return new Data();
    }

    @Override
    public void closeFile(File file) {
        System.out.println("Cerrando archivo DOC...");
    }
}

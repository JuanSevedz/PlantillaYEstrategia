public class Client {
    public static void main(String[] args) {
        DataMiner miner;

        miner = new PDFDataMiner();
        miner.mine("archivo.pdf");

        miner = new CSVDataMiner();
        miner.mine("archivo.csv");

        miner = new DocDataMiner();
        miner.mine("archivo.doc");
    }
}

public class RutaTuristica implements EstrategiaRuta {
    @Override
    public String calcular(String origen, String destino) {
        return "Ruta turística desde " + origen + " hasta " + destino;
    }
}

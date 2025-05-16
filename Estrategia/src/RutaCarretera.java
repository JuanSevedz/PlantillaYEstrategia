public class RutaCarretera implements EstrategiaRuta {
    @Override
    public String calcular(String origen, String destino) {
        return "Ruta por carretera desde " + origen + " hasta " + destino;
    }
}

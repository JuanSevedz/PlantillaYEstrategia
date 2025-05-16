public class RutaPeatonal implements EstrategiaRuta {
    @Override
    public String calcular(String origen, String destino) {
        return "Ruta a pie desde " + origen + " hasta " + destino;
    }
}

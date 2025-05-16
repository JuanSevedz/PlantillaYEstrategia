public class RutaCiclista implements EstrategiaRuta {
    @Override
    public String calcular(String origen, String destino) {
        return "Ruta en bicicleta desde " + origen + " hasta " + destino;
    }
}

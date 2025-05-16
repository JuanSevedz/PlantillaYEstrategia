public class RutaTransportePublico implements EstrategiaRuta {
    @Override
    public String calcular(String origen, String destino) {
        return "Ruta en transporte público desde " + origen + " hasta " + destino;
    }
}

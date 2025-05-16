public class Cliente {
    public static void main(String[] args) {
        Navegador navegador = new Navegador();

        navegador.setEstrategia(new RutaCarretera());
        System.out.println(navegador.calcularRuta("Bogotá", "Medellín"));

        navegador.setEstrategia(new RutaPeatonal());
        System.out.println(navegador.calcularRuta("Parque Central", "Museo"));

        navegador.setEstrategia(new RutaTransportePublico());
        System.out.println(navegador.calcularRuta("Estación A", "Estación B"));

        navegador.setEstrategia(new RutaCiclista());
        System.out.println(navegador.calcularRuta("Parque", "Universidad"));

        navegador.setEstrategia(new RutaTuristica());
        System.out.println(navegador.calcularRuta("Hotel", "Sitios históricos"));
    }
}

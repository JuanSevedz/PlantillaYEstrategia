package com.navegador;

public class Navegador {
    private EstrategiaRuta estrategiaRuta;

    public void setEstrategia(EstrategiaRuta estrategiaRuta) {
        this.estrategiaRuta = estrategiaRuta;
    }

    public String calcularRuta(String origen, String destino) {
        if (estrategiaRuta == null) {
            return "No se ha definido estrategia de ruta";
        }
        return estrategiaRuta.calcular(origen, destino);
    }
}
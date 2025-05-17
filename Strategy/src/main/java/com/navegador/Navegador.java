package com.navegador;

public class Navegador {
    private EstrategiaRuta estrategia;

    public Navegador(EstrategiaRuta estrategia) {
        this.estrategia = estrategia;
    }

    public String calcularRuta(String origen, String destino) {
        return estrategia.calcular(origen, destino);
    }
}

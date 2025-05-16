package com.navegador;

public class Cliente {
    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        navegador.setEstrategia(new RutaCarretera());
        String resultado = navegador.calcularRuta("Bogotá", "Medellín");
        System.out.println(resultado);
    }
}
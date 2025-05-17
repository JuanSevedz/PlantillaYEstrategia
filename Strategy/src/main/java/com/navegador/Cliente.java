package com.navegador;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("🌍 Ciudad origen: ");
        String origen = scanner.nextLine();

        System.out.print("🌍 Ciudad destino: ");
        String destino = scanner.nextLine();

        EstrategiaRuta estrategia = new RutaCarretera();
        Navegador navegador = new Navegador(estrategia);

        String resultado = navegador.calcularRuta(origen, destino);
        System.out.println(resultado);
    }
}

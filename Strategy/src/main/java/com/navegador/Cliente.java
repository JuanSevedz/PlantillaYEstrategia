package com.navegador;

import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🌍 Bienvenido al Navegador de Rutas");
        System.out.print("Ingrese ciudad de origen: ");
        String origen = sc.nextLine();

        System.out.print("Ingrese ciudad de destino: ");
        String destino = sc.nextLine();

        System.out.println("\nSeleccione el tipo de ruta:");
        System.out.println("1. 🚗 Ruta por carretera");
        System.out.println("2. 🚶 Ruta peatonal");
        System.out.println("3. 🏛️ Ruta turística");
        System.out.println("4. 🚌 Ruta en transporte público");
        System.out.println("5. 🚴 Ruta ciclista");
        System.out.print("Opción (1-5): ");
        int opcion = sc.nextInt();
        sc.nextLine();

        EstrategiaRuta estrategia;

        switch (opcion) {
            case 1:
                estrategia = new RutaCarretera();
                break;
            case 2:
                estrategia = new RutaPeatonal();
                break;
            case 3:
                estrategia = new RutaTuristica();
                break;
            case 4:
                estrategia = new RutaTransportePublico();
                break;
            case 5:
                estrategia = new RutaCiclista();
                break;
            default:
                System.out.println("❌ Opción inválida. Usando ruta por carretera por defecto.");
                estrategia = new RutaCarretera();
                break;
        }

        Navegador navegador = new Navegador(estrategia);
        String resultado = navegador.calcularRuta(origen, destino);
        System.out.println("\n" + resultado);
    }
}

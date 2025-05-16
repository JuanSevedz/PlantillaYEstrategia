package com.navegador;

import org.openrouteservice.client.*;
import org.openrouteservice.client.model.*;
import org.locationtech.jts.geom.Coordinate;
import java.util.List;

public class RutaCarretera implements EstrategiaRuta {
    private static final String API_KEY = "TU_API_KEY";

    @Override
    public String calcular(String origen, String destino) {
        try {
            Coordinate from = new Coordinate(-74.08175, 4.60971); // Bogotá
            Coordinate to = new Coordinate(-75.56359, 6.25184);   // Medellín

            ORSClient client = new ORSClient(API_KEY);

            DirectionsRequest request = new DirectionsRequest()
                    .coordinates(List.of(List.of(from.x, from.y), List.of(to.x, to.y)))
                    .profile(DirectionsProfile.DRIVING_CAR)
                    .format("json");

            DirectionsResponse response = client.directions(request);

            double distanceKm = response.routes().get(0).summary().distance() / 1000.0;
            double durationMin = response.routes().get(0).summary().duration() / 60.0;

            return String.format("Ruta por carretera: %.2f km, %.2f minutos", distanceKm, durationMin);

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al calcular la ruta";
        }
    }
}
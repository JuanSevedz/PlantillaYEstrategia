package com.navegador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;

public class RutaTuristica implements EstrategiaRuta {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY");

    @Override
    public String calcular(String origen, String destino) {
        try {
            double[] coordOrigen = geocode(origen);
            double[] coordDestino = geocode(destino);
            double[] parada1 = geocode("Guaduas, Colombia");
            double[] parada2 = geocode("Honda, Colombia");

            
            JSONArray coordinates = new JSONArray()
                    .put(new JSONArray(coordOrigen))
                    .put(new JSONArray(parada1))
                    .put(new JSONArray(parada2))
                    .put(new JSONArray(coordDestino));

            URL url = new URL("https://api.openrouteservice.org/v2/directions/foot-walking");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", API_KEY);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            String jsonInputString = new JSONObject()
                    .put("coordinates", coordinates)
                    .toString();

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
            }

            JSONObject json = new JSONObject(response.toString());

            if (!json.has("routes")) {
                return "❌ La respuesta no contiene rutas.";
            }

            JSONObject summary = json
                    .getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary");

            double distanceKm = summary.getDouble("distance") / 1000.0;
            double durationMin = summary.getDouble("duration") / 60.0;

            JSONArray steps = json
                    .getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONArray("segments")
                    .getJSONObject(0)
                    .getJSONArray("steps");

            StringBuilder instrucciones = new StringBuilder();
            instrucciones.append("🗺️ Ruta turística con paradas:\n");
            for (int i = 0; i < steps.length(); i++) {
                JSONObject paso = steps.getJSONObject(i);
                String instruction = paso.getString("instruction");
                double pasoDistancia = paso.getDouble("distance");
                instrucciones.append(String.format("%d. %s (%.0f m)\n", i + 1, instruction, pasoDistancia));
            }

            // Mostrar en Google Maps
            String mapsUrl = "https://www.google.com/maps/dir/" +
                    coordOrigen[1] + "," + coordOrigen[0] + "/" +
                    coordDestino[1] + "," + coordDestino[0];

            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(mapsUrl));
            }

            return String.format(
                    "✅ Ruta turística:\n📍 Distancia: %.2f km\n⏱ Duración: %.2f minutos\n\n%s",
                    distanceKm, durationMin, instrucciones);

        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Error al calcular la ruta turística";
        }
    }

    private double[] geocode(String ciudad) throws Exception {
        String endpoint = "https://api.openrouteservice.org/geocode/search";
        String urlString = endpoint + "?api_key=" + API_KEY + "&text=" + java.net.URLEncoder.encode(ciudad, "UTF-8")
                + "&size=1";

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
        }

        JSONObject json = new JSONObject(response.toString());
        JSONArray features = json.getJSONArray("features");

        if (features.length() == 0) {
            throw new Exception("❌ Ciudad no encontrada: " + ciudad);
        }

        JSONArray coordinates = features.getJSONObject(0)
                .getJSONObject("geometry")
                .getJSONArray("coordinates");

        return new double[] { coordinates.getDouble(0), coordinates.getDouble(1) };
    }
}

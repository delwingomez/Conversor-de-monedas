import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class ConsultaAPI {
    public String buscaMoneda(String moneda, String monedaCambio, Double cantidad){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c9586d14b1a1037a84669a92/latest/"+moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        Gson gson = new Gson();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            // Acceder a las propiedades deseadas
            String base = jsonObject.get("base_code").getAsString();
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            Double conversion = (rates.get(monedaCambio).getAsDouble()) * cantidad;
            DecimalFormat df = new DecimalFormat("#.00"); // Formato con 2 decimales
            return df.format(conversion);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener datos: " + e.getMessage(), e);
        }
    }
}


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {
    String origen;
    String destino;
    double valor;
    public ConsultaConversion(int opcion, double valor) {
        this.valor=valor;
        switch (opcion){
            case 1:
                origen="USD";
                destino="ARS";
                break;

            case 2:
                origen="ARS";
                destino="USD";
                break;

            case 3:
                origen="USD";
                destino="BRL";
                break;

            case 4:
                origen="BRL";
                destino="USD";
                break;

            case 5:
                origen="USD";
                destino="COP";
                break;

            case 6:
                origen="COP";
                destino="USD";
                break;
        }

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7feb4143dce50232e12be3e7/pair/"
                + origen +"/" + destino +"/" + valor);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json=response.body();
            //System.out.println(json);

            Gson gson = new GsonBuilder()

                    .create();

            ConversionModelo miConversion= gson.fromJson(json, ConversionModelo.class);

            //System.out.println("Objeto convertido " + miConversion.conversion_result);
            System.out.println("El valor de: " + valor + "[" + miConversion.base_code +"] corresponde al valor final de =>>>" + miConversion.conversion_result +"[" + miConversion.target_code +"]");

        }
        catch (NumberFormatException e){
            System.out.println("Error en el ingreso de datos");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println("Error en la Direccion, Verifique");
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

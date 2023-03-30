import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        System.out.println(body);
        var parser = new JsonParse();

        List<Map<String,String>> listaDeFilmes = parser.parse(body);

        for (Map<String,String> filmes : listaDeFilmes) {
            
            System.out.println(" \u001b[1m Titulo: \u001b[m" + filmes.get("title"));
            System.out.println("Poster: " + filmes.get("image"));

           double classificacao = Double.parseDouble(filmes.get("imDbRating"));
           int numeroEstrelas = (int) classificacao;

            for(int n=1 ; n<= classificacao; n++){
                System.out.print("⭐ ");
            
            }
           
            System.out.print("\n");
        }

    }
    
}

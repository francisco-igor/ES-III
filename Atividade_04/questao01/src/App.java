import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Autor autor = new Autor(1, "Max", "max@email.com");
        Post post = new Post(1, "First Post", autor, new Date());
        RepositorioDePosts repositorio = new RepositorioDePosts(autor, post);

        repositorio.saveToFile();
        repositorio.readFile();
    }
}

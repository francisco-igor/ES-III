import java.io.File;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;

public class RepositorioDePosts {
    private Autor autor;
    private Post post;
    private String filePath;

    public RepositorioDePosts(Autor autor, Post post) {
        this.autor = autor;
        this.post = post;
        this.filePath = "bin/texto.txt";
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID: " + post.getId() + "\n");
            writer.write("Texto: " + post.getTexto() + "\n");
            writer.write("Autor: " + autor.getNome() + "\n");
            writer.write("Data: " + post.getData() + "\n");
            writer.write("Quantidade de Likes: " + post.getQuantidadeDeLikes() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() throws IOException {
        File file = new File(filePath);
        String dados = new String(Files.readAllBytes(file.toPath()));
        System.out.print(dados);
    }
}

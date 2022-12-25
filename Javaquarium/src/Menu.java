import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Menu {

    int test = Integer.parseInt(Files.readString(Paths.get("C:/Users/jujud/IdeaProjects/Javaquarium/Sauvegardes/tour.txt")));
    int numberOfTurn = test;

    Aquarium aquarium = new Aquarium();

    public Menu() throws IOException {
    }


    public void start() throws IOException, InterruptedException {
        PrintWriter writer = new PrintWriter(Main.tourFile, StandardCharsets.UTF_8);




        aquarium.firstEntity();
        aquarium.showEntities();
        while (aquarium.aleatoryLiving() != null) {
            numberOfTurn++;
            writer.print(numberOfTurn);
            writer.close();
            System.out.println("========== Tour "+numberOfTurn+" ==========\n");
            aquarium.Turn();

        }

        System.err.println("\nFIN DE LA SIMULATION");

    }




}

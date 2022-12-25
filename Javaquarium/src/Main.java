import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Main {

    static File tourFile = new File("C://Users/jujud/IdeaProjects/Javaquarium/Sauvegardes/tour.txt");
    public static void main(String[] args) throws InterruptedException, IOException {


        Menu menu = new Menu();

        if(!tourFile.exists()){
            try{
                tourFile.createNewFile();
                PrintWriter writer = new PrintWriter(Main.tourFile, StandardCharsets.UTF_8);
                writer.print("0");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        menu.start();


    }





}
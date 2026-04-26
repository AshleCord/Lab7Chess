import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FenFileReader {

    public String[] readFenFile(String path) {
        //List
        List<String> fens = new ArrayList<>();

        try {
            //Reader
            BufferedReader reader = new BufferedReader(new FileReader(path));
            System.out.println(reader.readLine());

            //String
            String currentLine = reader.readLine();
            //Loop
            while(currentLine != null) {
                fens.add(currentLine);
                System.out.println(currentLine);
                currentLine = reader.readLine();
            }

            reader.close();

        //Catch Block
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Finished reading a file.");
        }
        return fens.toArray(new String[0]);
    }

    //RenamedFen
    public static void main(String args[]) {
        System.out.println("Fen file reader main run...");

        //Store
        FenFileReader fenFileReader = new FenFileReader();
        String[] fenArray = fenFileReader.readFenFile("resources/chess_positions.fen");

        for(int i = 0; i < fenArray.length; i++) {
            System.out.println("fenArray: " + fenArray[i]);
        }
    }
}

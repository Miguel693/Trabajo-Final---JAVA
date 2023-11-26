import java.io.BufferedReader;
import java.io.FileReader;
// import java.io.BufferedWriter;
import java.io.FileNotFoundException;
// import java.io.FileWriter;
import java.io.IOException;

public class Reader {
  
  public static String readFile(String fileName) {
    String fileLocation = "src/data/";
    String line = "";
    String data = "";
    try{
      FileReader reader = new FileReader(fileLocation+fileName);
      // FileWriter writer = new FileWriter(baseFileLocation);


      BufferedReader readBuffer  = new BufferedReader(reader);
      // BufferedWriter writeBuffer = new BufferedWriter(writer);

      while( (line  = readBuffer.readLine())!= null){
        line = line.replace(";", ":");
        data += line+";";
        // System.out.println(line);
        // writeBuffer.write(line+"/n");
      }
      readBuffer.close();
      // writeBuffer.close();      
    }catch( FileNotFoundException e){
      System.err.println(e.getMessage());
      data = e.getMessage();
    }catch ( IOException e){
      System.err.println(e.getMessage());
      data = e.getMessage();
    }
    return data;
  }
}

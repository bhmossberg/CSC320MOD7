import java.io.IOException;
public class InputStreamReader {
   public static void main (String[] args)
   throws IOException {
      int usrInput;
      // Read 1st byte
      usrInput = System.in.read();
      // Read 2nd byte
      usrInput = System.in.read();
      // Read 3rd byte
      usrInput = System.in.read();
      // Read 4th byte
      usrInput = System.in.read();
      // Read 5th byte (empty buffer)
      usrInput = System.in.read();
      System.out.println("End of stream reached, no more bytes to read.");
   }
}
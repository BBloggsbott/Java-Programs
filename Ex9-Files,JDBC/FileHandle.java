import java.io.*;

class FileHande{

  public static void main(String[] args) {
    try{
      File file = new File("Dummy.txt");
      File file2 = new File("DummyCopy.txt");

      file.createNewFile();
      file2.createNewFile();

      FileWriter writer = new FileWriter(file);
      writer.write("This is a dummy text file");
      writer.flush();
      writer.close();

      FileReader reader = new FileReader(file);
      writer = new FileWriter(file2);
      char[] a = new char[50];
      reader.read(a);
      for(char c : a){
        writer.write(c);
      }
      reader.close();
      writer.close();
      System.out.println("Job Done");
    }
    catch(Exception e){System.out.println(e);}
  }
}

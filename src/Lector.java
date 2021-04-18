import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Lector
{

    public ArrayList<String> Leer(String nombre)
    {
        ArrayList<String> temp = new ArrayList<>();
        try
        {
            File Archivo = new File(nombre);
            Scanner Lector = new Scanner(Archivo);

            while (Lector.hasNextLine())
            {
                String Line = Lector.nextLine();
                temp.add(Line);
            }

        }
        catch (Exception e)
        {
            System.out.println("Error al abrir el archivo "+ e);
        }
        return temp;
    }

}

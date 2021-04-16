import java.util.ArrayList;

public class Controlador
{
    Lector leer;

    public Controlador()
    {
        leer= new Lector();
    }

    public void start()
    {
        ArrayList<?> datos = leer.Leer();
    }
}

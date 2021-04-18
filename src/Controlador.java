import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controlador
{
    Lector leer;
    Scanner scan;
    BST storage;
    public Controlador()
    {
        leer = new Lector();
        scan = new Scanner(System.in);
        storage= new BST();
    }

    public void start() {
        ArrayList<String> datos = leer.Leer("diccionario.txt");
        while (true)
        {
            System.out.println("Menu");
            System.out.println("1)Traducir");
            System.out.println("2) Recorrer el Arbol In order\n");
            String input = scan.next();

            int idioma;
            int traductor;
            if (input.equals("1"))
            {
                storage= new BST();
                idioma = Idioma();
                traductor = traductor();

                for (int i=0; i<datos.size();i++)
                {
                    String temp = datos.get(i);
                    String[] arr=temp.split(",");
                    ComparableAssociation Mapa = new ComparableAssociation(arr[idioma], arr[traductor]);

                    storage.add(Mapa);

                }



                ArrayList<String> separar = leer.Leer("texto.txt");
                String acum=" ";
                for (int i=0; i< separar.size();i++)
                {
                    acum+=separar.get(i);
                }
                String[] separado=acum.split(" ");
                String[] traducido = new  String[separado.length];
                String finall="";
                for (int i =0; i < separado.length;i++)
                {
                    ComparableAssociation CA= new ComparableAssociation(separado[i]);
                    if (storage.contains(CA))
                    {
                        BinaryTree temp= storage.locate(storage.root,CA);
                        ComparableAssociation otro =(ComparableAssociation) temp.value();
                        traducido[i]=""+otro.getValue();
                    }
                    else
                    {
                        if (separado[i].isEmpty())
                            traducido[i]="";
                        else
                            traducido[i]=" *"+separado[i]+"* ";
                    }
                    finall+=traducido[i];
                }
                System.out.println(finall);


            }
            else if (input.equals("2"))
            {

                storage= new BST();
                idioma = 0;

                for (int i=0; i<datos.size();i++)
                {
                    String temp = datos.get(i);
                    String[] arr=temp.split(",");
                    ComparableAssociation Mapa = new ComparableAssociation(arr[idioma], arr[1]+","+arr[2]);

                    storage.add(Mapa);

                }
                storage.iterator();
            }





        }
    }

    private int Idioma()
    {
        System.out.println("Idioma original \n1)Ingles \n2)Español \n3)Frances");
        String input = scan.next();
        if(input.equals("1"))
            return 0;
        if(input.equals("2"))
            return 1;
        if(input.equals("3"))
            return 2;
        return -1;
    }
    private int traductor()
    {
        System.out.println("Traducir a  \n1)Ingles \n2)Español \n3)Frances");
        String input = scan.next();
        if(input.equals("1"))
            return 0;
        if(input.equals("2"))
            return 1;
        if(input.equals("3"))
            return 2;
        return -1;
    }
}

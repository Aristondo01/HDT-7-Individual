import static org.junit.jupiter.api.Assertions.*;

public class BSTTest
{
    BST arbol;
    @org.junit.Test
    public void add()
    {
        arbol   = new BST();
        ComparableAssociation valor = new ComparableAssociation("JUnit","Comprobado");
        arbol.add(valor);

        assertEquals(1,arbol.size());

    }
    @org.junit.Test
    public void contains()
    {
        arbol   = new BST();
        ComparableAssociation valor = new ComparableAssociation("JUnit","Comprobado");
        arbol.add(valor);
        assertEquals(true,arbol.contains(valor));


    }




}
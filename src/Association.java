/*
 * La implementación de esta clase se obtuvo gracias al material compartido en canvas
 */
public class Association <K,V> implements MapEntry<K,V>
{
    protected K theKey;
    protected V theValue;

    public  Association(K key, V value)
    {
        theKey= key;
        theValue=value;
    }

    public Association(K key)
    {
        this(key,null);
    }

    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }

    public int hashCode()
    {
        return getKey().hashCode();
    }

    public K getKey()
    {
        return theKey;
    }

    @Override
    public V getValue() {
        return theValue;
    }

    public V setValue(Object value)
    {
        V oldValue = theValue;
        theValue = (V) value;
        return oldValue;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}

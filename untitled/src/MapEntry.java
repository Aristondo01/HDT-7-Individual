public interface MapEntry<K,V>
{
    public boolean equals(Object o);

    public K getKey();
    // post: returns the key K of this entry

    public V getValue();
    // post: returns the value V of this entry

    public int hashCode();
    // post: returns the hashcode for the key

    public V setValue(V value);

}

package nl.marwik.jdriventest;
import java.util.*;


public class BetterProgrammerTask2 {

    public static class WriteOnceMap<K, V> extends HashMap<K, V> {

        public V put(K key, V value) {
            /*
             WriteOnceMap is a map that does not allow changing value for a particular key.
             It means that put() method should throw IllegalArgumentException if the key is already
             assosiated with some value in the map.

             Please implement this method to conform to the above description of WriteOnceMap.
            */
            if (this.containsKey(key)) {
                throw new IllegalArgumentException("This map already contains the key " + key.toString());
            } else {
                return super.put(key, value);
            }
        }

        public void putAll(Map<? extends K, ? extends V> m) {
            /*
             Pleaase implement this method to conform to the description of WriteOnceMap above.
             It should either
             (1) copy all of the mappings from the specified map to this map or
             (2) throw IllegalArgumentException and leave this map intact
             if the parameter already contains some keys from this map.
            */
            for (K key : m.keySet()) {
                if (this.containsKey(key)) {
                    throw new IllegalArgumentException("This map already contains the key " + key.toString());
                }
            }
            super.putAll(m);
        }
    }

    /** test */
    public static void main(String[] args) {
        WriteOnceMap<String, String> map = new WriteOnceMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        //map.put("a", "c");
        WriteOnceMap<String, String> map2 = new WriteOnceMap<String, String>();
        map2.put("d", "d");
        map2.put("e", "e");
        map2.put("f", "f");
        //map2.put("a", "a");
        map.putAll(map2);
    }
}

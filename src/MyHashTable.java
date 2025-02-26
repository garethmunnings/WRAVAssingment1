import java.util.Iterator;
import java.util.LinkedList;

// Author: Anne van der Merwe

// DO NOT CHANGE (other than specified methods)
public class MyHashTable {

    int capacity = 10;
    private LinkedList<Node>[] my_table;

    public MyHashTable(){

        my_table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            my_table[i] = new LinkedList<>();
        }
    }

    // hash: YOU ARE REQUIRED TO IMPLEMENT THIS METHOD
    public int hash(String key){
        int k = 0;
        for (int i = 0; i < key.length(); i++) {
            k += (int)key.charAt(i);
        }
        k = k % capacity;
        return k;
    }

    // put: YOU ARE REQUIRED TO IMPLEMENT THIS METHOD
    public void put(String key, String value){
        int k = hash(key);
        my_table[k].add(new Node(key,value));
    }

    // get: YOU ARE REQUIRED TO IMPLEMENT THIS METHOD
    public String get(String key){
        int k = hash(key);
        Node cur = my_table[k].getFirst();
        while(cur != null){
            if(cur.key.equals(key)){
                return cur.value;
            }
        }
        return null;

    }

    // remove: YOU ARE REQUIRED TO IMPLEMENT THIS METHOD
    public String remove(String key){
        int k = hash(key);
        Node cur = my_table[k].getFirst();
        int i = 0;
        while(cur != null){
            if(cur.key.equals(key)){
                my_table[k].remove(i);
                return cur.value;
            }
            i++;
        }

        return null;
    }

    // display: prints out the contents of the hash table - DO NOT CHANGE
    public void display(){
        System.out.println("Contents of my_table Hash Table:");
        for (int i = 0; i < capacity; i++) {
            if (!my_table[i].isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Node node : my_table[i]) {
                    System.out.print("(" + node.key + ": " + node.value + ") -> ");
                }
                System.out.println("null");
            }
        }
    }

    // uniqueGroups: returns count of unique groups - DO NOT CHANGE
    public int uniqueGroups() {
        int count = 0;
        for (LinkedList<Node> bucket : my_table){
            if (!bucket.isEmpty())
                count++;
        }
        return count;
    }

    // anagramFrequency: returns frequency of anagram - DO NOT CHANGE
    public int anagramFrequency(String key) {
        int index = hash(key);
        LinkedList<Node> bucket = my_table[index];
        return bucket.size();
    }


    // Node class stores key-value pair - DO NOT CHANGE
    private static class Node{
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }

}

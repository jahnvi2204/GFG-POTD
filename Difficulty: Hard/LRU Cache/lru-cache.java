//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    public Node[] map;
    public int count, capacity;
    public Node head, tail;
    
    public LRUCache(int capacity) {
        
        this.capacity= capacity;
        count= 0;
        
        map= new Node[10_000+1];
        
        head= new Node(0,0);
        tail= new Node(0,0);
        
        head.next= tail;
        tail.prev= head;
        
        head.prev= null;
        tail.next= null;
    }
    
    public void deleteNode(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;       
        
        return;
    }
    
    public void addToHead(Node node){
        node.next= head.next;
        node.next.prev= node;
        node.prev= head;
        
        head.next= node;      
        
        return;
    }
    
    public int get(int key) {
        
        if( map[key] != null ){
            
            Node node= map[key];
            
            int nodeVal= node.value;
            
            deleteNode(node);
            
            addToHead(node);
            
            return nodeVal;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        
        if(map[key] != null){
            
            Node node= map[key];
            
            node.value= value;
            
            deleteNode(node);
            
            addToHead(node);
            
        } else {
            
            Node node= new Node(key,value);
            
            map[key]= node;
            
            if(count < capacity){
                count++;
                addToHead(node);
            } 
            else {
                
                map[tail.prev.key]= null;
                deleteNode(tail.prev);
                
                addToHead(node);
            }
        }
        
        return;
    }
    
}
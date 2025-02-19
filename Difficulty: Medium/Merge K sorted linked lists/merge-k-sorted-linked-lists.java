//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }

            Solution sol = new Solution();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.data,b.data));
        for(Node node:arr) pq.offer(node);
        while(pq.size()>=2){
            Node node1 = pq.poll();
            Node node2 = pq.poll();
            Node merged = merged(node1,node2);
            pq.offer(merged);
        }
        
        return pq.peek();
    }
    
    Node merged(Node n1,Node n2){
        Node merged = new Node(-1);
        Node curr = merged;
        while(n1 != null && n2 != null){
            if(n1.data <= n2.data){
                curr.next = n1;
                curr = curr.next;
                n1 = n1.next;
            }else{
                curr.next = n2;
                curr = curr.next;
                n2 = n2.next;
            }
        }
        
        if(n1 != null) curr.next = n1;
        if(n2 != null) curr.next = n2;
        
        return merged.next;
    }
}
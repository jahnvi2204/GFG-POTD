//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    
    static Node addTwoLists(Node num1, Node num2){

        Node a = reverse(num1);
        Node b = reverse(num2);
        
        Node temp = new Node(0);
        Node ans = temp;
        
        int carry = 0;
        while(a!=null && b!=null){
            int val = a.data + b.data + carry;
            Node node = new Node((val%10));
            temp.next = node;
            temp = temp.next;
            carry = val/10;
            
            a = a.next;
            b = b.next;
        }
        while(a!=null){
            int val = a.data + carry;
            Node node = new Node((val%10));
            temp.next = node;
            temp = temp.next;
            carry = val/10;
            
            a = a.next;
        }
        while(b!=null){
            int val = b.data + carry;
            Node node = new Node((val%10));
            temp.next = node;
            temp = temp.next;
            carry = val/10;
            
            b = b.next;
        }
        Node node = new Node(carry);
        temp.next = node;
        ans = ans.next;
        Node p = reverse(ans);
        
        while(p.data==0 && p.next!=null){
            p = p.next;
        }
        
        return p;
    }
    public static Node reverse(Node start){
        Node prev = start;
        Node curr = start.next;
        
        prev.next = null;
        
        while(curr!=null){
            Node temp = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
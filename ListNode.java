/*
Data structure of the List Node
 *Name: Qiushuo Li
 *ID: 260725145 
*/
public class ListNode {
    public String item;       // data stored in this node
    public ListNode next;  // link to next node in the list

    // Initializing a node with data 0 and null link
    public ListNode() {
        this("", null);
    }

    // Initializing a node with some data and null link
    public ListNode(String data) {
        this(data, null);
    }

    // Initializing a node with some data and some link
    public ListNode(String data, ListNode next) {
        this.item = data;
        this.next = next;
    }
}

/*Queue Class
 *Name: Qiushuo Li
 *ID: 260725145 
*/
public class Queue<String> {
    private ListNode first;    // beginning of queue
    private ListNode last;     // end of queue
    private int n;             // size of elements on queue
  
    //Initializing a Queue with nothing
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the size of items in this queue.
     */
    public int size() {
        return n;
    }

    //enqueue a String at the last and return nothing
    public void enqueue(String item) {
        ListNode oldlast = last;
        last = new ListNode();
        last.item = (java.lang.String)item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    //dequeue the first String and return it
    public String dequeue() {
        if (isEmpty()) {
           return (String)"Nothing in the queue.";
        }

        String returnItem = (String) first.item;
        first = first.next;
        n--;
        return returnItem;
    }
    
    public String peak() {
    		return (String)first.item; 
    }
}


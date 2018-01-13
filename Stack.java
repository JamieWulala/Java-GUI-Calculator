/*
Stack class
 *Name: Qiushuo Li
 *ID: 260725145 
*/

public class Stack {

    private int n;          // size of the stack
    private ListNode first;     // top of stack



   /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the size of this stack.
     */
    public int size() {
        return n;
    }

    //push a String on the top of the stack and return nothing
    public void push(String item) {
        ListNode oldFrist = first;
        first = new ListNode();
        first.item = item;
        first.next = oldFrist;
        n++;
    }

    //remove the String on the top and return it
    public String pop() {
        String returnValue = first.item;
        first = first.next;
        n--;
        return returnValue;
    }

    //return the String on the top but do not remove it
    public String peak() {
    		if(isEmpty()) {
    			return (String)"Nothing is on the top.";
    		}
        return first.item;
    }
}



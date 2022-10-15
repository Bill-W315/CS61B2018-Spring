public class LinkedListDeque<T>{
    private Node sentinal;
    private int size;
    private class Node{
        Node prev;
        Node next;
        T item;
        Node(Node prev, Node next, T item){
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    //Adds an item of type T to the front of the deque.
    public void addFirst(T item){
        Node newNode = new Node(null,null,item);
        if(size == 0){
            sentinal.next = newNode;
            sentinal.prev = newNode;
        }else{
            newNode.next = sentinal.next;
            sentinal.next.prev = newNode;
            sentinal.next = newNode;
        }
        size += 1;
    }

    //Adds an item of type T to the back of the deque.
    public void addLast(T item){
        Node newNode = new Node(null,null,item);
        if(size == 0){
            sentinal.next = newNode;
            sentinal.prev = newNode;
        }else{
            newNode.prev = sentinal.prev;
            sentinal.prev.next = newNode;
            sentinal.prev = newNode;
        }
        size += 1;
    }

    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    //Returns the number of items in the deque.
    public int size(){
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space.
    public void printDeque(){
        Node node = sentinal.next;
        while (node != null){
            System.out.print(node.item + " ");
            node = node.next;
        }
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst(){
        if(size > 0){
            size -= 1;
            T item = sentinal.next.item;
            sentinal.next = sentinal.next.next;
            return item;
        }
        return null;
    }

    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast(){
        if(size > 0){
            size -= 1;
            T item = sentinal.prev.item;
            sentinal.prev = sentinal.prev.prev;
        }
        return null;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        if(index+1 > size){
            return null;
        }
        Node result = sentinal.next;
        for(int i = 0; i < index; i++){
            result = result.next;
        }
        return result.item;
    }
    public LinkedListDeque(){
       sentinal = new Node(null,null,null);
       size = 0;
    }
    public T getRecursive(int index){
        if(index+1 > size || index < 0){
            return null;
        }
        return recursiveHelper(index,sentinal.next);
    }
    private T recursiveHelper(int index, Node current){
        if (index == 0){
            return current.item;
        }
        return  recursiveHelper(index-1,current.next);
    }
}
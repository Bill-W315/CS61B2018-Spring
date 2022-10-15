public class ArrayDeque<T>{

    private T[] items = (T[]) new Object[8];
    private int nextFirst = 3;
    private int nextLast = 4;
    private int size = 0;
    private int arraySize = items.length;
    private double usageFactor = 0.25;

    private void resize(float refactor){
        int targetSize = Math.round(arraySize * refactor) + 1;
        if(targetSize <= 8){
            targetSize = 8;
        }
        arraySize = targetSize;
        T[] newArray = (T[]) new Object[targetSize];
        for (int i=0; i < targetSize; i++){
            newArray[i] = items[i];
        }
        items = newArray;
    }
    private void checkUsage(){
        double usage = size / arraySize;
        if (usage < usageFactor){
            resize(0.5F);
        }
        if(usage > 0.8){
            resize(2);
        }
    }
    //Adds an item of type T to the front of the deque.
    public void addFirst(T item){
        size++;
        checkUsage();
        items[nextFirst] = item;
        nextFirst -= 1;
        if(nextFirst < 0){
            nextFirst = arraySize - 1;
        }
    }

    //Adds an item of type T to the back of the deque.
    public void addLast(T item){
        size++;
        checkUsage();
        items[nextLast] = item;
        nextLast += 1;
        if(nextLast == arraySize){
            nextLast = 0;
        }
    }

    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    //Returns the number of items in the deque.
    public int size(){
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space.
    public void printDeque(){
        for(int i=0; i < size; i++){
            System.out.println(get(i) + " ");
        }
    }

    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst(){
        if(size == 0){
            return null;
        }
        size -= 1;
        checkUsage();
        nextFirst += 1;
        if(nextFirst >= arraySize){
            nextFirst = 0;
        }
        checkUsage();
        return items[nextFirst];
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast(){
        if(size == 0){
            return null;
        }
        size -= 1;
        checkUsage();
        nextLast -= 1;
        if(nextLast < 0){
            nextLast = arraySize - 1;
        }
        checkUsage();
        return items[nextLast];
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        int target;
        if(index >= size || index < 0){
            return null;
        }else{
            target = nextFirst + index - 1;
            if(target > arraySize - 1){
                target = target - arraySize;
            }
            if(target < 0){
                target = arraySize - target;
            }
        }
        return items[target];
    }

    public ArrayDeque(){}
}

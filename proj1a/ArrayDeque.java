public class ArrayDeque<T>{

    T[] items = (T[]) new Object[8];
    int nextFirst = 3;
    int nextLast = 4;
    int size = 0;
    int arraySize = items.length;
    double usageFactor = 0.25;

    private void resize(float refactor){
        int targetSize = Math.round(arraySize * refactor) + 1;
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
        T item = items[nextFirst];
        if(nextFirst == arraySize){
            nextFirst = 0;
        }
        return items[nextLast];
    }

    // Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast(){
        if(size == 0){
            return null;
        }
        size -= 1;
        checkUsage();
        nextLast -= 1;
        T item = items[nextLast];
        if(nextLast < 0){
            nextLast = arraySize - 1;
        }
        return item;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        int target;
        if(index >= size || index < 0){
            return null;
        }else{
            target = nextFirst + index - 1;
            if(target >= arraySize - 1){
                target = target - arraySize;
            }
        }
        return items[target];
    }

    public ArrayDeque(){}
}

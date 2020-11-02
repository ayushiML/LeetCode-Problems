public class MinHeap {
    private int[] Heap; 
    private int size; 
    private int maxsize;
    MinHeap(int capacity)
    {   size = 0;
        Heap = new int[capacity+1];
        maxsize = capacity;
    }
    boolean isLeaf(int pos)
    {
        if(pos >= size/2 && pos <= size)
        return true;

        return false;
    }
    void insert(int value)
    {
        if(size >=  maxsize)
        {System.out.println("full capacity");
        return;
         }
    Heap[++size] = value;
    int current = size;

    while(Heap[current] < Heap[parent(current)])
    {
        swap(current, parent(current));
        current = parent(current);
    }
}
public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            heapfiy(pos); 
        } 
    }


    
     void heapfiy(int pos)
    {

        if(!isLeaf(pos))
        {
           if(Heap[pos] > Heap[left(pos)] || Heap[pos] > Heap[right(pos)])
           {
             if(Heap[left(pos)] < Heap[right(pos)])
             {
                 swap(pos,left(pos));
                 heapfiy(left(pos));
             }
             else{
                 swap(pos,right(pos));
                 heapfiy(right(pos));
             }


           }
        }

          
    }
    void remove(int value)
    {

    }
    public int parent (int pos)
    {
        return (pos)/2;
    }
    public int left (int parent)
    {
        return (2*parent +1);
    }
    public int right(int parent)
    {
        return (2*parent +2);
    }
    public void swap(int i , int j )
    {
        int temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(1);minHeap.insert(13);
        minHeap.insert(5);
        minHeap.insert(8);minHeap.insert(15);

        minHeap.minHeap();

        minHeap.print();
        

        
    }

    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] 
                             + " LEFT CHILD : " + Heap[2 * i] 
                             + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    }
}

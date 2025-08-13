import java.util.ArrayList;

public class ModifiedHeap{
    ArrayList<Integer> heap;
    int childrenCount;
    
    public ModifiedHeap (int powOfx){
        this.heap = new ArrayList<>();
        for (int i = 1; i<=powOfx; i++){
            this.childrenCount = this.childrenCount * 2;
        }
    }
    
    public void insert(int number){
        
        heap.add(number);
        this.orderLast(heap.size()-1);
        
    }

    public int popMax(){
        if (heap.isEmpty()){
            return -1;
        }
        int biggestNumber = heap.get(0);
        int lastNumber = heap.remove(heap.size()-1);
        if (!heap.isEmpty()){
            heap.set(0,lastNumber);
            this.orderFirst(0);
        }
        return biggestNumber;
    }

    public void orderLast(int childIndex){
        if (childIndex == 0){
            return;
        }
        int temp;
        int parentIndex = (childIndex) / this.childrenCount;
        if (heap.get(parentIndex)<heap.get(childIndex)){
            temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(childIndex));
            heap.set(childIndex, temp);
        }
        
        
    }

    public void orderFirst(int parentIndex){
        int firstChildIndex = childrenCount * parentIndex + 1;
        int biggestChildIndex = firstChildIndex;
        for (int i = firstChildIndex+1; (i<=firstChildIndex+childrenCount) && (i<heap.size()); i++) {
            if (heap.get(biggestChildIndex) < heap.get(i)){
                biggestChildIndex = i;
            }
        }
        if (heap.get(biggestChildIndex) < heap.get(parentIndex)){
            int temp = heap.get(biggestChildIndex);
            heap.set(biggestChildIndex, heap.get(parentIndex));
            heap.set(parentIndex,temp);
            this.orderFirst(biggestChildIndex);
        }
    }

    public void printHeap() {
        System.out.println("Heap contents: " + heap);
        System.out.println("Each parent has " + childrenCount + " children");
    }

    // public static void main(String[] args) {
        
    //     PowerOfTwoMaxHeap heap1 = new PowerOfTwoMaxHeap(1);
        
    //     // Add some numbers
    //     heap1.insert(10);
    //     heap1.printHeap();
    //     heap1.insert(30);
    //     heap1.printHeap();
    //     heap1.insert(20);
    //     heap1.printHeap();
    //     heap1.insert(40);
    //     heap1.printHeap();
    //     heap1.insert(25);
        
    //     heap1.printHeap();
        
    //     System.out.print("\n\n Numbers removed: ");
    //     int t;
    //     while (!heap1.isEmpty()) {
    //         t = heap1.popMax();
    //         System.out.print(t + " Heap after removed " );
    //         heap1.printHeap();
    //         System.out.println("\n");
    //     }
    //     System.out.println("\n");
    // }
    
}
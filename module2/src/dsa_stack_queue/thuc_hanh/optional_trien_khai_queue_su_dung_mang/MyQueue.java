package dsa_stack_queue.thuc_hanh.optional_trien_khai_queue_su_dung_mang;

import java.util.Arrays;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head;
    private int tail = -1;
    private int currentSize;


    public int size() {
        return this.currentSize;
    }

    public int tail() {
        return this.tail;
    }

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        if (currentSize == capacity) {
            return true;
        }
        return false;
    }

    public boolean isQueueEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            tail++;
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }
//    public void enqueue(int element){
//        if(isQueueFull()){
//            System.out.println("Overflow! Unable to add element "+element);
//        }else {
//            tail++;
//            queueArr[tail]=element;
//            currentSize++;
//        }
//    }

    public int capa() {
        return this.capacity;
    }

    //    public void dequeue(){
//        if (isQueueEmpty()){
//            System.out.println("Queue is null");
//        }else {
//            head++;
//            queueArr=Arrays.copyOfRange(queueArr,head,capacity+1);
//            tail--;
//            head--;
//            currentSize--;
//        }
//    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            System.out.println("Pop operation done ! removed: " + queueArr[head]);
            for (int i = 0; i < currentSize - 1; i++) {
                queueArr[i] = queueArr[i + 1];
            }
            queueArr[currentSize - 1] = 0;
            tail--;
            currentSize--;
        }
    }

    public void display() {
        for (int i = 0; i < currentSize; i++) {
            System.out.println(queueArr[i]);
        }
    }
}

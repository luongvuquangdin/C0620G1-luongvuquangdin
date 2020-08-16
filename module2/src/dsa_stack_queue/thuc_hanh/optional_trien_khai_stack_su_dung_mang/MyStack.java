package dsa_stack_queue.thuc_hanh.optional_trien_khai_stack_su_dung_mang;

public class MyStack {
    private int arr[];
    private int size;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }


    public void push(int element) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        System.out.println("Element "+element+" is pushed to Stack");
        arr[index] = element;
        index++;
    }

    public int pop() {
        if (isEmpty()){
            throw new StackOverflowError("Stack is null");
        }else {
            index--;
            int element=arr[index];
            System.out.println("Remove "+arr[index]+" done!");
            arr[index]=0;
            return element;
        }
    }

    public void display(){
        for (int i=0;i<index;i++){
            System.out.println(arr[i]);
        }
    }

    public int size() {
        return index;
    }
}

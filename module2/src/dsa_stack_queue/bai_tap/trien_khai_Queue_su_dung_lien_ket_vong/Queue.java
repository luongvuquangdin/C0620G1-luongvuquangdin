package dsa_stack_queue.bai_tap.trien_khai_Queue_su_dung_lien_ket_vong;

public class Queue implements Solution {
    private Node front;
    private Node rear;
    private int size = 0;
    @Override
    public void enQueue(int data) {
        if (size==0) {
            front = rear = new Node(data);
            size++;
        }else {
            rear.link=new Node(data);
            rear=rear.link;
            rear.link=front;
            size++;
        }
    }

    @Override
    public void deQueue() {
        if (size==0){
            System.out.println("null");
        }else if (front.equals(rear)){
            front=rear=null;
            size--;
        }else {
            front=front.link;
            rear.link=front;
            size--;
        }
    }


    @Override
    public void displayQueue() {
        if (size==0){
            System.out.println("Nothing to display");
            return;
        }
        Node temp=front;
        for (int i=0;i<size;i++){
            System.out.println(temp.data);
            temp=temp.link;
        }
    }


    /**Mỗi phần tử trong liên kết có dạng
     *
     */
    private class Node{
        private int data;
        private Node link;

        public Node(int data){
            this.data=data;
        }
    }

}

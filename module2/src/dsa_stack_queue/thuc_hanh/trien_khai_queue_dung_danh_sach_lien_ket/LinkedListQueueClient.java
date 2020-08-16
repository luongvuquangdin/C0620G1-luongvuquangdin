package dsa_stack_queue.thuc_hanh.trien_khai_queue_dung_danh_sach_lien_ket;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue a = new MyLinkedListQueue();
        a.enqueue(10);
        a.enqueue(20);
        a.dequeue();
        a.dequeue();
        a.enqueue(30);
        a.enqueue(40);
        a.enqueue(50);
        System.out.println(a.dequeue().key);
    }
}

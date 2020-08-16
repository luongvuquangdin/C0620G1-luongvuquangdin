package dsa_stack_queue.bai_tap.trien_khai_Queue_su_dung_lien_ket_vong;

public class Main {
    public static void main(String[] args) {
        Queue ab = new Queue();
        ab.enQueue(1);
        ab.enQueue(2);
        ab.enQueue(3);
        ab.enQueue(4);
        ab.enQueue(5);
        ab.enQueue(6);
        ab.deQueue();
        ab.deQueue();



        ab.displayQueue();
    }
}

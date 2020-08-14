package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;


public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
      MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
        ll.addFirst(1);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(1);
        Integer a=1;
        ll.remove(a);
        System.out.println(ll.size());

    }
}

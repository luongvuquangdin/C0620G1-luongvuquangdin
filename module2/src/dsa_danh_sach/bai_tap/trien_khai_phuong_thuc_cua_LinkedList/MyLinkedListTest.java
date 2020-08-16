package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;


public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
      MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println("ll có "+ll.size()+" phần tử");
        ll.printList();
        System.out.println("-----------");
        MyLinkedList<Integer> v=ll.clone();
        v.printList();
      System.out.println("Vị trí đầu tiên là "+ll.getFirst());
      System.out.println("Vị trí tiếp theo là "+ll.getLast());
        System.out.println("Tìm kiếm là "+ll.contains(6));
        System.out.println("Tìm kiếm nằm ở vị trí thứ "+ll.indexOf(0));
        ll.clear();
      System.out.println("-------------");
      ll.addFirst(6);
      System.out.println("ll có "+ll.size()+" phần tử");
      ll.printList();
    }
}

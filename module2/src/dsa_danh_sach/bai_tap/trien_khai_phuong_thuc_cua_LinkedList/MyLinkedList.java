package dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_LinkedList;

import mang_va_phuong_thuc_trong_java.bai_tap.PushElement;

import java.util.LinkedList;

public class MyLinkedList<E> {
    /**Thuộc tính của MyLinkedList
     *
     */
    private Node head;
    private int numNodes=0;

    /**Phương thức khởi tạo đối tượng
     *
     */
    public MyLinkedList() {
    }
    //SIZE
    public int size(){
        return numNodes;
    }
    /**Cộng vào phần tử đầu tiên
     *
     */
    public void addFirst(E e){
        Node temp=head;
        head=new Node(e);
        head.next=temp;
        numNodes++;
    }
    /**Cộng vào phần tử cuối cùng
     *
     */
    public void addLast(E e){
        Node temp=head;
        while (temp.next!=null){
        temp=temp.next;
        }
        temp.next=new Node(e);
        numNodes++;
    }
//    LinkedList
    /**Cộng vào phần tử ở vị trí index
     *
     */
    public void add(int index,E e) {
        if (index > numNodes || index < 0) {
            throw new IndexOutOfBoundsException("index = " + index + " Size = " + numNodes);
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node temp = head;
            Node holder;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(e);
            temp.next.next = holder;
            numNodes++;
        }
    }
    /**Lấy phần tử tại vị trí index
     *
     */
    public Object get(int index){
        Node temp=head;
        for (int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }

    /**Xóa phần tử tại vị trí index
     *
     */
    public E remove(int index) {
        if (index >= numNodes || index < 0) {
            throw new IndexOutOfBoundsException("index = " + index + " Size = " + numNodes);
        }
        Node temp = head;
        Object data=null;
        if (index == 0) {
            data=head.data;
            head=head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    /**Xóa phần tử theo element
     *
     */

    public boolean remove(E e){
        Node temp1=head;
        boolean isFalse=false;
        for (int i=0;i<numNodes;i++){
            System.out.println(temp1.data);
            if (temp1.data.equals(e)){
                remove(i);
                temp1=temp1.next;
                isFalse=true;
                i--;
                continue;
            }
            temp1=temp1.next;
        }
        return isFalse;
    }
    /**In các phần tử
     *
     */
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**các phần tử liên kết có dạng
     *
     */
   private class Node{
       Node next;
       Object data;

       public Node(Object data) {
           this.data = data;
       }

       public Object getData() {
           return this.data;
       }
   }


}

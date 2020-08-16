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

    /**Tạo clone sao chép ra một danh sách khác
     *
     */
    public MyLinkedList<E> clone(){
        MyLinkedList<E> v=new MyLinkedList<E>();
        v.head=head;
        Node tempV=v.head;
        Node temp=head;
        for (int i=1;i<size();i++){
            tempV.next=temp.next;
            temp=temp.next;
            tempV=tempV.next;
        }
        return v;

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
        if (head==null){
            addFirst(e);
            return;
        }
        while (temp.next!=null){
        temp=temp.next;
        }
        temp.next=new Node(e);
        numNodes++;
    }
    /**tìm kiếm nếu có thì trả về vị trí xuất hiện đầu tiên
     * nếu không thì trả về -1
     */
    public int indexOf(E e){
        Node temp=head;
        for (int i=0;i<numNodes;i++){
            if (temp.data.equals(e)){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
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
    public E get(int index){
        if (head==null){
            throw new IndexOutOfBoundsException("Rỗng");
        }
        Node temp=head;
        for (int i=0;i<index;i++){
            temp=temp.next;
        }
        return (E) temp.data;
    }
    /**Lấy phần tử ở vị trí đầu
     *
     */
    public E getFirst(){
        if (head==null){
            throw new IndexOutOfBoundsException("Rỗng");
        }
        return (E) head.data;
    }
    /**Lấy phần tử ở vị trí cuối
     *
     */
    public E getLast(){
        Node temp=head;
        if (head==null){
            throw new IndexOutOfBoundsException("Rỗng");
        }
        while (temp.next!=null){
            temp=temp.next;
        }
        return (E) temp.data;
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
    /**Kiểm tra phần tử có trong danh sách hay không
     *
     */
    public boolean contains(Object o){
        Node temp=head;
        while (temp!=null){
            if (temp.data.equals(o)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    /**Xóa phần tử theo element
     *
     */
    public boolean remove(E e){
        Node temp1=head;
        boolean isFalse=false;
        for (int i=0;i<numNodes;i++){
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
        for (int i=0;i<numNodes;i++){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    /**Xóa đối tượng
     *
     */

//    public void clear(){
//       head=null;
//       numNodes=0;
//    }
    public void clear(){
        Node temp=head;
        while (temp.next!=null){
            temp.data=null;
            temp=temp.next;
        }
        numNodes=0;
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

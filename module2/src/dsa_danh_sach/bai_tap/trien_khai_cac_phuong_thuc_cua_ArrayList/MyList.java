package dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_cua_ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
//Constructor
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    /**Thêm phần tử tại vị trí index
     *
     *
     */
    public void add(int index, E element) {
        getException(index);
        ensureCapacity(size);
        if (index >= 0 && index < size) {
            Object[] abc = new Object[elements.length];
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        } else elements[size++] = element;
    }


    /**xóa phần tử tại vị trí index
     *
     *
     *
     */
    public E remove(int index){
        getException(index);
        E element = (E) elements[index];
        if (index<size) {
            System.arraycopy(elements, index + 1, elements, index, size - index + 1);
            size--;
            return element;
        }else throw new IndexOutOfBoundsException("index : " + index + "  Size: " + this.size);

    }

    /**Số phần tử trong mảng
     *
     *
     */
    public int size() {
        return this.size;
    }

    /**Clone mảng
     *
     *
     */
    public MyList<E> clone(){
        MyList<E> v=new MyList<>();
        v.elements = Arrays.copyOf(this.elements,this.size);
        v.size=this.size;
        return v;
    }

    /**Tìm kiếm phần tử trong mảng
     *
     *
     */
    public boolean contains(E element){
        for (int i=0;i<size;i++){
            if (elements[i]==element){
                return true;
            }
        }
        return false;
    }

    /**Vị trí của phần tử element trong mảng
     *
     *
     */
    public int indexOf(E element){
            for (int i=0;i<size ;i++){
                if (elements[i]==element){
                    return i;
                }
            }
        return -1;
    }

/**Clear cac phan tu trong mang
 *
 */
 public void clear(){
     for (int i=0;i<size;i++){
         elements[i]=null;
     }
     size=0;
 }

    /**Lấy Giá trị của phần tử thứ index
     *
     *
     */
    public E get(int index) {
        getException(index);
        return (E) elements[index];
    }
/**Thêm phần tử vào cuối danh sách
 */
    public boolean add(E e){
        ensureCapacity(size);
        elements[size++] = e;
        return true;
    }

    /**Kiểm tra độ dài của elements có đủ lưu trữ không

     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newSize = minCapacity;
            elements = Arrays.copyOf(elements, minCapacity);
        }
        System.out.println("minCapacity = "+elements.length);
    }

    /**Kiểm tra ngoại lệ
     *
     *
     */
    private void getException(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index : " + index + "  Size: " + this.size);
        }
    }


}

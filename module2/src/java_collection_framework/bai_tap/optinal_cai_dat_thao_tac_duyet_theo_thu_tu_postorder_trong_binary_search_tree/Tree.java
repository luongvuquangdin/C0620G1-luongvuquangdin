package java_collection_framework.bai_tap.optinal_cai_dat_thao_tac_duyet_theo_thu_tu_postorder_trong_binary_search_tree;

import javax.swing.*;

public class Tree {
    private Node root;
    public Tree(){
    }

    class Node {
        private int data;
        private Node rightSubTree;
        private Node leftSubTree;

        public Node(int element) {
           data = element;
        }
        private void add(int data){
            if (this.data>data){
                if (this.leftSubTree==null){
                    this.leftSubTree=new Node(data);
                }
                else this.leftSubTree.add(data);
            }else if (this.data<data){
                if (this.rightSubTree==null){
                    this.rightSubTree=new Node(data);
                }else this.rightSubTree.add(data);
            }else System.out.println("This "+data+" already exist");
        }

        public int getData() {
            return data;
        }

        public void setData(int element) {
            this.data = element;
        }
        public void printf(){
            if (this.rightSubTree==null&&this.leftSubTree==null)return;
            else if (this.leftSubTree==null){
                System.out.println("\t"+this.data+"\t"+this.rightSubTree.data);
                this.rightSubTree.printf();
            }else if (this.rightSubTree==null){
                System.out.println(this.leftSubTree.data+"\t"+this.data+"\t");
                this.leftSubTree.printf();
            }else {
                System.out.println(this.leftSubTree.data+"\t"+this.data+"\t"+this.rightSubTree.data);
                this.leftSubTree.printf();
                this.rightSubTree.printf();
            }
        }
        private void prinRoot(){
            System.out.print(this.data+" ");
        };
        public void printfPostorder(){
            if (this.leftSubTree!=null) this.leftSubTree.printfPostorder();
            if (this.rightSubTree!=null) this.rightSubTree.printfPostorder();
            this.prinRoot();
        }

        public void printfPreorder(){
            this.prinRoot();
            if (this.leftSubTree!=null) this.leftSubTree.printfPostorder();
            if (this.rightSubTree!=null) this.rightSubTree.printfPostorder();

        }
    }

    //Thêm một số vào Tree
    public void add(int data){
        if (root==null){
            root=new Node(data);
        }else{
            this.root.add(data);
        }
    }

    public  void printf(){
        if (root==null){
            return;
        }
        root.printf();
    }

    //Duyệt theo postorder
    public void printfPostorder() {
        if (root == null) {
            System.out.println("Null");
        } else {
            root.printfPostorder();
        }
    }

    //Duyệt theo Preorder
    public void printfPreorder() {
        if (root == null) {
            System.out.println("Null");
        } else {
            root.printfPreorder();
        }
    }

    //Tìm kiếm
    public boolean search(int element){
        if (root==null){
            System.out.println("Tree is Null");
        }else {
            Node current = root;
            while (current != null) {
                if (current.data==element){
                    return true;
                }else if (element>current.data){
                    current=current.rightSubTree;
                }else current=current.leftSubTree;
            }
        }
        return false;
    }
    //Kiểm tra xem phần tử đó là nút cha hay nút lá
    private boolean isSub(Node element){
        if (element.rightSubTree==null&&element.leftSubTree==null)return true;
        return false;
    }
    //Xóa phần tử trong Tree
    public void remove(int element ){
        if (root==null){
            System.out.println("Tree is Null");
        }else {
            Node current = root;
            while (current != null) {
                if (current.data==element){
                    if (isSub(current)){
                        current.data=0;
                    }else {
                        Node temp=current;
                        if (temp.data>)
                        current=current.rightSubTree;
                    }
                }else if (element>current.data){
                    current=current.rightSubTree;
                }else current=current.leftSubTree;
            }
        }
    }
}

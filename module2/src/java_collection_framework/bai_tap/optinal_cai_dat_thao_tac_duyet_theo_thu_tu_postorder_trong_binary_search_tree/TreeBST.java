package java_collection_framework.bai_tap.optinal_cai_dat_thao_tac_duyet_theo_thu_tu_postorder_trong_binary_search_tree;

public class TreeBST<E extends Comparable<E>>{


    class Node<E>{
        private E value;
        private Node right;
        private Node left;

        public Node(E data) {
            this.value = data;
            Node right=null;
            Node left=null;

        }
    }

    private Node root;
    public TreeBST(){
        root=null;
    }

    //Thêm phần tử mới
    public void add(E data) {
       root= add(root,data);
    }
    Node add(Node root,E data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if (data.compareTo((E) root.value) < 0) {
            root.left=add(root.left, data);
        } else if (data.compareTo((E) root.value) > 0) {
            root.right=add(root.right, data);
        }
        return root;
    }

    //Hiển thị cây
    public void print(){
        if (root==null){
            return;
        }
        print(root);
    }
    void print(Node root) {
        if (root.right==null&&root.left==null)return;
        if (root.right==null) {
            System.out.println(root.left.value+"\t"+root.value);
            print(root.left);
        }
        else if (root.left==null){
            System.out.println("\t"+root.value+"\t"+root.right.value);
            print(root.right);
        }
        else {
            System.out.println(root.left.value+"\t"+root.value+"\t"+root.right.value);
            print(root.left);
            print(root.right);
        }
    }

    //TÌm kiếm trong cây
    public boolean search(E element) {
        Node temp = root;
        while (temp != null) {
            if (element.compareTo((E) temp.value) < 0) {
                temp = temp.left;
            } else if (element.compareTo((E) temp.value) > 0) {
                temp = temp.right;
            }else return true;

        }
        return false;
    }

    //Duyệt theo postorder LRN
    public void printfPostorder() {
        if (root==null)return;
       printfPostorder(root);
    }
    void printfPostorder(Node root){
        if (root.left != null) printfPostorder(root.left);
        if (root.right != null) printfPostorder(root.right);
        System.out.print(root.value + "\t");
    }

    //Duyệt theo Preorder NLR
    public void printfPreorder() {
        if (root==null)return;
        printfPreorder(root);
    }
    void printfPreorder(Node root){
        System.out.print(root.value + "\t");
        if (root.left != null) printfPreorder(root.left);
        if (root.right != null) printfPreorder(root.right);
    }

    //Xóa phần tử
    public void delete(E element) {
        root=delete(root,element);
    }

    //Xóa phần tử có một nhánh con
    private Node delete(Node root, E element) {
        if (root == null) return root;
        if (element.compareTo((E) root.value) < 0) {
            root.left = delete(root.left, element);
        } else if (element.compareTo((E) root.value) > 0) {
            root.right = delete(root.right, element);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = min(root.right);
            root.right = delete(root.right, (E) root.value);
        }
        return root;
    }

    //Tìm phần tử nhỏ nhất trong nhánh
    private E min(Node tree) {
        E min = (E) tree.value;
        while (tree.left != null) {
            min = (E) tree.left.value;
            tree = tree.left;
        }
        return min;
    }
}

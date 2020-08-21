package java_collection_framework.bai_tap.optinal_cai_dat_thao_tac_duyet_theo_thu_tu_postorder_trong_binary_search_tree;

public class MainBST {
    public static void main(String[] args) {
        TreeBST tree=new TreeBST();
        tree.add(5);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(10);
        tree.add(6);
        tree.add(11);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.print();
        System.out.println(tree.search(11));
        System.out.println("Duyệt theo postorder");
        tree.printfPostorder();
        System.out.println("\nDuyệt theo preorder");
        tree.printfPreorder();
        System.out.println("\n----------------------");
        tree.delete(5);
        tree.print();
    }
}

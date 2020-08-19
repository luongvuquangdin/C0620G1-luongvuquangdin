package java_collection_framework.bai_tap.optinal_cai_dat_thao_tac_duyet_theo_thu_tu_postorder_trong_binary_search_tree;

public class Main {
    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.add(44);
        tree.add(18);
        tree.add(13);
        tree.add(15);
        tree.add(37);
        tree.add(23);
        tree.add(40);
        tree.add(88);
        tree.add(59);
        tree.add(108);
        tree.add(55);
        tree.add(71);
        System.out.println("Tree hiện tại");
        tree.printf();
        System.out.println("Tree Sắp xếp theo postorder LRN");
        tree.printfPostorder();
        System.out.println("Tree Sắp xếp theo preorder NLR");
        tree.printfPreorder();
    }
}

public class TreeSample {
    static class Node{ //Nodeクラスにまとめる
        int val;
        Node left;
        Node right;

        //Leafの代わり　左右がない（Leaf用）：値だけをセットする
        Node(int val){
            this(val,null,null);
        }

        //buranchの代わり　左右がある（Branch用）：値と左右のつながりをセットする
        Node(int val, Node left, Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    // 継承(abstract,extends)とleaf,brunchクラスは使用せず、
    // static abstract class Node {
    //     int val;

    //     Node(int val) {
    //         this.val = val;
    //     }

    //     abstract int sum();
    // }

    // static class Leaf extends Node {
    //     public Leaf(int val) {
    //         super(val);
    //     }

    //     @Override
    //     int sum() {
    //         return val;
    //     }
    // }

    // static class Branch extends Node {
    //     Node left;
    //     Node right;

    //     Branch(int val, Node left, Node right) {
    //         super(val);
    //         this.left = left;
    //         this.right = right;
    //     }

    //     @Override
        int sum() {
            int result = val;
            if (left != null) result += left.sum();
            if (right != null) result += right.sum();
            return result;
        }
    }

    public static void main(String[] args) {
        Node root =
            new Node(5,
                new Node(2,
                    new Node(4),
                    null),
                new Node(7,
                    new Node(6),
                    new Node(8)));
        System.out.println(root.sum());
    }
}
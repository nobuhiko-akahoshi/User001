public class TreeSample {
    static class Node{
        int val;
        Node left;
        Node right;

        //buranchの代わり　左右がある（Branch用）：値と左右のつながりをセットする
        Node(int val, Node left, Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }

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
                    new Node(4,null,null),
                    null),
                new Node(7,
                    new Node(6,null,null),
                    new Node(8,null,null)));
        if (0<=root.sum() && root.sum()<=1000) {
            System.out.println(root.sum());
        } else {
            System.err.println("入力された値は0~1000の範囲外です。");
        }
    }
}
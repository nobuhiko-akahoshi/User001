/**
 * 二分木のデータ構造とノードの合計値を計算するサンプルクラス。
 * TreeSampleクラス
 */
public class TreeSample {
    /**
     * 二分木の各要素(ノード)を表す内部クラス
     * Nodeクラス
     */
    static class Node{
        /** ノードが保持する数値データ */
        int val;
        /** 左の子ノード(存在しない場合はnull) */
        Node left;
        /** 右の子ノード(存在しない場合はnull) */
        Node right;

        /** 
         * ノードの値を設定し、左右の子ノードとの接続を初期化する
         * 
         * @param val このノードに保持させる値
         * @param left 左側の子ノード(存在しない場合はnull)
         * @param right 右側の子ノード(存在しない場合はnull)
         */
        Node(int val, Node left, Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }

        /**
         * 自分の配下を含むノードの合計値を計算する
         * @return ノードの合計値
         */
        int sum() {
            int result = val;
            if (left != null) result += left.sum();
            if (right != null) result += right.sum();
            return result;
        }
    }

    /**
     * メインメソッド
     * 2分木を作成し、合計値が0～1000の範囲か確認して結果を出力する
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        Node root =
            new Node(5,
                new Node(2,
                    new Node(4,null,null),
                    null),
                new Node(7,
                    new Node(6,null,null),
                    new Node(8,null,null)));

        // 計算コスト削減のため、全ノードの合計値を1度だけ計算して変数に保持
        int totalSum = root.sum();

        // 合計値が範囲外（0未満または1000より大きい）の場合はエラーメッセージを出力して即座に終了
        if (totalSum < 0 || totalSum > 1000){
            System.err.println("入力された値は0~1000の範囲外です。");
        return;
        }

        System.out.println(totalSum);
    }
}
package Aigo;

/**
 * @Description https://leetcode.cn/problems/valid-sudoku
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 * @Author Administrator
 * @Date 2023/3/1 14:41
 * @Version 1.0.0
 */
public class ValidSudoko {
    /*class Sudoko {
        String value;
        Point[]rowPoint = new Point[9];
        Point[]colPoint = new Point[9];
        Point[]square = new Point[9];

        public Sudoko() {
        }

        public Sudoko(String value, Point[] rowPoint, Point[] colPoint, Point[] square) {
            this.value = value;
            this.rowPoint = rowPoint;
            this.colPoint = colPoint;
            this.square = square;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setRowPoint(Point[] rowPoint) {
            this.rowPoint = rowPoint;
        }

        public void setColPoint(Point[] colPoint) {
            this.colPoint = colPoint;
        }

        public void setSquare(Point[] square) {
            this.square = square;
        }

        public String getValue() {
            return value;
        }

        public Point[] getRowPoint() {
            return rowPoint;
        }

        public Point[] getColPoint() {
            return colPoint;
        }

        public Point[] getSquare() {
            return square;
        }
    }
    class Point{
        int x;
        int y;

        public Point() {
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }*/

    public boolean isValidSudoku(String[][] board) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){

            }
        }
        return false;
    }


    public static void main(String[] args) {
//        String[][]board = new String[][]{
//                {"5","3",".",".","7",".",".",".","."},
//                {"6",".",".","1","9","5",".",".","."},
//                {".","9","8",".",".",".",".","6","."},
//                {"8",".",".",".","6",".",".",".","3"},
//                {"4",".",".","8",".","3",".",".","1"},
//                {"7",".",".",".","2",".",".",".","6"},
//                {".","6",".",".",".",".","2","8","."},
//                {".",".",".","4","1","9",".",".","5"},
//                {".",".",".",".","8",".",".","7","9"}};
//        boolean flag = isValidSudoku(board);
//        System.out.println(flag);
        String str1 = "243";
        String str2 = "564";
        int a = Integer.parseInt(String.valueOf(str1.charAt(0)));
        System.out.println(a);
        int b = str2.indexOf(0);
        System.out.println(b);
    }
}

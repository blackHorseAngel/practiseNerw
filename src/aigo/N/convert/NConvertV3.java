package aigo.N.convert;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/17 11:44
 * @Version 1.0.0
 */
public class NConvertV3 extends NConvertSuper{
    //开始状态
    public static final int BEGIN = 0;
    //向下走
    public static final int DOWN = 1;
    //向上走
    public static final int UP = 2;
    @Override
    public String convert(String s, int numRows) {
        //如果N的折只有1的时候，返回字符串本身
        if(numRows == 1){
            return s;
        }
        StringBuilder builder = new StringBuilder();
        //拆分后的字符串数组结果
        StringBuilder[]builders = new StringBuilder[numRows];
        //初始化字符串数组
        for(int k = 0 ; k < builders.length ; k++){
            builders[k]  = new StringBuilder();
        }
        //下标
        int index = 0;
        //向下
        int state = BEGIN;
        int num = 0;
        while (num < s.length()){
            switch (state){
                //当是开始状态的时候，只能向下走
                case BEGIN:
                    state = DOWN;
                    builders[index].append(s.charAt(num));
                    num++;
                    break;
                //当index等于numRows的时候，就需要改变方向向上走
                case DOWN:
                    index++;
                   builders[index].append(s.charAt(num));
                    num++;
                    state = DOWN;
                    if(index == numRows - 1){
                        state = UP;
                        index--;
                    }
                    break;
                //当index等于-1的时候，就需要改变方向向下走
                case UP:
                   builders[index].append(s.charAt(num));
                    index--;
                    num++;
                    if(index == -1){
                        state = DOWN;
                        index++;
                        break;
                    }

                    break;
                default:
                    break;
            }
            //每做完一次操作都需要将builder清理干净
            builder.setLength(0);
        }
        //拼接结果字符串数组
        for(int j = 0 ; j < builders.length ; j++){
            builder.append(builders[j]);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        //3:PAHNAPLSIIGYIR
        //4:PINALSIGYAHRPI
        int[]numRows = {3,4};
        NConvertV3 nConvertV3 = new NConvertV3();
        for (int i = 0 ; i < numRows.length ; i++) {
            System.out.println(nConvertV3.convert(s,numRows[i]));
        }
    }
}

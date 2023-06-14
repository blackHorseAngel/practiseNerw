package Aigo.Integer.To.Rome;

import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 9:47
 * @Version 1.0.0
 */
public class IntToRomeV2 extends IntToRomeSuper{
    /**
     * 整体放入map
     */
    public String intToRome(int num){
        Map<Integer,String> map = generateRomeIntMap();
        StringBuilder builder = new StringBuilder();
        String result = "";
        int ge =  num/10;
        int shi =  num/100;
        int bai =  num/1000;
        int qian =  num/10000;
        result = handleQian(qian,map,num,result);
        result = handleBai(bai,map,num,result);
        result = handleShi(shi,map,num,result);
        result = handleGe(ge,map,num,result);
        String[]results = result.split(",");
        return results[0];

    }

    /**
     * 处理个位数字
     * @param ge
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleGe(int ge,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(result.length() > 0){
            String[]strings = result.split(",");
            builder.append(strings[0]);
            num = Integer.parseInt(strings[1]);
        }
        if(ge > 0){
            if(ge == 9){
                builder.append(map.get(9));
                num = num -9;
            }else if (ge >= 5 && ge < 9){
                builder.append(map.get(5));
                num = num - 5;
                ge = ge -5;
                for(int i = 0 ; i < ge ; i++){
                    builder.append(map.get(1));
                }
                num = num - 1 * ge;
            }else if(ge == 4){
                builder.append(map.get(4));
                num = num - 4;
            }else if(ge < 4){
                for(int i = 0 ; i < ge ; i++){
                    builder.append(map.get(1));
                }
                num = num - 1 * ge;
            }
            builder.append(",");
            builder.append(num);
        }
        result = builder.toString();
        return result;
    }

    /**
     * 处理十位数字
     * @param shi
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleShi(int shi,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(result.length() > 0){
            String[]strings = result.split(",");
            builder.append(strings[0]);
            num = Integer.parseInt(strings[1]);
        }
        if(shi > 0){
            if(shi == 9){
                builder.append(map.get(90));
                num = num - 90;
            } else if (shi >= 5 && shi < 9) {
                builder.append(map.get(50));
                num = num - 50;
                shi = shi - 5;
                for(int i = 0 ; i < shi ; i++){
                    builder.append(map.get(10));
                }
                num = num - 10 * shi;
            } else if ( shi == 4 ) {
                builder.append(map.get(40));
                num = num - 40;
            } else if ( shi < 4 ) {
                for(int i = 0 ; i < shi ; i++){
                    builder.append(map.get(10));
                }
                num = num - 10 * shi;
            }
            builder.append(",");
            builder.append(num);
        }
        result = builder.toString();
        return result;
    }

    /**
     * 处理百威数字
     * @param bai
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleBai(int bai,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(result.length() > 0){
            String[]strings = result.split(",");
            builder.append(strings[0]);
            num =Integer.parseInt(strings[1]);
        }
        if( bai > 0){
            if(bai == 9){
                builder.append(map.get(900));
                num = num - 900;
            } else if (bai >= 5 && bai < 9) {
                builder.append(map.get(500));
                num = num - 500;
                bai = bai - 5;
                for(int i = 0 ; i < bai ; i++){
                    builder.append(map.get(100));
                }
                num = num - 100 * bai;
            }else if( bai == 4 ) {
                builder.append(map.get(400));
                num = num -400;
            }else if( bai < 4 ){
                for(int i = 0 ; i < bai ; i++){
                    builder.append(map.get(100));
                }
                num = num - 100 * bai;
            }
            builder.append(",");
            builder.append(num);
        }
        result = builder.toString();
        return result;
    }

    /**
     * 处理前卫数字
     * @param qian
     * @param map
     * @param num
     * @param result
     * @return
     */
    private String handleQian(int qian,Map<Integer,String>map,int num,String result) {
        StringBuilder builder = new StringBuilder();
        if(qian > 0){
            for(int i = 0 ; i < qian ; i++){
                builder.append(map.get(1000));
            }
            builder.append(",");
            num = num - 1000 * qian;
            builder.append(num);
        }
        String s = builder.toString();
        return s;
    }
    public static void main(String[] args) {
        //"III"
//        int num = 3;
        //"IV"
//        int num = 4;
        //"V"
//        int num = 5;
        //""VI
//        int num = 8;
        //"IX"
//        int num = 9;
        //"X"
//        int num = 10;
        //"XIV"
//        int num = 14;
        //"XXXIX"
//        int num = 39;
        //"XLIV"
//        int num = 44;
        //"XLIX"
//        int num = 49;
        //"LVIII"
//        int num = 58;
        //"XCIV"
//        int num = 94;
        //"C"
//        int num = 100;
        //"CCCLXXXIX"
//        int num = 389;
        //"CCCXCIX"
//        int num = 399;
        //"CDXXXIV"
//        int num = 434;
        //"CDLXXIX"
//        int num = 479;
        //"DXLV"
//        int num = 545;
        //"MCMXCIV"
        int num = 1994;
        IntToRomeV2 intToRomanV2 = new IntToRomeV2();
        String s = intToRomanV2.intToRoman(num);
        System.out.println(s);
    }
}

package Aigo.N.Convert;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/6/14 13:30
 * @Version 1.0.0
 */
public class NConvertV2 extends NConvertSuper{
    //TODO
    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    @Override
    public String convert(String s, int numRows) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        String[]strs = new String[numRows];
        for(int k = 0 ; k < strs.length ; k++){
            strs[k] = "";
        }
        if(numRows == 1){
            return s;
        }
        if(s.length() <= numRows){
            for(int m = 0 ; m < s.length() ; m++){
                strs[m] = String.valueOf(s.charAt(m));
            }
        }else {
            for(int i = 0 ; i < s.length() ; i++){
                int temp = i % (2 * numRows - 2);
                if(temp < numRows){
                    index = 0;
                    strs[temp] = builder.append(strs[temp]).append(s.charAt(i)).toString();
                } else if (temp >= numRows && temp <= (2 * numRows - 2)) {
                    if(index == 0){
                        index = numRows - 1;
                    }
                    index--;
                    strs[index] = builder.append(strs[index]).append(s.charAt(i)).toString();
                }
                builder.setLength(0);
            }
        }

        for(int j = 0 ; j < strs.length ; j++){
            builder.append(strs[j]);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        //3:PAHNAPLSIIGYIR
        //4:PINALSIGYAHRPI
        int[]numRows = {3,4};
        NConvertV2 nConvertV2 = new NConvertV2();
        for (int i = 0 ; i < numRows.length ; i++) {
            System.out.println(nConvertV2.convert(s,numRows[i]));
        }
    }
}

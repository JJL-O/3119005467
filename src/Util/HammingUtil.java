package Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class HammingUtil {

    /**
     * @param #{传入两个字符串形式的哈希值}
     * @return HammingDistance（定义为int型）
     * @Description: 通过对simHash值逐位比较，计算并返回有差异的位数（HammingDiStance）
     * @Author LJJ
     * @Version 1.0
     */
    public static int getHammingDistance(String simHash0, String simHash1) {

        //对两组simHash进行逐位比较
        int HammingDistance = 0;
        for (int i = 0; i < simHash0.length(); i++) {
            if (simHash0.charAt(i) != simHash1.charAt(i))
                HammingDistance++;
        }
        return HammingDistance;                                                //返回有差异的位数（HammingDiStance）


    }

    /**
     * @param simHash0，simHash1（String表示）
     * @return String(相似度)
     * @Description: 传入两个sinHash值输出他们的相似度
     * @Author LJJ
     * @Version 1.0
     */


    public static String getSimilarity(String simHash0, String simHash1) {

        double hammingDistance = getHammingDistance(simHash0, simHash1);

        return pointToPercent(1 - (hammingDistance) / 128);


    }

/**
 * @Description: 传入一个浮点数，以百分比的形式打印
 * @Author LJJ
 * @param point(需要转换的浮点数）
 * @return String（百分比）
 * @Version 1.0
 */
    public static String pointToPercent(double point) {

        //获取格式化对象
        NumberFormat numberFormat = NumberFormat.getPercentInstance();

        //设置百分数精确到小数点保留几位小数
        numberFormat.setMinimumFractionDigits(2);

        String percent = numberFormat.format(point);

        return percent;
    }


}

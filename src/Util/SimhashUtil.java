package Util;

import com.hankcs.hanlp.HanLP;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SimhashUtil {
    /**
     * @param str（字符串）
     * @return str的Hashcode
     * @Description: 传入字符串并计算其Hashcode，以字符串形式输出(内部使用)
     * @Author LJJ
     * @Version 1.0
     */
    public static String getHash(String str) {

        //Java利用MessageDigest获取Hashcode(此程序使用MD5算法）
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] inputByteArray = str.getBytes(StandardCharsets.UTF_8);         //将输入的字符串根据UTF-8标准转换为字节数组

            return new BigInteger(1, messageDigest.digest(inputByteArray)).toString(2);  //以二进制方式输出
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * @param str（字符串）
     * @return str的Simhash值
     * @Description: 传入字符串并计算其Hashcode，以字符串形式输出
     * @Author LJJ
     * @Version 1.0
     */
    public static String getSimhash(String str) {

        int hashbits = 128;       //MD5产生的序列为128位

        //定义特征向量、数组
        int[] vector = new int[hashbits];
        int index = 0;            //作为循环的索引

        //1、分词（为了简便分词过程使用了HanLP提供的接口）
        List<String> extractKeywordList = HanLP.extractKeyword(str, str.length());//提取出所有的关键词

        //2、获取该字符串的HashCode
        for (String keyword : extractKeywordList) {
            StringBuilder keywordHash = new StringBuilder(getHash(keyword));

            if (keywordHash.length() < 128) {
                int fillLength = 128 - keyword.length();
                for (int i = 0; i < fillLength; i++) {
                    keywordHash.append("0");
                }
            }                                                                          //若该hashCode位不足128位，在低位用0补齐

            //计算词频
            int fluency = Collections.frequency(extractKeywordList, keyword);          //由于测试文本字数不多，加权值可视为目标词在测试文本中出现的次数

            //3、加权，按照每个元素的权重形成加权数字串
            for (int j = 0; j < vector.length; j++) {
                if (keywordHash.charAt(j) =='1') {                                     //通过词频进行加权
                    vector[index]+=fluency;
                } else {
                    vector[index]-=fluency;
                }
            }
            index++;
        }
        //4、降维，形成SimHash签名
           StringBuilder SimHash = new StringBuilder();                                //接收生成的SimHash

        for (int i : vector) {
            if (i > 0) {
                SimHash.append("1");
            } else {
                SimHash.append("0");
            }

        }
           return SimHash.toString();
    }
}

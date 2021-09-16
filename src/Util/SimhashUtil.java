package Util;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

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
            byte[] inputByteArray = str.getBytes(StandardCharsets.UTF_8);                                               //将输入的字符串根据UTF-8标准转换为字节数组

            return new BigInteger(1, messageDigest.digest(inputByteArray)).toString(2);                    //以二进制方式输出
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

        //1、分词（为了简化分词过程使用了HanLP提供的接口）
        List<Term> termList = StandardTokenizer.segment(str);
        List<String> wordList = termList.stream().map(term -> term.word).collect(Collectors.toList());                  //提取出所有词

        List<String> extractKeywordList = HanLP.extractKeyword(str, str.length());                                      //提取关键词

        for (String keyword : extractKeywordList) {
            StringBuilder keywordHash = new StringBuilder(getHash(keyword));

            if (keywordHash.length() < 128) {
                int fillLength = 128 - keyword.length();
                for (int i = 0; i < fillLength; i++) {
                    keywordHash.append("0");
                }
            }                                                                                                           //若该hashCode位不足128位，在低位用0补齐

            //计算词频
            int fluency = Collections.frequency(wordList, keyword);                                                      //一个词在文章中出现的总次数


            //3、加权并合并，按照每个元素的权重形成加权数字串
            for (int j = 0; j < vector.length; j++) {
                if (keywordHash.charAt(j) == '1') {                                                                     //通过词频（fluency/文本中总词数）进行加权
                    vector[j] += 10 - fluency / (wordList.size() / 10);                                                 //不能直接使用词频作为加权值（有些权值会超过个位数，最终造成数组越界的错误），因此处理如下
                } else {
                    vector[j] -= 10 - fluency / (wordList.size() / 10);
                }
            }
            index++;
        }

        //4、降维，形成Simhash签名
        StringBuilder Simhash = new StringBuilder();                                                                    //接收生成的SimHash

        for (int i : vector) {
            if (i > 0) {
                Simhash.append("1");
            } else {
                Simhash.append("0");
            }

        }
        return Simhash.toString();
    }


}

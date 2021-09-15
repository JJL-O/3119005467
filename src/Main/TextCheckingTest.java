package Main;

import Util.HammingUtil;
import Util.SimhashUtil;
import Util.TextIOUtil;
import org.junit.Test;

/**
 * @Description: TextCheckingTest$
 * @Author LJJ
 * @Date: 2021/9/14$ 22:15$
 * @Version 1.0
 */
public class TextCheckingTest {

    @Test
    public void origAndOrigAddTest(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_add.txt");

       String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
       TextIOUtil.writeTxt("orig与orig_0.8_add的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrig_0_8DelTest(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_del.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_del的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrigDelTest(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_del.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_0.8_del的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrigDis_1Test(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_dis_1.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_0.8_dis_1的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }


    @Test
    public void origAndOrigDis_5Test(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_dis_5.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_0.8_dis_5的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrigDis_8Test(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_dis_8.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_0.8_dis_8的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrigDis_10Test(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_dis_10.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_0.8_dis_10的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }


    @Test
    public void origAndOrig_Dis_15Test(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_dis_15.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_0.8_dis_15的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrigMixTest(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_mix.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_0.8_mix的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");


    }

    @Test
    public void origAndOrigSubTest(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_sub.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_sub的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrigSub5Test(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_sub5.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与orig_sub5的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void origAndOrigWrongTest(){
        String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
        String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_wrong.txt");

        String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
        TextIOUtil.writeTxt("orig与rig_wrong的相似度为"+similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
    }

    @Test
    public void noExistPathTest() {
        try {
            String str0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orignoexistpath.txt");
            String str1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_add.txt");

            String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));
            TextIOUtil.writeTxt("orig与orig_0.8_add的相似度为" + similarity, "D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
        }catch(Exception e){
        }
    }


}


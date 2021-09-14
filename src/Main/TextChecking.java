package Main;

import Util.HammingUtil;
import Util.SimhashUtil;
import Util.TextIOUtil;
import org.junit.Test;

import java.io.IOException;

public class TextChecking {
    public static void main(String[] args) throws IOException {

        System.out.println("Test" );
            String readTxt0 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
            String readTxt1 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_add.txt");
            TextIOUtil.writeTxt(HammingUtil.getSimilarity(SimhashUtil.getSimhash(readTxt0),SimhashUtil.getSimhash(readTxt1)),"D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");



            String readTxt2 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig.txt");
            String readTxt3 = TextIOUtil.readTxt("D:\\软件工程\\个人项目作业\\测试文本\\orig_0.8_del.txt");

             TextIOUtil.writeTxt(HammingUtil.getSimilarity(SimhashUtil.getSimhash(readTxt2),SimhashUtil.getSimhash(readTxt3)),"D:\\软件工程\\个人项目作业\\测试文本\\similarity.txt");
//

    }
}


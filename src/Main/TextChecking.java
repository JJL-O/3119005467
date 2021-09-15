package Main;

import Util.HammingUtil;
import Util.SimhashUtil;
import Util.TextIOUtil;
import org.junit.Test;

import java.io.IOException;

public class TextChecking {
    public static void main(String[] args) throws IOException {

              String textOrigPath=args[0];
              String textOrig_FakerPath=args[1];
              String outPutPath=args[2];

              //根据命令行输入的路径读取和输出相应的文本
              String str0 = TextIOUtil.readTxt(textOrigPath);
              String str1 = TextIOUtil.readTxt(textOrig_FakerPath);

              //获取相似度
              String similarity = HammingUtil.getSimilarity(SimhashUtil.getSimhash(str0), SimhashUtil.getSimhash(str1));

              //将相似度写入对应的路径中
              TextIOUtil.writeTxt(similarity,outPutPath);

              //退出程序
               System.exit(0);
    }
}


package Util;

import java.io.*;

public class TextIOUtil {
  /**
   * @Description: 读取Path下的文件
   * @Author LJJ
   * @param Path（文件路径）
   * @return 文件内容
   * @Version 1.0
   */
    public static String readTxt(String Path) throws IOException {


        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        StringBuilder inputSB = null;

        try {
            fileInputStream = new FileInputStream(Path);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));

            inputSB = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {                                                                                      //进行字符串的拼接
                inputSB.append(line);
                line = bufferedReader.readLine();
                if (line != null) {
                    inputSB.append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();                                                                                     //关闭资源
            fileInputStream.close();
        }
        return inputSB.toString();
    }

/**
 * @Description: 将similarity输出到txt文件中
 * @Author LJJ
 * @param  similarity（相似度）
 * @param txtPath(文件路径）
 * @Version 1.0
 */
    public static void writeTxt(String similarity, String txtPath) {

        try {
            File file = new File(txtPath);
            FileWriter fileWriter = new FileWriter(txtPath, true);                                              //将similarity输入文件，不覆盖之前输入内容

            if (!file.exists()) {                                                                                       //判断txtPath是否存在，若存在则输入字符串，反之创建对应文件
                file.createNewFile();
            }

            fileWriter.write(similarity + "\n");
            fileWriter.close();                                                                                         //关闭资源

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


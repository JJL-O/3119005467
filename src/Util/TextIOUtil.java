package Util;

import java.io.*;

public class TextIOUtil {
    /**
     * @param Path（文件路径）
     * @return 文件内容
     * @Description: 读取Path下的文件
     * @Author LJJ
     * @Version 1.0
     */
    public static String readTxt(String Path) {


        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        StringBuilder inputStringBuilder = null;

        try {
            fileInputStream = new FileInputStream(Path);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));

            inputStringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {                                                                                      //进行字符串的拼接
                inputStringBuilder.append(line);
                line = bufferedReader.readLine();
                if (line != null) {
                    inputStringBuilder.append("\n");
                }
            }

            bufferedReader.close();                                                                                     //关闭资源
            fileInputStream.close();
        } catch (NullPointerException | FileNotFoundException | UnsupportedEncodingException e) {                       //进行简易的异常处理，当文件名不存在时输出相应提示
            System.out.println("路径不存在，请检查文件路径");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                bufferedReader.close();                                                                                 //关闭资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assert inputStringBuilder != null;
        return inputStringBuilder.toString();
    }

    /**
     * @param similarity（相似度）
     * @param txtPath(文件路径）
     * @Description: 将similarity输出到txt文件中
     * @Author LJJ
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


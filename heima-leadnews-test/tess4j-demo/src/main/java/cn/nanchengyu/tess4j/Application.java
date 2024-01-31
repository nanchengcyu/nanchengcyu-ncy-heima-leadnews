package cn.nanchengyu.tess4j;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * ClassName: Application
 * Package: cn.nanchengyu.tess4j
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/31 19:40
 * @Version 1.0
 */
public class Application {
    /**
     * 识别图片中的文字
     */
    public static void main(String[] args) throws TesseractException {
        //创建实例
        Tesseract tesseract = new Tesseract();
        //设置字体库路径
        tesseract.setDatapath("");

        //设置语言 -》简体中文
        tesseract.setLanguage("chi_sim");
        //识别图片
        String result = tesseract.doOCR(new File(""));

        System.out.println("识别的结果为"+result);
    }
}

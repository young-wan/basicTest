package excelIter.SPIDemo;

import java.util.ServiceLoader;

/**
 * @author Young
 * @create 2020-03-08 14:45
 * @desc leetcode
 * {@link}
 **/
public class SPIMain {

    private ServiceLoader<IParseDoc> list = ServiceLoader.load(IParseDoc.class);

    public static void main(String[] args) {

    }

}

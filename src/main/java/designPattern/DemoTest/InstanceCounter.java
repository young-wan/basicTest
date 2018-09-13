package designPattern.DemoTest;

/**
 * @title: wechat-service
 * @author: Young
 * @desc: 微信
 * @date: Created at 8/28 0028 16:16
 */
public class InstanceCounter {
    private static int numInstances = 0;
    protected static int getCount(){
        return numInstances;
    }
    private static void addInstance(){
        numInstances++;
    }
    InstanceCounter(){
        InstanceCounter.addInstance();
    }

    public static void main(String[] args) {
        System.out.println("Starting with : " + InstanceCounter.getCount()
        + " instances");

        for (int i = 0; i < 500; i++){
            InstanceCounter.addInstance();
        }
        System.out.println("Created " + InstanceCounter.getCount() + " instances " + InstanceCounter.numInstances);
    }



}

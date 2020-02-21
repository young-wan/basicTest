package resume_practice.JVMPack;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/21 11:22
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        WeakReference weakReference = new WeakReference(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        o1 = null;
        System.gc();

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("====================");

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }

    private static void phanRefQueue() {
        Object o1 = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=========================");
    }

    private static void weakMap() {
        WeakHashMap weakHashMap = new WeakHashMap();
        Integer key = new Integer(2);
//        Integer key =2;  此种定义不会回收
        String value = "data";
        weakHashMap.put(key, value);
        System.out.println(weakHashMap);

        key = null;
        System.out.println(weakHashMap);

        System.gc();
        System.out.println(weakHashMap);
    }

    private static void weakRef() {
        Object o1 = new Object();
        WeakReference weakReference = new WeakReference(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
    }

    private static void softRef() {
        Object o1 = new Object();
        SoftReference softReference = new SoftReference(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    private static void strongRef() {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2);
    }
}

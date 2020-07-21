package JUCPack;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2020/02/18 10:55
 */
class User {
    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class AtomicReferenceDemo {


    public static void main(String[] args) {
        User user1 = new User(1, "zs");
        User user2 = new User(2, "ls");
        AtomicReference<User> atomicReference = new AtomicReference<User>();
        atomicReference.set(user1);

        System.out.println(atomicReference.compareAndSet(user1, user2) + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(user1, user2) + atomicReference.get().toString());
    }
}

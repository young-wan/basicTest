package designPattern.ThreadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 2019/07/12 11:24
 */
public class RolePlay {

    private static int harm;
    private static int round;

    static class role {
        public role(String name, int hp, int attack, int r) {
            this.name = name;
            this.hp = hp;
            this.attack = attack;
            this.r = r;
        }

        private String name;

        private int hp;

        private int attack;

        private int r;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getAttack() {
            return attack;
        }

        public void setAttack(int attack) {
            this.attack = attack;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }
    }

    static class TT implements Runnable {
        private role role;

        public TT(RolePlay.role role) {
            this.role = role;
        }

        @Override
        public void run() {
            if (role.getHp() > 0 && role.getR() == round) {
                System.out.println("-------------------");
                System.out.println(role.getName());
                role.setHp(role.getHp() - harm);
                System.out.println("hp: " + role.getHp());
                int curHarm = (int) (Math.random() * role.getAttack());
                harm = curHarm;
                round = role.getR();
                System.out.println("curHarm: " + curHarm);
//                try {
//                    role.wait(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }else {
                round = 1;
            }
        }
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        double a = 2.1;
        double b = 1.1;
        double c = 3.1;
        list.add(a);
        list.add(b);
        list.add(c);
        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);


//        role role1 = new role("role_1", 20, 8, 1);
//        role role2 = new role("role_2", 30, 3, 2);
//        TT t1 = new TT(role1);
//        TT t2 = new TT(role2);
//        Thread td1 = new Thread(t1);
//        Thread td2 = new Thread(t2);
//        td1.start();
//        td2.start();
    }
}

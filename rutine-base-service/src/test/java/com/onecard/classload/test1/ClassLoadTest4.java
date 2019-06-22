package com.onecard.classload.test1;

/**
 * @description:
 * @author: wuchu
 * @date: Created in 2019/6/22 14:14
 */
public class ClassLoadTest4 {
        private static ClassLoadTest4 test = new ClassLoadTest4();

        static int x;
        static int y = 0;

        public ClassLoadTest4() {
            x++;
            y++;
        }

        public static void main(String[] args) {
            System.out.println(test.x);
            System.out.println(test.y);
        }


}

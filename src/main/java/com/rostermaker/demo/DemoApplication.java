package com.rostermaker.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


    }
}


//        public class Duck {
//
//            private int size;
//            private static int duckCount;
//            private static int totalSize;
//
//            public Duck(int size) {
//                this.size = size;
//                duckCount++;
//                totalSize += size;
//            }
//
//            public int getSize() {
//                return size;
//            }
//
//            public void setSize(int size) {
//                this.size = size;
//            }
//
//            public static int getDuckCount() {
//                return duckCount;
//            }
//
//            public static int getTotalSize() {
//                return totalSize;
//            }
//        }

//        Duck firstDuck = new Duck(2);
//        Duck secondDuck = new Duck(3);
//        Duck thirdDuck = new Duck(5);
//        Duck fourthDuck = new Duck(7);
//
//        System.out.println(Duck.getDuckCount());
//        System.out.println(Duck.getTotalSize());
//        System.out.println(Math.PI);



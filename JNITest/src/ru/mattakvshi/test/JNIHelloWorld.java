package ru.mattakvshi.test;

public class JNIHelloWorld {
    native void printHelloWorld();

    public static void main(String[] args) {
        JNIHelloWorld p = new JNIHelloWorld();
        p.printHelloWorld();
    }
    static {
        //System.load("C:/LectciiOOP/Progs/JNITest/bin/JNIHelloWorld.dll");
        System.loadLibrary("JNIHelloWorld");
    }
}

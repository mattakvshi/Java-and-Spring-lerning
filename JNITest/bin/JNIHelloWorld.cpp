#include <iostream>
#include "JNIHelloWorld.h"

JNIEXPORT void JNICALL Java_ru_mattakvshi_test_JNIHelloWorld_printHelloWorld
        (JNIEnv *, jobject) {
    std::cout << "Hello world!";
}
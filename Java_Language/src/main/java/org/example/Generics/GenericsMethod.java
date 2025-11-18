package org.example.Generics;

import org.example.Generics.Tool.Animal;
import org.example.Generics.Tool.Organism;

import java.util.List;
import java.util.Objects;

public class GenericsMethod {

    public static <T, K> void shout(T shoutT, K shoutK) {
        System.out.println(shoutT);
        System.out.println(shoutK);
    }

    public static <T extends Animal & Organism, K> void shoutAnimal(T shoutT, K shoutK) {
        System.out.println(shoutT);
        System.out.println(shoutK);
    }

    // 需要使用通配符 ?, 否则直接使用 List<Object> 会报错, 原因如下:
    // 假设传入类型为 String, 虽然 String 是 Object 的子类，但是 List<String> 不是 List<Object> 的子类
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void printAnimalList(List<? extends Animal> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

package org.example.Generics;

// 通过泛型避免IntContainer、StringContainer等重复实现
public class GenericsContainer <T> {

    private T container;

    public GenericsContainer(T container) {
        this.container = container;
    }

    public void print() {
        System.out.println(container);
    }
}

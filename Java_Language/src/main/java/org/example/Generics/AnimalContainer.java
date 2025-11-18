package org.example.Generics;

import org.example.Generics.Tool.Animal;
import org.example.Generics.Tool.Organism;

// Java 只支持单继承，不能 extend 多个 Class，但是可以 extend 多个 Interface
public class AnimalContainer <T extends Animal & Organism>{
}

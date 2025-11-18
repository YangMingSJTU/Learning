package org.example;

import org.example.Generics.*;
import org.example.Generics.Tool.Cat;
import org.example.Generics.Tool.Dog;
import org.example.Generics.Tool.IntContainer;
import org.example.Generics.Tool.StringContainer;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            IO.println("i = " + i);
//        }

        // Not Generics
        StringContainer stringContainer = new StringContainer("Test");
        stringContainer.print();
        IntContainer intContainer = new IntContainer(123);
        intContainer.print();

        // Generics
        GenericsContainer<String> stringGenericsContainer = new GenericsContainer<>("Test");
        stringGenericsContainer.print();
        GenericsContainer<Integer> integerGenericsContainer = new GenericsContainer<>(123);
        integerGenericsContainer.print();

        // Generics Animal
        AnimalContainer<Cat> catAnimalContainer = new AnimalContainer<>();
        AnimalContainer<Dog> dogAnimalContainer = new AnimalContainer<>();

        // Generics Method
        GenericsMethod.shout("Method", 1);
        List<Integer> list = new ArrayList<>();
        GenericsMethod.printList(list);
    }
}

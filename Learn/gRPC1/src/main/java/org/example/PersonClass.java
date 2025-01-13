package org.example;

import org.example.protos.PersonProto.Person;

import java.io.FileOutputStream;
import java.io.IOException;

public class PersonClass{
  public static void main(String arg[]){
    Person shijas = Person.newBuilder()
                        .setId(123)
                        .setName("shijas")
                        .setEmail("shijas002@gmail.com")
                        .build();


    try {
        FileOutputStream output = new FileOutputStream("Generate.txt");
        shijas.writeTo(output);
    } catch (IOException e) {
        System.err.println("Error writing to file: " + e.getMessage());
        e.printStackTrace();
    }
    System.out.println("Person Details:");
    System.out.println("Name: " + shijas.getName());
    System.out.println("ID: " + shijas.getId()); 
    System.out.println("Email: " + shijas.getEmail());
    System.out.println("Person data written to file: Generate.txt");
  }
}

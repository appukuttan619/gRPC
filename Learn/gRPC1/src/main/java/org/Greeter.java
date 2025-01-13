package org;

import com.example.protos.GreeterProto.HelloRequest;
import com.example.protos.GreeterProto.HelloReply;  

public class Greeter {
    public static void main(String[] args) {
        HelloRequest request = HelloRequest.newBuilder()
            .setName("mandathi anakha")
            // .setSurname("Hii")
            .build();

            //send to server 

            // reply = from connected server 

        HelloReply reply = HelloReply.newBuilder()
            .setMessage("Hello, " + request.getName() + "!")
            .build();

        System.out.println(reply.getMessage());
        System.out.println(request.getName());
        // System.out.println(request.getSurname());
    }

}

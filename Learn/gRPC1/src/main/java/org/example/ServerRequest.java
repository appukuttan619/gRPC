package org.example;

// import com.example.protos.GreeterProto.HelloReply;
// import com.example.protos.GreeterProto.HelloRequest;
import com.example.helloworld.HelloRequest;
import com.example.helloworld.HelloReply;
import com.example.helloworld.GreeterGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ServerRequest {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext()
            .build();

        // Create stub
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        // Create request (existing code)
        HelloRequest request = HelloRequest.newBuilder()
            .setName("anakha")
            .build();

        try {
            // Send request to server and get response
            HelloReply reply = stub.sayHello(request);
            
            // Print the response
            System.out.println("Response from server: " + reply.getMessage());

            // Print the status code
            io.grpc.Status status = io.grpc.Status.OK;
            System.out.println("Status code: " + status.getCode());
        }catch(io.grpc.StatusRuntimeException statusRuntimeException){
            System.out.println("Error calling grpc server : " + statusRuntimeException.getMessage());
            System.out.println("Status code : " + statusRuntimeException.getStatus().getCode());
        } 
        
        catch (Exception e) {
            System.err.println("Error calling gRPC server: " + e.getMessage());
        } finally {
            // Shutdown the channel
            channel.shutdown();
        }
    }

}

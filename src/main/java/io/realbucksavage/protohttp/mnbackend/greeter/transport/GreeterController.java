package io.realbucksavage.protohttp.mnbackend.greeter.transport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.protobuf.codec.ProtobufferCodec;
import io.rbs.protobufhttp.greeter.Greeter;

@Controller("/greeter")
public class GreeterController {

    private static final Logger logger = LoggerFactory.getLogger(GreeterController.class);

    @Post
    @Consumes(ProtobufferCodec.PROTOBUFFER_ENCODED)
    @Produces(ProtobufferCodec.PROTOBUFFER_ENCODED)
    Greeter.GreeterResponse sayGreeting(@Body Greeter.GreeterRequest request) {

        logger.info("got request for " + request.getName());

        return Greeter.GreeterResponse.newBuilder().setGreeting("hola " + request.getName()).build();
    }
}

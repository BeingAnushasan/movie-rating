package com.tiger.movierating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MovieRatingApplication {

    public static void main( String[] args ){
        SpringApplication.run( MovieRatingApplication.class, args );
    }


//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//
//            Connection connect = Nats.connect();
//            Dispatcher dispatcher = connect.createDispatcher( message -> {
//                System.out.printf( "Received message [%s] from [%s] %n",
//                        new String( message.getData(), StandardCharsets.UTF_8 ),
//                        message.getSubject() );
//            } );
//            dispatcher.subscribe( "com.tiger" );
//        };
//    }

}

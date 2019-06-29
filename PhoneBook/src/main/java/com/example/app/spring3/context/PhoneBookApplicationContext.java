package com.example.app.spring3.context;
import com.example.app.spring3.repository.FileRepository;
import com.example.app.spring3.repository.GmailRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = {"com.example.app.spring3"})
public class PhoneBookApplicationContext {
    @Bean
    FileRepository getFileRepository(){
        FileRepository repository = new FileRepository("phone_books.bin");
        return repository;
    }
    @Bean
    GmailRepository getGmailrepository(){
        GmailRepository repository = new GmailRepository();
        return repository;
    }

}

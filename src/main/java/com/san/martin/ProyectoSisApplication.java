package com.san.martin;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProyectoSisApplication implements CommandLineRunner {

  // @Autowired
  // private BCryptPasswordEncoder passwordEncoder;

  // public WebMvcConfigurer corsMappingConfigurer() {
  //   return new WebMvcConfigurer() {
  //       @Override
  //       public void addCorsMappings(CorsRegistry registry) {
  //           registry.addMapping("/**")
  //             .allowedOrigins("*")
  //             .allowedMethods("*")
  //             .maxAge(3600)
  //             .allowedHeaders("*")
  //             .exposedHeaders("*");
  //       }
  //   };
  // }


  public static void main(String[] args) {
    SpringApplication.run(ProyectoSisApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // TEST bcrypt encryption
    // String password = "12345";

    // for (int i = 0; i < 4; i++) {
    //   String passwordBcrypt = passwordEncoder.encode(password);
    //   System.out.println(passwordBcrypt);
    // }
  }
}

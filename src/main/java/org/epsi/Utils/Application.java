package org.epsi.Utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

// @SpringBootApplication est annoté @ComponentScan sans paramètre. Par défaut, @ComponentScan
// scanne le package actuel et les sous-package... La Spring-Boot app est donc uniquement dans org.epsi.Utils.* !
// Pour éviter ce problème, on place généralement la classe annotée @SpringBootApplication à la racine du projet
// Pour fixer ce problème, on peut ajouter manuellement le bon @ComponentScan
@ComponentScan(basePackages = "org.epsi")
@SpringBootApplication
public class Application {

        @Bean
        public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
            return args -> {

                System.out.println("Liste des Beans enregistres par Spring Boot:");

                String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (String beanName : beanNames) {
                    System.out.println(beanName);
                }

            };
        }
    }


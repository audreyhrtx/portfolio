package ctp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(QuestionRepository questionRepository, ChoixRepository choixRepository) {
        return args -> {
            Question question1 = questionRepository.save(new Question("Date de la bataille de Marignan ?"));
            choixRepository.save(new Choix(question1.getQno(), "1313", false));
            choixRepository.save(new Choix(question1.getQno(), "1414", false));
            choixRepository.save(new Choix(question1.getQno(), "1515", true));
            choixRepository.save(new Choix(question1.getQno(), "1616", false));

            Question question2 = questionRepository.save(new Question("Quel est le président de la république actuel ?"));
            choixRepository.save(new Choix(question2.getQno(), "Chirac", false));
            choixRepository.save(new Choix(question2.getQno(), "Sarkozy", false));
            choixRepository.save(new Choix(question2.getQno(), "Hollande", false));
            choixRepository.save(new Choix(question2.getQno(), "Macron", true));

            Question question3 = questionRepository.save(new Question("Qui a découvert la péniciline ?"));
            choixRepository.save(new Choix(question3.getQno(), "Darwin", false));
            choixRepository.save(new Choix(question3.getQno(), "Pasteur", false));
            choixRepository.save(new Choix(question3.getQno(), "Fleming", true));
            choixRepository.save(new Choix(question3.getQno(), "Watson", false));
        };
    }
}
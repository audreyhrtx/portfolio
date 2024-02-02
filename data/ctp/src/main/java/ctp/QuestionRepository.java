package ctp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Question q SET q.active = false")
    void deactivateAllQuestions();

    @Query("SELECT q FROM Question q WHERE q.active = true")
    Optional<Question> findByActiveTrue();
}
package ctp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Choix {
    public Choix(Long qno, String string, boolean b) {
        this.question = new Question(string);
        this.statut = b;
        this.question.setQno(qno);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    private String libchoix;

    private boolean statut;

    @Column(name = "nbchoix", nullable = false, columnDefinition = "int default 0")
    private int nbchoix;

    @ManyToOne
    @JoinColumn(name="qno", nullable=false)
    private Question question;

    public Choix() {
    }
}
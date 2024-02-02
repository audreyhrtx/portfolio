package ctp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Question {

    public Question() {
    }
    public Question(Long qno) {
        this.qno = qno;
    }

    public Question(String string) {
        this.libquest = string;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long qno;
    private String libquest;
    private boolean active;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Choix> choix;

}
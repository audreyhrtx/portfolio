package ctp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChoixRepository choixRepository;

    @GetMapping({"/activer",""})
    public String showForm(Model model) {
        List<Question> questions = questionRepository.findAll();
        System.out.println("Questions: " + questions); 
        model.addAttribute("questions", questions);
        return "activateQuestion";
    }
    
    @PostMapping("/activer")
    public String activateQuestion(@RequestParam Long questionId, Model model) {
        ctp.Question activatedQuestion = questionRepository.findById(questionId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + questionId));
        questionRepository.deactivateAllQuestions();
        activatedQuestion.setActive(true);
        questionRepository.save(activatedQuestion);
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);
        model.addAttribute("message", "La question " + activatedQuestion.getQno()+ " vient d’être activée");
        return "activateQuestion";
    }

    @GetMapping("/voter")
    public String showVoteForm(Model model) {
        Question activeQuestion = questionRepository.findByActiveTrue()
            .orElseThrow(() -> new IllegalArgumentException("No active question"));
        model.addAttribute("question", activeQuestion);
        model.addAttribute("choices", activeQuestion.getChoix());
        return "voteForm";
    }

    @PostMapping("/voter")
    public String handleVote(@RequestParam Long choixId, Model model) {
        Choix selectedChoice = choixRepository.findById(choixId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid choice ID: " + choixId));
        selectedChoice.setNbchoix(selectedChoice.getNbchoix() + 1);
        choixRepository.save(selectedChoice);
        model.addAttribute("message", "Votre choix a bien été pris en compte");
        return "voteConfirmation";
    }
}

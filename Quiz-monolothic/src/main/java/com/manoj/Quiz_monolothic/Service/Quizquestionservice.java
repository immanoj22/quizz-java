package com.manoj.Quiz_monolothic.Service;

import com.manoj.Quiz_monolothic.Model.Quiz;
import com.manoj.Quiz_monolothic.Model.Quizquestion;
import com.manoj.Quiz_monolothic.Model.Quizwrapper;
import com.manoj.Quiz_monolothic.Model.Responsefromquiz;
import com.manoj.Quiz_monolothic.Repository.QuizRepository;
import com.manoj.Quiz_monolothic.Repository.Quizquestionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Quizquestionservice {
    @Autowired
    Quizquestionrepository quizquestionrepository;

    @Autowired
    QuizRepository quizRepository;

    public ResponseEntity<String> createquizquestion(String category, int numofques, String title) {
        List<Quiz> quizques=quizRepository.findByRandomquesbyCategory(category,numofques);
        Quizquestion quizquestion=new Quizquestion();
        quizquestion.setTitle(title);
        quizquestion.setQuizquestion(quizques);
        quizquestionrepository.save(quizquestion);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<Quizwrapper>> getquestion(Integer id) {
        try{
            Optional<Quizquestion> quizquestion=quizquestionrepository.findById(id);
            List<Quiz>question=quizquestion.get().getQuizquestion();
            List<Quizwrapper>quizwraper=new ArrayList<>();
            for(Quiz i:question){
                Quizwrapper quizwrapper=new Quizwrapper(i.getId(),i.getQuestion(),i.getOption1(),i.getOption2(),i.getOption3(),i.getOption4());
                quizwraper.add(quizwrapper);
            }
            return new ResponseEntity<>(quizwraper,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<Integer> getresult(int id, List<Responsefromquiz> responsefromquiz) {
        Quizquestion quizquestion=quizquestionrepository.findById(id).get();
        List<Quiz>quiz=quizquestion.getQuizquestion();
        int i=0;
        int score=0;
        for(Responsefromquiz res:responsefromquiz){
            if(res.getResponse().equals(quiz.get(i).getRightanswer())){
                score++;
            }
            i++;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}

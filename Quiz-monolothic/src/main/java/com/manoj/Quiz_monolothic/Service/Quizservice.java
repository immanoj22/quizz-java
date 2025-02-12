package com.manoj.Quiz_monolothic.Service;

import com.manoj.Quiz_monolothic.Model.Quiz;
import com.manoj.Quiz_monolothic.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Quizservice{
    @Autowired
    QuizRepository quizRepository;

    public ResponseEntity<List<Quiz>> getslash(){
        try{
            List<Quiz>list=quizRepository.findAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Quiz>> addquestion(Quiz quiz) {
        try{
            quizRepository.save(quiz);
            List<Quiz>list= quizRepository.findAll();
            return new ResponseEntity<>(list,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Quiz>> getquestionbycategory(String category) {
        try{
            List<Quiz>list=quizRepository.findBycategory(category);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Optional<Quiz>> updatequestion(Quiz quiz) {
        try{
            quizRepository.save(quiz);
            Optional<Quiz>optional=quizRepository.findById(quiz.getId());

            return new ResponseEntity<>(optional,HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(Optional.empty(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deletequestion(int id) {
        try{
            quizRepository.deleteById(id);
            return new ResponseEntity<>("sucess",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);

    }
}

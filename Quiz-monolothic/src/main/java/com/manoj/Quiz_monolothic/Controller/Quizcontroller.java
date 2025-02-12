package com.manoj.Quiz_monolothic.Controller;

import com.manoj.Quiz_monolothic.Model.Quiz;
import com.manoj.Quiz_monolothic.Service.Quizservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("questions")
public class Quizcontroller {
    @Autowired
    Quizservice quizservice;

    @GetMapping("/")
    public ResponseEntity<List<Quiz>> homepage(){
        return quizservice.getslash();
    }

    @PostMapping("/addquestion")
    public ResponseEntity<List<Quiz>> addquestion(@RequestBody Quiz quiz){
        return quizservice.addquestion(quiz);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Quiz>> questionbycategory(@PathVariable String category){
        return quizservice.getquestionbycategory(category);
    }

    @PutMapping("/update/question")
    public ResponseEntity<Optional<Quiz>> updateques(@RequestBody Quiz quiz){
        return quizservice.updatequestion(quiz);
    }

    @DeleteMapping("deletequestion/{id}")
    public ResponseEntity<String> deletequestion(@PathVariable int id){
        return quizservice.deletequestion(id);
    }
}

package com.manoj.Quiz_monolothic.Controller;

import com.manoj.Quiz_monolothic.Model.Quizwrapper;
import com.manoj.Quiz_monolothic.Model.Responsefromquiz;
import com.manoj.Quiz_monolothic.Service.Quizquestionservice;
import com.manoj.Quiz_monolothic.Service.Quizservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class Quizquestioncreation {
    @Autowired
    Quizquestionservice quizquestionservice;

    @PostMapping("create")
    public ResponseEntity<String> createquiz(@RequestParam String category, int numofques, String title){
        return quizquestionservice.createquizquestion(category,numofques,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<Quizwrapper>> getquestion(@PathVariable Integer id){
        return quizquestionservice.getquestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitquiz(@PathVariable int id,@RequestBody List<Responsefromquiz> response){
        return quizquestionservice.getresult(id,response);
    }
}

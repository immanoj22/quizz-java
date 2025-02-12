package com.manoj.Quiz_monolothic.Repository;

import com.manoj.Quiz_monolothic.Model.Quizquestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Quizquestionrepository extends JpaRepository<Quizquestion,Integer> {
}

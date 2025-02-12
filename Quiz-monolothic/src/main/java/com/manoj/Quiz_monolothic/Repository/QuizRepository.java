package com.manoj.Quiz_monolothic.Repository;

import com.manoj.Quiz_monolothic.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    List<Quiz> findBycategory(String category);

    @Query(value ="SELECT * FROM quiz q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numofques " ,nativeQuery = true)
    List<Quiz> findByRandomquesbyCategory(String category, int numofques);
}

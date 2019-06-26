package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long>
{

}

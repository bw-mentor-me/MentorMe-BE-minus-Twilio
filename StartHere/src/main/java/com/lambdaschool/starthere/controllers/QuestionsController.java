package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Question;
import com.lambdaschool.starthere.services.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    QuestionService questionService;

    @GetMapping(value = "/questions",
                produces = {"application/json"})
    public ResponseEntity<?> listAllquestions(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Question> allquestions = questionService.findAll();
        return new ResponseEntity<>(allquestions, HttpStatus.OK);
    }


    @GetMapping(value = "/question/{questionId}",
                produces = {"application/json"})
    public ResponseEntity<?> getquestion(HttpServletRequest request,
                                      @PathVariable
                                              Long questionId)
    {
        logger.trace(request.getRequestURI() + " accessed");

        Question q = questionService.findQuestionById(questionId);
        return new ResponseEntity<>(q, HttpStatus.OK);
    }


    @GetMapping(value = "/username/{userName}",
                produces = {"application/json"})
    public ResponseEntity<?> findquestionByUserName(HttpServletRequest request,
                                                 @PathVariable
                                                         String userName)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Question> thequestions = questionService.findByUserName(userName);
        return new ResponseEntity<>(thequestions, HttpStatus.OK);
    }


    @PostMapping(value = "/question")
    public ResponseEntity<?> addNewquestion(HttpServletRequest request, @Valid
    @RequestBody
            Question newquestion) throws URISyntaxException
    {
        logger.trace(request.getRequestURI() + " accessed");

        newquestion = questionService.save(newquestion);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newquestionURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionid}").buildAndExpand(newquestion.getQuestionsid()).toUri();
        responseHeaders.setLocation(newquestionURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping("/question/{id}")
    public ResponseEntity<?> deletequestionById(HttpServletRequest request,
                                             @PathVariable
                                                     long id)
    {
        logger.trace(request.getRequestURI() + " accessed");

        questionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.models.Type;
import com.lambdaschool.starthere.services.TypeService;
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
@RequestMapping("/types")
public class TypesController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);
    @Autowired
    TypeService typeService;

    @GetMapping(value = "/types",
            produces = {"application/json"})
    public ResponseEntity<?> listRoles(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Type> allTypes = typeService.findAll();
        return new ResponseEntity<>(allTypes, HttpStatus.OK);
    }


    @GetMapping(value = "/type/{typeId}",
            produces = {"application/json"})
    public ResponseEntity<?> getRole(HttpServletRequest request,
                                     @PathVariable
                                             Long typeId)
    {
        logger.trace(request.getRequestURI() + " accessed");

        Type t = typeService.findTypeById(typeId);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @PostMapping(value = "/type")
    public ResponseEntity<?> addNewType(HttpServletRequest request, @Valid
    @RequestBody
            Type newType) throws URISyntaxException
    {
        logger.trace(request.getRequestURI() + " accessed");

        newType = typeService.save(newType);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTypeURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{typeid}").buildAndExpand(newType.getTypeid()).toUri();
        responseHeaders.setLocation(newTypeURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping("/type/{id}")
    public ResponseEntity<?> deleteTypeById(HttpServletRequest request,
                                            @PathVariable
                                                    long id)
    {
        logger.trace(request.getRequestURI() + " accessed");

        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

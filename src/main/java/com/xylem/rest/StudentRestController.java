package com.xylem.rest;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xylem.domain.StudentService;
import com.xylem.dto.StudentWraper;

@RestController
public class StudentRestController {

    @Autowired
    StudentService service;

    @RequestMapping(value = "/rest/parseList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentWraper getStudentByRollNumber(@RequestBody StudentWraper wraper, @RequestParam String startRollNo, @RequestParam String endRollNo) {

        Objects.requireNonNull(wraper, "Input JSON Is Mandatory !!");
        Objects.requireNonNull(startRollNo, "Start RpllNumber is Required !!");
        Objects.requireNonNull(endRollNo, "End Roll Number Is Required !!");

        return service.getStudentsByRollNumber(wraper, startRollNo, endRollNo);
    }

}

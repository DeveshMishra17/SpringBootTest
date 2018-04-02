package com.xylem.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xylem.dto.StudentDTO;
import com.xylem.dto.StudentWraper;
import com.xylem.dto.Students;

@Component
public class StudentService {
    
    Logger logger=LoggerFactory.getLogger(StudentService.class);
    
    public StudentWraper getStudentsByRollNumber(StudentWraper wraper,String startRollNumber,String endRollNumber) {
        
        logger.info("In StudentService With Start Roll Number :{} And End Roll Number:{}",startRollNumber,endRollNumber);
      
        Students students=wraper.getStudents();
        Objects.requireNonNull(students,"Empty Student Body is Not Allowed!");
        
        List<StudentDTO> studentList=students.getStudent();
        
        if(studentList==null || studentList.isEmpty()) {
            logger.info("Empty Input Body List :{}",studentList); 
            return null;
        }
        
        logger.info("Input Body List :{}",studentList); 
        
     List<StudentDTO> filteredStudentList=   studentList
        .stream()
        .filter(student->Integer.parseInt(student.getRollNo().substring(1)) >= Integer.parseInt(startRollNumber.substring(1)))
        .filter(student->Integer.parseInt(student.getRollNo().substring(1)) <= Integer.parseInt(endRollNumber.substring(1)))
        .collect(Collectors.toList());
     
     logger.info("Filtered Student List :{}",filteredStudentList);
     
     StudentWraper wraperResponse=new StudentWraper();
     Students student=new Students();
     student.setStudent(filteredStudentList);
     wraperResponse.setStudents(student);
     
     return wraperResponse;
    }

}

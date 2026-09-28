package com.service;

import com.exception.EmptyListException;
import com.exception.InvalidInputException;

import java.util.List;
import java.util.stream.Collectors;

public class DemoService {

    public int sum(int x , int y){
        return x+y;
    }

    //compute Perecentage using marks

    public String computeGrade(List<Double> listMarks){

        //Focus on Validation - second
        if(listMarks == null){
            throw new NullPointerException("List Can't be NULL");
        }
        if(listMarks.isEmpty()){
            throw  new EmptyListException("List can't be Empty");
        }
        long incorrectValues = listMarks
                                    .stream()
                                    .filter(m -> m<0 || m > 100)
                                    .count();
        if(incorrectValues != 0){
            throw new InvalidInputException("The Marks should be btw 0 - 100");
        }


        //Focus on Funtionality - first

        double totalMarks = listMarks
                                .stream()
                                .mapToDouble(e -> e)
                                .sum();

        int noOfSubjects = listMarks.size();

        double percent = totalMarks / noOfSubjects;

        if(percent >=75)
            return "A";
        else if(percent >= 65)
            return "B";
        else return "C";


    }


}

package com.example.app_borrow_book.utils;

import org.aspectj.lang.JoinPoint;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFile {
    private static final String PATH_TO_ACTION = "D:\\C0123G1-MODULE-4\\ss9_aop\\bai_tap\\app_borrow_book\\src\\main\\java\\com\\example\\app_borrow_book\\log\\action_change_status_of_library.txt";
    private static final String PATH_FILE_TO_VISIT = "D:\\C0123G1-MODULE-4\\ss9_aop\\bai_tap\\app_borrow_book\\src\\main\\java\\com\\example\\app_borrow_book\\log\\file_to_visit.txt";

    public static void writeToFileOfActionChangeStatus(JoinPoint joinPoint) {
        File file = new File(PATH_TO_ACTION);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeToFileOfVisitPage(){
        int count=0;
        File file = new File(PATH_FILE_TO_VISIT);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        count++;
        try{
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(count);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

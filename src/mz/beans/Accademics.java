/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.beans;

/**
 *
 * @author Aman
 */
public class Accademics {

    private String degree;
    private String year;
    private String school_college;
    private String board_university;
    private String marks;
    private int academicId;

    public Accademics(String degree, String year, String school_College, String board_University, String marks) {
        this.degree = degree;
        this.year = year;
        this.school_college = school_College;
        this.board_university = board_University;
        this.marks = marks;
    }
     public Accademics(String degree, String year, String school_College, String board_University, String marks,int academicId) {
        this.degree = degree;
        this.year = year;
        this.school_college = school_College;
        this.board_university = board_University;
        this.marks = marks;
        this.academicId=academicId;
    }
    public Accademics( int academicId) {
       
        this.academicId=academicId;
    }
   
    public String getBoard_university() {
        return board_university;
    }

    public String getDegree() {
        return degree;
    }

    public String getMarks() {
        return marks;
    }

    public String getSchool_college() {
        return school_college;
    }

    public String getYear() {
        return year;
    }

    public void setBoard_university(String board_university) {
        this.board_university = board_university;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public void setSchool_college(String school_college) {
        this.school_college = school_college;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAcademicId() {
        return academicId;
    }

    public void setAcademicId(int academicId) {
        this.academicId = academicId;
    }

}

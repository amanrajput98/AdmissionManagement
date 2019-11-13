/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Aman
 */
public class Trainee {

    private int traineeId;
    private String traineeName;
    private String gender;
    private String dateOfBirth;
    private String traineePhoneNum;
    private String emailId;
    private String fatherName;
    private String fatherPhoneNum;
    private String fatherOccupation;
    private String permanentAddress;
    private String permanentCity;
    private String permanentPin;
    private String temporaryAddress;
    private String temporaryCity;
    private String temporaryPin;
    private int trainingId;
    private String trainingEnrolled;
    private String trainingDuration;
    private String trainingFee;
    private String trainingPaymentMode;
    private Date installmentDates;
    private String enrolledBy;
    private String enrolledDate;
    private List<Accademics> accademics;
    
    public Trainee(String traineeName, String gender, String dateOfBirth, String traineePhoneNum, String emailId, String fatherName,
            String fatherPhoneNum, String fatherOccupation, String permanentAddress, String permanentCity,
            String permanentPin, String temporaryAddress, String temporaryCity, String temporaryPin,List<Accademics> academics,int trainingId, String trainingEnrolled,
            String trainingDuration, String trainingFee, String trainingPaymentMode,int traineeId,String enrolledBy, String enrolledDate) {
        //Constructor to add
        this.traineeId = traineeId;
        this.traineeName = traineeName;
        this.gender = gender;        
        this.dateOfBirth = dateOfBirth;
        this.traineePhoneNum = traineePhoneNum;
        this.emailId = emailId;
        this.fatherName = fatherName;
        this.fatherPhoneNum = fatherPhoneNum;
        this.fatherOccupation = fatherOccupation;
        this.permanentAddress = permanentAddress;
        this.permanentCity = permanentCity;
        this.permanentPin = permanentPin;
        this.temporaryAddress = temporaryAddress;
        this.temporaryCity = temporaryCity;
        this.temporaryPin = temporaryPin;
        this.accademics=academics;
        this.trainingId = trainingId;
        this.trainingEnrolled = trainingEnrolled;
        this.trainingDuration = trainingDuration;
        this.trainingFee = trainingFee;
        this.trainingPaymentMode = trainingPaymentMode;
        this.enrolledBy=enrolledBy;
       // this.installmentDates = installmentDates;
        this.enrolledDate=enrolledDate;
    }
       public Trainee(String traineeName, int traineeId,String gender, String dateOfBirth, String traineePhoneNum, String emailId, String fatherName,
            String fatherPhoneNum, String fatherOccupation, String permanentAddress, String permanentCity,
            String permanentPin, String temporaryAddress, String temporaryCity, String temporaryPin, String enrolledDate,String trainingPaymentMode,
             String enrolledBy, String trainingEnrolled,String trainingDuration, String trainingFee) {
           //constructor to View
        this.traineeId = traineeId;
        this.traineeName = traineeName;
        this.gender = gender;        
        this.dateOfBirth = dateOfBirth;
        this.traineePhoneNum = traineePhoneNum;
        this.emailId = emailId;
        this.fatherName = fatherName;
        this.fatherPhoneNum = fatherPhoneNum;
        this.fatherOccupation = fatherOccupation;
        this.permanentAddress = permanentAddress;
        this.permanentCity = permanentCity;
        this.permanentPin = permanentPin;
        this.temporaryAddress = temporaryAddress;
        this.temporaryCity = temporaryCity;
        this.temporaryPin = temporaryPin;
        this.trainingEnrolled = trainingEnrolled;
        this.trainingDuration = trainingDuration;
        this.trainingFee = trainingFee;
        this.trainingPaymentMode = trainingPaymentMode;
        this.enrolledBy=enrolledBy;
       // this.installmentDates = installmentDates;
        this.enrolledDate=enrolledDate;
    }
        public Trainee(String traineeName, int traineeId,String gender, String dateOfBirth, String traineePhoneNum, String emailId, String fatherName,
            String fatherPhoneNum, String fatherOccupation, String permanentAddress, String permanentCity,
            String permanentPin, String temporaryAddress, String temporaryCity, String temporaryPin, List<Accademics> academics,String enrolledDate,String trainingPaymentMode,
             String enrolledBy, String trainingEnrolled,String trainingDuration, String trainingFee) {
     
        this.traineeId = traineeId;
        this.traineeName = traineeName;
        this.gender = gender;        
        this.dateOfBirth = dateOfBirth;
        this.traineePhoneNum = traineePhoneNum;
        this.emailId = emailId;
        this.fatherName = fatherName;
        this.fatherPhoneNum = fatherPhoneNum;
        this.fatherOccupation = fatherOccupation;
        this.permanentAddress = permanentAddress;
        this.permanentCity = permanentCity;
        this.permanentPin = permanentPin;
        this.temporaryAddress = temporaryAddress;
        this.temporaryCity = temporaryCity;
        this.temporaryPin = temporaryPin;
        this.accademics=academics;
        this.trainingEnrolled = trainingEnrolled;
        this.trainingDuration = trainingDuration;
        this.trainingFee = trainingFee;
        this.trainingPaymentMode = trainingPaymentMode;
        this.enrolledBy=enrolledBy;
        this.enrolledDate=enrolledDate;
    }
        
    public Trainee(int trainingId,String trainingDuration,String trainingFee,String installments ){
        this.trainingId=trainingId;
        this.trainingDuration=trainingDuration;
        this.trainingFee=trainingFee;
        this.trainingPaymentMode=installments;
    }
     public Trainee(int traineeId,String traineeName,String emailId,String phoneNum,String trainingName ){
        this.traineeId=traineeId;
        this.traineeName=traineeName;
        this.emailId=emailId;
        this.traineePhoneNum=phoneNum;
        this.trainingEnrolled=trainingName;
    }   
    public Trainee(int traineeId,String traineeName,String phoneNum,String emailId,String fatherName,String fatherPhoneNum,String trainingEnrolled){
       this.traineeId=traineeId;
       this.traineeName=traineeName;
       this.traineePhoneNum=phoneNum;
       this.emailId=emailId;
       this.fatherName=fatherName;
       this.fatherPhoneNum=fatherPhoneNum;
       this.trainingEnrolled=trainingEnrolled;               
    }
    public Trainee(List<Accademics> traineeTable){
        
    }
    public Trainee(String trainingEnrolled){
        this.trainingEnrolled=trainingEnrolled;
    }

    public Trainee(int traineeId) {
        this.traineeId=traineeId;
    }

    public void setAccademics(List<Accademics> accademics) {
        this.accademics = accademics;
    }

    public List<Accademics> getAccademics() {
        return accademics;
    }
    
    
    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public String getFatherPhoneNum() {
        return fatherPhoneNum;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getGender() {
        return gender;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public String getPermanentPin() {
        return permanentPin;
    }

    public String getTemporaryAddress() {
        return temporaryAddress;
    }

    public String getTemporaryCity() {
        return temporaryCity;
    }

    public String getTemporaryPin() {
        return temporaryPin;
    }

    public String getTraineePhoneNum() {
        return traineePhoneNum;
    }

    public int getTrainingsId() {
        return trainingId;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public void setFatherPhoneNum(String fatherPhoneNum) {
        this.fatherPhoneNum = fatherPhoneNum;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }

    public void setPermanentPin(String permanentPin) {
        this.permanentPin = permanentPin;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public void setTemporaryCity(String temporaryCity) {
        this.temporaryCity = temporaryCity;
    }

    public void setTemporaryPin(String temporaryPin) {
        this.temporaryPin = temporaryPin;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public void setTraineePhoneNum(String traineePhoneNum) {
        this.traineePhoneNum = traineePhoneNum;
    }

    public String getEnrolledBy() {
        return enrolledBy;
    }

    public String getEnrolledDate() {
        return enrolledDate;
    }

    public Date getInstallmentDates() {
        return installmentDates;
    }

    public String getTrainingDuration() {
        return trainingDuration;
    }

    public String getTrainingEnrolled() {
        return trainingEnrolled;
    }

    public String getTrainingFee() {
        return trainingFee;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public String getTrainingPaymentMode() {
        return trainingPaymentMode;
    }

    public void setEnrolledBy(String enrolledBy) {
        this.enrolledBy = enrolledBy;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public void setInstallmentDates(Date installmentDates) {
        this.installmentDates = installmentDates;
    }

    public void setTrainingDuration(String trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

    public void setTrainingEnrolled(String trainingEnrolled) {
        this.trainingEnrolled = trainingEnrolled;
    }

    public void setTrainingFee(String trainingFee) {
        this.trainingFee = trainingFee;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public void setTrainingPaymentMode(String trainingPaymentMode) {
        this.trainingPaymentMode = trainingPaymentMode;
    }

    public int getTraineeId() {
        return traineeId;
    }
    

}

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
public class Trainings {

    private int trainingId;
    private String trainingName;
    private String duration;
    private String fee;
    private String discription;
    private String installments;
    private int availInstallments;

    public Trainings(String trainingName, String duration,
            String fee, String discription, String installments, int availInstalments) {
        //this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.duration = duration;
        this.fee = fee;
        this.discription = discription;
        this.installments = installments;
        this.availInstallments = availInstalments;

    }

    public Trainings(int trainingId, String trainingName, String duration, String fee, String installments, int availInstallments) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.duration = duration;
        this.fee = fee;
        // this.discription = discription;
        this.installments = installments;
        this.availInstallments = availInstallments;
    }

    public Trainings(int trainingId) {
        this.trainingId = trainingId;
    }

    public Trainings(String trainingEnrolled) {
        this.trainingName = trainingEnrolled;
    }

    public Trainings(int trainingId, String trainingName, String trainingDuraion) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.duration = trainingDuraion;
    }

    public Trainings(int trainingId, String trainingName, String duration, String fee, String discription, String installments, int availInstallments) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.duration = duration;
        this.fee = fee;
        this.discription = discription;
        this.installments = installments;
        this.availInstallments = availInstallments;
    }

    public String getDiscription() {
        return discription;
    }

    public String getDuration() {
        return duration;
    }

    public String getFee() {
        return fee;
    }

    public String getInstallments() {
        return installments;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public int getAvailInstallments() {
        return availInstallments;
    }

    public void setAvailInstallments(int availInstallments) {
        this.availInstallments = availInstallments;
    }

}

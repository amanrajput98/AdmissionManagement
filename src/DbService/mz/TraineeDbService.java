/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbService.mz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mz.beans.Accademics;
import mz.beans.Trainee;

/**
 *
 * @author Aman
 */
public class TraineeDbService {

    private static Connection conn = null;

    public static void forConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmz", "root", "ajjumudit");
    }

    public static boolean addTrainee(Trainee trainee) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        Statement stmt = conn.createStatement();
        String sql = "insert into addmissionform(traineeName,gender,dob,phoneNumber,emailId,fathersName,fathersPhoneNumber,fatherOccupation,"
                + "permanentAddress,permanentAddressCity,permanentAddressPin,temporaryAddress,temporaryAddressCity,temporaryAddressPin,"
                + "enrolledDate,paymentMode,enrolledBy,trainingId,trainingEnrolled,trainingDuration,trainingFee)values"
                + "('" + trainee.getTraineeName() + "','" + trainee.getGender() + "','" + trainee.getDateOfBirth() + "',"
                + "'" + trainee.getTraineePhoneNum() + "','" + trainee.getEmailId() + "','" + trainee.getFatherName() + "','" + trainee.getFatherPhoneNum() + "'"
                + ",'" + trainee.getFatherOccupation() + "','" + trainee.getPermanentAddress() + "','" + trainee.getPermanentCity() + "','" + trainee.getPermanentPin() + "'"
                + ",'" + trainee.getTemporaryAddress() + "','" + trainee.getTemporaryCity() + "','" + trainee.getTemporaryPin() + "','" + trainee.getEnrolledDate() + "'"
                + ",'" + trainee.getTrainingPaymentMode() + "','" + trainee.getEnrolledBy() + "','" + trainee.getTrainingId() + "','" + trainee.getTrainingEnrolled() + "','" + trainee.getTrainingDuration() + "'"
                + ",'" + trainee.getTrainingFee() + "')";
        int val = stmt.executeUpdate(sql);
        int traineeId = getLastTraineeId();
        for (Accademics accademics : trainee.getAccademics()) {
            academicDetails(accademics);
            String sql2 = "insert into academicDetails (degree,year,school_college,board_university,marks,traineeId)values('" + accademics.getDegree() + "','" + accademics.getYear() + "','"
                    + accademics.getSchool_college() + "','" + accademics.getBoard_university() + "'," + accademics.getMarks() + "," + traineeId + ");";
            stmt.executeUpdate(sql2);
        }
        return val > 0;

    }

    public static int getLastTraineeId() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        int lastTraineeId = 0;
        Statement stmt = conn.createStatement();
        String sql = "select traineeId from addmissionform order by traineeId desc limit 1";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            lastTraineeId = rs.getInt("traineeId");
        }
        conn.close();
        return lastTraineeId;
    }

    public static Trainee viewTrainee(Trainee traineeToBeViewed) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // ArrayList<Trainee> viewTraineelist = new ArrayList<>();
        ArrayList<Accademics> academicsList = new ArrayList<>();
        forConnection();
        Trainee viewTrainee = null;
        Statement stmt = conn.createStatement();
        String query = "select * from addmissionform where traineeId=" + traineeToBeViewed.getTraineeId();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            String traineeName = rs.getString("traineeName");
            int traineeId = rs.getInt("traineeId");
            String gender = rs.getString("gender");
            String dateOFBirth = rs.getString("dob");
            String phoneNum = rs.getString("phoneNumber");
            String emailId = rs.getString("emailId");
            String fatherName = rs.getString("fathersName");
            String fatherPhoneNum = rs.getString("fathersPhoneNumber");
            String fatherOccupation = rs.getString("fatherOccupation");
            String permanentAddress = rs.getString("permanentAddress");
            String permanentAddressCity = rs.getString("permanentAddressCity");
            String permanentAddressPin = rs.getString("permanentAddressPin");
            String temporaryAddress = rs.getString("temporaryAddress");
            String temporaryAddressCity = rs.getString("temporaryAddressCity");
            String temporaryAddressPin = rs.getString("temporaryAddressPin");
            String enrolledDate = rs.getString("enrolledDate");
            String paymentMode = rs.getString("paymentMode");
            String enrolledBy = rs.getString("enrolledBy");
            String trainingEnrolled = rs.getString("trainingEnrolled");
            String trainingDuration = rs.getString("trainingDuration");
            String trainingFee = rs.getString("trainingFee");
            System.err.println("==="+traineeName);
            String academicQuery = "Select * from academicdetails where traineeId=" + traineeToBeViewed.getTraineeId() + " limit 5";
            rs = stmt.executeQuery(academicQuery);
            while (rs.next()) {
                String degree = rs.getString("degree");
                String year = rs.getString("year");
                String school_College = rs.getString("school_college");
                String board_University = rs.getString("board_University");
                String marks = rs.getString("marks");
                int academicId = rs.getInt("academicId");
                System.err.println(degree);
                System.err.println(year);
                System.err.println(school_College);
                System.err.println(academicId);
                
                Accademics viewAcademics = new Accademics(degree, year, school_College, board_University, marks, academicId);
                academicsList.add(viewAcademics);
            }
            List<Accademics> optList=academicsList;
            System.err.println(optList);
            viewTrainee = new Trainee(traineeName, traineeId, gender, dateOFBirth, phoneNum, emailId,
                    fatherName, fatherPhoneNum, fatherOccupation, permanentAddress, permanentAddressCity, permanentAddressPin,
                    temporaryAddress, temporaryAddressCity, temporaryAddressPin,academicsList, enrolledDate, paymentMode,
                    enrolledBy, trainingEnrolled, trainingDuration, trainingFee);

            //  viewTraineelist.add(viewTrainee);
        }

        return viewTrainee;
    }

    public static ArrayList<Accademics> viewAcademics(int viewIdAcademics) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        ArrayList<Accademics> academicsList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmz", "root", "ajjumudit");
        Statement stmt = conn.createStatement();
        String query = "Select * from academicdetails where traineeId=" + viewIdAcademics + " limit 5";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String degree = rs.getString("degree");
            String year = rs.getString("year");
            String school_College = rs.getString("school_college");
            String board_University = rs.getString("board_University");
            String marks = rs.getString("marks");
            int academicId = rs.getInt("academicId");

            Accademics viewAcademics = new Accademics(degree, year, school_College, board_University, marks, academicId);
            academicsList.add(viewAcademics);
        }
        conn.close();
        return academicsList;
    }

    public static ArrayList searchTrainee(Trainee traineeToBeSearched) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        ArrayList<Trainee> traineeList = new ArrayList<>();
        forConnection();
        Statement stmt = conn.createStatement();
        StringBuilder query = new StringBuilder("Select * from addmissionform where");
        Trainee toBeSearch = new Trainee(traineeToBeSearched.getTraineeId(), traineeToBeSearched.getTraineeName(), traineeToBeSearched.getEmailId(), traineeToBeSearched.getTraineePhoneNum(), traineeToBeSearched.getTrainingEnrolled());
        if (toBeSearch.getTraineeId() != 0) {
            query.append(" traineeId=").append(toBeSearch.getTraineeId()).append(" and");
        }
        if (!toBeSearch.getTraineeName().equals("")) {
            query.append(" traineeName='").append(toBeSearch.getTraineeName()).append("'").append(" and");
        }
        if (!toBeSearch.getEmailId().equals("")) {
            query.append(" emailId='").append(toBeSearch.getEmailId()).append("'").append(" and");
        }
        if (!toBeSearch.getTraineePhoneNum().equals("")) {
            query.append(" phoneNumber='").append(toBeSearch.getTraineePhoneNum()).append("'").append(" and");
        }
        if (!toBeSearch.getTrainingEnrolled().equals("")) {
            query.append(" trainingEnrolled='").append(toBeSearch.getTrainingEnrolled()).append("'").append(" and");
        }
        String newQuery = query.toString();
        String finalQuery = null;
        if (newQuery.endsWith(" and")) {
            finalQuery = newQuery.substring(0, newQuery.length() - 4);
        }
        if (newQuery.endsWith(" where")) {
            finalQuery = newQuery.replace(" where", ";");
        }
        ResultSet rs = stmt.executeQuery(finalQuery);
        Trainee trainee;
        while (rs.next()) {
            trainee = new Trainee(rs.getInt("traineeId"), rs.getString("traineeName"), rs.getString("phoneNumber"), rs.getString("emailId"), rs.getString("fathersName"), rs.getString("fathersPhoneNumber"), rs.getString("trainingEnrolled"));
            traineeList.add(trainee);
        }
        conn.close();
        return traineeList;
    }

    public static void academicDetails(Accademics traineeAccademics) {
        Object[] detail = {
            traineeAccademics.getDegree(),
            traineeAccademics.getYear(),
            traineeAccademics.getSchool_college(),
            traineeAccademics.getBoard_university(),
            traineeAccademics.getMarks()
        };
    }

    public static void updateTrainee(Trainee traineeToBeUpdated) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        Statement stmt = conn.createStatement();
        String query = "update addmissionform set traineeName='" + traineeToBeUpdated.getTraineeName() + "',traineeId=" + traineeToBeUpdated.getTraineeId() + ",gender='" + traineeToBeUpdated.getGender() + "',dob='"
                + traineeToBeUpdated.getDateOfBirth() + "',phoneNumber='" + traineeToBeUpdated.getTraineePhoneNum() + "',emailId='" + traineeToBeUpdated.getEmailId() + "',fathersName='" + traineeToBeUpdated.getFatherName()
                + "',fathersPhoneNumber='" + traineeToBeUpdated.getFatherPhoneNum() + "',fatherOccupation='" + traineeToBeUpdated.getFatherOccupation() + "',permanentAddress='" + traineeToBeUpdated.getPermanentAddress()
                + "',permanentAddressCity='" + traineeToBeUpdated.getPermanentCity() + "',permanentAddressPin='" + traineeToBeUpdated.getPermanentPin() + "',temporaryAddress='" + traineeToBeUpdated.getTemporaryAddress()
                + "',temporaryAddressCity='" + traineeToBeUpdated.getTemporaryCity() + "',temporaryAddressPin='" + traineeToBeUpdated.getTemporaryPin() + "',enrolledDate='" + traineeToBeUpdated.getEnrolledDate()
                + "',paymentMode='" + traineeToBeUpdated.getTrainingPaymentMode() + "',installmentDates='" + traineeToBeUpdated.getInstallmentDates() + "',enrolledBy='" + traineeToBeUpdated.getEnrolledBy() + "',trainingId='"
                + traineeToBeUpdated.getTrainingId() + "',trainingEnrolled='" + traineeToBeUpdated.getTrainingEnrolled() + "',trainingDuration='" + traineeToBeUpdated.getTrainingDuration() + "',trainingFee='"
                + traineeToBeUpdated.getTrainingFee() + "' where traineeId=" + traineeToBeUpdated.getTraineeId();
        stmt.executeUpdate(query);
       // List<Accademics> updateAcademicsList = traineeToBeUpdated.getAccademics();

        //int academicId=getUpdatedAcademicId(traineeToBeUpdated.getTraineeId());
//            academic.getAcademicId(
        //  System.out.println(updateAcademicsList.size());
        // for (Object academicId : getUpdatedAcademicId(traineeToBeUpdated.getTraineeId())) {
        for (Accademics academic : traineeToBeUpdated.getAccademics()) {
            String degree = academic.getDegree();
            String year = academic.getYear();
            String school_College = academic.getSchool_college();
            String boardUniversity = academic.getBoard_university();
            String marks = academic.getMarks();
            System.out.println(academic.getAcademicId());
            // System.err.println(traineeToBeUpdated.getTraineeId());
            String updateAcademicQuery = "update academicDetails set degree='" + degree + "',year='" + year + "',school_College='" + school_College + "',board_University='" + boardUniversity + "',marks='" + marks + "' where traineeId= "
                    + traineeToBeUpdated.getTraineeId() + " and academicId=" + academic.getAcademicId() + ";";
            System.err.println(updateAcademicQuery);
            stmt.executeUpdate(updateAcademicQuery);
            //    break;
        }
        //}
    }

    public static ArrayList getUpdatedAcademicId(int traineeAcademicToBeUpdated) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<Integer> academicList = new ArrayList<>();
        forConnection();
        Statement stmt = conn.createStatement();
        String query = "select academicId from academicDetails where traineeId=" + traineeAcademicToBeUpdated;
        //System.err.println(query);
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int academicId = rs.getInt("academicId");
            //    System.err.println(academicId);
            // Accademics academicToBeUpdated=new Accademics(academicId);
            academicList.add(academicId);
        }
        // System.err.println(academicId);
        return academicList;
    }

    public boolean deleteTrainee(Trainee traineeToBeDeleted) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        Statement stmt = conn.createStatement();
        String sql2 = "delete from academicDetails where traineeId=" + traineeToBeDeleted.getTraineeId();
        int val = stmt.executeUpdate(sql2);
        int val2 = stmt.executeUpdate("delete from addmissionform where traineeId=" + traineeToBeDeleted.getTraineeId());
        return val > 0 && val2 > 0;
    }
}

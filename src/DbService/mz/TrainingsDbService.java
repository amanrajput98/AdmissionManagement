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
import mz.beans.Trainee;
import mz.beans.Trainings;

/**
 *
 * @author Aman
 */
public class TrainingsDbService {

    public static Connection conn = null;

    public static void forConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmz", "root", "ajjumudit");

    }

    public static Boolean addTraining(Trainings training) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        Statement stmt = conn.createStatement();
        String sql = "insert into trainings(trainingEnrolled,trainingDuration,fee,discription,installments,availInstallments)values('" + training.getTrainingName() + "','" + training.getDuration()
                + "','" + training.getFee() + "','" + training.getDiscription() + "','" + training.getInstallments() + "','" + training.getAvailInstallments() + "')";
        int val = stmt.executeUpdate(sql);
        conn.close();
        return val > 0;
    }

    public static ArrayList<Trainings> viewTraining(int viewTrainingId) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        forConnection();
        ArrayList<Trainings> viewTraininglist = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "select * from trainings where trainingId=" + viewTrainingId;
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int trainingId = rs.getInt("trainingId");
            String trainingName = rs.getString("trainingenrolled");
            String trainingDuration = rs.getString("trainingDuration");
            String fee = rs.getString("fee");
            String description = rs.getString("discription");
            String installments = rs.getString("installments");
            int availIstallments = rs.getInt("availInstallments");
            Trainings training = new Trainings(trainingId, trainingName, trainingDuration, fee, description, installments, availIstallments);
            viewTraininglist.add(training);
        }
        conn.close();
        return viewTraininglist;
    }

    public static ArrayList<Trainings> searchTraining(Trainings trainingToBeSearched) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        ArrayList<Trainings> trainingsList = new ArrayList<>();
        Statement stmt = conn.createStatement();
        StringBuilder query = new StringBuilder("select * from trainings where");
        Trainings toBeSearch = new Trainings(trainingToBeSearched.getTrainingId(), trainingToBeSearched.getTrainingName(), trainingToBeSearched.getDuration());
        if (toBeSearch.getTrainingId() != 0) {
            query.append(" trainingId=").append(toBeSearch.getTrainingId()).append(" and");
        }
        if (!toBeSearch.getTrainingName().equals("")) {
            query.append(" trainingenrolled='").append(toBeSearch.getTrainingName()).append("'").append(" and");
        }
        if (!toBeSearch.getDuration().equals("")) {
            query.append(" trainingDuration='").append(toBeSearch.getDuration()).append("'").append(" and");
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
        Trainings training;
        while (rs.next()) {
            training = new Trainings(rs.getInt("trainingId"), rs.getString("trainingEnrolled"), rs.getString("trainingDuration"), rs.getString("Fee"), rs.getString("installments"), rs.getInt("availInstallments"));
            trainingsList.add(training);
        }
        conn.close();
        return trainingsList;
    }

    public boolean deleteTraining(Trainings trainingToBeDeleted) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        Statement stmt = conn.createStatement();
        int val = stmt.executeUpdate("delete from trainings where trainingId=" + trainingToBeDeleted.getTrainingId());
        conn.close();
        return val > 0;
    }

    public static ArrayList editTraining(Trainings trainingToBeEdited) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        forConnection();
        ArrayList<Trainings> editTraininglist = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "select * from trainings where trainingId=" + trainingToBeEdited.getTrainingId();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int trainingId = rs.getInt("trainingId");
            String trainingName = rs.getString("trainingenrolled");
            String trainingDuration = rs.getString("trainingDuration");
            String fee = rs.getString("fee");
            String description = rs.getString("discription");
            String installments = rs.getString("installments");
            int availIstallments = rs.getInt("availInstallments");
            Trainings training = new Trainings(trainingId, trainingName, trainingDuration, fee, description, installments, availIstallments);
            editTraininglist.add(training);
        }
        conn.close();
        return editTraininglist;
    }

    public static boolean updateTraining(Trainings trainingToBeUpdated) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        Statement stmt = conn.createStatement();
        String query = "update trainings set trainingId=" + trainingToBeUpdated.getTrainingId() + ",trainingenrolled='" + trainingToBeUpdated.getTrainingName() + "',trainingDuration='" + trainingToBeUpdated.getDuration()
                + "',fee='" + trainingToBeUpdated.getFee() + "',discription='" + trainingToBeUpdated.getDiscription() + "',installments='" + trainingToBeUpdated.getInstallments() + "',"
                + "availInstallments=" + trainingToBeUpdated.getAvailInstallments() + " where trainingId=" + trainingToBeUpdated.getTrainingId();
        int val = stmt.executeUpdate(query);
        return val > 0;
    }

    public static ArrayList getTrainings() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        ArrayList<Trainings> trainingList = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "select * from trainings";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String trainingName = rs.getString("trainingenrolled");
            Trainings trainingTobeSent = new Trainings(trainingName);
            trainingList.add(trainingTobeSent);
        }
        conn.close();
        return trainingList;
    }

    public static ArrayList getTrainingValues(Trainee valuesToBeSent) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        ArrayList<Trainee> trainingValuesList = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String query = "select * from trainings where trainingenrolled='" + valuesToBeSent.getTrainingEnrolled() + "';";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int trainingId = rs.getInt("trainingId");
            String trainingDuration = rs.getString("trainingDuration");
            String fee = rs.getString("fee");
            String installments = rs.getString("installments");
            //int availIstallments = rs.getInt("availInstallments");
            Trainee trainingTobeSent = new Trainee(trainingId, trainingDuration, fee, installments);
            trainingValuesList.add(trainingTobeSent);
        }
        conn.close();
        return trainingValuesList;
    }

    public static int getTrainingId(Trainings name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        Statement stmt = conn.createStatement();
        String query = "select trainingId from trainings where trainingenrolled='" + name.getTrainingName() + "'";
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int trainingIdToBeSent = rs.getInt("trainingId");
        return trainingIdToBeSent;
    }

    public static int getLastTrainingId() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        forConnection();
        int lastTrainingId = 0;
        Statement stmt = conn.createStatement();
        String sql = "select trainingId from trainings order by trainingId desc limit 1";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            lastTrainingId = rs.getInt("trainingId");
        }
        conn.close();
        return lastTrainingId;
    }
}

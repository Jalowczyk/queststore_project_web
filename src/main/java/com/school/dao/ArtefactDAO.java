package com.school.dao;

import com.school.models.Artifact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtefactDAO extends  DBConnection{

    private static String table_name = "artefacts";
//    ArrayList<Artifact> artefacts = new ArrayList<>();

    public ArtefactDAO(){

        super(table_name);

    }

    public Artifact getArtefactById(Integer id) {

        Artifact artifact = null;

        String query = "SELECT * FROM artifacts WHERE artifact_id = " + id + ";";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if(rs.next()){
                artifact = createArtefactsFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            return artifact;
        }
    }

    public static Artifact createArtefactsFromResultSet(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("artifact_id");
        String title = rs.getString("title");
        Integer price = rs.getInt("price");
        String category = rs.getString("category");


        Artifact artifact = new Artifact(title, price, category);


        return artifact;
    }


}

package com.school.dao;


import com.school.models.Quest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestDAO extends DBConnection {

    private static final String tableName = "quests";

    public QuestDAO() {

        super(tableName);
    }

    public static Quest createQuestFromDatabase(Integer id) {

        Quest course = null;

        String query = "SELECT * FROM quests WHERE id_ = " + id + ";";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                course = createQuestFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }


    public static Quest createQuestFromResultSet(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("id");
        String title = rs.getString("title");
        String info = rs.getString("info");
        Integer prize = rs.getInt("prize");
        String category = rs.getString("quest_category");

        Quest quest = new Quest(title, info, prize, category);
        quest.setId(id);

        return quest;
    }

    public void saveQuest(Quest quest) {

        String query = "INSERT INTO quests (title, info, prize, quest_category) VALUES(?,?,?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, quest.getTitle());
            statement.setString(2, quest.getInfo());
            statement.setInt(3, quest.getPrize());
            statement.setString(4, quest.getCategory());

            statement.executeUpdate();
            System.out.println("Saved");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


package com.day5proj1phase2.dao;

import java.util.*;
import com.day5proj1phase2.models.Bug;
import com.day5proj1phase2.utils.DBUtil;
import java.sql.*;

public class BugDAO {

    public void insertBug(Bug bug) {
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con
                    .prepareStatement("INSERT INTO bugtable (title,description,status) VALUES (?,?,?)");
            ps.setString(1, bug.getTitle());
            ps.setString(2, bug.getDescription());
            ps.setString(3, bug.getStatus());
            ps.executeUpdate();
            System.out.println("Bug inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Bug> getAllBugs() {
        List<Bug> list = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bugtable");
            while (rs.next()) {
                Bug b = new Bug();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setDescription(rs.getString("description"));
                b.setStatus(rs.getString("status"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteBugById(int id) {
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM bugtable WHERE id=?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Bug deleted successfully!");
            else
                System.out.println("Bug not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBugStatus(int id, String newStatus) {
        Connection con = DBUtil.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE bugtable SET status=? WHERE id=?");
            ps.setString(1, newStatus);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Bug status updated successfully!");
            else
                System.out.println("Bug not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

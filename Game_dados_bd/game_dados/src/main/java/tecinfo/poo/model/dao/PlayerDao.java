package tecinfo.poo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tecinfo.poo.model.Player;

public class PlayerDao implements Dao<Player> {

    @Override
    public Player get(String name) {
        Player player = null;
        String sql = "select * from datatb where name = ?"; // ? is a parameters for the prepared statement
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null; //stores the query result

        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            // sending the parameter to sql execution
            preparedStatement.setString(1, name); // id is an object, not primitive (intValue required)
            resultSet = preparedStatement.executeQuery();
            // iterates the resultSet and stores in the object the column values from the database
            while (resultSet.next()){
                player = new Player(resultSet.getString("name"), resultSet.getInt("wins"), 0);
                player.setId(resultSet.getInt("id")); // "id" is the column at postgres
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return player;
    }

    @Override
    public List<Player> getAll() { //listAll (if the database is huge, consider the use of pagination)
        List<Player> players = new ArrayList<Player>();
        String sql = "select * from datatb"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null; //stores the query result

        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            // iterates the resultSet and stores in the object the column values from the database
            while (resultSet.next()){
                Player player = new Player(resultSet.getString("name"), resultSet.getInt("wins"), 0);
                player.setId(resultSet.getInt("id")); // "id" is the column at postgres


                players.add(player); //add the object filled with database data to products list
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return players;
    }

    @Override
    public int save(Player player) {
        String sql = "insert into datatb (name, wins)" + " values (?, ?)"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, player.getName());
            preparedStatement.setInt(2, player.getWins());
            
            preparedStatement.execute(); //it is not a query. It is an insert command
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return 1;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public boolean update(Player player) {
        String sql = "update datatb set wins = ? where id = ?"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, player.getWins());
            preparedStatement.setInt(2, player.getId());
            
            preparedStatement.execute(); //it is not a query. It is an insert command
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Player player) {
        String sql = "delete from datatb where id = ?"; 
        Connection conn = null;
        // prepares a query
        PreparedStatement preparedStatement = null;
        
        try {
            conn = DBConnection.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setLong(1, player.getId());
            
            preparedStatement.execute(); //it is not a query. It is an insert command
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // close all connections
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
                return true;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    
    
}
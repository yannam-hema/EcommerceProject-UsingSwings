package DBVersion1;


import java.sql.*;

/**
 * Handles customer database operations
 */
public class CustomerDAO {
    
    /**
     * Save customer and return customer_id
     */
    public static int saveCustomer(String name, String email, String contact) {
        String sql = "INSERT INTO customers (name, email, contact) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, contact);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int customerId = rs.getInt(1);
                    System.out.println("✅ Customer saved! ID: " + customerId);
                    return customerId;
                }
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error saving customer:");
            e.printStackTrace();
        }
        
        return -1;
    }
}
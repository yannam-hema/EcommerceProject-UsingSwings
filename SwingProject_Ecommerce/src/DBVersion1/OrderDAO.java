package DBVersion1;


import java.sql.*;

/**
 * Handles order database operations
 */
public class OrderDAO {
    
    /**
     * Save order to database
     */
    public static boolean saveOrder(int customerId, int totalAmount) {
        String sql = "INSERT INTO orders (customer_id, total_amount) VALUES (?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, customerId);
            pstmt.setInt(2, totalAmount);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("✅ Order saved successfully!");
                return true;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error saving order:");
            e.printStackTrace();
        }
        
        return false;
    }
}
import java.sql.*;

public class JdbcJoinDemo {
    static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/iot_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
        String user = "root";
        String password = "123456";

        try(Connection conn = DriverManager.getConnection(url,user,password)){
            System.out.println("成功连接到数据库！");
            String sql = "select d.device_name, d.status, u.username " +
                    "from device d inner join user u on d.user_id = u.id;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String deviceName = rs.getString("device_name");
                int status = rs.getInt("status");
                String username = rs.getString("username");
                System.out.println(deviceName + " " + status + " " + username);
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错了！");
            e.printStackTrace();
        }
    }
}

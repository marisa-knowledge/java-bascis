import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) {
        // 1. 数据库的账号密码配置
        // 注意：如果是 MySQL 8.0 以上，URL 后面必须加上时区和关闭 SSL 的配置
        String url = "jdbc:mysql://localhost:3306/iot_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
        String user = "root";
        String password = "123456"; // ⚠️ 这里改成你自己的密码！

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 2. 加载驱动（Java 8 以后其实可以省略，但这行写了更稳）
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. 获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("成功连接到数据库！");

            // 4. 创建执行对象
            stmt = conn.createStatement();

            // 5. 执行查询 SQL
            String sql = "SELECT * FROM device";
            rs = stmt.executeQuery(sql); // executeQuery 专门用来执行查询，返回结果集

            // 6. 遍历结果集（就像之前遍历集合一样）
            System.out.println("--- 设备列表 ---");
            while (rs.next()) { // 如果还有下一行数据，就继续循环
                int id = rs.getInt("id"); // 根据列名获取数据
                String name = rs.getString("device_name");
                int status = rs.getInt("status");
                // 时间字段先不管，打印 id、名字、状态
                System.out.println("编号：" + id + "，设备名：" + name + "，状态：" + status);
            }

        } catch (Exception e) {
            System.out.println("数据库操作出错了！");
            e.printStackTrace();
        } finally {
            // 7. 释放资源（先开后关，逆序关闭）
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
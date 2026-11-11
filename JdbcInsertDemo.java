import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcInsertDemo {
    public static void main(String[] args) {
        // 数据库连接三件套
        String url = "jdbc:mysql://localhost:3306/iot_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
        String user = "root";
        String password = "123456"; // ⚠️ 改成你自己的

        // 使用 try-with-resources 自动关闭连接
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("成功连接到数据库！\n");

            // ================= 1. 修改数据 (UPDATE) =================
            // 目标：把 "智能空调" 的状态修改为 0 (离线)
            // SQL 语句：把具体的值换成 ?
            String updateSql = "UPDATE device SET status = ? WHERE device_name = ?";

            // 获取预编译对象
            PreparedStatement updatePstmt = conn.prepareStatement(updateSql);

            // 填坑：问号从 1 开始数
            updatePstmt.setInt(1, 0);             // 第一个 ? 填 0
            updatePstmt.setString(2, "智能空调"); // 第二个 ? 填名字

            // 执行更新，返回受影响的行数
            int updateRows = updatePstmt.executeUpdate();
            System.out.println("修改操作完成！受影响的行数：" + updateRows);
            updatePstmt.close();


            // ================= 2. 删除数据 (DELETE) =================
            // 目标：把 "智能门锁" 删掉
            // SQL 语句：DELETE FROM 表名 WHERE 字段 = ?
            String deleteSql = "DELETE FROM device WHERE device_name = ?";

            PreparedStatement deletePstmt = conn.prepareStatement(deleteSql);

            // 填坑：只有一个问号
            deletePstmt.setString(1, "智能门锁");

            // 执行删除
            int deleteRows = deletePstmt.executeUpdate();
            System.out.println("删除操作完成！受影响的行数：" + deleteRows);
            deletePstmt.close();

        } catch (Exception e) {
            System.out.println("操作出错了！");
            e.printStackTrace();
        }
    }
}
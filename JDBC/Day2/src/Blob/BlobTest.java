package Blob;

import Bean.Customers;
import org.junit.jupiter.api.Test;
import util.JDBCUtil;

import java.io.*;
import java.nio.Buffer;
import java.sql.*;

/**
 * 使用prepareStatement操作Blob类型的数据
 *
 * @author zzq
 * @creat 2020-07-24 10:23
 */
public class BlobTest {
    //像customers表中插入Blob类型的字段
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into customers(`name`,email,birth,photo) value(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, "大菊");
            preparedStatement.setObject(2, "Daju@126.com");
            preparedStatement.setObject(3, "1999-01-10");
            FileInputStream fileInputStream = new FileInputStream(new File("girl2.jpg"));
            preparedStatement.setBlob(4, fileInputStream);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection, preparedStatement);
        }
    }


    //查询customers表中Blob类型的字段
    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        InputStream binaryStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id= ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 21);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //            方式一：
                //            int id = resultSet.getInt(1);
                //            String name = resultSet.getString(2);
                //            String email = resultSet.getString(3);
                //            Date birth = resultSet.getDate(4);

                //方式二：
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");
                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);
                //将Blob类型的字段下载并保存
                Blob photo = resultSet.getBlob("photo");
                binaryStream = photo.getBinaryStream();
                fileOutputStream = new FileOutputStream("xiaoju.jpg");
                byte[] bytes = new byte[1024];
                int len;
                while ((len = binaryStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (binaryStream != null)
                    binaryStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtil.closeConnection(connection, preparedStatement, resultSet);
        }

    }
}

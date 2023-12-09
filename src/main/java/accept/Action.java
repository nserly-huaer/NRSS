package accept;

import java.sql.*;
import java.util.*;

public class Action {
    private String password;
    //    private final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=NSERLY\\SQLEXPRESS"
//            + "integratedSecurity=true;" + "encrypt=true;trustServerCertificate=true";
    private final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Users;"
            + "integratedSecurity=true;" + "encrypt=true;trustServerCertificate=true";
    private String username;
    public Connection conn;

    public Action(String username, String password) throws SQLException, ClassNotFoundException {
        this.username = username;
        this.password = password;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(dbURL, username, password);
    }

    public String[] SelectAll(String tableName, String where) throws SQLException {
        List<String> resultList = new ArrayList<>();
        ResultSetMetaData rsmd = null;
        Statement sqlStatement = conn.createStatement();//创建sql语句
        String sql = "select * from " + tableName + " " + where;
        ResultSet rs = sqlStatement.executeQuery(sql);//执行sql语句
        //下面根据该table输出属性组和所有元组
        rsmd = rs.getMetaData();//获取属性名
        String[] arr = new String[0];
        if (rsmd != null) {
            int count = rsmd.getColumnCount();//统计属性个数
            while (rs.next()) {
                StringBuilder row = new StringBuilder();
                for (int i = 1; i <= count; i++) {
                    row.append(rsmd.getColumnName(i)).append(" ");
                    if (rsmd.getColumnType(i) == Types.ARRAY) {
                        Array array = rs.getArray(i);
                        if (array != null) {
                            Object[] values = (Object[]) array.getArray();
                            for (Object value : values) {
                                row.append(value).append(" ");
                            }
                        }
                    } else {
                        row.append(rs.getString(i)).append(" ");
                    }
                }
                resultList.add(row.toString());
            }
        }
        //返回结果
        return resultList.toArray(new String[0]);
    }

    public boolean AddValue(String tableName, String[] values) throws SQLException {
        ResultSetMetaData rsmd = null;
        StringBuilder s1 = new StringBuilder();//创建字符串对象
        Statement sqlStatement = conn.createStatement();//创建语句对象
        String sql = "select * from " + tableName;
        ResultSet rs = sqlStatement.executeQuery(sql);//执行sql语句
        //下面根据该table输出属性组
        rsmd = rs.getMetaData();//获取属性名
        if (rsmd != null) {
            int count = rsmd.getColumnCount();//统计属性个数
            for (int i = 1; i <= count; i++) {
                if (i < count) {
                    //输出属性名
                    System.out.print(rsmd.getColumnName(i) + "[" + rsmd.getColumnTypeName(i) + "(" + rsmd.getColumnDisplaySize(i) + ")],");
                } else
                    System.out.print(rsmd.getColumnName(i) + "[" + rsmd.getColumnTypeName(i) + "(" + rsmd.getColumnDisplaySize(i) + ")]");
            }
        }
        //输入需要添加的值用英文逗号分隔
        for (int i = 0; i < values.length; i++) {
            //把每个分量按SQL格式依次输入到对象s1中
            s1.append("'").append(values[i]).append(i < values.length - 1 ? "', " : "'");
        }
        String insertSql = "insert into " + tableName + " values(" + s1 + ")";
        return sqlStatement.executeUpdate(insertSql) > 0;
    }

    public boolean ModifyValue(String tableName, String filterColumn, String filterValue, String modifyColumn, String modifyValue) throws SQLException {
        ResultSetMetaData rsmd = null;
        Statement sqlStatement = conn.createStatement();//创建sql语句
        String sql = "select * from " + tableName;
        ResultSet rs = sqlStatement.executeQuery(sql);//执行sql语句
        //下面根据该table输出属性组
        rsmd = rs.getMetaData();//获取属性名
        Map map = new HashMap();
        if (rsmd != null) {
            int count = rsmd.getColumnCount();//统计属性个数
            for (int i = 1; i <= count; i++) {
                map.put(i, rsmd.getColumnName(i));
//                System.out.print("[" + i + ": " + rsmd.getColumnName(i) + "]");//输出属性名
            }
        }
        if (rsmd != null) {//输出属性名
            int count = rsmd.getColumnCount();
            for (int i = 1; i <= count; i++) {
                System.out.print("[" + i + ": " + rsmd.getColumnName(i) + "]");
            }
        }
        String modifySql = "update " + tableName + " set " + modifyColumn + "='" + modifyValue + "' where " + filterColumn + "='" + filterValue + "'";
        return sqlStatement.executeUpdate(modifySql) > 0;
    }

    public boolean DeleteValue(String tableName, String filterColumn, String filterValue) throws SQLException {
        //选择列名，询问是否删除以下数据，选择Y删除。
        ResultSetMetaData rsmd = null;
        Statement sqlStatement = conn.createStatement();//创建sql语句
        String sql = "select * from " + tableName;
        ResultSet rs = sqlStatement.executeQuery(sql);//执行sql语句
        //下面根据该table输出属性组
        rsmd = rs.getMetaData();//获取属性名
        Map map = new HashMap();
        if (rsmd != null) {//输出属性名
            int count = rsmd.getColumnCount();
            for (int i = 1; i <= count; i++) {
                map.put(i, rsmd.getColumnName(i));
//                System.out.print("[" + i + ": " + rsmd.getColumnName(i) + "]");
            }
        }
        String deleteSql = "delete from " + tableName + " where " + filterColumn + "='" + filterValue + "'";
        System.out.println("Execute Successful !");
        return sqlStatement.executeUpdate(deleteSql) > 0;
    }
}
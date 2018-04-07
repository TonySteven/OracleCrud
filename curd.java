package com.svse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class curd {
    private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String username = "steven";
    private static final String password = "123";

    //提前加载oracle数据库驱动
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //主程序
    public static void main(String[] args) {
        System.out.println("start");
        curd.Retrieve();
        curd.Update();
        System.out.println("after change");
        curd.Retrieve();
        System.out.println("stop");

    }

    //取得数据库链接
    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 查看
     */
    private static void Retrieve() {
        Connection con = curd.getConn();
        Statement st = null;
        ResultSet rs = null;
        try {

            //获取执行sql语句的平台
            st = con.createStatement();
            //执行sql语句获取结果集
            rs = st.executeQuery("select * from dept");
            //循环获取结果集数据
            while (rs.next()) {
                System.out.println(rs.getString("deptno") + "\t\t" + rs.getString("dname") + "\t\t" + rs.getString("loc"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭rs
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //关闭st
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //关闭con
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 添加部门
     */
    private static void Create() {
        Connection con = curd.getConn();
        Statement st = null;
        try {
            //获取执行sql语句的平台
            st = con.createStatement();
            //执行sql语句插入数据
            st.executeUpdate("insert into dept values(40,'研发69部','软件新区 1069')");


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭st
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //关闭con
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 修改部门
     */
    private static void Update() {
        Connection con = curd.getConn();
        Statement st = null;
        try {
            //获取执行sql语句的平台
            st = con.createStatement();
            //执行sql语句修改部门编号为40的部门
            st.executeUpdate("update dept set dname='研发40部',loc='软件新区 1040' where deptno=40");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭st
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //关闭con
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除部门
     */
    private static void Delete() {
        Connection con = curd.getConn();
        Statement st = null;
        try {
            //获取执行sql语句的平台
            st = con.createStatement();
            //执行sql语句删除部门编号为40的部门
            st.executeUpdate("delete dept where deptno=40");
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //关闭st
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //关闭con
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

package SAMPLE_COMP.COMP_NAME.utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Util {
    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;


    public static void createConnection(String url , String username, String password){
        try {
            con= DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (Exception e){
            System.out.println("CONNECTION HAS FAILED" + e.getMessage());
        }

    }
    public static void createConnection(){
        String url= Environment.DB_URL ;
        String username= Environment.DB_USERNAME ;
        String password= Environment.DB_PASSWORD  ;

        createConnection(url, username, password);
    }

    public static ResultSet runQuery(String sql){
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            rsmd = rs.getMetaData();
        }catch(Exception e){
            System.out.println("ERROR OCCURRED WHILE RUNNING QUERY"+ e.getMessage());
        }
        return rs ;
    }

    public static List<String> getColumnDataAsList(String columnName){
        List<String> columnDataLst = new ArrayList<>();
        try {
            rs.beforeFirst();
            while( rs.next() ){
                String cellValue = rs.getString(columnName) ;
                columnDataLst.add(cellValue) ;
            }
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getColumnDataAsList " + e.getMessage());
        }finally {
            resetCursor();
        }
        return columnDataLst;
    }
    public static void resetCursor(){
        try {
            rs.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getAllColumnNamesAsList()  {

        List<String> columnNameLst = new ArrayList<>();
        int columnNumber= 0;
        try {
            columnNumber = rsmd.getColumnCount();
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE getColumnNumber");
        }
        try {
            for (int colIndex = 1; colIndex <= columnNumber ; colIndex++) {
                String columnName =  rsmd.getColumnName(colIndex) ;
                columnNameLst.add(columnName) ;
            }
        }catch (Exception e){
            System.out.println("ERROR OCCURRED WHILE getAllColumnNamesAsList "+ e.getMessage());
        }
        return columnNameLst ;
    }
    public static void destroy(){
        try {
            if( rs!=null)  rs.close();
            if( stm!=null)  stm.close();
            if( con!=null)  con.close();
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE CLOSING RESOURCES " + e.getMessage());
        }
    }
}

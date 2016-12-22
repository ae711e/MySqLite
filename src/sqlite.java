/*
 * (C) 2016, Алексей Еремин
 * Проба работы с SqLite
 *  
 */
import java.sql.*;
import org.sqlite.*;

public class sqlite {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		//
		Connection bd=DriverManager.getConnection("jdbc:sqlite:mysqlite.db");
		Statement st=bd.createStatement();
		st.execute("CREATE TABLE if not exists Table1(name1 int, name2 text, name3 text);");
		ResultSet rs1=st.executeQuery("SELECT COUNT(*) FROM Table1;");
		// возьмем кол-во строк
		int cnt=0;
		while(rs1.next()){
			cnt=rs1.getInt(1);
		}
		rs1.close();
		cnt=cnt+1;   // увеличим на 1		
		st.execute("INSERT INTO Table1(name1,name2,name3) VALUES ("+cnt+",'nam1','" + Math.random() + "');");
				
		ResultSet rs=st.executeQuery("SELECT * FROM Table1;");
		while(rs.next()) {
			System.out.print(rs.getString("name1")+ " ");
			System.out.print(rs.getString("name2")+ " ");
			System.out.println(rs.getString("name3")+ " ");			
		
		}
		rs.close();
		st.close();
		bd.close();
	}

}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	// Singleton pattern
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConn() throws Exception {
		
		Context initCtx = new InitialContext();
		// searches java environment code in server.xml through lookup method
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		// in server.xml, search if the name of <Resource> inside <Context> tag is jdbc/pool
		DataSource ds = (DataSource)envCtx.lookup("jdbc/pool");
		conn = ds.getConnection();
		
		return conn;
	}
	
	// 1. check ID duplication 
	//    check = 1  ==> duplicate X 
	// 	  check = -1 ==> duplicate O 
	public int checkId(String id) {
		int check = 1;
		try {
			conn = getConn();
			
			String sql = "select * from user where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			
			// this method is used when signing up, so
			// if there is even one id that is the same, it is duplicate 
			if (rs.next()) {
				check = -1;
			}
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
        }
		return check;
		
	}
	
	// 2. Join
	//    check = 1  ==> Sign Up O
	// 	  check = -1 ==> Sign Up X
	public int joinMember(MemberBean bean) {
		int check = 1;
		try {
			check = checkId(bean.getId());
			
			conn = getConn();
			
			if (check == 1) { //when id is not duplicate
				String sql = "insert into user(id,pw,name,tel,email) "
						+ "values(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bean.getId());
				pstmt.setString(2, bean.getPw());
				pstmt.setString(3, bean.getName());
				pstmt.setString(4, bean.getTel());
				pstmt.setString(5, bean.getEmail());
				pstmt.executeUpdate();
			}
		}catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        }
		return check;
	}
	
	// 3. Login
	//    check = 1  ==> login success
	//    check = -1 ==> login fail
	public int loginCheck(String id, String pw) {
		int check = -1;
		try {
			conn = getConn();
			
			String sql = "select pw from user where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbPw = rs.getString("pw");
				if (dbPw.equals(pw)) {
					check = 1;
				}
			}
		}catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
        }
        return check;
	}
	
	// 4. check if the logged in person is admin
    public int adminCheck(String id, String pw) {
    	int admin = -1;
    	try {
    		 conn = getConn();
    		 if (id.equals("admin")) {
    			 String sql = "select pw from user where id=?";
        		 pstmt = conn.prepareStatement(sql);
        		 pstmt.setString(1,  id);
        		 rs = pstmt.executeQuery();
        		 if (rs.next()) {
        			 String dbPw = rs.getString("pw");
        			 if (dbPw.equals("admin") && dbPw.equals(pw)) {
        				 admin = 1;
        			 }
        		 }
    		 }
    		
    	}catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
        }
        return admin;
    }
	
	// 5. One member's info
	public MemberBean getOneMember(String id) {
		MemberBean bean = null;
		try {
			conn = getConn();
			
			String sql = "select * from user where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String pw = rs.getString("pw");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String field = rs.getString("field");
                String skill = rs.getString("skill");
                String major = rs.getString("major");
 
                bean = new MemberBean(id, pw, name, tel, email, field, skill, major);
			}
		}catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}            
        }
        return bean;
	}
	
	// 6. get all the members
    public Vector<MemberBean> getAllMember(){
    	Vector<MemberBean> v = new Vector<>();
		
		MemberBean bean = null;
		
		try {
			conn = getConn();
			
			String sql = "SELECT * FROM user where id!='admin'";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String field = rs.getString("field");
                String skill = rs.getString("skill");
                String major = rs.getString("major");
                
                bean = new MemberBean(id, pw, name, tel, email, field, skill, major);
				
				v.add(bean);
			}
		} catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}            
        }
		return v;
    }
	
	// 7. Update
	public void updateMember(String id, MemberBean bean) {
		try {
			conn = getConn();
			
			String sql = "update user set pw=?, name=?, tel=?, email=? "
					+ "field=?, skill=?, major=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getPw());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getTel());
            pstmt.setString(4, bean.getEmail());
            pstmt.setString(5, bean.getField());
            pstmt.setString(6, bean.getSkill());
            pstmt.setString(7, bean.getMajor());
            pstmt.setString(8, id);
            pstmt.executeUpdate();
		}catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        }
	}
	
	// 8. Apply
	public void apply(String id, String field, String skill, String major) {
		try {
			
			conn = getConn();
			
			String sql ="update user set field=?, skill=?, major=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, field);
			pstmt.setString(2, skill);
			pstmt.setString(3, major);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        }
	}
	
	// 9. Delete
    public void delete(String id) {
    	
    	try {
    		conn = getConn();
    		
    		String sql = "DELETE FROM user WHERE id=?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
    		pstmt.executeUpdate();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		if(conn != null) {try {conn.close();} catch (SQLException e) {}}
    		if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
    	}
    }
	
}

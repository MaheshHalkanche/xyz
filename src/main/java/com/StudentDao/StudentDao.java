package com.StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;    

import com.beans.Student;

public class StudentDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Student s){    
	    String sql="insert into students(name,address,contact_no,gender,email,dateofbirth,cource) values('"+s.getName()+"','"+s.getAddress()+"','"+s.getContact_no()+"','"+s.getGender()+"','"+s.getEmail()+" ','"+s.getDateofbirth()+"','"+s.getCource()+"')";    
	    return template.update(sql);    
	}    
	public int editsave(Student s){    
	    String sql="update students set name='"+s.getName()+"', address='"+s.getAddress()+"',contact_no='"+s.getContact_no()+"',gender='"+s.getGender()+"',email='"+s.getEmail()+"',dateofbirth='"+s.getDateofbirth()+"',cource='"+s.getCource()+"' where id="+s.getId()+"";    
	    return template.update(sql);       
	}    
	public int delete(int id){    
	    String sql="delete from students where id="+id+"";    
	    return template.update(sql);    
	}    
	public Student getStudentById(int id){    
	    String sql="select * from students where id=?";
	    //return template.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<Student>());//removed argument	        
	return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Student>(Student.class));
	}  
	public List<Student> getStudents()
	{
		return template.query("select * from students", new org.springframework.jdbc.core.RowMapper<Student>()
				{
			public Student mapRow(ResultSet rs, int row) throws SQLException {    
	            Student s = new Student();    
	            s.setId(rs.getInt(1));    
	            s.setName(rs.getString(2));
	           // s.setEmail(rs.getString(3));
	            s.setAddress(rs.getString(3));
	            s.setContact_no(rs.getString(4));
	            s.setGender(rs.getString(5));
	            s.setEmail(rs.getString(6));
	            s.setDateofbirth(rs.getString(7));
	            s.setCource(rs.getString(8));
	            //s.setDateofbirth(rs.getString(7));
	            //s.setCource(rs.getString(8));

	                
	            return s;    
	        }    
	    });    
	}    
	}   












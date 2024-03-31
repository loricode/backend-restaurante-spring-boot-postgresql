package com.restaurante.repositories.menu;

import java.sql.CallableStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.restaurante.models.menu.Menu;
import com.restaurante.models.menu.MenuRequest;

@Repository
public class MenuRepository {

	 private final JdbcTemplate jdbcTemplate;
	    
     @Autowired
     public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;	     
     }
	    
	 public List<Menu> findAll() {
	    
		String sql = "select * from ft_get_menus()";
	        
	    return jdbcTemplate.query(sql, (rs, rowNum) ->
                     new Menu(
                    	   rs.getString("menu_id"),
                    	   rs.getString("menu_name"))
               );
            
	 }
	    
     public String addOne(MenuRequest mr) {
	    String sql = "select ft_add_menu(?) as menu_id";
	    
    	List<String> list = this.jdbcTemplate.query(
    			(conn) -> {
    				CallableStatement cs = conn.prepareCall(sql); 
    				cs.setString(1, mr.getMenuName());
    				return cs;
    			},
    			(rs, rowNum) -> rs.getString("menu_id"));
    	
    	
    	return list.get(0);
	      
	 }
	
}

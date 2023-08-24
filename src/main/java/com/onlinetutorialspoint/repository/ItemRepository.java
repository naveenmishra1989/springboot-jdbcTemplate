package com.onlinetutorialspoint.repository;

import com.onlinetutorialspoint.model.Item;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    final private JdbcTemplate template;

    public ItemRepository(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * Getting all Items from table
     * */
     public List<Item> getAllItems(){
        return template.query("select id, name,category from item",BeanPropertyRowMapper
                .newInstance(Item.class));
    }
    /**
     * Getting all Items Name from table
     * */
    public List<String> getAllItemsNames(){
        return template.query("select name from item", (resultSet,rowNum)-> resultSet.getString("name"));
    }
    /**
     * Getting a specific item by item id from table
     * */
    public Item getItem(int itemId){
        String query = "SELECT * FROM ITEM WHERE ID=?";
        return template.queryForObject(query,new Object[]{itemId},new BeanPropertyRowMapper<>(Item.class));
    }
    /**
     * Adding an item into database table
     * */
    public int addItem(int id,String name,String category){
        String query = "INSERT INTO ITEM VALUES(?,?,?)";
        return template.update(query,id,name,category);
    }
    /**
     * delete an item from database
     * */
    public int deleteItem(int id){
        String query = "DELETE FROM ITEM WHERE ID =?";
        return template.update(query,id);
    }
}

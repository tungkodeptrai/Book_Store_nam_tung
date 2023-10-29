/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import entity.Categories;
import java.util.List;

/**
 *
 * @author TNO
 */
public class CategoriesDAO extends GenericDAO<Categories>{

    @Override
    public List<Categories> findAll() {
        return queryGenericDAO(Categories.class);
    }

    
}

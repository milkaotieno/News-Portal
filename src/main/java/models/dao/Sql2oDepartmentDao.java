package models.dao;

//public class Sql2oDepartmentDao {
//}

import models.projos.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    public static void getDrivers(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDepartment(Department department) {
        getDrivers();
        String sql = "INSERT INTO departments (departmentName,departmentDescription,employees) VALUES (:departmentName,:departmentDescription,:employees)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        getDrivers();
        String sql = "SELECT * FROM departments";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department getDepartmentById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void deleteDepartmentById(int id) {
        getDrivers();
        String sql = "DELETE FROM departments WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllDepartments() {
        getDrivers();
        String sql = "DELETE FROM departments";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }
}

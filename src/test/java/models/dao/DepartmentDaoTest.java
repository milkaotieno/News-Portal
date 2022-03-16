package models.dao;

import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDaoTest extends Sql2oDepartmentDao {

    public DepartmentDaoTest(Sql2o sql2o) {
        super (sql2o);
    }
}
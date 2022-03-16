package models.dao;

import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest extends Sql2oDepartmentDao {

    public UserDaoTest(Sql2o sql2o) {
        super (sql2o);
    }
}
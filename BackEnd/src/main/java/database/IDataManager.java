package database;

import java.sql.SQLException;

public interface IDataManager {

    boolean saveObject(Object object);
    int getRowcount();

}

package database;

import Objects.Production;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class databaseManager implements IDataManager{
    //private IMapper iMapper;
    private PreparedStatement preparedStatement;
    private databaseConnector databaseConnector;

    private static databaseManager databaseManager;

    private databaseManager(){this.databaseConnector = database.databaseConnector.getInstance();}

    public static databaseManager getInstance() {
        if(databaseManager==null){
            databaseManager = new databaseManager();
        }
        return databaseManager;
    }

    @Override
    public boolean saveProduction(Object object) {
        try {
            if (object instanceof Production) {
                Production production = (Production) object;
                preparedStatement = databaseConnector.getConnection().prepareStatement("INSERT INTO productions(machine_id, beer_type, production_size, succeeded_count, failed_count) VALUES (?,?,?,?,?)");
                preparedStatement.setInt(1, production.getMachineId());
                preparedStatement.setInt(2, production.getBeerType());
                preparedStatement.setInt(3, production.getProductionSize());
                preparedStatement.setInt(4, production.getSucceededCount());
                preparedStatement.setInt(5, production.getFailedCount());
                preparedStatement.execute();
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

}

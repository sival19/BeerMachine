package database;

import Objects.Production;
import Objects.SensorData;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class databaseManager implements IDataManager{
    //private IMapper iMapper;
    private PreparedStatement preparedStatement;
    private databaseConnector databaseConnector;
    private int rowcount;

    private static databaseManager databaseManager;

    private databaseManager(){this.databaseConnector = database.databaseConnector.getInstance();}

    public static databaseManager getInstance() {
        if(databaseManager==null){
            databaseManager = new databaseManager();
        }
        return databaseManager;
    }

    @Override
    public boolean saveObject(Object object) {
        try {
            if (object instanceof Production) {
                Production production = (Production) object;
                preparedStatement = databaseConnector.getConnection().prepareStatement("INSERT INTO productions(machine_id, beer_type, production_size, succeeded_count, failed_count, created_at) VALUES (?,?,?,?,?,?)");
                preparedStatement.setInt(1, production.getMachineId());
                preparedStatement.setInt(2, production.getBeerType());
                preparedStatement.setInt(3, production.getProductionSize());
                preparedStatement.setInt(4, production.getSucceededCount());
                preparedStatement.setInt(5, production.getFailedCount());
                preparedStatement.setTimestamp(6, production.getTimestamp());
                preparedStatement.execute();
            }else if (object instanceof SensorData){
                SensorData sensorData = (SensorData) object;
                preparedStatement = databaseConnector.getConnection().prepareStatement("INSERT INTO production_sensor_data(production_id, type, value, created_at) VALUES (?,?,?,?)");
                preparedStatement.setInt(1, sensorData.getProductionId());
                preparedStatement.setString(2, sensorData.getType());
                preparedStatement.setDouble(3, sensorData.getValue());
                preparedStatement.setTimestamp(4, sensorData.getTimestamp());
                preparedStatement.execute();
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public int getRowcount() {
        rowcount = databaseConnector.getRowCount();
        return rowcount;
    }

}

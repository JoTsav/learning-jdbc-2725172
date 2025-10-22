package com.joseph.lil.data.dao;


import com.joseph.lil.data.entity.Service;
import com.joseph.lil.data.util.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

public class ServiceDao implements Dao<Service, UUID> {

    /*
    After setting and completing dao we read all data in services table
    through services domain. It’s important to keep the actual SQL from the Java code itself
     */
    private static final Logger LOGGER = Logger.getLogger(ServiceDao.class.getName());

    // reads all data
    private static final String GET_ALL = "SELECT service_id, name, price FROM wisdom.services";

    // reads particular data. // ? is placeholder for parameterized query (binding variables)
    private static final String GET_BY_ID = "SELECT service_id, name, price FROM wisdom.services WHERE service_id = ?";


    @Override
    public List<Service> getAll() {

        List<Service> services = new ArrayList<>();
        Connection connection = DatabaseUtils.getConnection();

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(GET_ALL);
            services = this.processResultSet(rs);
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("ServiceDao.getALL", e, LOGGER);
        }
        return services;
    }

    @Override
    public Service create(Service entity) {
        return null;
    }

    @Override
    public Optional<Service> getOne(UUID id) {
        // obtaining one service by id not implemented yet
        // used a prepared statement for parameterized query (binding of variables)
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setObject(1, id);
            ResultSet rs = statement.executeQuery();
            List<Service> services = this.processResultSet(rs);
            // always processing for the result set to return a list
            if (services.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(services.get(0));

            
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("ServiceDao.getOne", e, LOGGER);
        }
        return Optional.empty();
    }

    @Override
    public Service update(Service entity) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    /**
     * Processes all of the result sets (what sql returns once commands/ queries are ran)
     * @param rs
     * @return
     * @throws SQLException
     */
    private List<Service> processResultSet(ResultSet rs) throws SQLException {
        List<Service> services = new ArrayList<>();
        while (rs.next()) {
            Service service = new Service();
            service.setServiceID((UUID) rs.getObject("service_id"));
            service.setName(rs.getString("name"));
            service.setPrice(rs.getBigDecimal("price"));
            services.add(service);
        }
        return services;
    }
}
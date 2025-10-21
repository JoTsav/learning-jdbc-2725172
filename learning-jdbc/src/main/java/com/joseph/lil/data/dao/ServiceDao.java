package com.joseph.lil.data.dao;


import com.joseph.lil.data.entity.Service;
import com.joseph.lil.data.util.DatabaseUtils;

import java.sql.Connection;
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

    private static final String GET_ALL = "SELECT service_id, name, price FROM wisdom.services";

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
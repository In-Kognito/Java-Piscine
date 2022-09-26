package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {

    private DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from product;");

        while (resultSet.next()) {
            productList.add(new Product(
                    resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getInt(3)
            ));
        }

        statement.close();
        connection.close();

        return productList;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String request = "SELECT * FROM product WHERE identifier = " + id + ";";
        ResultSet resultSet = statement.executeQuery(request);

        Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3));

        resultSet.close();
        statement.close();
        connection.close();

        return Optional.of(product);
    }

    @Override
    public void update(Product product) throws SQLException {

        String request = "UPDATE product SET name = " + "'" + product.getName() + "'" + ", price = " + product.getPrice()
                + "WHERE identifier = " + product.getId() + ";";

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(request);

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

    }

    @Override
    public void save(Product product) throws SQLException {
        String request = "INSERT INTO product(identifier, name,price) values (" + product.getId() + ", " + product.getName() + ", " + product.getPrice() + "');";

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(request);

            statement.close();
            connection.close();


    }

    @Override
    public void delete(Long id) throws SQLException {
        String request = "DELETE FROM product WHERE identifier = " + id + ";";

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(request);

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
    }
}

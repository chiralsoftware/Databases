package chiralsoftware.oldjdbc;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * World of SQL
 */
public final class Sql {

    private static final Logger LOG = Logger.getLogger(Sql.class.getName());
    
    public static void main(String[] args) throws Exception {
        final Connection connection = getConnection("jdbc:postgresql://localhost/test?user=test&password=test");
        final PreparedStatement preparedStatement = 
                connection.prepareStatement("select name, age from customer where age > ? order by age asc");
        preparedStatement.setInt(1, 26); // look for age over 26
        final ResultSet rs = preparedStatement.executeQuery();
        final List<Customer> results = new ArrayList<>();
        while(rs.next()) {
            final Customer customer = new Customer(rs.getString(1), rs.getInt(2));
            results.add(customer);
        }
        LOG.info("Here is the result: " + results);
    }
}

package despina.bazar.orm;

import despina.bazar.orm.entities.ContinentEntity;
import despina.bazar.orm.service.ContinentService;
import despina.bazar.orm.service.CountryService;
import despina.general.exceptions.ExceptionORM;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;

/**
 * Created by ASUS on 9/6/2016.
 */
public class BazarCountryTest {
    @Test
    public void jdbcTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bazar_db?useUnicode=yes&amp;characterEncoding=utf-8", "root", "");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bazar_db?useUnicode=yes&characterEncoding=utf-8", "root", "");
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder("insert into country(title, continent_id, continent_title) VALUES (")
                    .append("'قطر'")
                    .append(", 1, ")
                    .append("'آسیا'")
                    .append(")");
            statement.execute(stringBuilder.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() throws UnsupportedEncodingException {
        CountryService countryService = DespinaBazarORMServiceProvider
                .getCountryService();
        countryService.insert("ایران", 1);
    }

    @Test
    public void deleteById() {
        ContinentService continentService = DespinaBazarORMServiceProvider
                .getContinentService();
        try {
            System.out.println(continentService.deleteById(6));
        } catch (ExceptionORM exceptionORM) {
            exceptionORM.printStackTrace();
        }
    }

    @Test
    public void selectAll() {
        ContinentService continentService = DespinaBazarORMServiceProvider
                .getContinentService();
        List<ContinentEntity> continentEntities = continentService.selectAll();
        for(ContinentEntity e : continentEntities) {
            System.out.println(e.getTitle());
        }
    }

    @Test
    public void selectById() {
        ContinentService continentService = DespinaBazarORMServiceProvider
                .getContinentService();
        ContinentEntity continentEntity = continentService.selectWithId(5);
        System.out.println(continentEntity.getTitle());
    }
}

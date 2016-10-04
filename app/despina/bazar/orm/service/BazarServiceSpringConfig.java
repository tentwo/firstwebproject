package despina.bazar.orm.service;

import despina.bazar.orm.dao.BazarBaseDao;
import despina.bazar.orm.dao.BazarDaoSpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rahmati on 1/19/2016.
 */
@Configuration
@Import(BazarDaoSpringConfig.class)
@ComponentScan
public class BazarServiceSpringConfig {
}

package despina.bambino.orm.service;

import despina.market.orm.dao.MarketDaoSpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rahmati on 1/19/2016.
 */
@Configuration
@Import(MarketDaoSpringConfig.class)
@ComponentScan
public class BambinoServiceSpringConfig {
}

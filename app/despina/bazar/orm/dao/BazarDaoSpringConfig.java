package despina.bazar.orm.dao;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Rahmati on 1/19/2016.
 */
@Configuration
@EnableJpaRepositories("despina.bazar.orm.entities")
@EnableTransactionManagement
@ComponentScan
public class BazarDaoSpringConfig {

    @Bean
    BeanPostProcessor getBeanPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    JpaVendorAdapter getJpaVendorAdapter(){
        // will set the provider to 'org.hibernate.ejb.HibernatePersistence'
        EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.eclipse.persistence.platform.database.MySQLPlatform");
        // will set hibernate.show_sql to 'true'
        vendorAdapter.setShowSql(true);
        // if set to true, will set hibernate.hbm2ddl.auto to 'update'
        vendorAdapter.setGenerateDdl(false);
        return vendorAdapter;
    }

    /*@Bean
    DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/switch");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "111392" );
        return dataSource;
    }*/

    /**
     * local container
     */

//    -javaagent:C:\.m2\repository\org\springframework\spring-instrument\4.2.4.RELEASE\spring-instrument-4.2.4.RELEASE.jar

//    @Bean
//    DataSource getJtadataSource() {
//        JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
//        return jndiDataSourceLookup.getDataSource("java:comp/env/jdbc/shadbarg-ds");
//    }

    /*@Bean
    javax.persistence.spi.PersistenceProvider getPersistenceProvider(){
        return new org.eclipse.persistence.jpa.PersistenceProvider();
    }*/

    /*@Bean
    public EntityManagerFactory getLocalContainerEntityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(getJpaVendorAdapter());
        factory.setPersistenceProvider(getPersistenceProvider());
//        factory.setLoadTimeWeaver(new SimpleLoadTimeWeaver());
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
//        factory.setDataSource(getDataSource());
//        factory.setJtaDataSource(getJtadataSource());
        factory.setPersistenceUnitName("switchPU");
        factory.setPackagesToScan("com.dml.parsian.orm.entities");
//        factory.setJtaDataSource(getDataSource());

        // This will trigger the creation of the entity manager factory
        factory.afterPropertiesSet();

        return factory.getObject();
    }*/

/*    @Bean
    public PlatformTransactionManager getTransactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean());
        return txManager;
    }*/

    /**
     * local
     */

    @Bean
    public EntityManagerFactory getLocalEntityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(getJpaVendorAdapter());
        factory.setPersistenceUnitName("bazar-pu");

        // This will trigger the creation of the entity manager factory
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(getLocalEntityManagerFactoryBean());
        return txManager;
    }
}

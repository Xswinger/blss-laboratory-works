package com.github.Xswinger.blsslaboratorywork1.configuration.atomikos;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.postgresql.xa.PGXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "DataSourceConfiguration",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.github.Xswinger.blsslaboratorywork1.repositories"}
)
public class DataSourceConfiguration {

    public Map<String, String> jpaProperties() {
        Map<String, String> accountJpaProperties = new HashMap<>();
        accountJpaProperties.put("hibernate.hbm2ddl.auto", "validate");
        accountJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        accountJpaProperties.put("hibernate.show_sql", "true");
        accountJpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        accountJpaProperties.put("jakarta.persistence.transactionType", "JTA");
        return accountJpaProperties;
    }

    @Bean(name = "managerFactoryBuilder")
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
                new HibernateJpaVendorAdapter(), jpaProperties(), null
        );
    }

    @Bean(name = "DataSourceConfiguration")
    public LocalContainerEntityManagerFactoryBean accountEntityManager(
            @Qualifier("managerFactoryBuilder") EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("dataSource") DataSource postgresDataSource
    ) {
        return entityManagerFactoryBuilder
                .dataSource(postgresDataSource)
                .packages("com.github.Xswinger.blsslaboratorywork1.entities")
                .persistenceUnit("postgres")
                .properties(jpaProperties())
                .jta(true)
                .build();
    }

    @Bean(name = "dataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties accountDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean("dataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource inventoryDataSource(@Qualifier("dataSourceProperties") DataSourceProperties accountDataSourceProperties) {
        PGXADataSource ds = new PGXADataSource();

        ds.setUrl(accountDataSourceProperties.getUrl());
        ds.setUser(accountDataSourceProperties.getUsername());
        ds.setPassword(accountDataSourceProperties.getPassword());

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();

        dataSource.setXaDataSource(ds);
        dataSource.setUniqueResourceName("ds1");
        
        return dataSource;
    }

}

package com.sotong.projectcms.datasource;

import com.sotong.projectcms.exception.InvalidParamException;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class DatasourceProvider {
    @Bean(name = "sotongMariaDatasource")
    @Qualifier("sotongMariaDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource-sotong-maria")
    protected DataSource sotongMariaDatasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
    @Bean(name = "amazonMariaDatasource")
    @Qualifier("amazonMariaDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource-amazon-maria")
    protected DataSource amazonMariaDatasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    public DataSource provideDatasource(String type) throws InvalidParamException{
        switch (type) {
            case "sotong-maria-datasource":
                return sotongMariaDatasource();
            case "amazon-maria-datasource":
                return amazonMariaDatasource();
            default:
                throw new InvalidParamException("Datasource type invalid");

        }
    }
}

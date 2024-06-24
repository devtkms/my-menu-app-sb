package com.devtkms.mymenuappsb.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder

@Configuration
@MapperScan("com.devtkms.mymenuappsb.mapper")
class MyBatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    @Throws(Exception::class)
    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactory {
        val factoryBean = SqlSessionFactoryBean()
        factoryBean.setDataSource(dataSource)
        return factoryBean.getObject()!!
    }
}
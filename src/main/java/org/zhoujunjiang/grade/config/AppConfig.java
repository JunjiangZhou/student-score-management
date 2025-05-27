package org.zhoujunjiang.grade.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {"org.zhoujunjiang.grade.service"})
@EnableTransactionManagement
public class AppConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/student_grade_system?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("Mysql4mypj");
        ds.setMaxTotal(20);
        ds.setMaxIdle(5);
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfigLocation(new org.springframework.core.io.ClassPathResource("mybatis-config.xml"));
        try {
            factoryBean.setMapperLocations(
                    new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml")
            );
        } catch (IOException e) {
            throw new RuntimeException("无法加载 Mapper XML 文件", e);
        }
        return factoryBean;
    }

    // 注意：MapperScannerConfigurer 不能写 @Bean 时返回接口类，要用这个方式配置
    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("org.zhoujunjiang.grade.mapper");
        return configurer;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}

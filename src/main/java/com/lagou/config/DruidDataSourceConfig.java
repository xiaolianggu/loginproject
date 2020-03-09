package com.lagou.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.util.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 数据源使用阿里开源的Druid
 * 默认监控页面：http://${service_name}/${context}/druid
 */
@Configuration
@ConditionalOnClass({DruidDataSource.class})
@ConditionalOnProperty(
        name = {"${spring.datasource.type}"},
        havingValue = "com.alibaba.druid.pool.DruidDataSource",
        matchIfMissing = true
)
@EnableConfigurationProperties(DruidDataSourceProperties.class)
public class DruidDataSourceConfig {
    @Bean
    public DruidDataSource dataSource(DataSourceProperties dataSourceProperties, DruidDataSourceProperties druidDataSourceProperties) {
        DruidDataSource druidDataSource = (DruidDataSource) dataSourceProperties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        druidDataSource.configFromPropety(druidDataSourceProperties.toProperties());
        druidDataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
        druidDataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
        druidDataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
        druidDataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
        druidDataSource.setConnectProperties(druidDataSourceProperties.getConnectionProperties());
        return druidDataSource;
    }
    @Bean
    public ServletRegistrationBean druidStatViewServlet(DruidDataSourceProperties druidDataSourceProperties) {
        if (StringUtils.isEmpty(druidDataSourceProperties.getServletPath())) {
            druidDataSourceProperties.setServletPath("/druid/*");
        }
        return new ServletRegistrationBean(new StatViewServlet(), druidDataSourceProperties.getServletPath());
    }
    @Bean
    public FilterRegistrationBean druidWebStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}

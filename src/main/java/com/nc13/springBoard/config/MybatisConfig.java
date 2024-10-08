package com.nc13.springBoard.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

// 마이바티스의 경우, 데이터 베이스 통신을 위한 객체를
// 자기 자신이 내부적으로 컨트롤을 하게 된다.
// 따라서, 데이터베이스 통신을 위한 설정 값을 application.properties에 저장하고
// 실행시킬 쿼리들은 xml에 파일로 분리하게 된다.
// 그런 후에 mybatis에서 쿼리를 실행시킬 객체들을 스프링이 관리할 수 있도록
// 클래스를 만들어서 관리를 하게 된다.
@Configuration
public class MybatisConfig {
    // 컨트롤러, 서비스, 컨피겨레이션 같이 스프링 프레임워크가 직접 관리하는
    // 객체들 중 특수한 성격을 띄는 친구들은 우리가 직접 @Controller, @Service
    // 같은 어노테이션을 붙여주지만 만약 스프링 프레임워크가 직접 관리해야할 객체들 중
    // 특수한 성격을 띄지 않거나 아니면 별개의 라이브러리 객체일 경우에는
    // 우리가 @Bean이라는 어노테이션을 붙여주게된다.

    //서비스에 있는 에스큐엘세션템플릿을 관리하라고 빈이라는 것을 사용함
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
    // 어떤 템플릿을 사용할 건지 준비를 하는 거고
    // 에스큐엘세션팩토리가 데이터베이스의 아이디, 비밀번호 등의 내용과 컨피규 로케이션에 추가적인 정보를 적어주는 설정들도 불러올 수 있고
    // 매퍼(쿼리문을 사용하는 것) 파일 불러오는 것도 받아놔야함

            throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        Resource[] resources =
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean// 템플릿에 팩토리 정보를 넣어서 사용하는 것임
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

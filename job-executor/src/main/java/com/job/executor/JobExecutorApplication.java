package com.job.executor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
public class JobExecutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobExecutorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  任务执行器启动成功!!!   ლ(´ڡ`ლ)ﾞ");
    }

}

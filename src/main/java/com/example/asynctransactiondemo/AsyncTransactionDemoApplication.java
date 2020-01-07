package com.example.asynctransactiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableAsync(mode = AdviceMode.ASPECTJ)
public class AsyncTransactionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncTransactionDemoApplication.class, args);
	}

	@Bean
	public Executor threadPoolTaskExecutor() {
		return new SimpleAsyncTaskExecutor("async-thread-");
	}

}


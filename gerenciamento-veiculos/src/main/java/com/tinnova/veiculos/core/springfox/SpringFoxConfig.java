package com.tinnova.veiculos.core.springfox;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.classmate.TypeResolver;
import com.tinnova.veiculos.api.exceptionhandler.Problem;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {
		
	@Bean
	public Docket apiDocketV1() {
		TypeResolver typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("V1")				
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.tinnova.veiculos.api"))
					.paths(PathSelectors.ant("/**"))
					.build()
					.useDefaultResponseMessages(false)
					.globalResponseMessage(RequestMethod.GET, globalGetResponseMessage())
					.globalResponseMessage(RequestMethod.POST, globalPostResponseMessage())
					.globalResponseMessage(RequestMethod.PUT, globalPutResponseMessage())
					.globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessage())
					.additionalModels(typeResolver.resolve(Problem.class))
					.ignoredParameterTypes(ServletWebRequest.class, URI.class, URL.class,
							URLStreamHandler.class, Resource.class, File.class, InputStream.class)
					.apiInfo(apiInfoV1())
					.tags(  new Tag("Veiculos", "Gerencia os veiculos"));
	}
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	public ApiInfo apiInfoV1() {
		return new ApiInfoBuilder()
				.title("Veiculos API")
				.description("API aberta para gerenciamento de veiculos.")
				.version("1.0")
				.contact(new Contact("Tinnova Teste", "http://www.veiculos-teste.com.br", "teste@teste.com"))
				.build();
	}
	

	private List<ResponseMessage> globalGetResponseMessage() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build()
				);
	}
	
	private List<ResponseMessage> globalPostResponseMessage() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
					.message("Media Type não suportada")
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Falha no modelo de entrada.")
					.responseModel(new ModelRef("Problema"))
					.build()
				);
	}
	
	private List<ResponseMessage> globalPutResponseMessage() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
					.message("Media Type não suportada")
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Falha no modelo de entrada.")
					.responseModel(new ModelRef("Problema"))
					.build()
				);
	}
	
	private List<ResponseMessage> globalDeleteResponseMessage() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Falha no modelo de entrada.")
					.responseModel(new ModelRef("Problema"))
					.build()
				);
	}
}

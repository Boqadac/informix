package main;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class InformixToFile {
		private static final String CONFIG_PATH = "classpath*:main/applicationContext.xml";
		@Autowired
		CallrecordImpl impl;

		void sayHello() throws IOException {
			impl.printS();
		}

		public static void main(final String[] args) throws IOException {
			@SuppressWarnings("resource")
			final ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
			final InformixToFile minimalSpringApp = context.getBean(InformixToFile.class);
			minimalSpringApp.sayHello();
		}
}




package by.la.strada;

import by.tsydzik.application.config.AppConfiguration;
import by.tsydzik.data.config.DataServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, DataServiceConfig.class})
public class RetailAppApplicationTests {

	@Test
	public void contextLoads() {
	}

}

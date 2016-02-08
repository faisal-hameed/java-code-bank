package spring.boot;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurations {

	@Value("${app.name}")
	String appName;

	@Value("${app.version}")
	String appVersion;

	@Value("#{'${app.team}'.split(',')}")
	private List<String> team;

	public MyConfigurations() {
		System.out.println("Constructor");
	}

	@PostConstruct
	public void doProcess() {
		System.out.println("Post Construct Values : " + this);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Cleanup task");
	}

	@Override
	public String toString() {
		return "MyConfigurations [appName=" + appName + ", appVersion=" + appVersion + ", team=" + team + "]";
	}

}

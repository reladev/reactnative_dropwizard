package com.reladev.rndw;

import com.reladev.rndw.rest.SampleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class RnDwApplication extends Application<AppConfiguration> {
	public static final Logger LOGGER = LoggerFactory.getLogger(RnDwApplication.class);

	public static void main(final String[] args) throws Exception {
		new RnDwApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		bootstrap.addBundle(GuiceBundle.builder()
			  // module is not required, but used here to show precise guice beans configuration
			  .modules(new ManualModule())
			  // in manual mode extension classes must be declared explicitly to be recognized by installer and properly installed
			  .extensions(SampleResource.class)
			  .build());
	}

	@Override
	public void run(final AppConfiguration configuration, final Environment environment) throws Exception {
		LOGGER.info("Application name: {}", configuration.getAppName());
	}
}
package com.example.config;

import javax.servlet.ServletContext;

import org.ocpsoft.logging.Logger.Level;
import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;
import org.ocpsoft.rewrite.config.Log;

@RewriteConfiguration
public class FacesRewriteConfigurationProvider extends HttpConfigurationProvider {

	@Override
	public int priority() {
		return 10;
	}

	@Override
	public Configuration getConfiguration(final ServletContext context) {
		System.err.println("----------------- FacesRewriteConfigurationProvider -------------------");
		return ConfigurationBuilder.begin().addRule(Join.path("/ex04/").to("/exo4/index.xhtml"))
				.addRule(Join.path("/ex04/book/{id}/").to("/ex04/viewBook.xhtml"))
				.perform(Log.message(Level.INFO, "Rewrite is active."));

		// .addRule()
		// .when(Direction.isInbound().and(Path.matches("/some/{page}/")))
		// .perform(Forward.to("/new-{page}/"));

		// Forwarding .html to .xhtml with some magic
		// .when(Direction.isInbound()
		// .and(Path.matches("{name}.html").where("name").matches("[a-zA-Z/]+")))
		// .perform(Forward.to("{name}.xhtml"));

	}

}

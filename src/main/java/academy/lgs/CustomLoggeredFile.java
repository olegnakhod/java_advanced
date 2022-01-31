package academy.lgs;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLoggeredFile {

	private static Logger LOG = Logger.getLogger(CustomLoggeredFile.class);

	public static void main(String[] args) {

		logWithDomConfigurator();

	}

	public static void logWithDomConfigurator() {
		DOMConfigurator.configure("loggerConfig.xml");
		LOG.trace("TRACE Logger mesaage of project");
		LOG.debug("DEBUG Logger mesaage of project");
		LOG.info("INFO Logger mesaage of project");
		LOG.warn("WARN Logger mesaage of project");
		LOG.error("ERROR Logger mesaage of project");
		LOG.fatal("FATAL Logger mesaage of project");
	}
}

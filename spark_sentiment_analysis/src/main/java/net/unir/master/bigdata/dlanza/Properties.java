package net.unir.master.bigdata.dlanza;

import org.apache.log4j.Logger;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Properties{
	
    private static final Logger LOG = Logger.getLogger(Properties.class);
    
    private static Properties singleton;

    private Configuration config;

    private Properties(){
        try{
            this.config = new PropertiesConfiguration(
                this.getClass().getResource("/spark.properties"));
        }catch (Exception ex){
            LOG.fatal("Could not load configuration", ex);
            LOG.trace(null, ex);
        }
    }

    private static Properties get(){
        if (singleton == null)
            singleton = new Properties();
        return singleton;
    }

    public static String getString(String key){
        return get().config.getString(key);
    }

    public static Integer getInt(String key){
        return get().config.getInt(key);
    }
    
}

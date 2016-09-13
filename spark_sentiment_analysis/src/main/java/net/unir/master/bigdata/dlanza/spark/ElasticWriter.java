package net.unir.master.bigdata.dlanza.spark;

import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.*;

import net.unir.master.bigdata.dlanza.Properties;
import scala.Tuple5;

/**
 * Source: https://github.com/s44d/spark-streaming-elasticsearch/blob/master/src/main/java/spark/streaming/StreamingExample.java
 * @author daniellanzagarcia
 *
 */
public class ElasticWriter
    implements Function2<JavaRDD<Tuple5<Long, String, Float, Float, String>>, Time, Void>{
	
    private static final long serialVersionUID = 42l;

    public Void call(JavaRDD<Tuple5<Long, String, Float, Float, String>> rdd, Time time){
    	
        if (rdd.count() <= 0) 
        	return null;
        
        JavaEsSpark.saveJsonToEs(rdd, "tweets/tweet");
        
        return null;
    }
    
}

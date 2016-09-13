package net.unir.master.bigdata.dlanza.spark;

import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.*;

import net.unir.master.bigdata.dlanza.Properties;
import scala.Tuple5;

public class FileWriter
    implements Function2<JavaRDD<Tuple5<Long, String, Float, Float, String>>, Time, Void>{
	
    private static final long serialVersionUID = 42l;

    public Void call(JavaRDD<Tuple5<Long, String, Float, Float, String>> rdd, Time time){
    	
        if (rdd.count() <= 0) 
        	return null;
        
        String path = Properties.getString("spark.hdfs.output_file") + "_" + time.milliseconds();
        
        rdd.saveAsTextFile(path);
        
        return null;
    }
    
}

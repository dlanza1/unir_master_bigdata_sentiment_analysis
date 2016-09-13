package net.unir.master.bigdata.dlanza.spark.functions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.PairFunction;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import scala.Tuple2;

public class TwitterFilterFunction implements PairFunction<String, Long, String>{
	
    private static final long serialVersionUID = 42l;
    
    private final ObjectMapper mapper = new ObjectMapper();
   
    public Tuple2<Long, String> call(String tweet){
//        try{
//            JsonNode root = mapper.readValue(tweet, JsonNode.class);
//            long id;
//            String text;
//            
//            if (root.get("lang") != null && "en".equals(root.get("lang").textValue())){
//                if (root.get("id") != null && root.get("text") != null){
//                    id = root.get("id").longValue();
//                    text = root.get("text").textValue();
//                    return new Tuple2<Long, String>(id, text);
//                }
//                
//                return null;
//            }
            
            return new Tuple2<Long, String>((long) (Math.random() * 1000000d), tweet);
//        }catch (IOException ex){
//            Logger LOG = Logger.getLogger(this.getClass());
//            LOG.error("IO error while filtering tweets", ex);
//            LOG.trace(null, ex);
//        }
        
//        return null;
    }

}

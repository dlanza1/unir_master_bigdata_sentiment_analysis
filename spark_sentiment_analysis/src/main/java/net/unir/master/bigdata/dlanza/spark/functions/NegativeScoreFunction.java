package net.unir.master.bigdata.dlanza.spark.functions;

import org.apache.spark.api.java.function.*;

import net.unir.master.bigdata.dlanza.sentiment.NegativeWords;
import scala.Tuple2;

import java.util.Set;

public class NegativeScoreFunction
    implements PairFunction<Tuple2<Long, String>, Tuple2<Long, String>, Float>{
	
    private static final long serialVersionUID = 42l;

    public Tuple2<Tuple2<Long, String>, Float> call(Tuple2<Long, String> tweet){
    	
        String text = tweet._2();
        Set<String> negWords = NegativeWords.getWords();
        String[] words = text.split(" ");
        int numWords = words.length;
        int numNegWords = 0;
        
        for (String word : words){
            if (negWords.contains(word))
                numNegWords++;
        }
        
        return new Tuple2<Tuple2<Long, String>, Float>(
            new Tuple2<Long, String>(tweet._1(), tweet._2()),
            (float) numNegWords / numWords
        );
    }
    
}

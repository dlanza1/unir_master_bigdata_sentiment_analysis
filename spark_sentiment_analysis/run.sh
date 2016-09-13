#!/bin/sh

spark-submit --class net.unir.master.bigdata.spark.SentimentAnalysis \
             --name "Twitter Sentiment Analysis" \
             --master $1 \
             ~/rts.spark-0.0.1.jar \
             $@

package com.tinysearchengine.indexer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

import com.tinysearchengine.pagerank.PageRankMainDriver;
import com.tinysearchengine.pagerank.PageRankMainMapper;
import com.tinysearchengine.pagerank.PageRankMainReducer;

public class BuildInvertedIndexDriver extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {
//		Job job = Job.getInstance();
//		job.setJobName("PageRankMain");
//		job.setJarByClass(PageRankMainDriver.class);
//		job.getConfiguration().set("mapreduce.output.basename", "PageRank_Result");
	    
		Configuration conf = new Configuration();
		
		Job job =  Job.getInstance(conf, "inverted index");
		job.setJarByClass(BuildInvertedIndexDriver.class);
		
		job.setMapperClass(BuildInvertedIndexMapper.class);
		job.setReducerClass(BuildInvertedIndexReducer.class);
	    
	    job.setMapOutputKeyClass(Text.class); //Set Mapper Output
	    job.setMapOutputValueClass(Text.class);
	    job.setOutputKeyClass(Text.class); //Set Reducer Output
	    job.setOutputValueClass(Text.class);
	    
	    FileInputFormat.setInputPaths(job, new Path("filesForTest/invertedInderxer/input"));
	    FileOutputFormat.setOutputPath(job, new Path("filesForTest/invertedInderxer/output"));
	  
//	    FileInputFormat.setInputPaths(job, new Path(arg0[0]));
//	    FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
	    
//		return job.waitForCompletion(true) ? 0 : 1;
		return 0;
	}

}

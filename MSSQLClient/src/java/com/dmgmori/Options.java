package com.dmgmori;

import com.lexicalscope.jewel.cli.Option;

public class Options {
	
	private int records;
	private int batchSize;
//	private boolean autoCommit;
	
    @Option(shortName="r", longName="records", description="Set number of records.", defaultValue="0")
    public void setRecords(int records) {
            this.records = records;
    }
    
    public int getRecords() {
    	return records;
    }
    
    @Option(shortName="b", longName="batchSize", description="Set batch size.", defaultValue="1000")
    public void setMethod(int batchSize) {
    	this.batchSize = batchSize;
    }
    
//    @Option(shortName="c", longName="commit", description="Set autoCommit to true or false.", defaultValue="true")
//    public void setCommit(boolean commit) {
//    	this.autoCommit = commit;
//    }
//    
//    public boolean getCommit() {
//    	return autoCommit;
//    }
    
    public int getBatchSize() {
    	return batchSize;
    }

    @Option(helpRequest = true)
    public void setHelp(boolean help) { }

}
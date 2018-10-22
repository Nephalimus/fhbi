package com.dmgmori;

import com.lexicalscope.jewel.cli.Option;

public class Options {
	
	private int records;
	private int batchSize;
	private boolean dryRun;
	
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
    
    public int getBatchSize() {
    	return batchSize;
    }

    @Option(shortName="d", longName="dryRun", description="Set dry run on or off.")
    public void setDryRun(boolean dryRun) {
    	this.dryRun = dryRun;
    }

    public boolean getDryRun() { 
    	return dryRun;
    }
    
    @Option(helpRequest = true)
    public void setHelp(boolean help) { }

}
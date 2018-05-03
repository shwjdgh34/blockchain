package com.blockchain.simple.core;


import java.util.Date;
import com.blockchain.simple.util.StringUtil;


public class Block {
	
	 public String hash;  /* 해시값 */
	 public String previousHash; /* 이전 블럭의 해시값 */
	 private String data;   /* 블럭의 data */
	 private long timestamp;  /* timestamp */
	 private int nonce;
	 
	 public Block(String data, String previousHash ) {

		  this.data = data;
		  this.previousHash = previousHash;
		  this.timestamp = new Date().getTime();
		  this.hash = calculateHash();
	 }

	public String calculateHash() {
		 String calculatedhash = StringUtil.applySha256( 
				 previousHash +
				 Long.toString(timestamp) +
				 Integer.toString(nonce) + 
				 data 
				 );
		 return calculatedhash;
	 }

	 
	 public void mineBlock(int difficulty) {
		 String target = new String(new char[difficulty]).replace('\0', '0');
		 while(!hash.substring( 0, difficulty).equals(target)) {
			 nonce ++;
			 hash = calculateHash();
			 System.out.printf("\nGEN Hash #%d : %s", nonce, hash);
		 }
		 System.out.println("\n채굴 성공!!! : " + hash);
	 }
}


package com.blockchain.simple.core;


import java.util.Date;
import com.blockchain.simple.util.StringUtil;


public class Block {
	
	 public String hash;  /* �ؽð� */
	 public String previousHash; /* ���� ���� �ؽð� */
	 private String data;   /* ���� data */
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
		 System.out.println("\nä�� ����!!! : " + hash);
	 }
}


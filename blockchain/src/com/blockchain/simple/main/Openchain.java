package com.blockchain.simple.main;

import java.util.ArrayList;

import com.blockchain.simple.core.Block;
import com.blockchain.simple.util.*;
import com.google.gson.GsonBuilder;


import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;


public class Openchain {
	//blockchain ArrayList
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty =4;
	public static void main(String[] arg){
		//�ʱ� ���� ����ϴ�.
		blockchain.add(new Block("Genesis block", "0"));
		System.out.println("\nTrying to Mine Genesis block!");
		blockchain.get(0).mineBlock(difficulty);
		//���� ���� �����մϴ�.
		
		for(int i = 1 ; i <= 5 ; i++){
			blockchain.add(new Block("block " + i, blockchain.get(blockchain.size()-1).hash));
			System.out.printf("\nTrying to Mine block #%d", i+1 );
			blockchain.get(i).mineBlock(difficulty);
		}
		  //��ü ���� ����մϴ�.
		  String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		  System.out.println("\nOpenchain Block list : ");
		  System.out.println(blockchainJson);

		
	}
}

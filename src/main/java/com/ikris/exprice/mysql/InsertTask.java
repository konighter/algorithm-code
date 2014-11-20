package com.ikris.exprice.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.BrokenBarrierException;


import com.ikris.exprice.mysql.ConnectionFactoryTest.LatchBarrier;

public class InsertTask implements Runnable{
	LatchBarrier b;
	public InsertTask(LatchBarrier barrier){
		b = barrier;
	}
	
	
	@Override
	public void run() {
		try {
			b.barrierAwait();
			System.out.println(Thread.currentThread().getName()+" ---start work");
		} catch (InterruptedException | BrokenBarrierException e) {
			Thread.currentThread().interrupt();
		}
		
		Connection conn;
		try {
			conn = ConnectionFactoryTest.getConnection();
			String sql = "insert into sbtest_uuid (id,k,c,pad) values (uuid(),'1','ccccc','qqqqqqqqqqwwwwwwwwwweeeeeeeeeerrrrrrrrrrtttttttttt')";
			conn.setAutoCommit(false);
			Statement ps = conn.createStatement();
			
			for(int i=0;i<10000;i++){
//				ConnectionFactoryTest.excuteInsert(sql, conn);
				ps.execute(sql);
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		b.countdown();
		System.out.println(Thread.currentThread().getName()+" ---finish work");
		
		
	}

	

}

package com.ikris.exprice.mysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.DriverConnectionFactory;
import org.junit.Test;

public class ConnectionFactoryTest {
	
	static void print(Object o){
		System.out.println(o);
	}
	
	public static BasicDataSource ds;
	
	static {
		ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://172.27.21.102:3306/performance");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setInitialSize(153);
		ds.setMaxIdle(20);
		ds.setMaxActive(150);
	}
	
	static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	static void excuteInsert(String sql,Connection conn) throws SQLException{
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		
	}
	
	static void excuteQuery(String sql,Connection conn) throws SQLException{
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while(rs.next()){
			count ++;
		}
		System.out.println(Thread.currentThread().getName() + "-- "+count);
		conn.commit();
	}
	
	
	static void singleConnectionWaittimeoutTest() throws Exception {
		print("### singleConnectionWaittimeoutTest");
		String drivername = "com.mysql.jdbc.Driver";
		String url 		  = "jdbc:mysql://172.27.21.102:3306/performance";
		String username   = "root";
		String password   = "1234";
		final int MAX_CONNECTION = 200;
		Driver driver = (Driver) Class.forName(drivername).newInstance();
		print(driver);
		Properties p = new Properties();
		p.put("user", username);
		p.put("password", password);
		
		final DriverConnectionFactory dcf = new DriverConnectionFactory(driver,url,p);
		final List connPool = new ArrayList();
		final AtomicInteger a = new AtomicInteger();

		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					for(int i=0; i< MAX_CONNECTION; i++){
						connPool.add(dcf.createConnection());
						a.incrementAndGet();
					}
						
				} catch (SQLException e) {
					print(e.getMessage());
					Thread.currentThread().interrupt();
					print(a);
				}
			}
			
		});
		
		t.start();
		t.join();
		
		
		
		
		
		Thread.sleep(20000);
		
		
		Connection conn = (Connection) connPool.get(0);
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select * from sbtest");
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while(rs.next()){
			count ++;
		}
		print("### singleConnectionWaittimeoutTest---count: "+count);
	}
	
	
	static void ConnectionPoolTimeoutTest() throws Exception{
		print("### ConnectionPoolTimeoutTest");
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://172.27.21.102:3306/performance");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setInitialSize(150);
		ds.setMaxIdle(20);
		ds.setMaxActive(15);
		ds.getConnection();
		Thread.sleep(20000);
		print("### ConnectionPoolTimeoutTest--- invoke query");
		Connection conn = ds.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select * from sbtest");
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while(rs.next()){
			count ++;
		}
		print("### ConnectionPoolTimeoutTest---count: "+count);
	}
	
	@Test
	public void MysqlInsertTest() throws InterruptedException, BrokenBarrierException{
		final int THREAD_NUMS = 100;
		
		LatchBarrier lb = new LatchBarrier(THREAD_NUMS);
		
		// run task
		for(int i=0;i<THREAD_NUMS;i++){
			new Thread(new InsertTask(lb)).start();
		}
		
		lb.barrierAwait();
		long now = System.currentTimeMillis();
		
		lb.countDownAwait();
		System.out.println(System.currentTimeMillis()-now);
	}
	
	
	
	public static class LatchBarrier{
		CyclicBarrier barrier;
		CountDownLatch cdl;
		public LatchBarrier(int threads){
			 barrier = new CyclicBarrier(threads+1);
			
			 cdl = new CountDownLatch(threads);
		}
		
		public void countDownAwait() throws InterruptedException{
			cdl.await();
		}
		
		public void barrierAwait() throws InterruptedException, BrokenBarrierException{
			barrier.await();
		}
		
		public void countdown(){
			cdl.countDown();
		}
	}
	
//	@Test
	public void testDatasource(){
		try {
			int count = 0;
			for(int i=0;i<1000;i++){
				System.out.println(count++);
				ds.getConnection();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InterruptedException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws Exception{
		ConnectionPoolTimeoutTest();
		
	}

}

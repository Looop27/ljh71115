import java.util.ArrayList;

public class SaleTickets implements Runnable{
	private int count = 200;

	private Boolean flag = true;

	@Override

	public void run() {




		while (flag) {

			synchronized ("") {

				if (count > 0) {

					try {

						Thread.sleep(500);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					System.out.println("窗口号:"+Thread.currentThread().getName()+"剩余票数:"+count);	

					count--;

				} else if (count == 0) {

					if (flag) {

						System.out.println("the tickets have been sold out!");

						flag = false;

					}

				}

			}

		}

	}
	public static void main(String[]args){
		
		long begin=System.currentTimeMillis();
		SaleTickets task=new SaleTickets();
		 ArrayList<Thread>threadGroup=new ArrayList<Thread>();
		 
		 for(int i=0;i<10;i++){
			 Thread t=new Thread(task,"Thread"+i);
			 threadGroup.add(t);
			 t.start();
			 
		 }//初始化十个线程

	}}

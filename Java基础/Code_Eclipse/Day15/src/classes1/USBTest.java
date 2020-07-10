package classes1;

public class USBTest {
	public static void main(String[] args) {
		Computer c = new Computer();
		//1.创建了接口的非匿名实现类的非匿名对象
		Flash f = new Flash();
		c.transferData(f);
		
		//2.创建了接口的非匿名实现类的匿名对象
		c.transferData(new Printer());
		
		//3.创建了接口的匿名实现类的非匿名对象
		USB phone = new USB() {

			@Override
			public void start() {
				System.out.println("手机开始工作");
			}

			@Override
			public void stop() {
				System.out.println("手机结束工作");
			}
			
		};
		c.transferData(phone);
		
		//4.创建了接口的匿名实现类的匿名对象
		c.transferData(new USB() {

			@Override
			public void start() {
				System.out.println("mp3开始工作");
			}

			@Override
			public void stop() {
				System.out.println("mp3结束工作");
			}
			
		});
	}
}

class Computer{
	public void transferData(USB usb) {
		usb.start();
		System.out.println("数据传输中");
		usb.stop();
	}
}

interface USB{
	int hight = 50;
	int wide = 150;
	
	void start();
	void stop();
}

class Flash implements USB{

	@Override
	public void start() {
		System.out.println("u盘开始工作");
	}

	@Override
	public void stop() {
		System.out.println("u盘结束工作");
	}
	
}
class Printer implements USB{
	
	@Override
	public void start() {
		System.out.println("打印机开始工作");
	}
	
	@Override
	public void stop() {
		System.out.println("打印机结束工作");
	}
	
}
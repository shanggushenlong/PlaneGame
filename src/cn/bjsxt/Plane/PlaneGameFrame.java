package cn.bjsxt.Plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.bjsxt.Util.Constant;
import cn.bjsxt.Util.GameUtil;
import cn.bjsxt.Util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
//	Image plane = GameUtil.getImage("images/plane.png"); 将飞机类独立封装起来
	Plane plane = new Plane("images/plane.png",100,100);
	
	//由于子弹的数量必须要多,所以采用ArrayList集合类
	ArrayList bulletList = new ArrayList();
	
	//计算飞机生存时间
	Date startTime;   //起始时间是在窗口刚刚加载的时候,从这一刻开始算
	Date endTime;     //结束时间是在飞机死亡的时候,
	
	Explode bz;
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);

		//遍历这堆子弹,将这堆子弹全部重画出来
		for(int i=0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			//每当重画一个子弹的时候,就进行一次碰撞检测
			boolean flag = b.getRect().intersects(plane.getRect());
			if(flag){
				plane.setLive(false);    //当碰撞发生的时候,设置值为false
//				endTime = new Date();    	//结束时间,如果写在这里,死亡时间会频繁的修改
				
				//加载爆炸类  当第一次碰到爆炸的时候,值为null,第二次不一样,将爆炸类声明在外面去,如果在里面声明,那么每次都会重新加载图片
				if(bz == null){
					bz = new Explode(plane.x,plane.y);
					endTime = new Date();    	//结束时间
				}
				bz.draw(g);
				
				break;
			}
		}
		//当游戏结束的时候,相关的提示文字应该一直都会打印
		if(!plane.isLive()){
			printInfo("Game Oval",g,50,Constant.GAME_WIDTH/3,Constant.GAME_HEIGHT/2,Color.WHITE);
			//计算存活时间   
//java.lang.NullPointerException:产生空指针异常,计算时间有错误,由于只有当飞机死亡的时候才能计算时间,所以必须放在死亡里面
			int period = (int)((endTime.getTime() - startTime.getTime())/1000);   //强制转型int
			printInfo("生存时间"+period+"秒",g,18,330,350,Color.WHITE);
			
			switch(period/10){
			case 0:
			case 1:
				printInfo("等级:菜鸟",g,30,310,390,Color.WHITE);
				break;
			case 2:
				printInfo("等级:普通",g,30,310,390,Color.WHITE);
				break;
			case 3:
				printInfo("等级:中等",g,30,310,390,Color.WHITE);
				break;
			case 4:
				printInfo("等级:高手",g,30,310,390,Color.WHITE);
				break;
			default:
				printInfo("等级:大师",g,30,310,390,Color.WHITE);
				break;
			}
		}	
	}
	/**
	 * 在窗口上打印信息
	 * @param args
	 */
	public void printInfo(String str,Graphics g,int size,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		//设置字体大小
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		
		g.drawString(str,x, y);
		g.setColor(c);
	}
	
	public static void main(String[] args){
		new PlaneGameFrame().launchFrame();
	}
	
	//现在要加入键盘的监听控制,重写父类的launchFrame方法
	public void launchFrame(){
		super.launchFrame();
		//增加键盘的监听
		this.addKeyListener(new KeyMonitor());
		
		//在窗口刚刚加载出来的时候,生成一堆子弹
		for(int i=0;i<50;i++){
			Bullet b = new Bullet();   //创建子弹类对象
			bulletList.add(b);		   //将子弹类加如到集合中
		}
		//起始时间
		startTime = new Date();
	}
	
	//写一个内部类,使用键盘来控制,可以方便的使用外部类普通属性
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
	//		System.out.println("按下:"+e.getKeyCode());   //在键盘按下去的时候,值为true
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e){ 
	//		System.out.println("释放:"+e.getKeyCode());  //在键盘弹起的时候,值为false;
			plane.loseDirection(e);
		}
	}
}














package codeExample;
/*
 * 里氏替换原则：
 * 如果对每一个类型为T1的对象 o1，都有类型为 T2 的对象o2，
 * 使得以 T1定义的所有程序 P 在所有的对象 o1 都代换成 o2 时，
 * 程序 P 的行为没有发生变化，那么类型 T2 是类型 T1 的子类型。
 */
public class LiskovSubstitutionPrinciple {
	/*
	 * 虚拟的抢,后面的枪不管如何实现的，都必须保证，shoot这个接口，实现的就是枪的射击，不同的枪的射击方式是不一样的，但是枪的射击理论上有一个共同的步骤
	 * 就是子弹出来，射向对方，具体如何我们不管，总之，子类在实现枪这个shoot这个射击方法的接口的时候，不能变成是装子弹，这个就违反了里氏替换原则了
	 * 这里是关键，就是射击的方法还是射击，虽然过程细节不一样，但还是射击
	 * 如果不明白为什么违反，那么请你再仔细思考下.
	 *
	 */
	static interface Gun{
	       public void shoot();
	}
	 
	//手枪实现Gun接口
	static class HandGun implements Gun{
	       public void shoot()
	       {
	              System.out.println("手枪射击");
	       }
	}
	 
	//AK47实现Gun接口
	static class AK47 implements Gun{
	       public void shoot()
	       {
	              System.out.println("AK47射击");
	       }
	}
	 
	//机枪实现Gun接口
	static class MachineGun implements Gun{
	       public void shoot()
	       {
	              System.out.println("机枪在装子弹");//这里就是违反了里氏替换原则原则,应改为机枪射击
	       }
	}
	 
	static class Hero{
	       String name;
	       Gun gun;
	       public Hero(String name)
	       {
	              this.name=name;
	       }
	      
	       public void setGun(Gun gun)
	       {
	              this.gun=gun;
	       }
	      
	       public Gun getGun(Gun gun)
	       {
	              return gun;
	       }
	      
	       public void shoot()
	       {
	              if(gun==null)
	              {
	                     System.out.println("没抢啦，快去拿把枪吧");
	                     return ;
	              }
	              gun.shoot();
	       }
	}
	 
	
     //普通的矩形
	static class Rectangle
       {
       	int height, width;

       	public int getWidth()
       	{
       		return width;
       	}

       	public void setWidth(int width)
       	{
       		this.width = width;
       	}

       	public int getHight()
       	{
       		return height;
       	}

       	public void setHeight(int height)
       	{
       		this.height = height;
       	}
       }

       /*
        * 因为Square的长宽相同，用一个size来统一 所以改写了父类的方法，因为它们实际上都是对size进行修改
        */
	static class Square extends Rectangle
       {
       	int size;

       	public int getWidth()
       	{
       		return size;
       	}

       	public void setWidth(int width)
       	{
       		this.size = width;
       	}

       	public int getHight()
       	{
       		return size;
       	}

       	public void setHeight(int height)
       	{
       		this.size = height;
       	}

       	public int getSize()
       	{
       		return size;
       	}

       	public void setSize(int size)
       	{
       		this.size = size;
       	}
       }
       	/**
       	 * 这个方法主要作用就是调整长方形的长宽，让长方形的width调整至比height更长。
       	 * 可是就是这样的方法，出问题了，因为如果穿进去的rec实际上是一个正方形的话，那么，程序会无限制的运行下去
       	 * 
       	 * @param rec
       	 * @return
       	 */
       	static void testRec(Rectangle rec)
       	{
       		while (rec.getWidth() <= rec.getHight())//
       		{
       			rec.setWidth(rec.getWidth()+1);
       		}
       	}

       	public static void main(String[] args)
       	{
       		//例子 1
            Hero hero=new Hero("神枪手");
            
            //给枪手配上AK47
            hero.setGun(new AK47());
            hero.shoot();
           
            //给枪手配上机枪
            hero.setGun(new MachineGun());
            hero.shoot();//本来想设计的，结果却变成了装子弹
                                 //这个还是属于比较明显的问题
           
            hero.setGun(new HandGun());
            hero.shoot();
       		
       		//例子2
       		Rectangle rec = new Square();
       		rec.setWidth(5);
       		rec.setHeight(6);
       		testRec(rec);// 就是这里出现问题了，这个方法会无限的运行下去，不信的话，你试试就ok了

       	}
     /*
      * 例子2出现了死循环， 原因存在于修改了父类中的属性，用size代替了height和width。这就违反了替换原则.想要区别对待正方形和矩形，可以抽象一个四边形的类，让两者继承他
      */

}

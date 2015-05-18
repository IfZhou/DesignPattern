package codeExample;
import java.util.*;
/*
 * 开闭原则：
 * 软件实体应当对扩展开放，对修改关闭
 */
public class OpenClosedPrinciple {
	//将技巧抽象为一个方法，单独拿出来
	static public  interface Skill{
		public void skill();
	};

	//詹姆斯的技巧
	static public class JamesSkill implements Skill{
		public void skill()
		{
			System.out.println("詹姆斯的技巧：战斧式扣篮");
		}
	};

	//科比的技巧
	static public class KobeSkill implements Skill{
		public void skill()
		{
			System.out.println("科比的技巧： 后仰跳投");
		}
	};

	//艾弗森的技巧
	static public class AISkill implements Skill{
		public void skill()
		{
			System.out.println("艾弗森的技巧： 变相");
		}
	};

	/*
		抽象的方法拿出来后，有不同的类来实现抽象方法这个接口，让不同的选手持有不同的行为类，这个设计方案叫做封装可变形。  同时，在后面的设计模式中我们也会讲到，这个叫做策略模式
	*/
	static public class NBAPlayer {
		//姓名
		private	String name;
		private Skill skill;

		public NBAPlayer(String name,Skill skill){
			this.name=name;
			this.skill=skill;
		}
		public void setSkill(Skill  skill){
			this.skill=skill;
		}
		public Skill  getSkill(){
			return skill;
		}
	    public String getName(){
	    	return name;
	    }
	    public void action(){
	    	skill.skill();
	    }
	};
	public static void main(String args[])
	{
		//不同的技巧
		OpenClosedPrinciple.Skill jamesSkill=new OpenClosedPrinciple.JamesSkill();
		OpenClosedPrinciple.Skill kobeSkill=new OpenClosedPrinciple.KobeSkill();
		OpenClosedPrinciple.Skill aiSkill=new OpenClosedPrinciple.AISkill();

		//不同的球员
		OpenClosedPrinciple.NBAPlayer james=new OpenClosedPrinciple.NBAPlayer("James",jamesSkill);
		OpenClosedPrinciple.NBAPlayer kobe=new OpenClosedPrinciple.NBAPlayer("kobe",kobeSkill);
		OpenClosedPrinciple.NBAPlayer ai=new OpenClosedPrinciple.NBAPlayer("AI",aiSkill);

		//会有不同的表现
		james.action();
		kobe.action();
		ai.action();
	}

}

/*
 * 思考：开闭原则，定义了很多NBAPlayer对象，这样方便添加一个新的对象，来实现新的action方法，这就体现了可以添加，但不允许修改旧代码的思想。
 * 而替换原则，只有一个Hero对象，可以选择其中一个继承了Gun接口的类，使用该类中的方法，这就体现了“替换”这个概念。
 */

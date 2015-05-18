package codeExample;
/*
 * 这里的接口，不是java语言内部的interface的意思，在这里，可以将接口理解为一个类提供的所有的方法的特征集合，通俗点说就是所有可见方法和可见变量（java的说法， c++的说法是可见函数和可见属性元素）。
 * 接口隔离原则：
 * 给对象的每个使用者一个单独的接口.其中只包含它们需要的方法,不要设计一个包含很多方法的接口让不需要这些继承接口的类去实现它们.
 * 一个类对于另一个类的依赖应当建立在最小的接口上，不应当依赖一些不需要的接口。
 */
public class InterfaceSegregationPrinciple {
	/**
	 * 考试抽象类
	 * 
	 * @author zhonghuan
	 */
	interface Exam
	{
		public void chinese();// 考语文

		public void math();// 考数学

		public void physics();// 考物理

		public void geolography();// 考地理
	}

	/**
	 * 文科生实现考试抽象类，文科生不考物理
	 * 
	 * @author zhonghuan
	 */
	class ExamForLiberalArtStu implements Exam
	{
		public void chinese()
		{
			System.out.println("考语文");
		}

		public void math()
		{
			System.out.println("考数学");
		}

		public void physics()
		{
			// "不考物理", 不用实现， 没有意义
		}

		public void geolography()
		{
			System.out.println("考地理");
		}
	}

	/**
	 * 理科生实现考试抽象类，理科生不考地理
	 * 
	 * @author zhonghuan
	 */
	class ExamForScienceStu implements Exam
	{
		public void chinese()
		{
			System.out.println("考语文");
		}

		public void math()
		{
			System.out.println("考数学");
		}

		public void physics()
		{
			System.out.println("考物理");
		}

		public void geolography()
		{
			// 理科生不考地理，不用实现没有意义
		}
	}
/*
 * 以上设计不太合是，有的方法在其实现类中没有实现，接口臃肿在方法较多的情况下，显得尤为不合适
 */
}
class InterfaceSegregationPrinciple_Right {
	///将原来的一个接口分为三个接口，一般考试接口，理科考试接口，文科考试接口，文科生和理科生都可以依赖最小的接口，而不用担心接口臃肿的问题。
	/**
	 * 考试抽象类
	 * 
	 * @author zhonghuan
	 */
	interface Exam
	{
		public void chinese();// 考语文

		public void math();// 考数学
	}

	/**
	 * 理科生考试接口
	 */
	interface ScienceExam
	{
		public void physics();// 考物理
	}

	/**
	 * 文科生考试接口
	 */
	interface LiberalArtExam
	{
		public void geolography();// 考地理
	}

	/**
	 * 文科生考试实现类
	 * 
	 * @author zhonghuan
	 */
	class ExamForLiberalArtStu implements Exam, LiberalArtExam
	{
		public void chinese()
		{
			System.out.println("考语文");
		}

		public void math()
		{
			System.out.println("考数学");
		}

		public void geolography()
		{
			System.out.println("考地理");
		}
	}

	/**
	 * 理科生考试实现类
	 * 
	 * @author zhonghuan
	 */
	class ExamForScienceStu implements Exam, ScienceExam
	{
		public void chinese()
		{
			System.out.println("考语文");
		}

		public void math()
		{
			System.out.println("考数学");
		}

		public void physics()
		{
			System.out.println("考物理");
		}
	}
/*
 * 原则：
 * 建立单一接口，不要建立庞大臃肿的接口，尽量细化接口，接口中的方法尽量少。
 * 也就是说，我们要为各个类建立专用的接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。
 * 在上面的例子中，原本依赖于一个大的抽象接口，改为依赖于3个更细化的抽象接口，可以避免接口的污染.
 */
}

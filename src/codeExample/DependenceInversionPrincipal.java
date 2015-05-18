package codeExample;
/*
 * 依赖倒转原则:
 * 依赖：A use B ，就说A对B产生了依赖。
 * 依赖关系种类：
 * 1.零耦合：类A中声明了B但没有使用。
 * 2.具体耦合：两个具体类（可实例化的）之间，经由一个类对另一个类的直接引用造成。类A声明并使用了B
 * 3.抽象耦合关系：一个具体类和一个抽象类（或者java接口）之间，使两个必须发生关系的类之间存在最大的灵活性。类A中声明接口B并使用了类B1.（B1是B的实现类）
 * 
 * 依赖倒转原则：抽象应当不依赖细节，细节应当依赖于抽象。Abstractions should not depend upon details， details should depend upon abstractions
 * 另一种表述是：要针对接口编程，不要针对实现编程。（Program to an interface， not an implementation）
 * 针对接口编程的意思就是说，应当使用java接口或者抽象java类进行变量的类型声明，参数的类型声明，方法的返回类型说明，以及数据类型的转换等。
 * 通俗点说，就是实现类只是实现  实现的接口或者继承的抽象类 中的方法，不要再声明新的变量或者新的方法，这样能够保证实现依赖倒转原则，当然这样有时也并不是好的方式，该原则是在合适的时候使用。
 */
public class DependenceInversionPrincipal {
	  interface IReader{  
		     public String getContent();  
	  }  
	  static class Newspaper implements IReader {  
		     public String getContent(){  
		         return "林书豪17+9助尼克斯击败老鹰……";  
		     }  
		}  
	  static   class Book implements IReader{  
		    public String getContent(){  
		         return "很久很久以前有一个阿拉伯的故事……";  
		    }  
		 }  	  
	public static class Mother{  
		    public void narrate(IReader reader){  
		        System.out.println("妈妈开始讲故事");  
				System.out.println(reader.getContent());  
		    }  
	}  
		  
 
    public static void main(String[] args){  
//        Mother mother = new Mother();  
//        mother.narrate(new Book());  
        /*
         * 运行结果：
			妈妈开始讲故事
			很久很久以前有一个阿拉伯的故事……
         */
        //此时Mother的nattate方法只能朗读书籍，不能有其他的类型，要实现多种类型，可以抽象一个IReader接口，其中包含getContent()方法，那么narrate只需要传入IReader就可以了。
        Mother mother = new Mother();  
        mother.narrate(new Book());  
        mother.narrate(new Newspaper());  
    }  
//其实就是抽象化参数和类型

}

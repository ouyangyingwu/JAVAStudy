package main.java.leagueOfLegends.charactor;

import main.java.leagueOfLegends.charactor.heroInterface.AD;

/*
 * 测试类型转换
*/
public class Hero1 {
    public String name;
    protected float hp;
 
    public Hero1(String name,float hp) {
		this.name = name;
        this.hp = hp;
		//System.out.println(name+"  的对血量是: "+ hp);
	}
    
    public static void main(String[] args) {
        ADHero ad = new ADHero("提莫", 383f, 14f, 330, 8);
        Hero h = ad;								//向上转型，不报错
        AD adi = (AD) h;							//	向上转型，不会报错；但是因为 h 指向的是 ADHero类位 AD的子类
        //APHero ap = (APHero) adi;		//	无继承关系的类之间转换，会报错
        
        // 测试 finalize 方法
        Hero1 temp = new Hero1("沃里克", 550f);
        ADHero temp1 = new ADHero("提莫", 383f, 14f, 330, 8);
        temp.equals(temp1);
        temp.toString();
        
        temp = new Hero1("嗜血狼人", 550f);
        for (int i = 0; i < 10000; i++) {
            //不断生成新的对象
            //每创建一个对象，前一个对象，就没有引用指向了
            //那些对象，就满足垃圾回收的条件
            //当，垃圾堆积的比较多的时候，就会触发垃圾回收
            //一旦这个对象被回收，它的finalize()方法就会被调用
        	temp = new Hero1("嗜血狼人", 550f);
        }
    }
    // 重写 object 垃圾回收方法
    public void finalize(){
        System.out.println(this.name+ " 这个英雄正在被回收");
    }
    // 重写 object 的toString
    public String toString(){
        System.out.println("重写的toString方法");
        return this.name + this.hp;
    }
 // 重写 object 的equals
    public boolean equals(Object o){
        System.out.println("重写的toStequals方法");
        boolean test = o instanceof Hero1;
        if(test)  System.out.println("对象是 Hero1 类");
        else  System.out.println("对象不是 Hero1 类");
        return super.equals(o);
    }
}


package main.java.leagueOfLegends.charactor;

import main.java.leagueOfLegends.charactor.heroInterface.AD;
import main.java.leagueOfLegends.charactor.heroInterface.AP;
import main.java.leagueOfLegends.charactor.heroInterface.Mortal;

// 物理英雄类
public class ADAPHero extends Hero implements AD,AP,Mortal {
	int physicalAttackPower;			//物理攻擊力
	int magicAttackPower;				//魔法攻擊力
	
	public static void main(String[] args) {
		ADAPHero teemo = new ADAPHero("提莫", 383f, 14f, 330,60,20);
		ADAPHero garen =  new ADAPHero("盖伦", 615f, 14f, 300,68,0);
        teemo.magicAttack(garen);
        teemo.attack1(garen);
        
        print(String.valueOf(garen.hp));
		/*
		 *	AD、AP 都有 attack 的默认方法，需要在类中重新写一个方法覆盖
		 */
        garen.attack();
    }
	
	//构造方法
	public ADAPHero(String name, float hp, float armor, int moveSpeed, int physicalAttackPower, int magicAttackPower) {
		super(name, hp, armor, moveSpeed);
		this.physicalAttackPower = physicalAttackPower;
		this.magicAttackPower = magicAttackPower;
	}
	
	/*
	 * 攻击方法，并且进行了两次重载
	*/
	public void attack() {
		 System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
	}
	public void attack(Hero h1) {
		 System.out.println(name + "对" + h1.name + "进行了一次攻击 ");
	}
	public void attack(Hero h1, Hero h2) {
		System.out.println(name + "同时对" + h1.name + "和" + h2.name + "进行了攻击 ");
	}
	// 可变数量的参数
    public void attack1(Hero... heros) {
    	int attackPower = this.magicAttackPower + this.physicalAttackPower;
        for (int i = 0; i < heros.length; i++) {
        	heros[i].hp -= attackPower;
            System.out.println(this.name + " 攻击了 " + heros[i].name+" 造成了 "+ attackPower + "点伤害；");
        }
    }
    
	/*
	 * 实现AD接口的攻击方法
	 */
    @Override
	public void physicAttack(ADAPHero temp) {
    	temp.hp -= this.physicalAttackPower;
    	System.out.println(this.name+" 对 "+temp.name+"进行物理攻击 , 造成 "+this.physicalAttackPower+" 点物理伤害");
	}
    
    /*
	 * 实现AP接口的攻击方法
	 */
    @Override
	public void magicAttack(ADAPHero temp ) {
    	temp.hp -= this.magicAttackPower;
    	System.out.println(this.name+" 对 "+temp.name+"进行魔法攻击 , 造成 "+this.magicAttackPower+" 点魔法伤害");
	}
    
    /*
	 * 实现AP接口的攻击方法
	 */
    @Override
    public void die() {
		print("ADAP英雄阵亡了");
	}
}

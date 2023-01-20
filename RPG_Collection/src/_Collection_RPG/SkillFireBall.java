package _Collection_RPG;

import java.util.Random;
import java.util.ArrayList;

public class SkillFireBall implements Skill{
	String info = "적전체에게 파이어볼로 공격합니다.";
	int skillPower;
	@Override
	public void skill(Unit unit) {
		System.out.println(info);
		ArrayList<Unit> monsterList = UnitManager.instance.monsterList;
		Random ran = GameManager.instance.ran;
		skillPower = ran.nextInt(25) + 25;
		for(Unit mon : monsterList) {
			if(mon.isDead == false) {
				unit.attack(mon);
			}
		}		
	}
}

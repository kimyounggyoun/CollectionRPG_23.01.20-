package _Collection_RPG;


import java.util.Random;
import java.util.ArrayList;

public class SkillHeal implements Skill{
	String info = "체력이 가장적은 아군의 체력을 회복합니다.";
	int skillPower;
	@Override
	public void skill(Unit unit) {
		ArrayList<Unit> playerList = UnitManager.instance.playerList;
		Random ran = GameManager.instance.ran;
		skillPower = ran.nextInt(25) + 25;
		int minHp = 100;
		Unit healUnit = null;
		for(Unit player : playerList) {
			if(player.isDead == false) {
				if(minHp > player.currentHp) {
					minHp = player.currentHp;
					healUnit = player;
				}
			}
		}		
		if(healUnit != null) {
			System.out.println(info);
			healUnit.currentHp += skillPower;
			System.out.printf("[msg] %s 가 %s 의 체력을 %d 회복합니다.",
			                    unit.name , healUnit.name , skillPower);
			System.out.println();
		}
	}
}

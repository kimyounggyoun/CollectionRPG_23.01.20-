package _Collection_RPG;

public class SkillPowerAttack implements Skill{
	String info = "적한명에게 공격력의 2배의 데미지를 입힙니다.";
	@Override
	public void skill(Unit unit) {
		System.out.println(info);
		
	}

}

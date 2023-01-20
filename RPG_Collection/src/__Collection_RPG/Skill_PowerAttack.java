package __Collection_RPG;

public class Skill_PowerAttack implements Skill {

	String info = "한명의 적에게 120% ~ 140% 데미지의 공격";
	
	@Override
	public void skill(Unit unit) {
		System.out.println(info);
	}

}

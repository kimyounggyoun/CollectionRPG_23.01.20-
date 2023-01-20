package __Collection_RPG;

public class Unit {
	String name;
	int hp;
	int maxHp;
	int power;
	boolean isDead;

	public Unit(String name, int maxHp, int Power) {
		super();
		this.name = name;
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.power = power;
		isDead = false;
	}

	void printUnit() {
		System.out.printf("[직업:%s][HP:%d/%d][ATK:%d]\n", name, hp, maxHp, power);
	}

	void attack(Unit unit) {
		unit.hp -= this.power;
		System.out.printf("[%s]가 [%s]에게 공격 \n [%d]의 데미지를 입혔다, \n", name, unit.name, power);
		if (unit.hp <= 0) {
			unit.hp = 0;
			unit.isDead = true;
			System.out.printf("[%s]는 쓰러졌다\n", unit.name);
		}
	}
}

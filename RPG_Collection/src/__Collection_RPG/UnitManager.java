package __Collection_RPG;

import java.util.ArrayList;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	ArrayList<Unit> playerList = new ArrayList<Unit>();
	ArrayList<Unit> monsterList = new ArrayList<Unit>();

	void init() {
		setPlayer();
	}

	void setPlayer() {
		playerList.clear();
		playerList.add(new UnitPlayer("전사", 100, 30, new Skill_PowerAttack()));
		playerList.add(new UnitPlayer("마법사", 80, 20, new Skill_PowerAttack()));
		playerList.add(new UnitPlayer("힐러", 60, 10, new Skill_PowerAttack()));
	}

	void setMonster() {
		monsterList.clear();
		monsterList.add(new Monster("늑대", 200, 5));
	}

}

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

	}

}

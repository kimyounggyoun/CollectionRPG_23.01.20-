package __Collection_RPG;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static GameManager instance = new GameManager();
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	String currentStageName = "";
	String nextStageName = "";

	void init() {
		UnitManager.instance.init();
		stageList.put("Title", new StageTitle()); // 이름 , Stage (implements) 받은 클래스
		stageList.put("Lobby", new StageLobby()); // 이름 , Stage (implements) 받은 클래스
		stageList.put("Battle", new StageBattle()); // 이름 , Stage (implements) 받은 클래스
		nextStageName = "Title";
		update();
	}

	void update() {
		while (changeStage(nextStageName) == false) {
			break;
		}
		System.out.println("[게임종료]");
	}

	boolean changeStage(String nextStageName) {
		if (nextStageName.equals(""))
			return false;
		if (currentStageName.equals(nextStageName))
			return true;

		currentStageName = nextStageName;
		Stage currentStage = stageList.get(currentStageName);
		currentStage.init();

		while (true) {
			if (currentStage.update()) {
				break;
			}
		}
		return true;
	}
}

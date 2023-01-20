package __Collection_RPG;

public class StageTitle implements Stage {

	@Override
	public void init() {
		System.out.println("[ T I T L E ]");
	}

	@Override
	public boolean update() {
		System.out.println("[ 타이틀 ]");
		System.out.println("[0.종료][1.시작]");
		int select = GameManager.instance.sc.nextInt();
		if (select == 1) {
			GameManager.instance.changeStage("Lobby");
			return false;
		} else if (select == 0) {
			GameManager.instance.changeStage("");
			return false;
		}
		return false;
	}

}

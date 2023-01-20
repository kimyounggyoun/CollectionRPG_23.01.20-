package _Collection_RPG;

public class StageTitle implements Stage{
	@Override
	public void init() {
		System.out.println("[메세지] 타이틀에 입장합니다.");
	}

	@Override
	public boolean update() {
		System.out.println("=====[타이틀]=====");
		System.out.println("[0.종료][1.시작]");
		int select = GameManager.instance.scan.nextInt();
		if(select == 1) {
			GameManager.instance.changeStage("Lobby");			
			return false;
		}else if(select == 0){
			GameManager.instance.changeStage("");	
			return false;
		}
		
		return true;
	}

}

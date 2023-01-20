package _Collection_RPG;


public class StageLobby implements Stage{

	@Override
	public void init() {
		System.out.println("[메세지] 로비에 입장합니다.");
		
	}

	@Override
	public boolean update() {
		while(true) {
			System.out.println("=====[로비]=====");
			System.out.println("[0.뒤로가기] [1.던전]");
			int select = GameManager.instance.scan.nextInt();
			if(select==1) {
				GameManager.instance.changeStage("Battle");	
				return false;
			}else if(select == 0){
				GameManager.instance.changeStage("Title");
				return false;
			}	
			
			return true;
		}			
	}
}

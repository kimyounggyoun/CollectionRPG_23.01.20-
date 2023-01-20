package _Collection_RPG;

import java.util.ArrayList;

public class StageBattle implements Stage{
	boolean turn;
	ArrayList<Unit> playerList;
	ArrayList<Unit> monsterList;
	@Override
	public void init() {
		UnitManager.instance.setMonster();		
		playerList = UnitManager.instance.playerList;
		monsterList = UnitManager.instance.monsterList;
		turn= true;
	}
	@Override
	public boolean update() {		
		boolean run = true;		
		while(run) {
			UnitManager.instance.printMonster();
			UnitManager.instance.printPlayer();	
			boolean allDead = false;
			if(turn) {	
				allDead = playerTurn();
			}else {
				allDead = monsterTurn();
			}
			if(allDead)break;
		}
		GameManager.instance.changeStage("Lobby");
		return false;		
	}
	boolean playerTurn() {
		 
		int playerSize = playerList.size();		
		int playerIndex = 0;
		while(true) {						
			UnitPlayer player = (UnitPlayer)playerList.get(playerIndex);
			System.out.printf("[%s turn] " , player.name);
			System.out.println("[1.공격] [2.스킬]");
			int sel = GameManager.instance.scan.nextInt();
			if(sel == 1) {						
				if(player.isDead== false) {
					player.normalAttack();
				}				
			}else if(sel == 2) {
				if(player.isDead== false) {
					player.skillAttack(player);
				}
			}
			if(allDead(monsterList)) return true;	
			
			
			playerIndex += 1;
			if(playerIndex >= playerSize) {
				turn = false;
				break;
			}
		}
		return false;
	}
	boolean allDead(ArrayList<Unit> unitList) {
		int alldead = unitList.size();
		for(Unit unit: unitList) {
			if(unit.isDead == true) {
				alldead -= 1;
			}
		}
		if(alldead == 0) return true;
		return false;
	}
	
	boolean monsterTurn() {
		
		int monsterSize = monsterList.size();		
		int monsterIndex = 0;
		while(true) {
			Monster monster = (Monster)monsterList.get(monsterIndex);
			System.out.printf("[%s 턴]",monster.name);
			if(monster.isDead==false) {
				monster.attack();
			}
			
			if(allDead(playerList)) {
				return true;
			}
			
			monsterIndex += 1;
			if(monsterIndex >= monsterSize) {
				turn = true;
				break;
			}
		}
		return false;
		
	}
}

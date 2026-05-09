package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hero> party=List.of(new Hero("Adi",100,20,15), new Hero("Partner",80, 15, 10));

        QuestLog log=new QuestLog();
        log.add(new Quest("Rat Problem", QuestPriority.LOW, 10, false));
        log.add(new Quest("Dragon Hunt", QuestPriority.URGENT,5000,true));
        log.add(new Quest("Save the Village", QuestPriority.HIGH,1000, false));
        log.add(new Quest("Decipher Runes", QuestPriority.NORMAL, 200, false));
        log.add(new Quest("Final Boss", QuestPriority.HIGH,2000,true));

        GuildHall hall=new GuildHall();
        Captain captain =new Captain("Leon", hall);
        Scout scout =new Scout("Swift",hall);
        new Healer("Mercy",hall);
        new Quartermaster("Hogger", hall);
        new Loremaster("Deckard",hall);

        System.out.println("--- Sorted by Reward (Extension) ---");
        QuestIterator rewardIt=new RewardSortedQuestIterator(log);
        while(rewardIt.hasNext()) System.out.println("Quest: "+rewardIt.next());

        CouncilEngine engine=new CouncilEngine();
        var result=engine.runCouncil(party, log, hall);

        System.out.println("\n--- Out-of-Council Communication ---");
        captain.issueOrder("ORDERS", "Prepare for Dragon Hunt!");
        hall.dispatch("LORE", scout, "Found ancient markings on the cave wall.");
        System.out.println("\n" + result);}
}
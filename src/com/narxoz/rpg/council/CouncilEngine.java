package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.GuildMediator;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;
import java.util.List;

public class CouncilEngine {

    public CouncilRunResult runCouncil(List<Hero> party, QuestLog questLog, GuildMediator hall) {
        int questsTraversed=0;
        int messagesRouted=0;

        System.out.println("--- Starting War Council Planning ---");
        QuestIterator priorityIterator = questLog.priorityAtLeast(QuestPriority.HIGH);
        while (priorityIterator.hasNext()) {
            Quest q=priorityIterator.next();
            questsTraversed++;
            hall.dispatch("ORDERS", null, "New High-Priority Mission: " + q.getTitle());
            hall.dispatch("REPORTS", null, "Scouting area for: " + q.getTitle());
            messagesRouted+=2;}
        return new CouncilRunResult(questsTraversed, messagesRouted, 4);
    }
}
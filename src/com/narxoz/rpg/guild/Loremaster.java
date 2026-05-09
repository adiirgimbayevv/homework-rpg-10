package com.narxoz.rpg.guild;

public class Loremaster extends GuildMember {
    public Loremaster(String name, GuildMediator mediator) { super(name, mediator); }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        if (topic.equals("LORE")) {
            System.out.println("[Loremaster "+getName() + "] Deciphered ancient secret: "+payload);}
    }
}
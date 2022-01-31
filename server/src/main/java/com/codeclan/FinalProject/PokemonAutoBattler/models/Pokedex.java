package com.codeclan.FinalProject.PokemonAutoBattler.models;

public class Pokedex {
     private int PokemonId;

     private boolean used;

     private int opponentsFainted;

     private long damageDealt;

     private long damageTaken;

     private int attacksUsed;

     private int attacksReceived;

     public Pokedex(int pokemonId, boolean used, int opponentsFainted, long damageDealt, long damageTaken, int attacksUsed, int attacksReceived) {
          PokemonId = pokemonId;
          this.used = used;
          this.opponentsFainted = opponentsFainted;
          this.damageDealt = damageDealt;
          this.damageTaken = damageTaken;
          this.attacksUsed = attacksUsed;
          this.attacksReceived = attacksReceived;
     }

     public int getPokemonId() {
          return PokemonId;
     }

     public void setPokemonId(int pokemonId) {
          PokemonId = pokemonId;
     }

     public boolean isUsed() {
          return used;
     }

     public void setUsed(boolean used) {
          this.used = used;
     }

     public int getOpponentsFainted() {
          return opponentsFainted;
     }

     public void setOpponentsFainted(int opponentsFainted) {
          this.opponentsFainted = opponentsFainted;
     }

     public double getDamageDealt() {
          return damageDealt;
     }

     public void setDamageDealt(long damageDealt) {
          this.damageDealt = damageDealt;
     }

     public double getDamageTaken() {
          return damageTaken;
     }

     public void setDamageTaken(long damageTaken) {
          this.damageTaken = damageTaken;
     }

     public int getAttacksUsed() {
          return attacksUsed;
     }

     public void setAttacksUsed(int attacksUsed) {
          this.attacksUsed = attacksUsed;
     }

     public int getAttacksReceived() {
          return attacksReceived;
     }

     public void setAttacksReceived(int attacksReceived) {
          this.attacksReceived = attacksReceived;
     }

     public void markUsed() {
          setUsed(true);
     }

     public int addToOpponentsFainted(int newOpponentsFainted) {
          opponentsFainted += newOpponentsFainted;
          return opponentsFainted;
     }

     public long addToDamageDealt(int newDamageDealt) {
          damageDealt += newDamageDealt;
          return damageDealt;
     }

     public long addToDamageTaken(int newDamageTaken) {
          damageTaken += newDamageTaken;
          return damageTaken;
     }

     public int addToAttacksUsed(int newAttacksUsed) {
          attacksUsed += newAttacksUsed;
          return attacksUsed;
     }

     public int addToAttacksRecieved(int newAttacksReceived) {
          attacksReceived += newAttacksReceived;
          return attacksReceived;
     }
}

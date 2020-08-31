package ua.azbest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreeSideBattle {

    public static final Random gen = new Random();

    public static void main(String[] args) {



    }

    private class Player {
        int idTarget;
        double hitProbability;
        boolean available;

        public void setIdTarget(int idTarget) {
            this.idTarget = idTarget;
        }

        public boolean isAvailable() {
            return available;
        }

        public int getIdTarget() {
            return idTarget;
        }

        public double getHitProbability() {
            return hitProbability;
        }

        public Player(double hitProbability) {
            this.hitProbability = hitProbability;
            this.available = true;
        }

        public void toUnvaliable() {
            this.available = false;
        }

        public void hitTarget(Player target) {
            if (available) {
                double hitChance = gen.nextDouble();
                if (hitChance <= hitProbability)
                    target.toUnvaliable();
            }
        }
    }

    private class Team {

        private final int playersCount = 3;
        List<Player> team = new LinkedList<>();

        public boolean hasWinner() {
            int left = playersCount;
            for (Player player: team) {
                if (!player.isAvailable())
                    left--;
                if (left == 1)
                    return true;
            }
            return false;
        }

        public int getWinnerId() {
            if (hasWinner()) {
                Iterator<Player> iterator = team.iterator();
                while (iterator.hasNext()) {
                    Player player = iterator.next();
                    if (player.isAvailable())
                        return player.getIdTarget();
                }
            }
            return -1;
        }

        public Player getStrongestPlayer() {
            int idTarget = 0;
            Player target = team.get(idTarget);
            while (!target.isAvailable())
                target = team.get(++idTarget);
            for (int i=idTarget+1; i<playersCount; i++) {
                if (team.get(i).isAvailable() && target.getHitProbability() < team.get(i).getHitProbability())
                    target = team.get(i);
            }
            return target;
        }

    }

}

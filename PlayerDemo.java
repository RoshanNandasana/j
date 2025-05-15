class Player {
    String playerName;
    int playerAge;
    
    void setInfo(String pName, int pAge) {
        playerName = pName;
        playerAge = pAge;
    }
    
    void showInfo() {
        System.out.println("Player Name: " + playerName);
        System.out.println("Age: " + playerAge);
    }
}

class Game extends Player {
    int odiMatches;
    int testMatches;
    
    void setInfo(String pName, int pAge, int odi, int test) {
        super.setInfo(pName, pAge);
        odiMatches = odi;
        testMatches = test;
    }
    
    void showInfo() {
        super.showInfo();
        System.out.println("ODI Matches: " + odiMatches);
        System.out.println("Test Matches: " + testMatches);
    }
}

class PlayerDemo {
    public static void main(String[] args) {
        Game[] players = new Game[5];
        int argIndex = 0;
        
        for(int i = 0; i < 5; i++) {
            players[i] = new Game();
            String name = args[argIndex++];
            int age = Integer.parseInt(args[argIndex++]);
            int odi = Integer.parseInt(args[argIndex++]);
            int test = Integer.parseInt(args[argIndex++]);
            
            players[i].setInfo(name, age, odi, test);
            System.out.println("\nPlayer " + i + " Details:");
            players[i].showInfo();
        }
    }
}
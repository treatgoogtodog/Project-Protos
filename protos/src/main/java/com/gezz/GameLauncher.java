package com.gezz;

public class GameLauncher {
    public static void main(String args[]){
        GameEngine gameEngine = new GameEngine();
        try{
            gameEngine.run()
        }catch (Exception e){
            System.err.println("An Error has ocurred!");
            e.printStackTrace();
        }finally{
            gameEngine.cleanup();
        }
    }
}

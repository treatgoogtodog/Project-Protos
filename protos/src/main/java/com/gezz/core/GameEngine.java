package com.gezz.core;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

public class GameEngine {

    private Window window;
    private InputHandler inputHandler;
    private GameLoop gameLoop;
    private boolean isRunning = false;

    public GameEngine(int width, int height, String name){
        this.window = new Window(width,height,name);
        this.inputHandler = new InputHandler();
        this.gameLoop = new GameLoop();
    }

    public void Init(){
        window.init();

        glClearColor(0, 0, 0, 0);

    }

    public void update(int deltaTime){

    }

    public void render(){
        window.swapBuffer();
    }

    public void run(){
        isRunning = true;
    }

    public boolean isRunning(){
        return isRunning;
    }

    public void cleanup(){
        window.cleanup();
        gameLoop.cleanup();
        inputHandler.cleanup();
    }
}

package com.gezz.core;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {

    private long Windowhandle;
    private String windowTitle;
    private int windowWidth;
    private int windowHeight;

    /**
     * Get necessery args for window creation
     * @param windowWidth Width of the window
     * @param windowHeight Height of the window
     * @param windowTitle Title of the window
     */

    public Window(int windowWidth, int windowHeight, String windowTitle){
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.windowTitle = windowTitle;
    }

    /**
     * Initialize window and necessery funcion. </br>
     * Note: By default, window will be created at center and V-Sync is enabled.
     */
    public void init(){
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW!");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        
        Windowhandle = glfwCreateWindow(windowWidth, windowHeight, windowTitle, 0L, 0L);
        if(Windowhandle == 0) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        GLFWVidMode VidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(Windowhandle, (VidMode.width() - windowWidth) / 2, (VidMode.height() - windowHeight)/2);

        glfwMakeContextCurrent(Windowhandle);

        glfwSwapInterval(1);

        glfwShowWindow(Windowhandle);
    }

    public void swapBuffer(){
        glfwSwapBuffers(Windowhandle);
    }
    //getters
    public long getWindow(){
        return Windowhandle;
    }

    public int getWidth(){
        return windowWidth;
    }

    public int getHeight(){
        return windowHeight;
    }

    public void cleanup(){
        glfwDestroyWindow(Windowhandle);
    }
}

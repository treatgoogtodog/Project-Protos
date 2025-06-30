package com.gezz.core;

import static org.lwjgl.glfw.GLFW.*;

import  org.lwjgl.glfw.*;


public class InputHandler {
    private long windowHanlde;
    
    private boolean[] keys = new boolean[GLFW_KEY_LAST + 1];
    private boolean[] mkeys = new boolean[GLFW_MOUSE_BUTTON_LAST + 1];
    
    private double _Mx, _My;

    private GLFWKeyCallback keyCallback;
    private GLFWMouseButtonCallback mButtonCallback;
    private GLFWCursorPosCallback cursorPosCallback;

    public InputHandler(long windowHanlde){
        this.windowHanlde = windowHanlde;

        glfwSetKeyCallback(windowHanlde, null);
        glfwSetMouseButtonCallback(windowHanlde, null);
        glfwSetCursorPosCallback(windowHanlde, null);

        for (int i = 0; i < keys.length; i++) {
            keys[i] = false;
        }

        for (int i = 0; i < mkeys.length; i++) {
            mkeys[i] = false;
        }

        keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key >= 0 && key <= GLFW_KEY_LAST) {
                    keys[key] = action != GLFW_RELEASE;
                }
            }
        };
        glfwSetKeyCallback(windowHanlde, keyCallback);

        mButtonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                if (button >= 0 && button <= GLFW_MOUSE_BUTTON_LAST) {
                    mkeys[button] = action != GLFW_RELEASE;
                }
            }
        };
        glfwSetMouseButtonCallback(windowHanlde, mButtonCallback);

        cursorPosCallback = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                _Mx = xpos;
                _My = ypos;
            }
        };
        glfwSetCursorPosCallback(windowHanlde, cursorPosCallback);
    }

    public int[] getMousePos() {
        return new int[] { (int) _Mx, (int) _My };
    }

    public boolean isKeyDown(int key) {
        return keys[key];
    }

    public boolean isMouseButtonDown(int button) {
        return mkeys[button];
    }

    public void cleanup() {
        keyCallback.close();
        mButtonCallback.close();
        cursorPosCallback.close();
    }
}

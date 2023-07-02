package com.amrita.jpl.cys21039.pt2;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 * @author Manbendra Satpathy
 */
public abstract class QuizGame {
    public abstract void startGame();

    abstract void askQuestion();
    abstract void evaluateAnswer();
}
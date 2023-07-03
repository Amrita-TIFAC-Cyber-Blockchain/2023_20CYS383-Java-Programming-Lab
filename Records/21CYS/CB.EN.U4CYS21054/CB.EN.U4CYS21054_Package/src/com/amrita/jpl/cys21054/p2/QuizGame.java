package com.amrita.jpl.cys21054.p2;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 * @author P Jivan Prasadd
 */
public abstract class QuizGame {
    public abstract void startGame();

    abstract void askQuestion();
    abstract void evaluateAnswer();
}
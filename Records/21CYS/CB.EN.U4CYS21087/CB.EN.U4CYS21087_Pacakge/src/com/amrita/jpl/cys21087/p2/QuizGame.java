package com.amrita.jpl.cys21087.p2;
import java.net.*;
import java.io.*;
import java.util.*;
public abstract class QuizGame {
    public abstract void startGame();

    abstract void askQuestion();
    abstract void evaluateAnswer();
}
package com.example;

import java.util.Random;

public class Joker {

    private static Random random = new Random();
    private static String[] jokes = {
            "Maybe if we start telling people the brain is an app they will start using it.",
            "If you can smile when things go wrong, you have someone in mind to blame.",
            "Before I tell my wife something important, I take both her hands in mine. That way she can't hit me with them.",
            "My speech today will be like a mini-skirt. Long enough to cover the essentials but short enough to hold your attention!",
            "The difference between \"Girlfriend\" and \"Girl Friend\" is that little space in between we call the \"Friend Zone\".",
            "Relationships are a lot like algebra. Have you ever looked at your X and wondered Y?",
            "Never laugh at your girlfriends choices... your one of them.",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it.",
            "A woman's mind is cleaner than a man's: She changes it more often.",
            "What do women and police cars have in common? They both make a lot of noise to let you know they are coming.",
            "Time waits for no man, time is obviously a woman."
    };

    public static  String getJoke(){
        return jokes[random.nextInt(jokes.length)];
    }

}

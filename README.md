# Hangman

A **Java console game** where players try to guess a secret word one letter at a time before running out of attempts.

---

## Description

This project implements the classic **Hangman** word-guessing game in Java.  
A random word is chosen from a small built-in library, and the player must guess the letters before their attempts run out.

The program validates user input, tracks wrong guesses, and updates the displayed word as correct guesses are made.

---

## Features

- Randomly selects a secret word from a word library  
- Tracks all guessed letters (correct and incorrect)  
- Validates user input (single character, alphabetical only, not guessed before)  
- Displays remaining attempts and current progress  
- Declares win or loss at the end of the game  

---

## How It Works

1. A random word is chosen from a list (`wordLibrary`)  
2. The program displays underscores (`_`) for each letter of the word  
3. The player enters a letter guess each round  
4. If the letter is in the word, it replaces the corresponding underscore(s)  
5. Incorrect guesses are stored and displayed  
6. The game ends when:
   - All letters are guessed (**player wins**)  
   - The player runs out of attempts (**player loses**)  

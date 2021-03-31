// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.

(START)

@SCREEN
D=A
@0
M=D

(CHECKIN)
@KBD
D=M
@BLACK
D;JGT
@WHITE
D;JEQ
@KEYCHECK
0;JMP

(BLACK)
@A1
M=-1
@FILL
0;JMP

(WHITE)
@A1
M=0
@FILL
0;JMP

(FILL)
@A1
D=M

@A0
A=M
M=D

@A0
D=M+1
@KBD
D=A-D

@A0
M=M+1
A=M

@FILL
D;JGT

@START
0;JMP
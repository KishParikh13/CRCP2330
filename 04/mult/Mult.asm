// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
//
// This program only needs to handle arguments that satisfy
// R0 >= 0, R1 >= 0, and R0*R1 < 32768.

// Put your code here.

@A2
M=0

@A0
D=M
@STEP
D;JGT

@DONE
0;JMP

(STEP)
@A2
D=M

@A1
D=D+M

@A2
M=D

@A0
D=M-1
M=D

@STEP
D;JGT

(DONE)
@DONE
0;JMP
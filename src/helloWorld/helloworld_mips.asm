.data
msg: .asciiz “\nHello, World!\n”
.text
main:
li $v0, 4
la $a0, msg
syscall

li $v0, 10
syscall

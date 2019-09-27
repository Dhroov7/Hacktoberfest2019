		.align 2
.LC0:
		.ascii "Hello World!\000"
		.text
		.align 2
		.global main
		.type main, %function
main:
		@ args = 0, pretend = 0, frame = 0
		@ frame_needed = 0, uses_anonymous_args = 0
		str	lr, [sp, #-4]!
		ldr r1, .L3
		sub sp, sp, #4
		mov r0, #1
		bl __printf_chk
		mov r0, #0
		add sp, sp, #4
		ldmfd sp!, {pc}
.L4:
		.align 2
.L3:
		.word .LC0
		.size main; .-main
		.ident "GCC: (Ubuntu 4.3.3-5ubuntu4) 4.3.3"
		.section	.note.GNU-stack,"",%progbits

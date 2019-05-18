#Ong Thao

#CSC 35 Project: Splat Squid Splat



.data 

Opening:
	
	.ascii "\nWelcome to Ong Thao's Squid Squid Splat!\n\nUnfortunately, because of lack of materials, there can only be a max of 5 squids who can enter.\nHow many squids wants to get splat? \0"



Players:
	
	.ascii "\n\nPlayer \0"


PlayerName:					#purpose of this table is to print out each player's name
	
	.quad FirstPlay
	
	.quad SecondPlay
	
	.quad ThirdPlay
	
	.quad FourthPlay
	
	.quad FifthPlay



FirstPlay:
	
	.ascii ": Marie\0"



SecondPlay:
	
	.ascii ": Pearl\0"



ThirdPlay:
	
	.ascii ": Marina\0"



FourthPlay:
	
	.ascii ": Callie\0"



FifthPlay:
	
	.ascii ": Captain Cuttlefish\0"



HealthPrompt:
	
	.ascii "\nHealth: \0"



Health:						#purpose of this table is to keep track of each player's health
	
	.quad 100
	
	.quad 100
	
	.quad 100
	
	.quad 100
	
	.quad 100



Num:
	
	.quad 0



Max:
	
	.quad 0



Target:
	
	.ascii "\nYour target: \0"



TargetDead:
	
	.ascii "\n\nThe player you are trying to attack is dead. Please choose another player.\0"



Attack:
	
	.ascii " them for \0"



Attack2: 
	
	.ascii " points.\n\0"



AttackNum:
	
	.quad 0



Win1:
	
	.ascii "\n\nThe winner is Player \0"



Win2:
	
	.ascii "!!! Congrats! Thanks for playing.\n\0"



Select:
	
	.ascii "\nSelect your ability: \n\0"



FirstP:
	
	.ascii "\n1) Splat Bomb \0"



FirstAtk:
	
	.ascii "(10+ Atk/80% chance)\n\0"



FirstP1:
	
	.ascii "\n2) Ink Storm \0"



SecondAtk:
	
	.ascii "(20+ Atk/60% chance)\n\0"



FirstP2:
	
	.ascii "\n3) InkStrike \0"



ThirdAtk:
	
	.ascii "(30+ Atk/40% chance)\n\0"



FirstP3:
	
	.ascii "\n4) Super Seanwich \0"



FourthHeal:
	
	.ascii "(1-50 Health/50% chance)\0"



Prompt:
	
	.ascii "\n\nWhich ability would you like to use? \0" 



First:
	
	.ascii "\n\nSplat Bomb\0"



Second:
	
	.ascii "\n\nInk Storm\0"



Third:
	
	.ascii "\n\nInkStrike\0"



Fourth:
	
	.ascii "\n\nSuper Seanwich\0"



Abilities:						#label to print each player's separate abilities
	
	.quad First
	
	.quad Second
	
	.quad Third
	
	.quad Fourth



Divider:
	
	.ascii "====================================================================================\n\n\0"



Miss:
	
	.ascii "\n\nOops! You slipped and your attack missed. You did 0 damage.\n\0"



Healed:
	
	.ascii "\n\nYay! You healed \0"



Healed1:
	
	.ascii " health! You are at \0"


Healed2:
	
	.ascii " health now.\n\0"


Heals:
	
	.quad 0


NoHeals:
	
	.ascii "\n\nOops! Looks like you got a bad Seanwich. No health was recovered.\n\0"



Place:
	
	.quad 0



Bomb:
	
	.ascii "             . . .\n              \|/\n            `--+--'\n              /|\ \n             ' | '\n               |\n               |\n           ,--'#`--.\n           |#######|\n        _.-'#######`-._\n     ,-'###############`-.\n   ,'#####################`,\n  /#########################\ \n |###########################|\n|#############################|\n|#############################|\n|#############################|\n|#############################|\n |###########################|\n  \#########################/\n   `.#####################,'\n     `._###############_,'\n        `--..#####..--'\n\nBOOM!\n\0"



Explosion:
	
	.ascii "\n\n     _.-^^---....,,--\n _--                  --_\n<                        >)\n|                         |\n \._                   _./\n    ```--. . , ; .--'''\n          | |   |\n       .-=||  | |=-.\n       `-=#$%&%$#=-'\n          | ;  :|\n _____.,-#%&$@%#&#~,._____\n\nWoosh! Woosh! Woosh! Explosion!\n\0"



Missiles:
	
	.ascii "\n\n     |\\**/|  |\\**/|  |\\**/|\n     \\ == /  \\ == /  \\ == /\n      |  |    |  |    |  |\n      |  |    |  |    |  |\n      \\  /    \\  /    \\  /\n       \\/      \\/      \\/\n\n\n\0"



MissileExplosion:
	
	.ascii "\n\n          _ ._  _ , _ ._\n        (_ ' ( `  )_  .__)\n      ( (  (    )   `)  ) _)\n     (__ (_   (_ . _) _) ,__)\n         `~~`\ ' . /`~~`\\ \n              ;   ;\n              /   \\ \n_____________/_ __ \\_____________\n\nStrike! Strike! Strike! EXPLOSION!\n\0"



Potion:
	
	.ascii "                       ____\n           .----------'    '-.\n          /  .      '     .   \\\\ \n         /        '    .      /|\n        /      .             \\\\ /\n       /  ' .       .     .  || |\n      /.___________    '    / //\n      |._          '------'| /|\n      '.............______.-' /\n      |-.                  | /\n      `\"\"\"\"\"\"\"\"\"\"\"\"-.....-'\n\n*chomp chomp* Mmmmm yummm~\n\0"



WinnerArt:
	
	.ascii "      _\n     /(|\n    (  :\n   __\  \\  _____\n (____)  `|\n(____)|   |\n (____).__|\n  (___)__.|_____\n\nGood Game!\n\n\n\0"



.text 

.global _start


_start:
	
	mov $Opening, %rcx				#Display title and first prompt
	
	call PrintCString				#store number into a label b/c will be using %rcx for something else	

	call Cyan
	
	call ScanInt					#get the number of players that are playing
	
	mov %rcx, Num
	
	mov %rcx, Max
	
	sub $1, Max
	
	call White	
	
	mov $0, %rax					#rax = 0, rax keeps track of our count
	
	cmp $1, Num
	
	je PNum

	

PrintInfo:					#purpose of label is to print the player's
		
	cmp $0, Health(, %rax, 8)		#cmp here to see if player is still alive
		
	jle Increment				#to check if curr player is dead, if they are then increment, if not move on
			mov $Players, %rcx 			#print out "Player 0"
		
	call PrintCString	
		
	mov %rax, %rcx				#print out the player's index
		
	call PrintInt			
		
	mov PlayerName(, %rax, 8), %rcx		#print out the player's name	
		
	call PrintCString
		
	mov $HealthPrompt, %rcx			#print out the HealthPrompt --> "Health: "
		
	call PrintCString	
		
	call Green				#set the color of player's health to "green"
		
	mov Health(, %rax, 8), %rcx 		#printing Health[index] 	
		
	call PrintInt
		
	call White
	
		
	mov $Select, %rcx			#print out player's abilities
		
	call PrintCString
		
	mov $FirstP, %rcx			#print out first ability (atk addition in red)
		
	call PrintCString
		
	call Red
		
	mov $FirstAtk, %rcx 
		
	call PrintCString
		
	call White
	
		
	mov $FirstP1, %rcx			#print out second ability (atk addition in red)
		
	call PrintCString
		
	call Red
		
	mov $SecondAtk, %rcx
		
	call PrintCString
		
	call White

		
	mov $FirstP2, %rcx			#print out third ability (atk addition in red)
		
	call PrintCString
		
	call Red
		
	mov $ThirdAtk, %rcx
		
	call PrintCString
		
	call White
		
		
	mov $FirstP3, %rcx			#print out fourth ability (amt that can potentially be healed in green)
		
	call PrintCString
		
	call Green
		
	mov $FourthHeal, %rcx
		
	call PrintCString
		
	call White	
	
		
	mov $Prompt, %rcx
		
	call PrintCString
		
	call Yellow
		
	call ScanInt				#get player's ability selection
		
	mov %rcx, %rbx
		
	call White 
		
	sub $1, %rbx
		
	cmp $3, %rbx
		
	je HealProb
		
	

TargetSelect:
		
	mov $Target, %rcx			#print out "Your target: "
		
	call PrintCString
		
	call Red				#setting input atk color to red
			
	call ScanInt				#get target's index			
		
	mov %rcx, %rdi				#move the target's index to rdi
		
	call White					
		
	jmp MissProb				#figuring out if the attack made misses or not

	

Atk1:	
		
	mov $Bomb, %rcx				#print out the ascii art associated with the atk move
		
	call PrintCString
		
	mov Abilities(, %rbx, 8), %rcx		#print out name of ability used
		
	call PrintCString			
		
	mov $Attack, %rcx			#print out the atk message
		
	call PrintCString
		
	mov $26, %rcx			
		
	call Random				#print and subtract a random number from target's health (in addition to atk pts)
		add $10, %rcx				#10 additional atk points are added to make atk stronger from use of ability
			mov %rcx, AttackNum
		
	call Red 
		
	mov AttackNum, %rcx
		
	call PrintInt
		
	call White
		
	mov $Attack2, %rcx
		
	call PrintCString
		
	mov $Divider, %rcx
		
	call PrintCString		
		
	mov AttackNum, %rcx
		
	sub %rcx, Health(, %rdi, 8)		#subtract the atk to the target's health
		
	cmp $0, Health(, %rdi, 8)		#if the target's health is zero, remove them from the game
		
	jle SubPlayer
		
	jmp Compare				#jmp to Compare to see how many players are left

	

Atk2:						#same as Atk1
		
	mov $Explosion, %rcx			#printing out ascii art associated with atk move
		
	call PrintCString
		
	mov Abilities(, %rbx, 8), %rcx		#print out name of ability used
		
	call PrintCString			
		
	mov $Attack, %rcx
		
	call PrintCString
		
	mov $26, %rcx				#random number from 0-25 added to ability atk points
		
	call Random
		
	add $20, %rcx				#20 atk points are added to attack to make atk stronger
		
	mov %rcx, AttackNum
		
	call Red
		
	mov AttackNum, %rcx
		
	call PrintInt				#by adding the additional atk points, it differentiates between the abilities
			call White					
		
	mov $Attack2, %rcx
		
	call PrintCString
		
	mov $Divider, %rcx
		
	call PrintCString		
		
	mov AttackNum, %rcx
		
	sub %rcx, Health(, %rdi, 8)	
		
	cmp $0, Health(, %rdi, 8)
		
	jle SubPlayer
		
	jmp Compare			

	

Atk3:						#same as Atk1
		
	mov $Missiles, %rcx			#print out ascii art associated with atk move
		
	call PrintCString
		
	mov $MissileExplosion, %rcx
		
	call PrintCString
		
	mov Abilities(, %rbx, 8), %rcx		
		
	call PrintCString			
		
	mov $Attack, %rcx		
		
	call PrintCString
		
	mov $26, %rcx				#get a random number from 0-25
		
	call Random
		
	add $30, %rcx				#30 atk points are added to attack to make atk stronger				
		mov %rcx, AttackNum
		
	call Red
		
	mov AttackNum, %rcx
		
	call PrintInt
		
	call White			
		
	mov $Attack2, %rcx
		
	call PrintCString
		
	mov $Divider, %rcx
		
	call PrintCString
		
	mov AttackNum, %rcx		
		
	sub %rcx, Health(, %rdi, 8)		
		
	cmp $0, Health(, %rdi, 8)		
		
	jle SubPlayer
		
	jmp Compare			
		
	

MissProb:					#switch statement for calculating probability of each atk	
		
	cmp $0, Health(, %rdi, 8)
		
	jle Dead
		
	cmp $0, %rbx
		
	je Likely
		
	cmp $1, %rbx
		
	je FairlyLikely
		
	cmp $2, %rbx
		
	je Unlikely
		
	jmp HealProb				#Heal is my default case to account for input validation			
			
	
Dead: 						#if the target player is dead, ask player to choose another player
		
	mov $TargetDead, %rcx
		
	call PrintCString
		
	jmp TargetSelect

	

Likely:
		
	mov $101, %rcx
		
	call Random
		
	cmp $20, %rcx				#There is an 80% chance of first ability succeeding
		
	jg Atk1
		
	jmp Missed

	

FairlyLikely:
		
	mov $101, %rcx
		
	call Random
		
	cmp $40, %rcx				#60% chance of second ability succeeding
		
	jg Atk2
		
	jmp Missed

	

Unlikely:
		
	mov $101, %rcx
		
	call Random
		
	cmp $60, %rcx				#40% chance of third ability succeeding
		
	jg Atk3
		
	jmp Missed

	

HealProb:
		
	mov $101, %rcx
		
	call Random
		
	cmp $50, %rcx				#50% chance of being able to heal oneself
		
	jg Heal
		
	jmp NoHeal

	

Heal:
		
	mov $Potion, %rcx			#print out ascii art associated with "healing"
		
	call PrintCString
		
	mov $Healed, %rcx
		
	call PrintCString
		
	mov $50, %rcx				#can recover a random number of 0-50 health 
		
	call Random
		
	add $1, %rcx				#add "1" here, so that any success will heal the player a certain amt 
		
	mov %rcx, Heals				#placeholder for additional Health to use rcx
		
	call Green				#setting the amount healed to "green"
		
	mov Heals, %rcx
		
	call PrintInt
		
	call White				#setting the forecolor back to "white"
		
	mov $Healed1, %rcx			#printing out healing prompt
		
	call PrintCString
		
	mov Heals, %rcx
		
	add %rcx, Health(, %rax, 8)		#adding the amount healed to player's health
		
	mov Health(, %rax, 8), %rcx
		
	call PrintInt				
		
	mov $Healed2, %rcx
		
	call PrintCString
		
	mov $Divider, %rcx			#separates each player's information
		
	call PrintCString
		
	jmp Compare

	

NoHeal:
		
	mov $NoHeals, %rcx			#prints out the prompt if the player loses the chance to heal
		
	call PrintCString
		
	mov $Divider, %rcx
		
	call PrintCString	
		
	jmp Compare	

	

Missed:
		
	mov $Miss, %rcx				#prints out the miss prompt if the player "misses"
		
	call PrintCString
		
	mov $Divider, %rcx			#a divider to help make the program look more organized
		
	call PrintCString
		
	jmp Compare	

	

Compare:					#purpose of Compare label is to figure out how many players we have left (while loop)
		cmp $1, Num
		
	je PNum					#if there is only one player left, go to PlayerNum
		
	jmp Increment				#if there are several players left, increment index by one and continue playing	



Increment:
		
	cmp Max, %rax				#this label increments or resets the index to move on
		
	je Zero
		
	add $1, %rax
		
	jmp PrintInfo
		
	

Zero:						#this label goes back to "zero" when max player is reached
		
	mov $0, %rax
		
	jmp PrintInfo

	

PNum:	 					#purpose of this label is to figure out which player is the winner and find their index
		mov $0, %rdi

	

Loop:						#Loop until we find the player that still has health
		
	cmp $0, Health(, %rdi, 8)		#compare the player's health to see if they are the winner	
		
	jle Add					#increment if the player is a loser
		
	jmp Winner				#print out winner message if the current player is the Winner

	

Add:
		
	add $1, %rdi
		
	jmp Loop
			
	

SubPlayer:					#purpose of this label is to keep track of the remaining players by taking out players
		sub $1, Num
		
	jmp Compare
	
	

Red:						#setting color of texts to red
		
	mov $1, %rcx
		
	call SetForeColor
		
	ret
	
	

Green:						#setting color of texts to Green
		
	mov $2, %rcx
		
	call SetForeColor
		
	ret

	

White:						#setting color of texts to White
		
	mov $7, %rcx
		
	call SetForeColor
		
	ret
	
	

Yellow:						#setting color of texts to Yellow
		
	mov $3, %rcx
		
	call SetForeColor
		
	ret
	
	

Cyan:						#setting color of texts to Cyan
		
	mov $6, %rcx
		
	call SetForeColor
		
	ret

	

Winner:						#prints out the winner message and end the game
		
	mov $Win1, %rcx
		
	call PrintCString
		
	mov %rdi, %rcx
		
	call PrintInt
		
	mov $Win2, %rcx
		
	call PrintCString
		
	mov $WinnerArt, %rcx			#print out ascii art associated with "Winning"
		
	call PrintCString
		
	call EndProgram				#once we find a winner, we "end" the program

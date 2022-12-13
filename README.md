# minesweeper
looks like a tough project but here we go!
coding minesweeper in the command line for AP Comp Sci A

important planning:
game: printing board, flagging, flipping, winning/losing
grid: stores info (2d array of tile objects)
tile: flipped/unflipped, mine/safe

TODO:
add colors all the way up to 8
print "safe tiles left" every turn

// f 0 0
// 0 0
// debug
if it's not one of these things, make user input again

Color coding:
reset: \u001B[0m

any questions: italic cyan \u001B[0m\u001B[3m\u001B[36m
parentheicals: underline yellow \u001B[0m\u001B[4m\u001B[33m
game info: bold green \u001B[0m\u001B[1m\u001B[32m
errors: bold red \u001B[0m\u001B[1m\u001B[31m

debug: \u001B[0m\u001B[7m\u001B[31m\u001B[40m
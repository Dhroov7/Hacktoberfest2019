import argparse
from AppKit import NSScreen
from pyautogui import moveTo

delta = 5

args = argparse.ArgumentParser()
args.add_argument("-d", "--delta", required=True, help="mouse move speed")
delta = int(vars(args.parse_args())["delta"])

point = (delta, delta)
add_point = (delta, delta)

WIDTH = int(NSScreen.mainScreen().frame().size.width)
HEIGHT = int(NSScreen.mainScreen().frame().size.height)

print("WIDTH: {WIDTH}, HEIGHT: {HEIGHT}".format(WIDTH=WIDTH, HEIGHT=HEIGHT))

if WIDTH % delta + HEIGHT % delta > 0:
	raise Exception("WIDTH and HEIGHT must be delta's multiple")

add = lambda x, y: (x[0] + y[0], x[1] + y[1])

if __name__ == "__main__":
	while True:
		moveTo(point)
		point = add(point, add_point)
		if point[0] in (delta, WIDTH):
			add_point = (-1 * add_point[0], add_point[1])
		if point[1] in (delta, HEIGHT):
			add_point = (add_point[0], -1 * add_point[1])
import turtle as t
import random

# Set up the Turtle screen
t.speed(0)  # Set the drawing speed to the maximum
t.bgcolor("white")  # Set the background color to white
t.title("Maze Generator")

# Set up the maze parameters
maze_size = 100  # Size of the maze in units
cell_size = 4  # Size of each maze cell in units
entrance = (0, maze_size // 2)  # Entrance coordinates (left side)
exit = (maze_size - 1, maze_size // 2)  # Exit coordinates (right side)

# Initialize the maze grid
maze = [[1] * maze_size for _ in range(maze_size)]

# Function to check if a cell is within the maze boundaries
def is_inside(x, y):
    return 0 <= x < maze_size and 0 <= y < maze_size

# Function to check if a cell has unvisited neighbors
def has_unvisited_neighbors(x, y):
    for dx, dy in [(0, 2), (2, 0), (0, -2), (-2, 0)]:
        nx, ny = x + dx, y + dy
        if is_inside(nx, ny) and maze[ny][nx] == 1:
            return True
    return False

# Function to carve a path using random depth-first search
def carve_path(x, y):
    maze[y][x] = 0  # Mark the current cell as visited
    directions = [(0, 2), (2, 0), (0, -2), (-2, 0)]
    random.shuffle(directions)

    for dx, dy in directions:
        nx, ny = x + dx, y + dy
        if is_inside(nx, ny) and maze[ny][nx] == 1:
            t.forward(2)  # Move forward by two units
            carve_path(nx, ny)
            t.backward(2)  # Move backward by two units

# Function to draw the maze walls
def draw_maze():
    t.penup()
    for y in range(maze_size):
        for x in range(maze_size):
            if maze[y][x] == 1:
                t.goto(x * cell_size - maze_size * cell_size / 2, maze_size * cell_size / 2 - y * cell_size)
                t.pendown()
                t.forward(cell_size)
                t.right(90)
    t.hideturtle()

# Function to draw the path from entrance to exit
def draw_path():
    t.penup()
    x, y = entrance
    t.goto(x * cell_size - maze_size * cell_size / 2 + cell_size / 2, maze_size * cell_size / 2 - y * cell_size)
    t.pendown()
    t.pencolor("red")
    for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
        nx, ny = x + dx, y + dy
        if is_inside(nx, ny) and maze[ny][nx] == 0:
            t.setheading(t.towards(nx * cell_size - maze_size * cell_size / 2 + cell_size / 2,
                                    maze_size * cell_size / 2 - ny * cell_size))
            t.forward(cell_size)

# Generate the maze
t.penup()
t.goto(-maze_size * cell_size / 2, maze_size * cell_size / 2)
t.pendown()
carve_path(entrance[0], entrance[1])

# Draw the maze
draw_maze()

# Draw the path
draw_path()

# Close the Turtle graphics window on click
t.exitonclick()
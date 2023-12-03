const canvas = document.getElementById("flappyBirdCanvas");
const ctx = canvas.getContext("2d");

const bird = { x: 100, y: canvas.height / 2 - 10, width: 20, height: 20, color: "#f78f5d" };
const gravity = 0.10;
let velocity = 0;
const jumpStrength = 4;
const columns = [];
let score = 0;
let speed = 2;
let gameOver = true;

function sendScoreToBackend(score) {
    // Using fetch API to send a POST request to the Spring Boot endpoint
    fetch('/submitScore', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(score),
    })
        .then(response => {
            if (!response.ok) {
                console.error('Failed to submit score');
            }
        })
        .catch(error => console.error('Error:', error));
}

function drawBackground() {
    // Sky
    ctx.fillStyle = "#6bc8f1";
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    // Grass
    ctx.fillStyle = "green";
    ctx.fillRect(0, canvas.height - 20, canvas.width, 20);
}

function drawBird() {
    ctx.fillStyle = bird.color;
    ctx.fillRect(bird.x, bird.y, bird.width, bird.height);
}

function drawColumn(column) {
    ctx.fillStyle = "green";
    ctx.fillRect(column.x, column.y, column.width, column.height);
}

function draw() {
    if (gameOver) {
        ctx.fillStyle = "black";
        ctx.font = "30px Arial";
        sendScoreToBackend(score);
        const textWidth = ctx.measureText("Game over!").width;
        ctx.fillText("Game over!", canvas.width / 2 - textWidth / 2, canvas.height / 2);
        return;
    }

    ctx.clearRect(0, 0, canvas.width, canvas.height);

    drawBackground();
    drawBird();

    for (const column of columns) {
        drawColumn(column);
        column.x -= speed; // Move columns to the left
    }

    // Remove off-screen columns
    columns.forEach((column, index) => {
        if (column.x + column.width < 0) {
            columns.splice(index, 1);
            if (columns.length < 2) { // Add a new pair of columns when there are fewer than 2 columns
                createColumn();
            }
            score = score + 0.5;

            if (speed < 4) {
                if (score % 5 === 0) {
                    speed += 1;
                }
            }

            else if (speed < 7) {
                if (score % 20 === 0) {
                    speed += 1;
                }
            }
        }
    });

    ctx.fillStyle = "black";
    ctx.font = "20px Arial";
    ctx.fillText("Score: " + score, 20, 30);

    bird.y += velocity;
    velocity += gravity;

    // Check for collisions with the top boundary
    if (bird.y < 0) {
        bird.y = 0;
        velocity = 0;
        gameOver = true;
    }

    if (bird.y + bird.height > canvas.height - 15) {
        // Bird touches the grass
        gameOver = true;
        bird.y = canvas.height - 15 - bird.height;
    }

    // Check for collisions
    for (const column of columns) {
        if (
            bird.x < column.x + column.width &&
            bird.x + bird.width > column.x &&
            bird.y < column.y + column.height &&
            bird.y + bird.height > column.y
        ) {
            gameOver = true;
        }
    }

    requestAnimationFrame(draw);
}

function getHighScore() {
    // Using fetch API to get the high score from the Spring Boot endpoint
    return fetch('/highscore')
        .then(response => response.json())
        .catch(error => {
            console.error('Error:', error);
            return 0; // Default value if there's an error
        });
}

function jump() {
    if (gameOver) {
        resetGame();
    }
    velocity = -jumpStrength;
}

function resetGame() {
    bird.y = canvas.height / 2 - 10;
    velocity = 0;
    score = 0;
    speed = 2;
    gameOver = false;
    columns.length = 0;

    createColumn();
}

function createColumn() {
    const columnGap = 150;
    const columnWidth = 50;
    const minHeight = 50;
    const maxHeight = canvas.height - columnGap - minHeight;

    const height = Math.random() * (maxHeight - minHeight) + minHeight;
    columns.push({ x: canvas.width + columnGap, y: 0, width: columnWidth, height });
    columns.push({ x: columns[columns.length - 1].x, y: height + columnGap, width: columnWidth, height: canvas.height - (height + columnGap) });
}

canvas.addEventListener("click", (event) => {
    const rect = canvas.getBoundingClientRect();
    const clickX = event.clientX - rect.left;
    const clickY = event.clientY - rect.top;

    if (clickX >= 0 && clickX <= canvas.width && clickY >= 0 && clickY <= canvas.height) {
        if (gameOver) {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            resetGame();
            draw();
        } else {
            jump();
        }
    }
});

ctx.fillStyle = "white";
ctx.font = "30px Arial";
const textWidth = ctx.measureText("Click to Start").width;
ctx.fillText("Click to Start", canvas.width / 2 - textWidth / 2, canvas.height / 2);
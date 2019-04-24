<template>
  <div class="board">
    <!-- 8 -->
    <div>8</div>
    <div class='tile1'><img src="../assets/black_bishop.png" class="center"></div>
    <div class='tile2'><img src="../assets/black_bishop.png" class="center"></div>
    <div class='tile1'><img src="../assets/black_knight.png" class="center"></div>
    <div class='tile2'><img src="../assets/black_king.png" class="center"></div>
    <div class='tile1'><img src="../assets/black_rook.png" class="center"></div>
    <div class='tile2'><img src="../assets/black_rook.png" class="center"></div>
    <div class='tile1'><img src="../assets/black_pawn.png" class="center"></div>
    <div class='tile2'><img src="../assets/black_pawn.png" class="center"></div>
    <!-- 7 -->
    <div>7</div>
    <div class='tile2'><img src="../assets/black_pawn.png" class="center"></div>
    <div class='tile1'><img src="../assets/black_rook.png" class="center"></div>
    <div class='tile2'><img src="../assets/black_queen.png" class="center"></div>
    <div class='tile1'><img src="../assets/black_queen.png" class="center"></div>
    <div class='tile2'><img src="../assets/black_rook.png" class="center"></div>
    <div class='tile1'><img src="../assets/black_pawn.png" class="center"></div>
    <div class='tile2'><img src="../assets/black_pawn.png" class="center"></div>
    <div class='tile1'><img src="../assets/black_bishop.png" class="center"></div>
    <!-- 6 -->
    <div>6</div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <!-- 5 -->
    <div>5</div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <!-- 4 -->
    <div>4</div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <!-- 3 -->
    <div>3</div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <div class='tile2'></div>
    <div class='tile1'></div>
    <!-- 2 -->
    <div>2</div>
    <div class='tile1'><img src="../assets/white_pawn.png" class="center"></div>
    <div class='tile2'><img src="../assets/white_knight.png" class="center"></div>
    <div class='tile1'><img src="../assets/white_knight.png" class="center"></div>
    <div class='tile2'><img src="../assets/white_queen.png" class="center"></div>
    <div class='tile1'><img src="../assets/white_rook.png" class="center"></div>
    <div class='tile2'><img src="../assets/white_queen.png" class="center"></div>
    <div class='tile1'><img src="../assets/white_rook.png" class="center"></div>
    <div class='tile2'><img src="../assets/white_pawn.png" class="center"></div>
    <!-- 1 -->
    <div>1</div>
    <div class='tile2'><img src="../assets/white_bishop.png" class="center"></div>
    <div class='tile1'><img src="../assets/white_bishop.png" class="center"></div>
    <div class='tile2'><img src="../assets/white_knight.png" class="center"></div>
    <div class='tile1'><img src="../assets/white_rook.png" class="center"></div>
    <div class='tile2'><img src="../assets/white_king.png" class="center"></div>
    <div class='tile1'><img src="../assets/white_queen.png" class="center"></div>
    <div class='tile2'><img src="../assets/white_queen.png" class="center"></div>
    <div class='tile1'><img src="../assets/white_pawn.png" class="center"></div>
    <div></div>
    <div>a</div>
    <div>b</div>
    <div>c</div>
    <div>d</div>
    <div>e</div>
    <div>f</div>
    <div>g</div>
    <div>h</div>
  </div>
</template>

<script>
export default {
}
</script>

<style scoped>
.board {
  margin: 0 auto;
  width: 500px;
  display: grid;
  grid-template-columns: repeat(9, 1fr);
  grid-auto-rows: minmax(50px, auto);
}

.tile1 {
  border: 1px solid #333;
  background-color: red;
}

.tile2 {
  border: 1px solid #333;
  background-color: pink;
}

.center {
  display: block;
  width: 50px;
  height: 50px;
  margin: 0 auto;
}

.highlight {
  background-color: green;
}
</style>

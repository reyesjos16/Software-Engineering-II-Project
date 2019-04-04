<template>
  <div id="app">
    <div></div>
    <Board1></Board1>
    <Board2></Board2>
    <Board3></Board3>
    <Board4></Board4>
    <Board5></Board5>
  </div>
</template>

<script>
import Board1 from './components/Board1.vue'
import Board2 from './components/Board2.vue'
import Board3 from './components/Board3.vue'
import Board4 from './components/Board4.vue'
import Board5 from './components/Board5.vue'

export default {
  name: 'app',
  components: {
    Board1,
    Board2,
    Board3,
    Board4,
    Board5
  }
}
</script>

<style>
#app {
  background-color: grey;
  padding: 5em;
}
</style>

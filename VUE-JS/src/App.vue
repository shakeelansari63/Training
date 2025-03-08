<script setup lang="ts">
import { ref } from 'vue'
import MyButton from './components/MyButton.vue'

const count = ref<number>(0)

const countUp = () => {
  count.value++
}
</script>

<template>
  <MyButton @click="countUp">Click me !!</MyButton>
  <div>Counter: {{ count }}</div>
</template>

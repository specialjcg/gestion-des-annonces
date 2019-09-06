<template>
  <v-app>
    <v-content>
      <ListeOffres />
    </v-content>
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import ListeOffres from "./components/ListeOffres.vue";

export default Vue.extend({
  name: "App",
  components: {
    ListeOffres
  },
  data: () => ({
    //
  })
});
</script>

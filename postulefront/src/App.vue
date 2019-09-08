<template>
  <v-app>
    <v-content>
      <ListeOffers />
    </v-content>
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import ListeOffers from "./components/ListeOffers.vue";

export default Vue.extend({
  name: "App",
  components: {
    ListeOffers
  },
  data: () => ({
    //
  })
});
</script>

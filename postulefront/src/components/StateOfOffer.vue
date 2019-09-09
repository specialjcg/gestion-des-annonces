<template>
     <v-card-actions>
      <v-chip-group
        :value="state"
        active-class="red darken-2 accent-4 white--text"
        mandatory
      >
        <v-chip :color="mycolor2">encour</v-chip>
        <v-chip :color="mycolor2">entretien</v-chip>
        <v-chip :color="mycolor2">negatif</v-chip>
        <v-chip :color="mycolor2">attente mission</v-chip>
      </v-chip-group></v-card-actions
    >
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";

import { Offer } from "../domain/Offer";

@Component({})
export default class StateOfOffer extends Vue {
  @Prop() state: number | undefined;

 
  mycolor2: string = "rgba(93, 211, 158, 1)";
  
}
</script>

<style lang="scss" scoped>
</style>

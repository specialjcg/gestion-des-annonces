<template>
   <v-menu
            ref="menu"
            v-model="menu"
            :close-on-content-click="false"
            :return-value.sync="eventi.time"
            transition="scale-transition"
            offset-y
            min-width="290px"
          >
            <template v-slot:activator="{ on }">
              <v-text-field
                v-model="eventi.timeformat"
                prepend-icon="mdi-calendar"
                readonly
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker v-model="eventi.time" no-title scrollable>
              <div class="flex-grow-1"></div>
              <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.menu.save(eventi.time)"
                >OK</v-btn
              >
            </v-date-picker>
          </v-menu>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";

import { Offer } from "../domain/Offer";

@Component({})
export default class DateTimeOfOffer extends Vue {
  @Prop() eventi: Offer | undefined;

  menu: boolean = false;
  mycolor2: string = "rgba(93, 211, 158, 1)";
  
}
</script>

<style lang="scss" scoped>
</style>

<template>
  <v-menu
    ref="menu"
    v-model="menu2"
    :close-on-content-click="false"
    :nudge-right="40"
    :return-value.sync="time"
    transition="scale-transition"
    offset-y
    min-width="290px"
  >
    <template v-slot:activator="{ on }">
      <v-text-field
        v-model="timeformat"
        prepend-icon="mdi-clock"
        readonly
        v-on="on"
      ></v-text-field>
    </template>
    <v-time-picker
      v-if="menu2"
      v-model="time"
      full-width
      @click:minute="setMinute()"
    ></v-time-picker>
  </v-menu>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";
import { OfferService } from "../services/OfferService";
import { Offer } from "../domain/Offer";

@Component({})
export default class TimeOfOffer extends Vue {
  @Prop() eventi: Offer | undefined;

  setMinute() {
    var event = new Date(this.eventi.time);
    event.setHours(
      parseInt(this.time.split(":")[0]),
      parseInt(this.time.split(":")[1])
    );
    this.timeformat = moment(event).format("LT");
    this.eventi.time=event;
    this.menu2=false;
  }
  timeformat: string = moment(this.eventi.time).format("LT");
  time: string = this.timeformat;
  menu2: boolean = false;
  mycolor2: string = "rgba(93, 211, 158, 1)";
}
</script>

<style lang="scss" scoped></style>

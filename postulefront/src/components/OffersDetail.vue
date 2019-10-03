<template>
  <v-card class="mx-auto" width="500px" elevation-24 :color="mycolor1">
    <LoadImage :eventi="eventi"></LoadImage>
    <LoadLink :eventi="eventi"></LoadLink>
    <v-layout row justify-space-around>
      <v-flex md3>
        <DateTimeOfOffer :eventi="eventi"></DateTimeOfOffer>
      </v-flex>
      <v-flex md3>
        <TimeOfOffer :eventi="eventi"></TimeOfOffer>
      </v-flex>
    </v-layout>

    <TagOfOffer :eventi="eventi"></TagOfOffer>

    <StateOfOffer :eventi="eventi"></StateOfOffer>

    <SaveDeleteOffer :eventi="eventi"></SaveDeleteOffer>
  </v-card>
</template>
<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";
import { Offer } from "../domain/Offer";
import StateOfOffer from "../components/StateOfOffer.vue";
import DateTimeOfOffer from "../components/DateTimeOfOffer.vue";
import TimeOfOffer from "../components/TimeOfOffer.vue";
import TagOfOffer from "../components/TagOfOffer.vue";
import SaveDeleteOffer from "../components/SaveDeleteOffer.vue";
import LoadImage from "../components/LoadImage.vue";
import LoadLink from "../components/LoadLink.vue";

@Component({
  components: {
    StateOfOffer,
    DateTimeOfOffer,
    TagOfOffer,
    SaveDeleteOffer,
    LoadImage,
    TimeOfOffer,
    LoadLink
  }
})
export default class OfferDetail extends Vue {
  @Prop() eventi: Offer | undefined;

  events: Offer[] = [];

  mycolor1: string = "rgba(188, 231, 132, 1)";
  mycolor2: string = "rgba(93, 211, 158, 1)";
  mycolor3: string = "rgba(52, 138, 167, 1)";
  mycolor4: string = "rgba(82, 81, 116, 1)";
  mycolor5: string = "rgba(81, 59, 86, 1)";

  input: string = "";
  dialog: boolean = false;

  mounted() {
    moment.locale("fr");
  }

  // Les méthodes peuvent être déclarées comme des méthodes d'instance
}
</script>

<style lang="scss" scoped></style>

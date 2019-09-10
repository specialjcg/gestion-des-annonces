<template>
  <v-container style="max-width: 600px;">
    <v-progress-circular
      :rotate="360"
      :size="nbDemandemax"
      :width="15"
      :value="nbDemande"
      :key="nbDemande"
      color="teal"
    >
      {{ nbDemande }}
    </v-progress-circular>
    <v-timeline dense clipped>
      <v-timeline-item
        fill-dot
        class="white--text mb-12"
        :color="mycolor3"
        large
        icon="mdi-book-variant "
      >
        <v-text-field
          :value="input"
          hide-details
          flat
          label="entrer un nouveau post"
          solo
          @keydown.enter="comment()"
        >
          <template v-slot:append>
            <v-btn class="mx-0" depressed @click.prevent="incrementOffer()">
              nblist
            </v-btn>
            <v-btn class="mx-0" depressed @click.prevent="loadOffer()">
              Charge
            </v-btn>
            <v-btn class="mx-0" depressed @click.prevent="comment()">
              Post
            </v-btn>
          </template>
        </v-text-field>
      </v-timeline-item>

      <v-slide-x-transition group v-show="loading">
        <v-timeline-item
          class="mb-6"
          hide-dot
          v-for="eventi in timeline()"
          :key="eventi.id"
        >
          <OffersDetail :eventi="eventi"></OffersDetail>
        </v-timeline-item>
      </v-slide-x-transition>
    </v-timeline>
  </v-container>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch } from "vue-property-decorator";
import moment from "moment";
import { Features } from "../domain/Features";
import { Offer } from "../domain/Offer";
import { Offerjson } from "../domain/OfferJson";
import { OfferService } from "../services/OfferService";
import OffersDetail from "../components/OffersDetail.vue";

@Component({ components: { OffersDetail } })
export default class ListeOffers extends Vue {
  // Les données initiales peuvent être déclarées comme des propriétés de l'instance

  events: Offer[] = [];

  mycolor1: string = "rgba(188, 231, 132, 1)";
  mycolor2: string = "rgba(93, 211, 158, 1)";
  mycolor3: string = "rgba(52, 138, 167, 1)";
  mycolor4: string = "rgba(82, 81, 116, 1)";
  mycolor5: string = "rgba(81, 59, 86, 1)";
  globalID: number = 0;

  input: string = "";

  loading: boolean = false;
  nbDemandemax: number = 0;
  nbDemande: number = 0;

  computed() {
    this.timeline();
  }

  mounted() {
    moment.locale("fr");
  }
  incrementOffer() {
    if (this.nbDemande < this.nbDemandemax) {
      this.nbDemande++;

      this.globalID = requestAnimationFrame(this.incrementOffer);
    } else {
      cancelAnimationFrame(this.globalID);
    }
  }

  async loadOffer() {
    this.loading = false;
    let offerService = new OfferService();
    this.events = await offerService.loadOffer();

    this.nbDemandemax = this.events.length;

    this.loading = true;
  }

  timeline() {
    return this.events.slice().reverse();
  }

  // Les méthodes peuvent être déclarées comme des méthodes d'instance

  comment() {
    const strTime = new Date();
    this.events.push({
      id: 0,
      text: 0,
      time: strTime,
      timeformat: moment(strTime).format("LLL"),
      srcimg: "",
      dialog: false,
      listfeature: [],
      listfeatureId: 0,
      srcimage: "",
      target: "",
      show1: false,
      show: false
    });

    this.input = "entrer un nouveau post";
    this.timeline();
  }
}
</script>
<style lang="scss" scoped></style>

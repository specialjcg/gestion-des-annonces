<template>
  <v-card-actions>
    <v-btn :color="mycolor4" dark @click="updateOffer(eventi)">
      Save
    </v-btn>
    <div class="flex-grow-1"></div>
<v-dialog v-model="eventi.dialog" persistent max-width="290">
      <template v-slot:activator="{ on }">
        <v-btn :color="mycolor4" dark v-on="on">Supprimer</v-btn>
      </template>

      <v-card>
        <v-card-title class="headline"
          >êtes vous sur de supprimer cette carte?</v-card-title
        >
        <v-card-actions>
          <div class="flex-grow-1"></div>
          <v-btn color="green darken-1" text @click="eventi.dialog = false"
            >Annuler</v-btn
          >
          <v-btn color="green darken-1" text @click="deleteOffer(eventi)"
            >Valider</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-card-actions>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";
import { OfferService } from "../services/OfferService";
import { Offer } from "../domain/Offer";

@Component({})
export default class SaveDeleteOffer extends Vue {
  @Prop() eventi: Offer | undefined;

  mycolor1: string = "rgba(188, 231, 132, 1)";
  mycolor2: string = "rgba(93, 211, 158, 1)";
  mycolor3: string = "rgba(52, 138, 167, 1)";
  mycolor4: string = "rgba(82, 81, 116, 1)";
  mycolor5: string = "rgba(81, 59, 86, 1)";

  updateOffer(event: Offer) {
    let offerService = new OfferService();
    offerService.updateOffer(event);
  }
  deleteOffer(event: Offer) {
    let offerService = new OfferService();
    offerService.deleteOffer(event);
  }
}
</script>

<style lang="scss" scoped>
.progress-titlepourcent {
  color: red;
}
.radial-progress .progress-title {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 100%;
  letter-spacing: 0;
  text-align: center;
  transform: translate(-50%, 15px);
  color: black;
}
.fill {
  width: 480px;
  height: 200px;
  object-fit: cover;
}
.tag-input span.chip {
  background-color: #1976d2;
  color: #fff;
  font-size: 1em;
}

.tag-input span.v-chip {
  background-color: #1976d2;
  color: #fff;
  font-size: 1em;
  padding-left: 7px;
}

.tag-input span.v-chip::before {
  content: "label";
  font-family: "Material Icons";
  font-weight: normal;
  font-style: normal;
  font-size: 20px;
  line-height: 1;
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
  word-wrap: normal;
  direction: ltr;
  -webkit-font-feature-settings: "liga";
  -webkit-font-smoothing: antialiased;
}
</style>

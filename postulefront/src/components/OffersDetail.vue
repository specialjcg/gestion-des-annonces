<template>
  <v-card class="mx-auto" width="500px" elevation-24 :color="mycolor1">
    <a :href="eventi.target" target="_blank">
      <div v-show="eventi.srcimg != ''" style="width:100%;height:200px;">
        <img
          alt="logo"
          :src="eventi.srcimage"
          style="float:left;width:100%;height:100%;"
        />
      </div>
    </a>

    <v-card-text>
      <v-text-field
        v-show="eventi.show1"
        width="80%"
        multiple
        @change="modifyLink(eventi, $event)"
        label="lien vers annonce"
        :placeholder="eventi.target"
        ><span>{{ eventi.target }}</span> </v-text-field
      ><br />
      <v-file-input
        v-show="eventi.show"
        @change="modifyUrlImg(eventi, $event)"
        accept="image/png, image/jpeg, image/bmp"
        :placeholder="eventi.srcimg"
        prepend-icon="mdi-camera"
        label="logo annonce"
      ></v-file-input>

      <v-row>
        <v-col cols="12" lg="6">
          <DateTimeOfOffer :eventi="eventi"></DateTimeOfOffer>
        </v-col>
        <div class="flex-grow-1 pa-2 align-self-center">
          <v-btn
            :color="mycolor4"
            fab
            small
            dark
            depressed
            @click="changeUrlImage(eventi)"
          >
            <v-icon title="LOGO">mdi-image</v-icon>
          </v-btn>
          <v-btn
            :color="mycolor2"
            fab
            small
            dark
            depressed
            @click="changeLink(eventi)"
          >
            <v-icon title="Link">mdi-link</v-icon>
          </v-btn>
        </div></v-row
      >

      <v-combobox
        v-model="eventi.listfeature"
        :items="items"
        chips
        clearable
        label="Tag,Nom,Memo"
        multiple
        solo
        class="tag-input"
        append-icon
      >
        <template v-slot:selection="{ attrs, item, select, selected }">
          <v-chip
            v-bind="attrs"
            :input-value="selected"
            close
            @click="select"
            @click:close="remove(eventi, item)"
            :color="mycolor2"
          >
            <strong>{{ item }}</strong>
          </v-chip>
        </template>
      </v-combobox>
    </v-card-text>
    <StateOfOffer :state="eventi.text"></StateOfOffer>
    <v-card-actions>
      <v-btn :color="mycolor4" dark @click="updateOffer(eventi)">
        Save
      </v-btn>

      <template>
        <v-card-actions>
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
                <v-btn
                  color="green darken-1"
                  text
                  @click="eventi.dialog = false"
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
    </v-card-actions>
  </v-card>
</template>
<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";
import { Features } from "../domain/Features";
import { Offer } from "../domain/Offer";
import { Offerjson } from "../domain/OfferJson";
import { OfferService } from "../services/OfferService";
import StateOfOffer from "../components/StateOfOffer.vue";
import DateTimeOfOffer from "../components/DateTimeOfOffer.vue";

@Component({ components: { StateOfOffer,DateTimeOfOffer } })

export default class OffersDetail extends Vue {
  @Prop() eventi: Offer | undefined;

  events: Offer[] = [];

  mycolor1: string = "rgba(188, 231, 132, 1)";
  mycolor2: string = "rgba(93, 211, 158, 1)";
  mycolor3: string = "rgba(52, 138, 167, 1)";
  mycolor4: string = "rgba(82, 81, 116, 1)";
  mycolor5: string = "rgba(81, 59, 86, 1)";
  items: string[] = [];
  menu: boolean = false;
  input: string = "";
  dialog: boolean = false;
 
 
 

  mounted() {
    moment.locale("fr");
  }
 
  formatdate(event: Offer): Date {
    return event.time;
  }


  updateOffer(event: Offer) {
    let offerService = new OfferService();
    offerService.updateOffer(event);
  }
  deleteOffer(event: Offer) {
    let offerService = new OfferService();
    offerService.deleteOffer(event);
  }
  remove(event: Offer, item: string) {
    event.listfeature.splice(event.listfeature.indexOf(item), 1);
    event.listfeature = [...event.listfeature];
  }
 
  changeUrlImage(eventi: Offer) {
    eventi.show = !eventi.show;
  }

  modifyUrlImg(eventi: Offer, nouvelImage: $event) {
    // Reference to the DOM input element

    var input = event.target;

    // Ensure that you have a file before attempting to read it
    if (input.files && input.files[0]) {
      // create a new FileReader to read this image and convert to base64 format
      var reader = new FileReader();
      // Define a callback function to run, when FileReader finishes its job
      reader.onload = e => {
        // Note: arrow function used here, so that "this.imageData" refers to the imageData of Vue component
        // Read image as base64 and set to imageData
        eventi.srcimage = e.target.result;
      };
      eventi.srcimg = input.files[0].name;
      // Start the reader job - read file as a data url (base64 format)
      reader.readAsDataURL(input.files[0]);
    }

    this.changeUrlImage(eventi);
  }
  changeLink(eventi: Offer) {
    eventi.show1 = !eventi.show1;
  }
  modifyLink(event: Offer, nouveaulink: $event) {
    // event.srcimg = require('@/assets/'+nouvelImage[0].name);
    event.target = nouveaulink;
    this.changeLink(event);
  }
  // Les méthodes peuvent être déclarées comme des méthodes d'instance
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

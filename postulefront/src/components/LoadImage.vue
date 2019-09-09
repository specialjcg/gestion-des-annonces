<template>
  <div>
    <a :href="eventi.target" target="_blank">
      <div v-show="eventi.srcimg != ''" style="width:100%;height:200px;">
        <img
          alt="logo"
          :src="eventi.srcimage"
          style="float:left;width:100%;height:100%;"
        />
      </div> </a
    ><v-file-input
      v-show="eventi.show"
      @change="modifyUrlImg(eventi, $event)"
      accept="image/png, image/jpeg, image/bmp"
      :placeholder="eventi.srcimg"
      prepend-icon="mdi-camera"
      label="logo de l'entreprise"
    ></v-file-input
    ><v-btn
      :color="mycolor4"
      fab
      small
      dark
      depressed
      @click="changeUrlImage(eventi)"
    >
      <v-icon title="LOGO">mdi-image</v-icon>
    </v-btn>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";
import { Offer } from "../domain/Offer";

@Component({})
export default class LoadImgage extends Vue {
  @Prop() eventi: Offer | undefined;

  mycolor1: string = "rgba(188, 231, 132, 1)";
  mycolor2: string = "rgba(93, 211, 158, 1)";
  mycolor3: string = "rgba(52, 138, 167, 1)";
  mycolor4: string = "rgba(82, 81, 116, 1)";
  mycolor5: string = "rgba(81, 59, 86, 1)";
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
}
</script>

<style lang="scss" scoped></style>

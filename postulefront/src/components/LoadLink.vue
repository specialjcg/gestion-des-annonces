<template>
 <v-container>
  <v-layout row justify-space-around>
    <v-flex md3>
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
    </v-flex>
    <v-flex md6>
      <v-text-field
        v-show="eventi.show1"
        width="80%"
        multiple
        @change="modifyLink(eventi, $event)"
        label="lien vers offre"
        :placeholder="eventi.target"
        ><span>{{ eventi.target }}</span>
      </v-text-field>
    </v-flex>
  </v-layout></v-container>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";
import { Offer } from "../domain/Offer";

@Component({})
export default class LoadLink extends Vue {
  @Prop() eventi: Offer | undefined;

  mycolor1: string = "rgba(188, 231, 132, 1)";
  mycolor2: string = "rgba(93, 211, 158, 1)";
  mycolor3: string = "rgba(52, 138, 167, 1)";
  mycolor4: string = "rgba(82, 81, 116, 1)";
  mycolor5: string = "rgba(81, 59, 86, 1)";
  changeLink(eventi: Offer) {
    eventi.show1 = !eventi.show1;
  }
  modifyLink(eventi: Offer) {
    // event.srcimg = require('@/assets/'+nouvelImage[0].name);
    var input = event!.target as HTMLInputElement;
    eventi.target = input.value;
    this.changeLink(eventi!);
  }
}
</script>

<style lang="scss" scoped></style>

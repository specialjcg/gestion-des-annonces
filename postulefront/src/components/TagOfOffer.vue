<template>
    <v-card-text>
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
                    @click:close="removeTag(eventi, item)"
                    :color="mycolor2"
                >
                    <strong>{{ item }}</strong>
                </v-chip>
            </template>
        </v-combobox>
    </v-card-text>
</template>

<script lang="ts">
import Vue from "vue";
import Component from "vue-class-component";
import { Watch, Prop } from "vue-property-decorator";
import moment from "moment";

import { Offer } from "../domain/Offer";

@Component({})
export default class TagOfOffer extends Vue {
    @Prop() eventi: Offer | undefined;

    mycolor1: string = "rgba(188, 231, 132, 1)";
    mycolor2: string = "rgba(93, 211, 158, 1)";
    mycolor3: string = "rgba(52, 138, 167, 1)";
    mycolor4: string = "rgba(82, 81, 116, 1)";
    mycolor5: string = "rgba(81, 59, 86, 1)";

    items: string[] = [];
    menu: boolean = false;

    removeTag(event: Offer, item: string) {
        event.listfeature.splice(event.listfeature.indexOf(item), 1);
        event.listfeature = [...event.listfeature];
    }
}
</script>

<style lang="scss" scoped>
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
